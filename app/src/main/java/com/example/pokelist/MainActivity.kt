package com.example.pokelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokelist.Api.RetrofitInstance
import com.example.pokelist.databinding.ActivityMainBinding
import com.example.pokelist.recyclerview.PokeAdapter
import retrofit2.HttpException
import java.io.IOException

private lateinit var binding: ActivityMainBinding
private lateinit var pokeAdapter: PokeAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupRecyclerView()
        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getPokemons()
            }catch (e: IOException) {
                Log.e(TAG, "** Vous n'avez peut être pas internet. EXCEPTION: $e")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }catch (e: HttpException){
                Log.e(TAG, "** HttpException, réponse innatendue. EXCEPTION: $e")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }
            val results = response.body()?.results
            if(response.isSuccessful && results != null) {
                pokeAdapter.todos = results
            } else {
                Log.e(TAG, "** Response incorrecte.")
            }
            binding.progressBar.isVisible = false
        }
        OnViewCreated()
    }

    private fun setupRecyclerView() = binding.rvPoke.apply {
        pokeAdapter = PokeAdapter()
        adapter = pokeAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun OnViewCreated(){
    }



}