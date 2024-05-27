package cc.el42.teeree.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController {
    @GetMapping("/posts")
    fun getPostsByPage(@RequestParam(defaultValue = "1") page: Int) /* : List<PostPreviewDto> */ {
        TODO()
    }

    @GetMapping("/posts/{id}")
    fun getPostById(@PathVariable("id") id: String) /* : PostDto */ {
        TODO()
    }
}