package com.example.springexample.web.controller

import com.example.springexample.domain.Comment
import com.example.springexample.domain.Member
import com.example.springexample.domain.Post
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class CommentControllerTest: BaseTest() {

    @Autowired lateinit var mockMvc: MockMvc
    @Autowired lateinit var mapper: ObjectMapper

    @BeforeEach
    fun init() {
        saveMemberByRepository()
    }

    @Test
    fun saveComment() {

        val post = Post(2L, "title", Date(), member = getMember())
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(post)))
                .andExpect(MockMvcResultMatchers.status().isCreated)

        val oldPost = Post(2L, member = getMember())

        val comment = Comment(1L, "COmmentntnetnet", oldPost)
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(comment)))
                .andExpect(MockMvcResultMatchers.status().isCreated)
    }
}

