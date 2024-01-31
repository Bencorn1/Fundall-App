package com.ayotola.fundall_app


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cards, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to your views in the ViewHolder
         val textView = holder.itemView.findViewById<TextView>(R.id.lifestyle)
         textView.text = itemList[position]

        // Bind data to views based on the position
        val data = itemList[position]
        // Update your UI components with data
        holder.textView.text = data
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare views here (e.g., val textView: TextView = itemView.findViewById(R.id.textView))
        val textView: TextView = itemView.findViewById(R.id.lifestyle)
    }
}
