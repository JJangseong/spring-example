package com.example.springexample.domain

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class)
data class Comment(
        @Id @GeneratedValue val id: Long? = null,
        val content: String,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "post_id") var post: Post
) {

}