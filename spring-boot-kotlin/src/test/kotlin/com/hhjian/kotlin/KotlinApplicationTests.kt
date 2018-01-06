package com.hhjian.kotlin

import com.google.gson.Gson
import com.hhjian.kotlin.query.UserInfoQuery
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

    @Test
    fun contextLoads() {
    }

    @Test
    fun testListUser() {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun testGetUser() {
        val userId = "5a5084250cbda24c85ad318d"
        mockMvc.perform(MockMvcRequestBuilders.get("/users/$userId"))
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun testUpdateUser() {
        val userId = "5a5084250cbda24c85ad318d"
        val user = UserInfoQuery("hao", 31, "111")
        mockMvc.perform(
                MockMvcRequestBuilders.put("/users/$userId")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Gson().toJson(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
    }

}