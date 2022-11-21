package com.example.pokelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokelist.Api.PokeApi
import com.example.pokelist.Api.RetrofitInstance
import com.example.pokelist.databinding.ActivityMainBinding
import com.example.pokelist.repository.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private lateinit var binding: ActivityMainBinding
private lateinit var viewModel: MainViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPokemon()
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.next.toString())
        })
        OnViewCreated()
    }

    private fun OnViewCreated(){
        binding.text.text = "test"


    }



}