package com.example.springexample

import org.junit.jupiter.api.Test

class KotlinTest {
    @Test
    fun test() {
        for(i in 1..9 step 3) {
            println(i)
        }
        println("=======================")
        for(i in 1 downTo 9 step 3) {
            println(i)
        }
        println("=======================")
        for(i in "abc") {
            println(i)
        }

        println("========================")

        var a = Developer("sungjin", 1000)

        var dog = Dog("dog", 12)
        dog.bark()

        b(::a)

        val c: (String) -> Unit = { println(it) }
        b(c)
    }
}

open class Animal(var name: String, var age: Int, var type: String) {
    fun introduce() {
        println("My Name is ${name}( ${type} ) and Age is ${age}")
    }

    open fun bark() {
        println("멍멍")
    }
}

class Dog(name:String, age:Int): Animal(name, age, "개") {
    override fun bark() {
        println("멍멍멍멍머어엉")
    }
}

abstract class Person (var name:String, val birthYear: Int) {
    abstract fun introduce()
}

class Developer(name: String, birthYear: Int): Person(name, birthYear), Runner, Eater {
    override fun introduce() {
        TODO("Not yet implemented")
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}

interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        println("음식을 먹습니다")
    }
}

fun a(str: String) {
    println("$str 함수 a")
}

fun b(function: (String) -> Unit) {
    function("b가 호출한")
}

// 싱글톤 패턴을 언어 자체에서 지원함
object Counter {
    var count = 0

    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}