package edu.kotlin.ch2

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/07/14
 * @desc
 */

// 1. Lambda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
//  1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a: Int)
//  2) return 값으로 사용할 수가 있다.

// 람다의 기본 정의
// val lambdaName : Type = {argumentList List -> codeBody}

val square : (Int) -> (Int) = {number -> number * number}
// 타입 추론을 위해서 최소한 {} 안의 적어줘야 한다.
val nameAge = {name:String, age: Int ->
    "my name is ${name} I'm ${age}"
}

fun main() {
    println(square(13)) // 169
    println(nameAge("지훈", 25)) // my name is 지훈 I'm 25
    val a = "joyce said"
    val b = "mac said"

    println(a.pizzaIsGreat()) // joyce saidPizza is th best!
    println(b.pizzaIsGreat()) // mac saidPizza is th best!

    println(extendString("ariana", 27)) // I am ariana and 27 years lod
    println(calculateGrade(97)) // Perfect
    println(calculateGrade(971)) // Error

    // 1-4
    val lambda = {number : Double ->
        number == 5.23423
    }
    println(invokeLambda(lambda))
    println(invokeLambda {it > 2.33 }) // 넣는 파라미터가 딱 한 개일때 가능
    println(invokeLambda ({it > 10.33 })) // 넣는 파라미터가 딱 한 개일때 가능
}

// 1-2. 확장함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is th best!"
}
fun extendString(name: String, age: Int): String{
    // 파라미터가 한 개일 경우 it이라는 대체 예약어로 가능
    val introduceMySelf : String.(Int) -> String = {
        "I am ${this} and ${it} years lod"
    }
    return name.introduceMySelf(age)
}

// 1-3. 람다의 리턴
val calculateGrade: (Int) -> String = {
    when(it){
        in 0..40 -> "Fail"
        in 41..70 -> "Pass"
        in 71..100 -> "Perfect"
        else -> "Error"
    }
}

// 1-4. 람다를 표현하는 요러가지 방법
fun invokeLambda(lambda : (Double) -> Boolean) : Boolean {
    return lambda(5.23423)
}