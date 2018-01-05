package com.hhjian.kotlin.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * <p>User domain</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2018.01.05
 */
@Document
data class User(
        var name: String?,
        var age: Int = 0,
        var phone: String? = null) {
    @Id
    var id: String? = null
}