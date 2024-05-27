package cc.el42.teeree.dto

import java.util.Date

data class PostPreviewDto(
    val id: Long,
    val category: String,
    val commentCount: Int,
    val content: String,
    val releaseDate: Date,
    val cookie: String
)