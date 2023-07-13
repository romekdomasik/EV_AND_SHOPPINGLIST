package com.example.evand2_shoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evand2_shoppinglist.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    val listOfGroceries = mutableListOf<Articles>()
    companion object {
        const val FRAGMENT_RESULT = "FRAGMENT_RESULT"
        const val NAME_RESULT = "NAME_RESULT"
        const val QUANTITE_RESULT = "QUANTITE_RESULT"
        const val CAT_RESULT = "CAT_RESULT"
    }

    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        val btnNew = binding.btnNew

        btnNew.setOnClickListener {
            findNavController().navigate(MainMenuFragmentDirections.actionMainMenuFragmentToNewArticleFragment())
        }
        setFragmentResultListener(FRAGMENT_RESULT) { key, bundle ->
            val name = bundle.getString(NAME_RESULT) ?: ""
            val qt = bundle.getString(QUANTITE_RESULT) ?: ""
            val cat = bundle.getString(CAT_RESULT) ?: ""
            // on cree une variable personne qui cree un obj Contact avec les resultats ci-dessus
            val produit = Articles(name, qt, cat)
            // on l'ajoute à la liste
            listOfGroceries.add(produit)
        }



    }


    private fun setupRecyclerView() {

        //récupération du composant RecyclerView
        val recyclerView = binding?.myRecyclerView

        //defintion de son layout
        recyclerView?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false)

        recyclerView?.adapter = GroceriesAdapter(listOfGroceries.sortedBy {
            it.nom
        }.toMutableList())
    }




}