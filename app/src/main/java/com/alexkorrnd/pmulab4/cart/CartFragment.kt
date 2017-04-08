package com.alexkorrnd.pmulab4.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alexkorrnd.pmulab4.BaseFragment
import com.alexkorrnd.pmulab4.CartRepository
import com.alexkorrnd.pmulab4.R

class CartFragment: BaseFragment() {

    companion object {
        fun newInstance() = CartFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvCount = view.findViewById(R.id.tvBooksCount) as TextView
        tvCount.text = getString(R.string.cart_books_count, CartRepository.totalCount)

        val tvTotalPrice = view.findViewById(R.id.tvBooksPrice) as TextView
        tvTotalPrice.text = getString(R.string.cart_books_price, CartRepository.totalPrice.toString())
    }

}
