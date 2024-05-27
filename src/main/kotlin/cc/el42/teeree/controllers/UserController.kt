package cc.el42.teeree.controllers

import cc.el42.teeree.dto.LoginDto
import cc.el42.teeree.dto.RegisterDto
import cc.el42.teeree.dto.UserDto
import cc.el42.teeree.forms.LoginForm
import cc.el42.teeree.forms.RegisterForm
import org.springframework.web.bind.annotation.*

@RestController
class UserController {
    @GetMapping("/user/email/{email}")
    fun getUserByEmail(@PathVariable email: String): UserDto {
        TODO()
    }

    @GetMapping("/user/cookie/{cookie}")
    fun getUserByCookie(@PathVariable cookie: String): UserDto {
        TODO()
    }

    @PostMapping("/user/login")
    fun login(@RequestBody form: LoginForm): LoginDto {
        TODO()
    }

    @PostMapping("/user/register")
    fun register(@RequestBody form: RegisterForm): RegisterDto {
        TODO()
    }

    @GetMapping("/user/{email}/captcha")
    fun sendCaptcha(@PathVariable email: String) {
        TODO()
    }
}