package com.example.food.data.repositories

import com.example.food.domain.models.User
import com.example.food.domain.repositories.UserRepository

class UserRepositoryImpl: UserRepository {
    override fun fetchCurrentUser(): User {
        return User(
            id = "00",
            name = "abubakir",
            lastName = "usenbaev",
            avatarUrl = "https://podborkiserialov.ru/wp-content/uploads/2021/01/barinov.jpg"
)
}
}