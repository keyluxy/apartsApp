package com.example.database.tokens

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object TokenService {
    fun saveToken(tokenDTO: TokenDTO) {
        transaction {
            TokensEntity.insert {
                it[userId] = tokenDTO.userId
                it[token] = tokenDTO.token
            }
        }
    }

    fun getUserByToken(token: String): Int? {
        return transaction {
            TokensEntity.select { TokensEntity.token eq token }
                .map { it[TokensEntity.userId] }
                .singleOrNull()
        }
    }
}
