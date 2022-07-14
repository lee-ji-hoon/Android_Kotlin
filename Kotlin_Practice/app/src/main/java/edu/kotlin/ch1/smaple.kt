package edu.kotlin.ch1

import java.util.*

fun main() {
    nullcheck()
}
// 4. 조건식
fun maxBy(a: Int, b:Int): Int{
    if(a > b)
        return a
    else
        return b
}

// 4-1 if else 한 줄에 return문 쓰기
fun maxBy2(a: Int, b: Int): Int{
    return if(a > b) a else b
}

// 4-2 대괄호까지 생략한 버전
fun maxBy3(a: Int, b: Int): Int = if(a > b) a else b

// 4-3 when
fun checkNum(score: Int){ // switch 구문 생각하면 편함
    // Statement
    when(score){
        // when 안의 값 -> 실행할 문장 (break 는 필요 없음)
        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3") //
        else -> println("I don know") // 필수 아님
    }
    // Expression
    var b: Int = when (score) {
        // 바로 변수 할당도 가능하다.
        1 -> 1
        2 -> 2
        else -> 3 // 이 경우는 필수
    }

    println("b: ${b}")

    when(score){
        in 90..100 -> println("A")
        in 10..80 -> println("Not Bad")
        else -> println("Okay") // 필수 아님
    }
}

// Expression vs Statement

// 5. Array and List
// Array
// List  1. List -> 수정 불가능  2. MutableList -> 수정 가능
fun array() {
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3) //

    val array2 = arrayOf(1, "d", 3.4f)
    val list2 = listOf(1, "d", 3.4f)

    array[0] = 3
//    list[0] = 2 // list에 원소를 바꾸는건 불가능하다. 갖고오는게 가능하다!
    var value = list.get(0)
    println("value = ${value}")
    // mutableList -> ArrayList
    var arrayList = arrayListOf<Int>()
    arrayList.add(10) // 10 추가 0번째 인덱스
    arrayList.add(20) // 20 추가 1번째 인덱스
}

// 6. 반복문
// for / while
fun forAndWhile() {
    val students = arrayListOf("any", "james", "jenny", "jennifer")
    for(name in students)
        println("이름 : ${name}")

    // 1 ~ 10까지의 합
    var sum: Int = 0
    for (i in 1..10)
        sum += i
    println("10부터 1까지의 합 : ${sum}")

    // 10부터 1까지의 합
    sum = 0
    for (i in 10 downTo 1)
        sum += i
    println("10부터 1까지의 합 : ${sum}")
    // 1 3 6 9의 합
    sum = 0
    for(i in 1..10 step 3)
        sum += i
    println("1, 3, 6, 9의 합 : ${sum}")

    // 1~99까지의 합 until 사용
    for(i in 1 until 100) // 100을 포함하지 않는다. 주로 배열의 길이까지 확인할때 자주 쓴다.
        sum += i
    println("1~99까지의 합 : ${sum}")

    // 배열을 index와 함께 사용하고 싶을때!
    for((index, name) in students.withIndex())
        println("${index}번째 학생: ${name}")

    // 0~9까지 출력 while 사용
    var index = 0
    while (index < 10)
        println("current index ${index++}")
}

// 7. Nullable / NonNull
fun nullcheck() {
    // NPE : Null Pointer Exception (런타임 과정에서만 잡히기 때문에 실행을 해야지만 확인 가능)
    var name: String = "joyce"
    var nullName: String? = null // Nullable : 변수타입? 선언
    var nameInUpperCase = name.uppercase()
    var nullNameInUpperCase = nullName?.uppercase() // nullName? -> nullName이 null 아니면 실행하고 아니면 null 반환

    // ?: null 값이 반환되는게 아닌 default 값을 주고 싶을 때 사용
    val lastName: String? = null
    val lastName2: String? = "Hoon"
    val fullName = name + " " + (lastName?: "No lastName")
    val fullName2 = name + " " + (lastName2?: "No lastName")

    println("fullName(Default) = ${fullName}") // fullName(Default) = joyce No lastName
    println("fullName(Not Null) = ${fullName2}") // fullName(Not Null) = joyce Hoon

    // !! 이거 null아냐 내가 보증해! NonNull
    ignoreNulls("lee")
}

fun ignoreNulls(str: String?) {
//    var mNotNull: String = str // str이 null이 들어올수도 있기 때문에 오류가 생김
    var mNotNull: String = str!! // 선언 끝에 !!를 넣음으로써 해당 값은 무조건 null이 아닌 것이라고 명시
    val upper = mNotNull.uppercase() // 앞에 이미 !!를 선언했기 때문에 상관없이 사용 가능
    // 단 확실하지 않으면 쓰지 말아야한다. 만약 null이 들어올 수 있는 경우가 있다면?.. NPE!


    // let 함수 이용
    val email: String? =  "dlwlgns1240@gmail.com"
    email?.let{ // null 아니라면 람다식 안으로 옮겨짐
        println("my email is ${it}")
    }

    val emailNull: String? =  null
    emailNull?.let{ // null 이므로 안의 람다식 실행이 안됨
        println("my email is ${it}")
    }
}

// 8. Class

