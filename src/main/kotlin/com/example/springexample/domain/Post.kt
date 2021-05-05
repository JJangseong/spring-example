package com.example.springexample.domain

import java.util.*
import javax.persistence.*

@Entity
data class Post(
        @Id @GeneratedValue val id: Long,
        var title: String = "",
        @Temporal(TemporalType.TIMESTAMP) val createdAt: Date? = Date(),
        @OneToMany(mappedBy = "post") val comments: List<Comment>? = null
) {

}
