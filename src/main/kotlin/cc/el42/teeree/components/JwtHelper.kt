package cc.el42.teeree.components

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtHelper(
) {
    private val jwtId = UUID.randomUUID().toString()
    private val key = Jwts.SIG.HS256.key().build()

    fun refreshToken(): String {
        return Jwts.builder()
            .header()
            .keyId(jwtId)
            .and()
            .subject("")
            .compact()
    }

    fun parse(token: String): Claims? {
        return try {
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .payload
        } catch (e: JwtException) {
            null
        }
    }
}