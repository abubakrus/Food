package com.example.food.domain.use_cases

import com.example.food.domain.models.RecommendationsEvent
import com.example.food.domain.repositories.FoodRepository

class FetchAllRecommendationsEventsUseCase (
    private val repository: FoodRepository
        ){
    operator fun invoke():List<RecommendationsEvent>{
        return repository.fetchAllRecommendationsEvents()
    }
}