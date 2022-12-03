package com.example.pokelist.DataClass

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonResponseObject(
    @JsonProperty("count") val count: Int,
    @JsonProperty("next") val next: String,
    @JsonProperty("previous") val previous: String?,
    @JsonProperty("results") val results: List<PokemonObject>
)