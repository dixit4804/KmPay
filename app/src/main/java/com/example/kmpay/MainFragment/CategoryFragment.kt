package com.example.kmpay.MainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kmpay.Adapter.GridAdapter
import com.example.kmpay.R

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        // Initialize RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.gridRecyclerView)

        // Prepare data
        val items = listOf(
            Pair(R.drawable.shoes, "Item 1"),
            Pair(R.drawable.kitchen1, "Item 2"),
            Pair(R.drawable.game_player, "Item 3"),
            Pair(R.drawable.mentshirt, "Item 4"),
            Pair(R.drawable.printer, "Item 5"),
            Pair(R.drawable.smart_watch, "Item 6"),
            Pair(R.drawable.airfryer, "Item 7"),
            Pair(R.drawable.sofa, "Item 8")
        )

        // Setup adapter and layout manager
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = GridAdapter(items)

        return view
    }
}
