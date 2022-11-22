package com.example.pokelist.Api

import com.example.pokelist.DataClass.PokemonList
import retrofit2.Response
import retrofit2.http.GET

interface PokeApi {

    @GET("/api/v2/pokemon")
    suspend fun getPokemons(): Response<List<PokemonList>>

}