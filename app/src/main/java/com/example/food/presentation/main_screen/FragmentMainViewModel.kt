package com.example.food.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.example.food.data.repositories.FoodRepositoryImpl
import com.example.food.data.repositories.UserRepositoryImpl
import com.example.food.domain.models.FoodCategory
import com.example.food.domain.models.Recipe
import com.example.food.domain.models.RecommendationsEvent
import com.example.food.domain.models.User
import com.example.food.domain.repositories.FoodRepository
import com.example.food.domain.use_cases.FetchAllFoodCategoriesUseCase
import com.example.food.domain.use_cases.FetchAllRecommendationsEventsUseCase
import com.example.food.domain.use_cases.FetchAllRecipesUseCase
import com.example.food.domain.use_cases.FetchCurrentUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainFragmentUiState(
    val recommendationsEvents:List<RecommendationsEvent> = emptyList(),
    val recipes:List<Recipe>  = emptyList(),
    val foodCategories:List<FoodCategory> = emptyList(),
    val currentUser:User = User.unknown(),
)

class FragmentMainViewModel : ViewModel() {
    private val foodRepository:FoodRepository= FoodRepositoryImpl()
    private val userRepository:UserRepositoryImpl= UserRepositoryImpl()
    private val fetchAllRecommendationsEventsUseCase = FetchAllRecommendationsEventsUseCase(foodRepository)
    private val fetchAllRecipesUseCase = FetchAllRecipesUseCase(foodRepository)
    private val fetchAllFoodCategoriesUseCase = FetchAllFoodCategoriesUseCase(foodRepository)
    private val fetchCurrentUserUseCase = FetchCurrentUserUseCase(userRepository)

    private val _uiStateFlow = MutableStateFlow(MainFragmentUiState())
    val uiStateFlow = _uiStateFlow.asStateFlow()

    init {
        val recommendationsEvents = fetchAllRecommendationsEventsUseCase.invoke()
        val recipes = fetchAllRecipesUseCase.invoke()
        val foodCategories = fetchAllFoodCategoriesUseCase.invoke()
        val currentUser = fetchCurrentUserUseCase.invoke()
        val uiState = MainFragmentUiState(
            recommendationsEvents = recommendationsEvents,
            recipes = recipes,
            foodCategories = foodCategories,
            currentUser = currentUser
        )
        _uiStateFlow.tryEmit(uiState)
    }

}