val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.conventionalCommits)
}

group = "dev.goobar"
version = "0.0.1"

application {
    mainClass.set("dev.goobar.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

// accepted types: feat, fix, build, chore, ci, docs, style, refactor, perf, test, tmp
// simplified commit format: 'type(scope): message'
// example commit: 'feat(android): Added app widget'
//
// see https://www.conventionalcommits.org/en/v1.0.0/ for more details on conventional commits
conventionalCommits {
    types += listOf("tmp")
    scopes += listOf("shortener-service", "android", "ios")
    failureMessage = "The commit message does not meet the Conventional Commit standard"
}

dependencies {

    implementation(libs.bundles.ktor.server)
    implementation(libs.logback.classic)

    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}
