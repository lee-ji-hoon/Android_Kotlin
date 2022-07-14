package edu.kotlin.ch2

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/07/14
 * @desc
 */

// 3. Companion == static
class Book private constructor(val id: Int, val name: String){
    companion object BookFactory: IdProvider{
        val myBook = "new Book"
        fun create() = Book(getId(), myBook)

        override fun getId(): Int {
            return 444
        }
    }
}

interface IdProvider{
    fun getId() : Int
}

fun main() {
//    val book = Book // 불가능
    val book = Book.create()
    val bookId = Book.BookFactory.getId()
    println("book id = ${book.id}, name = ${book.name}")
    println("bookId = ${bookId}")
}