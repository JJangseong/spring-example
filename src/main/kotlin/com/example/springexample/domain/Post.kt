package com.example.springexample.domain

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
data class Post(
        @Id @GeneratedValue val id: Long,
        val title: String,
        @Temporal(TemporalType.TIMESTAMP) val createdAt: Date?
) {

}
