package com.example.database.tokens

import com.example.database.users.UserDTO
import com.example.database.users.UsersEntity
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object TokenEntity: Table() {
    val id = TokenEntity.integer("id").autoIncrement()
    val login = TokenEntity.varchar("login", 25)
    val token = TokenEntity.varchar("token", 50)

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
            password = userEntity[UsersEntity.password],
            username = userEntity[UsersEntity.username],
            email = userEntity[UsersEntity.email]
        )
    }
}

