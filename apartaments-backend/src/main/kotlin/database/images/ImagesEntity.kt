package com.example.database.images

import com.example.database.ListingsEntity.ListingsEntity
import org.jetbrains.exposed.sql.Table

object ImagesEntity : Table("images") {
    val id = integer("id").autoIncrement()
    val listingId = integer("listing_id").references(ListingsEntity.id)
    val imageUrl = varchar("image_url", 500)

    override val primaryKey = PrimaryKey(id)
}
