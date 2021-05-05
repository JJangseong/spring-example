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
        @OneToMany(mappedBy = "post") var comments: List<Comment>? = null,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "member_id") val member: Member
) {

}
