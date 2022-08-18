package edu.kotlin.ch1

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/07/14
 * @desc
 */

// 코틀린은 기본적으로 private 클래스이므로 open으로 설정해줘야한다!
open class Human constructor(val name: String = "누구세요") { // 생성자 만드는법 신기하다...

    constructor(name: String, age: Int) : this(name) {// 부 생성자는 주 생성자의 위임을 받아야한다.
        println("나의 이름은 : ${name}, 나이는 : ${age}")
    }

    init { // 생성하자마자 특정 행동을 하고 싶다면?
        println("새로운 사람 생성")
    }

    fun eatingCake() {
        println("너무 맛있다...")
    }

    // 기본적으로 private이므로 override하고 싶다면 open해줘야 한다.
    open fun singASong() {
        println("lalala")
    }
}

// 상속 Korean이 Human을 상속받는다는 의미
// 아들 : 부모()
class Korean : Human() {
    override fun singASong() {
        super.singASong() // 만약 부모의 메서드까지 쓰고 싶다면
        println("랄랄라랄")
        println("my name is :${name}")
    }
}

fun main() {
    // 자바처럼 new 연산자를 사용할 필요가 없다.
    // 그리고 객체 변수명 = new 객체()가 아닌 val로 해도 된다!
    val jihoon = Human("JiHoon")
    val su = Human("su", 20)
    jihoon.eatingCake()
    println("사람의 이름 : ${jihoon.name}")

    // 여기서 신기한 점은 constructor -> init순으로 작성을 했지만
    // 실제로 출력은 init -> constructor 순으로 실행이 된다.
    // init은 주 생성자의 일부이기 때문이다 그러므로 주생성자 -> 보조생성자 이 순서대로 진행이 된다.
    val mom = Human("Kuri", 52)
    mom.singASong() // lalala
    val korean = Korean()
    korean.singASong() // 랄랄라랄 -> Korean 클래스에 해당 메서드가 재정의됐기 때문!
}