package com.example.evand2_shoppinglist


public enum class category{
    NOURRITURE,
    BOISSON,
    HYGIENE,
    MAISON
}
data class Articles(var quantite: String, var nom: String, var cat: category)
