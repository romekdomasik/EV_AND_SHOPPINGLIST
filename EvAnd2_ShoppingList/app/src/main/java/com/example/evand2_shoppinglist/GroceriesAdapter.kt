package com.example.evand2_shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evand2_shoppinglist.databinding.CellLayoutBinding

class GroceriesAdapter(private var grocery: MutableList<Articles>)
    : RecyclerView.Adapter<GroceriesHolder>() {

    interface onItemClickListener{
        fun onItemClicked(grocery: MutableList<Articles>)
    }

    private lateinit var binding: CellLayoutBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceriesHolder {
        binding = CellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return GroceriesHolder(binding)
    }
    override fun getItemCount(): Int = grocery.size

    override fun onBindViewHolder(holder: GroceriesHolder, position: Int) {
        holder.bind(grocery[position])
    }
}