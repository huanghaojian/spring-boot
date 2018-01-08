package com.hhjian.kotlin.repository

import com.hhjian.kotlin.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * <p>User Repository</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2018.01.05
 */
interface UserRepository : MongoRepository<User, String> {
    fun findByName(name: String): User
}
