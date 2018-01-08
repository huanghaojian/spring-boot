package com.hhjian.kotlin

import com.google.gson.Gson
import com.hhjian.kotlin.query.UserInfoQuery
import com.hhjian.kotlin.repository.UserRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class KotlinApplicationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun testListUser() {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun testGetUser() {
        val userDO = userRepository.findByName("hao")
        mockMvc.perform(MockMvcRequestBuilders.get("/users/${userDO.id}"))
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun testUpdateUser() {
        val userDO = userRepository.findByName("hao")
        val user = UserInfoQuery("hao", 30, "123456")
        mockMvc.perform(
                MockMvcRequestBuilders.put("/users/${userDO.id}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Gson().toJson(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
    }

}