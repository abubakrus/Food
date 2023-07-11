package com.example.food.data.repositories

import com.example.food.data.fake_data.FakeData
import com.example.food.domain.models.FoodCategory
import com.example.food.domain.models.Recipe
import com.example.food.domain.models.RecommendationsEvent
import com.example.food.domain.repositories.FoodRepository

class FoodRepositoryImpl: FoodRepository {
    override fun fetchAllRecommendationsEvents(
    ): List<RecommendationsEvent> {
        return FakeData.fakeRecommendationsEvents()
    }

    override fun fetchAllRecipes(
    ): List<Recipe> {
        return FakeData.fakeRecipes()
    }

    override fun fetchAllFoodCategories(): List<FoodCategory> {
        return FakeData.fakeFoodCategory()
    }
}