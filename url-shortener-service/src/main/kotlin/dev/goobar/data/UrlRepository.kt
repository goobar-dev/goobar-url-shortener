package dev.goobar.data

/**
 * Placeholder repository to simulate ADD/REMOVE operations
 */
object UrlRepository {

    val data: MutableList<ShortenedUrl> = mutableListOf(
        ShortenedUrl(
            id = 0,
            url = "https://ktor.io/docs/welcome.html",
            urlKey = "welcome",
            description = "Ktor Welcome Page"
        ),
        ShortenedUrl(
            id = 1,
            url = "https://goobar.dev/",
            urlKey = "goobar",
            description = null
        ),
    )

}
