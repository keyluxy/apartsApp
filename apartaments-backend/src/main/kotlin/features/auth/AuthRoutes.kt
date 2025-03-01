package com.example.features.auth

import com.example.database.tokens.TokenDTO
import com.example.database.users.UserDTO
import com.example.database.tokens.TokenService
import com.example.database.users.UserService
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import kotlinx.serialization.Serializable
import java.util.UUID


@Serializable
data class AuthRequest(val login: String, val password: String, val email: String)
@Serializable
data class AuthResponse(val token: String)

fun Application.authRoutes() {
    routing {
        post("/register") {
            val request = call.receive<AuthRequest>()

            val userExists = UserService.getUserByLogin(request.login)
            if (userExists != null) {
                call.respond(mapOf("error" to "User already exists"))
                return@post
            }

            val userId = UserService.register(
                UserDTO(
                    id = 0,
                    login = request.login,
                    password = request.password,
                    email = request.email,
                    username = null
                )
            )

            val token = UUID.randomUUID().toString()
            TokenService.saveToken(TokenDTO(userId, token))

            call.respond(AuthResponse(token))
        }

        post("/login") {
            val request = call.receive<AuthRequest>()
            val user = UserService.getUserByLogin(request.login)

            if (user == null || user.password != request.password) {
                call.respond(mapOf("error" to "Invalid credentials"))
                return@post
            }

            val token = UUID.randomUUID().toString()
            TokenService.saveToken(TokenDTO(user.id, token))

            call.respond(AuthResponse(token))
        }
    }
}
