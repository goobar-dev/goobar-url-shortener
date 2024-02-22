package dev.goobar.data.environment

import kotlinx.serialization.Serializable

@Serializable
enum class DeploymentEnvironment {
    LOCAL,
    DOCKER,
    DEV,
    PROD
}