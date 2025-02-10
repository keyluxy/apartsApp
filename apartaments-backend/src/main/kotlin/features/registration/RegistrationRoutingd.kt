package com.example.features.registration

import com.example.features.cache.InMemoryCache
import com.example.features.cache.TokenCache
import com.example.features.login.LoginReceiveRemote
import com.example.features.login.LoginResponseRemote
import com.example.utils.isEmailValid
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.util.UUID

fun Application.configureRegistrationRouting() {
    routing {
        post("/registr") {

            val receive = call.receive<RegistrationReceiverRemote>()

            if (!receive.email.isEmailValid()) {
                call.respond(HttpStatusCode.BadRequest, "email is not valid")
            }

            if (InMemoryCache.userList.map { it.login }.contains(receive.login)) {
                call.respond(HttpStatusCode.Conflict, "User alredy exists")
            }

            val token = UUID.randomUUID().toString()
            InMemoryCache.userList.add(receive)
            InMemoryCache.tokenList.add(TokenCache(login = receive.login, token = token))

            call.respond(RegistrationResponseRemode(token = token))
        }
    }
}

