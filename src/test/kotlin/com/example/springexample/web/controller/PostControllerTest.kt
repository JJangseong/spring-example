package com.example.springexample.web.controller

import com.example.springexample.domain.Comment
import com.example.springexample.domain.Post
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*


@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureMockMvc
internal class PostControllerTest {

    @Autowired lateinit var mockMvc: MockMvc
    @Autowired lateinit var mapper: ObjectMapper

    @Test
    @Order(2)
    fun getPostById() {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/post/1"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("\$.id").value(1L))
                .andExpect(jsonPath("\$.title").value("title"))
                .andReturn()

        println("LOG :::::::: ${result.response.contentAsString}")
    }

    @Test
    @Order(1)
    fun saveNewPost() {
        val post: Post = Post(1L, "title", Date())
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(post)))
                .andExpect(status().isCreated)

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(Comment(content = "COmmentntnetnet", post = Post(1L)))))
                .andExpect(MockMvcResultMatchers.status().isCreated)

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(Comment(content = "zzzzz", post = Post(1L)))))
                .andExpect(MockMvcResultMatchers.status().isCreated)
    }

    @Test
    @Order(3)
    fun updatePost() {
        val post: Post = Post(1L, "101111000", Date())
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/post/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(post)))
                .andExpect(status().isOk)

    }

}