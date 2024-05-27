package cc.el42.teeree.entities

import jakarta.persistence.*

@Entity
@Table(name = "comment_table")
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @OneToOne
    val replyTo: Post

    // TODO: Other fields
)