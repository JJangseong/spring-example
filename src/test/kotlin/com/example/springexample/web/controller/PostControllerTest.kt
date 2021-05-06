package com.example.springexample.web.controller

import com.example.springexample.domain.Comment
import com.example.springexample.domain.Member
import com.example.springexample.domain.Post
import com.example.springexample.web.repository.MemberRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*


@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureMockMvc
internal class PostControllerTest: BaseTest() {

    @Autowired lateinit var mockMvc: MockMvc
    @Autowired lateinit var mapper: ObjectMapper

    @BeforeEach
    fun init() {
        saveMemberByRepository()
    }


    @Test
    fun getPostById() {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/post/2"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("\$.id").value(2L))
                .andExpect(jsonPath("\$.title").value("title"))
                .andReturn()

        println(result.response.contentAsString)
    }

    @Test
    fun saveNewPost() {
        val post: Post = Post(1L, "title", Date(), member = getMember())

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(post)))
                .andExpect(status().isCreated)
    }

    @Test
    fun updatePost() {
        val post: Post = Post(1L, "101111000", Date(), member = getMember())
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(post)))
                .andExpect(status().isOk)

    }

}