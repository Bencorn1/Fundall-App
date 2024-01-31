package com.ayotola.fundall_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayotola.fundall_app.databinding.FragmentCardsBinding

class CardsFragment : Fragment() {
    private lateinit var binding: FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView

        // Create a layout manager with horizontal orientation
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        // Create a list of data (replace with your actual data)
        val itemList = listOf("Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card")
        // Add your data to the list

        // Create the adapter and set it to the RecyclerView
        val adapter = CustomAdapter(itemList)
        recyclerView.adapter = adapter

    }
}