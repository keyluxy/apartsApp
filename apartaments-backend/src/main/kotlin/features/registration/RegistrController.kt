//package com.example.features.registration
//
//import com.example.database.tokens.TokenDTO
//import com.example.database.tokens.TokenEntity
//import com.example.database.users.UserDTO
//import com.example.database.users.UsersEntity
//import io.ktor.http.HttpStatusCode
//import io.ktor.server.application.ApplicationCall
//import io.ktor.server.response.respond
//import java.util.UUID
//
//class RegistrController(val call: ApplicationCall) {
//
//    suspend fun registerNewUser(
//        registrationReceiverRemote: RegistrationReceiverRemote
//    ) {
//
//        val userDTO = UsersEntity.fetchUser(registrationReceiverRemote.login)
//
//        UsersEntity.insert(
//            UserDTO (
//                login = registrationReceiverRemote.login,
//                password = registrationReceiverRemote.password,
//                email = registrationReceiverRemote.email,
//                username = "",
//                id =
//            )
//        )
//
//        if (userDTO != null) {
//            call.respond(HttpStatusCode.Conflict, "User alredy exists")
//        } else {
//            val token = UUID.randomUUID().toString()
//            TokenEntity.insert(
//                TokenDTO(
//                    id = UUID.randomUUID().toString(),
//                    login = registrationReceiverRemote.login,
//                    token = token
//                )
//            )
//            call.respond(RegistrationResponseRemode(token = token))
//        }
//
//    }
//}