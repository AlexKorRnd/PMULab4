package com.alexkorrnd.pmulab4

object CartRepository {

    private val books = ArrayList<Book>()

    val totalCount: Int
        get() = books.size

    val totalPrice: Double
        get() {
            var _totalPrice: Double = 0.toDouble()
            books.forEach { _totalPrice += it.price }
            return _totalPrice
        }

    fun add(book: Book) {
        books.add(book)
    }

    fun remove(book: Book) {
        books.remove(book)
    }

    fun contains(book: Book): Boolean = books.contains(book)
}
