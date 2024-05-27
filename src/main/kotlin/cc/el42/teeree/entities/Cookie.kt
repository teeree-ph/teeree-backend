package cc.el42.teeree.entities

import jakarta.persistence.*

@Entity
@Table(name = "cookie_table")
class Cookie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val value: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)

data class CookieDto(val value: String, val user: UserDto)