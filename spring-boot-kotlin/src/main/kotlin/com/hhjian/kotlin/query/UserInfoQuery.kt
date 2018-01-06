package com.hhjian.kotlin.query

/**
 * <p>User Query Object</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2018.01.06
 */
data class UserInfoQuery(val name: String? = null,
                         val age: Int = 0,
                         val phone: String? = null)