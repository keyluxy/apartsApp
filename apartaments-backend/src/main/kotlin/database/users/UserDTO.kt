package com.example.database.users

data class UserDTO(
    val id: Int,
    val login: String,
    val password: String,
    val username: String,
    val email: String
)