package com.alexkorrnd.pmulab4

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


class BooksListFragment : ListFragment() {

    interface ClickListener {
        fun onItemClick(id: Int)
    }

    private lateinit var adapter: ArrayAdapter<Book>
    private var mClickListener: ClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        adapter = ArrayAdapter(
                context,
                android.R.layout.simple_list_item_1,
                BooksRepository.books)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ClickListener)
            mClickListener = context
    }

    override fun onDetach() {
        super.onDetach()
        mClickListener = null
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        mClickListener?.onItemClick(id.toInt())
    }

}