package com.example.food.presentation.main_screen.view_pager

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.databinding.FragmentMainBinding
import com.example.food.databinding.ItemRecommendationEventBinding
import com.example.food.domain.models.RecommendationsEvent

class ViewPagerViewHolder(
    private val binding: ItemRecommendationEventBinding
): RecyclerView.ViewHolder(binding.root){
    fun bind(event: RecommendationsEvent) =  with(binding){
        titleTextView.text = event.title
        Glide.with(root.context)
            .load(event.imageUrl)
            .into(imageView)
    }
}