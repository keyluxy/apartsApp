package com.example.database.users

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object UserService {
    fun register(userDTO: UserDTO): Int {
        return transaction {
            UsersEntity.insert {
                it[login] = userDTO.login
                it[password] = userDTO.password
                it[email] = userDTO.email
                it[username] = userDTO.username
            } get UsersEntity.id
        }
    }

    fun getUserByLogin(login: String): UserDTO? {
        return transaction {
            UsersEntity.select { UsersEntity.login.eq(login) }
                .map { row ->
                    UserDTO(
                        id = row[UsersEntity.id],
                        login = row[UsersEntity.login],
                        password = row[UsersEntity.password],
                        email = row[UsersEntity.email],
                        username = row[UsersEntity.username]
                    )
                }
                .singleOrNull()
        }
    }
}
