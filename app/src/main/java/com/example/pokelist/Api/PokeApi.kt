package com.example.pokelist.Api

import com.example.pokelist.DataClass.Pokemon
import com.example.pokelist.DataClass.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.OffsetTime

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
    ): Pokemon
}