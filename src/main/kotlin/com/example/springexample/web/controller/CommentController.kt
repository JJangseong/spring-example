package com.example.springexample.web.controller

import com.example.springexample.domain.Comment
import com.example.springexample.web.repository.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/comment")
class CommentController {

    @Autowired lateinit var commentRepository: CommentRepository

    @PostMapping
    fun saveComment(@RequestBody comment: Comment): ResponseEntity<Comment> {
        commentRepository.save(comment)
        return ResponseEntity(HttpStatus.CREATED)
    }

}