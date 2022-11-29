package com.example.pokelist.Api

import com.example.pokelist.DataClass.PokemonResponseObject
import retrofit2.Response
import retrofit2.http.GET

interface PokeApi {

    @GET("/api/v2/pokemon?limit=100")
    suspend fun getPokemons(): Response<PokemonResponseObject>

}