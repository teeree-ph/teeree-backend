package cc.el42.teeree.forms

data class LoginForm(val username: String, val password: String)

data class RegisterForm(val username: String, val password: String, val captcha: String)
