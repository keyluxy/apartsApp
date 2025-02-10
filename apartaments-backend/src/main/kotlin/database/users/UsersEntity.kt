package com.example.database.users

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object UsersEntity : Table("users") {
    val id = integer("id").autoIncrement()
    val login = varchar("login", 25)
    val password = varchar("password", 25)
    val username = varchar("username", 35)
    val email = varchar("email", 20)

    override val primaryKey = PrimaryKey(id)

    fun insert(userDTO: UserDTO): Int {
        return transaction {
            UsersEntity.insert {
                it[login] = userDTO.login
                it[password] = userDTO.password
                it[username] = userDTO.username
                it[email] = userDTO.email
            } get UsersEntity.id
        }
    }

    fun fetchUser(login: String): UserDTO {
        val userEntity = UsersEntity.select { UsersEntity.login.eq(login) }.single()
        return UserDTO(
            id = userEntity[id],
            login = userEntity[UsersEntity.login],
            password = userEntity[password],
            username = userEntity[username],
            email = userEntity[email]
        )
    }
}

