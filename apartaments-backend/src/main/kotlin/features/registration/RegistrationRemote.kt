package com.example.features.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationReceiverRemote(
    val login: String,
    val email: String,
    val password: String
)

@Serializable
data class RegistrationResponseRemode(
    val token: String
)
