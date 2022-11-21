package com.example.pokelist.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.Lazy as lazy

object RetrofitInstance {

    var BASE = "https://pokeapi.co/api/v2/"

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PokeApi by lazy {
        retrofit.create(PokeApi::class.java)
    }

}