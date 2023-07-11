package com.example.food.presentation.main_screen.view_pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food.R
import com.example.food.databinding.ItemRecommendationEventBinding
import com.example.food.domain.models.RecommendationsEvent

class ViewPagerAdapter:RecyclerView.Adapter<ViewPagerViewHolder>() {
    private val events = mutableListOf<RecommendationsEvent>()
    fun updateData(newList:List<RecommendationsEvent>){
        events.clear()
        events.addAll(newList)
            notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_recommendation_event, parent, false)
        val binding = ItemRecommendationEventBinding.bind(view)
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(events[position])
    }
}