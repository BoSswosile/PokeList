package com.example.pokelist.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.Lazy as lazy

object RetrofitInstance {

    val BASE_URL = "https://pokeapi.co/"

    val api: PokeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }
}