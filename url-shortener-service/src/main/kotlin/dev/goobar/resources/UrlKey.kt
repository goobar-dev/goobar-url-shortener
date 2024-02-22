package dev.goobar.resources

import dev.goobar.data.UrlRepository
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Resource("/{urlKey}")
data class UrlKey(val urlKey: String)

fun Routing.urlKey() {
    get<UrlKey> { resource ->
        val shortenedUrl = UrlRepository.data.find { it.urlKey == resource.urlKey }

        when (shortenedUrl) {
            null -> call.respond(HttpStatusCode.NotFound)
            else -> call.respondRedirect(shortenedUrl.url)
        }
    }
}
