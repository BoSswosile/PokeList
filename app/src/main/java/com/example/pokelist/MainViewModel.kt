package com.example.pokelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokelist.DataClass.Pokemon
import com.example.pokelist.DataClass.PokemonList
import com.example.pokelist.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<PokemonList> = MutableLiveData()

    fun getPokemon(){
        viewModelScope.launch {
            val response = repository.getPokemon()
            myResponse.value = response
        }
    }
}