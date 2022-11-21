package com.example.pokelist.repository

import com.example.pokelist.Api.RetrofitInstance
import com.example.pokelist.DataClass.Pokemon
import com.example.pokelist.DataClass.PokemonList

class Repository {

    suspend fun getPokemon(): PokemonList {
        return RetrofitInstance.api.getPokemonList()
    }
}