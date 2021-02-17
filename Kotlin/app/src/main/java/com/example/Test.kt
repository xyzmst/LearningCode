package com.example

import com.example.app.entity.User

fun main() {
    val user = User()
    val copy = user.copy()
    println(" =============== ")
    println(user == copy)
    println(user === copy)

//    var a: UnionBankPay = UnionBankPay.build {
//        tradeCode { "123123" }
//        serverModel { "00" }
//    }

    println(Mode.COMMON.name)
}

class A : TDInterface {
    override fun testA() {
        TODO("Not yet implemented")
    }
}