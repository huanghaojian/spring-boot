package com.hhjian.kotlin

import com.hhjian.kotlin.domain.User
import com.hhjian.kotlin.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
class KotlinApplication {

    @Bean
    fun init(repository: UserRepository) = CommandLineRunner {
        repository.deleteAll()
        repository.save(User(name = "hao", age = 18, phone = "13987654321"))
        repository.save(User(name = "jian", age = 19, phone = "13123456789"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinApplication::class.java, *args)
}