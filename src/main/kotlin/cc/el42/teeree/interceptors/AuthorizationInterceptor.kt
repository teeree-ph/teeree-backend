package cc.el42.teeree.interceptors

import cc.el42.teeree.components.JwtHelper
import cc.el42.teeree.entities.User
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@Order(Ordered.HIGHEST_PRECEDENCE)
annotation class Role(val role: User.Role)

class AuthorizationInterceptor(
    private val jwtHelper: JwtHelper,
) : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler !is HandlerMethod) {
            response.status = HttpStatus.UNAUTHORIZED.value()
            return false
        }
        if (!handler.method.isAnnotationPresent(Role::class.java)) {
            return true
        }
        val rawToken = request.getHeader("Authorization")
        if (rawToken.isEmpty()) {
            response.status = HttpStatus.UNAUTHORIZED.value()
            return false
        }
        val token = rawToken.replace("Bearer ", "")
        val claims = jwtHelper.parse(token) ?: let {
            response.status = HttpStatus.UNAUTHORIZED.value()
            return false
        }
        val role = User.Role.valueOf(claims["role"].toString())
        val requiredRole = handler.method.getAnnotation(Role::class.java).role
        if (role.priority <= requiredRole.priority) {
            return true
        }
        response.sendError(HttpStatus.UNAUTHORIZED.value())
        return false
    }
}