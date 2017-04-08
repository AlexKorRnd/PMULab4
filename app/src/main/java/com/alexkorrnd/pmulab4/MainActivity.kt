package com.alexkorrnd.pmulab4

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.FrameLayout
import com.alexkorrnd.pmulab4.cart.CartFragment


class MainActivity : AppCompatActivity(), BooksListFragment.ClickListener {

    companion object {
        private val BOOK_DETAIL_FRAGMENT_TAG = BookDetailedFragment::class.java.simpleName
    }

    private var detailContainer: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        detailContainer = findViewById(R.id.book_detail_container) as? FrameLayout

        val btnNavigateToCart = findViewById(R.id.btnNavigateToCart) as Button
        btnNavigateToCart.setOnClickListener {
            if (detailContainer != null) {
                replaceFragment(CartFragment.newInstance(), false, R.id.book_detail_container)
            } else {
                replaceFragment(CartFragment.newInstance(), true, android.R.id.content)
            }
        }
    }

    override fun onItemClick(id: Int) {
        if (detailContainer != null) {
            replaceFragment(BookDetailedFragment.newInstance(id), false, R.id.book_detail_container)
        } else {
            startActivity(BookDetailActivity.getIntent(this, id))
        }
    }

    private fun replaceFragment(fragment: BaseFragment, needAddToBackStack: Boolean = false,
                                containerId: Int) {
        val transaction =
                supportFragmentManager.beginTransaction()
                        .replace(containerId,
                                fragment,
                                BOOK_DETAIL_FRAGMENT_TAG)
        if (needAddToBackStack) {
            transaction.addToBackStack(BOOK_DETAIL_FRAGMENT_TAG)
        } else {
            transaction.addToBackStack(null)
        }

        transaction
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

}
