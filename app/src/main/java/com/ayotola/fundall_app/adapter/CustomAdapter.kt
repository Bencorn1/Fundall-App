package com.ayotola.fundall_app.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayotola.fundall_app.R

class CustomAdapter(private val itemList: List<String>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cards, parent, false)
        return ViewHolder(view,listener)
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


    class ViewHolder(itemView: View, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        // Declare views here (e.g., val textView: TextView = itemView.findViewById(R.id.textView))
        val textView: TextView = itemView.findViewById(R.id.lifestyle)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
