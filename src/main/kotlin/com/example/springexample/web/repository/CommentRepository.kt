package com.example.springexample.web.repository

import com.example.springexample.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long>{
}