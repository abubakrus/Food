package com.example.food.domain.use_cases

import com.example.food.domain.models.FoodCategory
import com.example.food.domain.repositories.FoodRepository

class FetchAllFoodCategoriesUseCase (
    private val repository: FoodRepository
        ){
    operator fun invoke(): List<FoodCategory> {
        return repository.fetchAllFoodCategories()
    }
}