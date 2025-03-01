//package com.example.features.registration
//
//import com.example.utils.isEmailValid
//import io.ktor.http.HttpStatusCode
//import io.ktor.server.application.Application
//import io.ktor.server.request.receive
//import io.ktor.server.response.respond
//import io.ktor.server.routing.post
//import io.ktor.server.routing.routing
//
//fun Application.configureRegistrationRouting() {
//    routing {
//        post("/registr") {
//
//            val receive = call.receive<RegistrationReceiverRemote>()
//
//            if (!receive.email.isEmailValid()) {
//                call.respond(HttpStatusCode.BadRequest, "email is not valid")
//            }
//
//
//        }
//    }
//}
//
