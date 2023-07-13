package com.example.evand2_shoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.evand2_shoppinglist.MainMenuFragment.Companion.CAT_RESULT
import com.example.evand2_shoppinglist.MainMenuFragment.Companion.FRAGMENT_RESULT
import com.example.evand2_shoppinglist.MainMenuFragment.Companion.NAME_RESULT
import com.example.evand2_shoppinglist.MainMenuFragment.Companion.QUANTITE_RESULT

class NewArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBack = view.findViewById<Button>(R.id.btnEnregistrer)
        val name = view.findViewById<TextEdit>()

        btnBack.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(NAME_RESULT, name)
            bundle.putString(QUANTITE_RESULT, qt)
            bundle.putString(CAT_RESULT, cat)
            setFragmentResult(FRAGMENT_RESULT, bundle)
            findNavController().navigateUp()


        }
    }


}