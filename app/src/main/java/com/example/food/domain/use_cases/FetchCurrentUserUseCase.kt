package com.example.food.domain.use_cases

import com.example.food.domain.models.User
import com.example.food.domain.repositories.UserRepository

class FetchCurrentUserUseCase(
    private val repository:UserRepository
) {
    operator fun invoke():User{
        return repository.fetchCurrentUser()
    }
}