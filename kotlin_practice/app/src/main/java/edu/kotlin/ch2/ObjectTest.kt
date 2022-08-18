package edu.kotlin.ch2

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/07/14
 * @desc
 */

// Singleton Pattern
object CarFactory{
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower: Int)

fun main() {
    // main 에서 따로 객체를 생성하지 않았지만 사용을 할 수 있다!
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(CarFactory.cars.size.toString()) // 2
}