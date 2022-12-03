package com.example.pokelist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokelist.DataClass.PokemonObject
import com.example.pokelist.databinding.ItemTodoBinding

class PokeAdapter : RecyclerView.Adapter<PokeAdapter.PokeViewHolder>(){
    inner class PokeViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<PokemonObject>() {
        override fun areContentsTheSame(oldItem: PokemonObject, newItem: PokemonObject): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areItemsTheSame(oldItem: PokemonObject, newItem: PokemonObject): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var todos: List<PokemonObject>
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
        holder.itemView.setOnClickListener {

        }
    }

    }