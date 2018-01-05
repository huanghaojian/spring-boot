package com.hhjian.kotlin.controller

import com.hhjian.kotlin.domain.User
import com.hhjian.kotlin.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * <p>User Controller</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2018.01.05
 */
@RestController
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun listUser(): List<User> = userRepository.findAll()

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable userId: String): User = userRepository.findOne(userId)
}
