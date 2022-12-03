package com.example.pokelist.DataClass

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonObject(
    @JsonProperty("name") val name: String,
    @JsonProperty("url") val url: String
)