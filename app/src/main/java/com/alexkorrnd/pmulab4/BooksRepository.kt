package com.alexkorrnd.pmulab4

object BooksRepository  {

    val books = arrayOf(
            Book(name = "Коллекционер",
                    description = "Роман рассказывает историю безумного клерка Фредерика Клегга, попытавшегося добавить в свою коллекцию живого человека.",
                 price = 150.0
            ),
            Book(name = "Идиот",
                    description = "26-летний князь Мышкин возвращается из Швейцарии, где провёл несколько лет, лечась от недуга. Размышление Достоевского о добре и красоте в мире наживы, безбожия, разгула эгоистических страстей не оставят вас равнодушными.",
                    price = 220.5
            ),
            Book(name = "Пролетая над гнездом кукушки",
                    description = "Огромный индеец по кличке Вождь Бромден притворяется глухонемым в психиатрической больнице. Приход нового пациента постепенно меняет его жизнь и побуждает на совершение побега.",
                    price = 555.8

            )
    )

    /*fun getBook(id: Int): Book {
        return books[id]
    }*/
}