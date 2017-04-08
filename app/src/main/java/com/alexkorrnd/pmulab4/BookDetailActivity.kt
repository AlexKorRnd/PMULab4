package com.alexkorrnd.pmulab4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class BookDetailActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, bookId: Int) =
                Intent(context, BookDetailActivity::class.java).apply {
                    putExtra(EXTRA_BOOK_ID, bookId)
                }

        private const val EXTRA_BOOK_ID = "EXTRA_BOOK_ID"
    }

    private val bookId: Int by lazy { intent.getIntExtra(EXTRA_BOOK_ID, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detailed)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, BookDetailedFragment.newInstance(bookId))
                .commit()
    }
}
