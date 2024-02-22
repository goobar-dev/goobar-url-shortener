package dev.goobar.data.environment

import kotlinx.serialization.Serializable

@Serializable
data class DeploymentInfo(
    val environment: DeploymentEnvironment,
    val revision: String
)