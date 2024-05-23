package cc.el42.teeree.entities

import jakarta.persistence.*

@Entity
@Table(name = "user_table")
class User(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Enumerated(EnumType.STRING)
    val role: Role
) {
    fun toDto() = UserDto(email, role)

    enum class Role(val priority: Int) {
        ADMIN(0),
        STUDENT(1),
    }
}

data class UserDto(val email: String, val role: User.Role)