package com.example.food.presentation.main_screen.recycler_view.recipe

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.databinding.ItemRecipeBinding
import com.example.food.domain.models.Recipe
import com.example.food.presentation.main_screen.recycler_view.listeners.RecipeOnClickListeners

class RecipeViewHolder(
    private val binding: ItemRecipeBinding,
    private val listener: RecipeOnClickListeners
    ): RecyclerView.ViewHolder(binding.root){
    fun bind(recipe:Recipe) =  with(binding){
        root.setOnClickListener{listener.onRecipeClick(recipe)}
        titleTextView.text = recipe.title
        ratingTextView.text = recipe.rating.toString()
        loadImageByUrl(imageUrl = recipe.imageUrl, imageView= backgroundImageView)
        loadImageByUrl(imageUrl = recipe.cook.avatarUrl, imageView= avatarImageView)
    }
    private fun loadImageByUrl(imageUrl:String, imageView: ImageView){
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}