package com.xyzmst.generics


interface Shop<in T>{

    fun getAmount(t: T, number: Float):Float
}

open class Fruit{
    var price: Float = 0f
}

class Apple : Fruit()

class Banana : Fruit()

class FruitShop: Shop<Fruit>{
    override fun getAmount(t: Fruit, number: Float): Float {
        return t.price * number
    }
}

fun main(){

    val shop = FruitShop()
    var apple = Apple().apply { price = 3.5f }
    var banana = Banana().apply { price = 2.5f }

    println("3 apple amount is ${shop.getAmount(apple,3f)}")
    println("3 banana amount is ${shop.getAmount(banana,3f)}")
    shop.getAmount(Fruit(),3f)
}