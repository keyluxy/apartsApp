package com.example.database.favorites

import com.example.database.users.UsersEntity
import org.jetbrains.exposed.sql.Table
import com.example.database.ListingsEntity.ListingsEntity

object FavoritesEntity : Table("favorites") {
    val id = integer("id").autoIncrement()
    val userId = integer("user_id").references(UsersEntity.id)
    val listingId = integer("listing_id").references(ListingsEntity.id)

    override val primaryKey = PrimaryKey(id)
}
