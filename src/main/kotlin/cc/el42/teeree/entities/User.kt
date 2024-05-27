package cc.el42.teeree.entities

import cc.el42.teeree.dto.UserDto
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

    @OneToMany(mappedBy = "user")
    val cookies: List<Cookie>,

    @Enumerated(EnumType.STRING)
    val role: Role
) {
    fun toDto() = UserDto(email, role)

    enum class Role(val priority: Int) {
        ADMIN(0),
        STUDENT(1),
    }
}