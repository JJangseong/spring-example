package com.example.springexample.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class MemberControllerTest : BaseTest() {

    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    @Order(1)
    fun saveMember() {
        val member = getMember()
        member.name = "zzzz"
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/member")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(member)))
                .andExpect(MockMvcResultMatchers.status().isCreated)
    }

    @Test
    fun removeMember() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/member/${getMember().id}"))
                .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    @Order(2)
    fun updateMember() {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/member")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(getMember())))
                .andExpect(MockMvcResultMatchers.status().isOk)
    }
}