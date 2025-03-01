package com.example.database.favorites

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object FavoriteService {
    fun addFavorite(userId: Int, listingId: Int) {
        transaction {
            FavoritesEntity.insert {
                it[FavoritesEntity.userId] = userId
                it[FavoritesEntity.listingId] = listingId
            }
        }
    }

    fun getFavoritesByUser(userId: Int): List<Int> {
        return transaction {
            FavoritesEntity.select { FavoritesEntity.userId eq userId }
                .map { it[FavoritesEntity.listingId] }
        }
    }
}
