package com.ayotola.fundall_app.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayotola.fundall_app.adapter.CustomAdapter
import com.ayotola.fundall_app.R
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

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val itemList = listOf("Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card")

        val adapter = CustomAdapter(itemList)
        recyclerView.adapter = adapter

    }
}