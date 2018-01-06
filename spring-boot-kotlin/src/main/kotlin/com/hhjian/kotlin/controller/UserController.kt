package com.hhjian.kotlin.controller

import com.hhjian.kotlin.domain.User
import com.hhjian.kotlin.query.UserInfoQuery
import com.hhjian.kotlin.repository.UserRepository
import org.springframework.beans.BeanUtils
import org.springframework.web.bind.annotation.*

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

    @PutMapping("/users/{userId}")
    fun updateUser(@PathVariable userId: String, @RequestBody userInfo: UserInfoQuery): User {
        val userDO: User = userRepository.findOne(userId)
        BeanUtils.copyProperties(userInfo, userDO)
        return userRepository.save(userDO)
    }
}
