package com.example.food.presentation.main_screen.recycler_view.recipe

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food.R
import com.example.food.databinding.ItemRecipeBinding
import com.example.food.domain.models.Recipe
import com.example.food.presentation.main_screen.recycler_view.listeners.RecipeOnClickListeners

class RecipeAdapter(
    private val listener: RecipeOnClickListeners
):RecyclerView.Adapter<RecipeViewHolder>(
) {
    private val recipes = mutableListOf<Recipe>()
    fun updateData(newList:List<Recipe>){
        recipes.clear()
        recipes.addAll(newList)
            notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        val binding = ItemRecipeBinding.bind(view)
        return RecipeViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }
}