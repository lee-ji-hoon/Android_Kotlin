package edu.kotlin.ch2

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/07/14
 * @desc
 */

// 2. 데이터 클래스
// toString, HashCode, construct, equals copy 등등 자동 생성
data class Ticket(val companyName: String, val name : String, var date : String, var seatNumber : Int)

class TicketNormal(val companyName: String, val name : String, var date : String, var seatNumber : Int)

fun main() {
    val ticketA = Ticket("koreanAir", "joyceHong", "2022-07-14", 14)
    val ticketB = TicketNormal("koreanAir", "joyceHong", "2022-07-14", 14)

    println("ticketA = ${ticketA}") // ticketA = Ticket(companyName=koreanAir, name=joyceHong, date=2022-07-14, seatNumber=14)
    println("ticketB = ${ticketB}") // ticketB = edu.kotlin.ch2.TicketNormal@6a5fc7f7
}