package cc.el42.teeree.dto

import cc.el42.teeree.entities.User

data class UserDto(val email: String, val role: User.Role)

data class LoginDto(val token: String)

data class RegisterDto(val token: String)