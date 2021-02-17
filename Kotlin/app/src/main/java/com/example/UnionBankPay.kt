package com.example

import android.app.Activity

class UnionBankPay private constructor(val activity: Activity,
                                       val tradeCode: String,
                                       val serverModel: String){
    //私有化构造方法
    private constructor(builder: Builder) : this(builder.activity,
            builder.tradeCode,
            builder.serverModel)

    //伴生对象，对外提供静态的build方法
    companion object {
        fun build(init: Builder.() -> Unit) = Builder(init).build()
    }

    //Builder 内部类
    class Builder private constructor() {
        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        //属性
        lateinit var activity: Activity
        lateinit var tradeCode: String
        lateinit var serverModel: String

        //DSL赋值方法
        fun activity(init: Builder.() -> Activity) = apply { activity = init() }
        fun tradeCode(init: Builder.() -> String) = apply { tradeCode = init() }
        fun serverModel(init: Builder.() -> String) = apply { serverModel = init() }

        fun build() = UnionBankPay(this)
    }
}