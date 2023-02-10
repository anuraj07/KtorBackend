package com.deep

import com.deep.db.DatabaseFactory
import com.deep.repository.UserRepository
import com.deep.repository.UserRepositoryImpl
import com.deep.routes.authRoutes
import com.deep.service.UserService
import com.deep.service.UserServiceImpl
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.jackson.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        DatabaseFactory.init()

        install(ContentNegotiation) {
            jackson()
        }

        val service: UserService = UserServiceImpl()
        val repository: UserRepository = UserRepositoryImpl(service)

        authRoutes(repository)

    }.start(wait = true)
}
