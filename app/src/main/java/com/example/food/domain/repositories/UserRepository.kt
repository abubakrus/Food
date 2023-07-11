package com.example.food.domain.repositories

import com.example.food.domain.models.User

interface UserRepository {
    fun fetchCurrentUser(): User
}