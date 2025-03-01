package com.example.database.tokens

import kotlinx.serialization.Serializable

@Serializable
data class TokenDTO(
    val userId: Int,
    val token: String
)
