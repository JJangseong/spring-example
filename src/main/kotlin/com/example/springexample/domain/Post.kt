package com.example.springexample.domain

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import java.util.*
import javax.persistence.*

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class)
data class Post(
        @Id @GeneratedValue val id: Long,
        var title: String = "",
        @Temporal(TemporalType.TIMESTAMP) val createdAt: Date? = Date(),
        @OneToMany(mappedBy = "post") val comments: List<Comment>? = null
) {

}
