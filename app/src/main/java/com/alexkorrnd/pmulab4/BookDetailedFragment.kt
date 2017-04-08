package com.alexkorrnd.pmulab4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ToggleButton


class BookDetailedFragment : BaseFragment() {

    companion object {
        fun newInstance(bookId: Int): BookDetailedFragment {
            val fragment = BookDetailedFragment()
            val args = Bundle()
            args.putInt(ARG_BOOK_ID_KEY, bookId)
            fragment.arguments = args
            return fragment
        }

        private const val ARG_BOOK_ID_KEY = "BOOK_ID_KEY"
    }

    private val bookId by lazy { arguments.getInt(ARG_BOOK_ID_KEY) }
    private val book: Book by lazy { BooksRepository.books[bookId] }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_book_detailed, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById(R.id.name_text_view) as TextView
        tvName.text = book.name

        val tvDescription = view.findViewById(R.id.description_text_view) as TextView
        tvDescription.text = book.description

        val tbCartStatus = view.findViewById(R.id.tbCartStatus) as ToggleButton
        tbCartStatus.isChecked = CartRepository.contains(book)
        tbCartStatus.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                CartRepository.add(book)
            } else {
                CartRepository.remove(book)
            }
        }
    }
}
