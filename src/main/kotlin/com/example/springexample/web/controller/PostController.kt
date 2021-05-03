package com.example.springexample.web.controller

import com.example.springexample.domain.Post
import com.example.springexample.web.model.PostDto
import com.example.springexample.web.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/post")
class PostController {

    @Autowired lateinit var postRepository: PostRepository

    @GetMapping("/{postId}")
    fun getPostById(@PathVariable("postId") postId: Long): ResponseEntity<Post> {
        return ResponseEntity( postRepository.getOne(1L), HttpStatus.OK)
    }

    @PostMapping
    fun saveNewPost(@RequestBody post: Post): ResponseEntity<Post> {
        postRepository.save(post)
        return ResponseEntity(CREATED)
    }
}