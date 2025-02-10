package com.example.features.cache

import com.example.features.registration.RegistrationReceiverRemote

data class TokenCache (
    val login: String,
    val token: String
)

object InMemoryCache {
    val userList: MutableList<RegistrationReceiverRemote> = mutableListOf()
    val tokenList: MutableList<TokenCache> = mutableListOf()
}