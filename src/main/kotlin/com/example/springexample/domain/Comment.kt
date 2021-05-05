package com.example.springexample.domain

import javax.persistence.*

@Entity
data class Comment(
        @Id @GeneratedValue val id: Long? = null,
        val content: String,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "post_id") val post: Post
) {

}