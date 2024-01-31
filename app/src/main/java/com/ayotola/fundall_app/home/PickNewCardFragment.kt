package com.ayotola.fundall_app.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayotola.fundall_app.adapter.CustomAdapter
import com.ayotola.fundall_app.databinding.FragmentPickNewCardBinding
import com.ayotola.fundall_app.dialog.CustomDialogFragment


class PickNewCardFragment : Fragment(), CustomAdapter.OnItemClickListener {
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
            activity?.onBackPressed();
        }

        binding.include.continueBtn.setOnClickListener {

            val customDialogFragment = CustomDialogFragment() // Use your custom dialog fragment

            activity?.supportFragmentManager?.let {
                customDialogFragment.show(it, "YourCustomDialogFragmentTag")
            }

            Handler().postDelayed({
                // Dismiss the dialog after a delay
                customDialogFragment.dismiss()
            }, 2000) // Delay in milliseconds
        }

        val recyclerView = binding.recyclerView

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val itemList = listOf(
            "Fundall Lifestyle Card",
            "Fundall Lifestyle Card",
            "Fundall Lifestyle Card",
            "Fundall Lifestyle Card",
            "Fundall Lifestyle Card"
        )

        val adapter = CustomAdapter(itemList, this)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {

    }

}