package dev.goobar.plugins

import dev.goobar.resources.status
import dev.goobar.resources.urlKey
import dev.goobar.resources.urls
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        status()
        urlKey()
        urls()
    }
}
