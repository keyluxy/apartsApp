package com.example.database.ListingsEntity


import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import com.example.database.users.UsersEntity
import com.example.database.sources.SourcesEntity

object ListingsEntity : Table("listings") {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 255)
    val description = text("description")
    val price = integer("price")
    val location = varchar("location", 255)
    val sourceId
        get() = integer("source_id").references(SourcesEntity.id)
    val userId = integer("user_id").references(UsersEntity.id).nullable()

    override val primaryKey = PrimaryKey(id)

//    fun insertListing(listingDTO: ListingsEntity): Int {
//        return transaction {
//            ListingsEntity.insert {
//                it[title] = listingDTO.title
//                it[description] = listingDTO.description
//                it[price] = listingDTO.price
//                it[location] = listingDTO.location
//                it[sourceId] = listingDTO.sourceId
//                it[userId] = listingDTO.userId
//            } get id
//        }
//    }
}
