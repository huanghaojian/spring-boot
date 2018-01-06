package com.hhjian.kotlin.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.util.*

/**
 * <p>domain object base param</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2018.01.06
 */
abstract class BaseDO {
    @Id
    var id: String? = null
    @Version
    var version: Long = 0
    @CreatedDate
    var createAt: Date? = null
    @LastModifiedDate
    var modifiedAt: Date? = null
}