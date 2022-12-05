package com.example.pokelist.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokelist.databinding.ItemTodoBinding

private lateinit var binding: ItemTodoBinding

class itemtodoViewHolder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemTodoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        OnViewCreated()
    }
    private fun OnViewCreated(){

        binding.star.setOnClickListener {
            Toast.makeText(baseContext, "Added to favourites", Toast.LENGTH_SHORT).show()
        }
    }
}
