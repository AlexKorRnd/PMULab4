package com.alexkorrnd.pmulab4

class Book(val name: String,
           val description: String,
           val price: Double
) {

    override fun toString(): String {
        return name
    }
}
