package com.example.database.listings

import com.example.database.ListingsEntity.ListingsEntity
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object ListingService {
    fun addListing(listing: ListingDTO): Int {
        return transaction {
            ListingsEntity.insert {
                it[title] = listing.title
                it[description] = listing.description
                it[price] = listing.price
                it[location] = listing.location
                it[sourceId] = listing.sourceId
                it[userId] = listing.userId
            } get ListingsEntity.id
        }
    }

    fun getAllListings(): List<ListingDTO> {
        return transaction {
            ListingsEntity.selectAll().map {
                ListingDTO(
                    id = it[ListingsEntity.id],
                    title = it[ListingsEntity.title],
                    description = it[ListingsEntity.description],
                    price = it[ListingsEntity.price],
                    location = it[ListingsEntity.location],
                    sourceId = it[ListingsEntity.sourceId],
                    userId = it[ListingsEntity.userId]
                )
            }
        }
    }
}
