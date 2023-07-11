package com.example.food.domain.use_cases

import com.example.food.domain.models.Recipe
import com.example.food.domain.repositories.FoodRepository

class FetchAllRecipesUseCase (
    private val repository: FoodRepository
){
    operator fun invoke():List<Recipe>{
        return repository.fetchAllRecipes()
    }
}