package com.example.springexample.domain

import javax.persistence.*

@Entity
data class Member(
        @Id @GeneratedValue val id: Long,
        val age: Float,
        val name: String,
        @OneToMany(mappedBy = "member") val posts: List<Post>? = null
) {

}