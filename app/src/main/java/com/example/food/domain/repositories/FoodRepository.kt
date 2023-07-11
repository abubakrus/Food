package com.example.food.domain.repositories

import com.example.food.domain.models.FoodCategory
import com.example.food.domain.models.Recipe
import com.example.food.domain.models.RecommendationsEvent

interface FoodRepository {
    fun fetchAllRecommendationsEvents():List<RecommendationsEvent>
    fun fetchAllRecipes():List<Recipe>
    fun fetchAllFoodCategories():List<FoodCategory>

}