package com.example.database.tokens

import com.example.database.users.UsersEntity
import org.jetbrains.exposed.sql.*

object TokensEntity : Table("tokens") {
    val id = integer("id").autoIncrement()
    val userId = integer("user_id").references(UsersEntity.id)
    val token = varchar("token", 255).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
