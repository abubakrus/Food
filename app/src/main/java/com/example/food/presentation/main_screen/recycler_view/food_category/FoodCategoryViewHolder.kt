package com.example.food.presentation.main_screen.recycler_view.food_category

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.databinding.ItemFootCategoryBinding
import com.example.food.domain.models.FoodCategory

class FoodCategoryViewHolder(
    private val binding: ItemFootCategoryBinding
): RecyclerView.ViewHolder(binding.root){
    fun bind(foodCategory: FoodCategory) =  with(binding){
        titleTextView.text = foodCategory.title
        loadImageByUrl(imageUrl = foodCategory.imageUrl, imageView= categoryImageView)
    }
    private fun loadImageByUrl(imageUrl:String, imageView: ImageView){
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}