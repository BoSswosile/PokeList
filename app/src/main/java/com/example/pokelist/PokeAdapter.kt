package com.example.pokelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokelist.DataClass.PokemonList
import com.example.pokelist.databinding.ItemTodoBinding

class PokeAdapter : RecyclerView.Adapter<PokeAdapter.PokeViewHolder>(){
    inner class PokeViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<PokemonList>() {
        override fun areContentsTheSame(oldItem: PokemonList, newItem: PokemonList): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areItemsTheSame(oldItem: PokemonList, newItem: PokemonList): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var todos: List<PokemonList>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        return PokeViewHolder(ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        holder.binding.apply {
            val todo = todos[position]
            tvTitle.text = todo.name
        }
    }

    }