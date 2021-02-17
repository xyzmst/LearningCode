package com.example.core.utils

import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R
import java.util.*

/**
 * object 修饰的类 所有的方法都是静态的
 */
object CacheUtils {
    private val context = BaseApplication.currentApplication

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) = SP.edit().putString(key, value).apply()

    //类型推断 简化函数
    fun get(key: String?) = SP.getString(key, null)
}