package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(Netty, port = 4242, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Koin) {
        modules(appModule)
    }

    configureSecurity()
    configureSerialization()
    configureDatabase()
    configureRouting()
}
