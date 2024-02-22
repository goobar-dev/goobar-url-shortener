package dev.goobar.resources

import dev.goobar.deploymentInfo
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.resources.get
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


@Resource("/status")
data object Status

fun Routing.status() {
    get<Status> {
        call.respond(HttpStatusCode.OK, call.application.deploymentInfo)
    }
}
