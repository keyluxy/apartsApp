package com.example.database.users

import org.jetbrains.exposed.sql.*

object UsersEntity : Table("users") {
    val id = integer("id").autoIncrement()
    val login = varchar("login", 50).uniqueIndex()
    val password = varchar("password", 255)
    val email = varchar("email", 100).uniqueIndex()
    val username = varchar("username", 50).nullable()

    override val primaryKey = PrimaryKey(id)
}
