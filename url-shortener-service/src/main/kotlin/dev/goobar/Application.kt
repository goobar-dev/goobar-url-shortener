package dev.goobar

import dev.goobar.data.environment.DeploymentEnvironment
import dev.goobar.data.environment.DeploymentInfo
import dev.goobar.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureMonitoring()
    configureHTTP()
    configureTypeSafeRouting()
    configureRouting()
}

val Application.deploymentInfo: DeploymentInfo
    get() {
        val envProperty = environment.config.property("ktor.environment")
        val env = DeploymentEnvironment.valueOf(envProperty.getString().uppercase())
        val revisionProperty = environment.config.property("ktor.revision").getString()

        return DeploymentInfo(env, revisionProperty)
    }
