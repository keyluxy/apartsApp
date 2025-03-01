package com.example.database.favorites

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteDTO(
    val userId: Int,
    val listingId: Int
)
