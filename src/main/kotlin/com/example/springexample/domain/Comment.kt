package com.example.springexample.domain

import javax.persistence.*

@Entity
data class Comment(
        @Id @GeneratedValue val id: Long,
        val content: String,
        @ManyToOne @JoinColumn val post: Post
) {
}