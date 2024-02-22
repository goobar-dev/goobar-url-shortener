package dev.goobar.resources

import dev.goobar.data.ShortenUrlRequestBody
import dev.goobar.data.ShortenedUrl
import dev.goobar.data.UrlRepository
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

@Resource("/urls")
data object AllUrls {
    @Resource("shorten")
    data class Shorten(val parent: AllUrls = AllUrls)
}

fun Routing.urls() {

    get<AllUrls> {
        call.respond(HttpStatusCode.OK, UrlRepository.data)
    }

    post<AllUrls.Shorten, ShortenUrlRequestBody> { resource, body ->

        val urlKey = UUID.randomUUID().toString()

        val shortenedUrl = ShortenedUrl(
            id = System.currentTimeMillis(),
            url = body.url,
            urlKey = urlKey,
            description = body.description
        )
        UrlRepository.data.add(shortenedUrl)

        call.respond(shortenedUrl)
    }
}
