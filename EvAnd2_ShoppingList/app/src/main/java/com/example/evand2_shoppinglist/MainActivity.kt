package com.example.evand2_shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.evand2_shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.customToolbar
        setSupportActionBar(toolbar.mainToolbar)

    }

    override fun onStart() {
        super.onStart()
        var navController = findNavController(R.id.navHostFragment)
       val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainMenuFragment
            )
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }
}