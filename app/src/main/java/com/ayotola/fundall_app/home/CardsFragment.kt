package com.ayotola.fundall_app.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayotola.fundall_app.adapter.CustomAdapter
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

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val itemList = listOf("Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card")

        val adapter = CustomAdapter(itemList)
        recyclerView.adapter = adapter

    }
}