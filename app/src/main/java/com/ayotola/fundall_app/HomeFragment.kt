package com.ayotola.fundall_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayotola.fundall_app.databinding.FragmentCardsBinding
import com.ayotola.fundall_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navBtn.setOnClickListener {

        }

        binding.requestView.setOnClickListener {
            findNavController().navigate(R.id.cardsFragment)
        }

        binding.analyticsView.setOnClickListener {

        }

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