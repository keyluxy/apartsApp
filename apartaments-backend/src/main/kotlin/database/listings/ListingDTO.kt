package com.example.database.listings

import kotlinx.serialization.Serializable

@Serializable
data class ListingDTO(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val location: String,
    val sourceId: Int,
    val userId: Int?
)
