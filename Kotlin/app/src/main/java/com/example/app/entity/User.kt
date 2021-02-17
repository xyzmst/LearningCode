package com.example.app.entity

// data 数据类 帮助 生成 通用函数 toString hashcode copy
data class User(var username: String?, var password: String?, var code: String?) {
    constructor() : this(null, null, null)
}