package com.ayotola.fundall_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayotola.fundall_app.databinding.FragmentCardsBinding
import com.ayotola.fundall_app.databinding.FragmentPickNewCardBinding


class PickNewCardFragment : Fragment() {
    private lateinit var binding: FragmentPickNewCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPickNewCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backText.setOnClickListener {

        }

        binding.include.continueBtn.setOnClickListener {

        }


        val recyclerView = binding.recyclerView

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val itemList = listOf("Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card", "Fundall Lifestyle Card")

        val adapter = CustomAdapter(itemList)
        recyclerView.adapter = adapter

        val customDialogFragment = DialogFragment()
        fragmentManager?.let { customDialogFragment.show(it, "CustomDialogFragment") }

    }

}