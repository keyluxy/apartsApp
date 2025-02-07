package com.example.features.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRemote(
    val login: String,
    val email: String,
    val password: String
)

@Serializable
data class RegistrationResponseModel(
    val token: String
)
