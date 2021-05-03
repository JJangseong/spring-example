package com.example.springexample.web.model

import com.example.springexample.domain.Post

data class CommentDto(val id: Long, val content: String, val post: PostDto) {
}