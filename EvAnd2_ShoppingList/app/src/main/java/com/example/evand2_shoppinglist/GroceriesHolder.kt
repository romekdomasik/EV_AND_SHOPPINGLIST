package com.example.evand2_shoppinglist

import androidx.recyclerview.widget.RecyclerView
import com.example.evand2_shoppinglist.databinding.CellLayoutBinding

class GroceriesHolder(private var viewBinding: CellLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(grocery: Articles) {
            viewBinding.qtResult.text = grocery.quantite
            viewBinding.articleResult.text = grocery.nom
        }
    }