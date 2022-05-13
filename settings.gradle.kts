pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(uri("build/localPluginRepository"))
    }
    plugins {
        kotlin("jvm") version "1.6.20"
    }
}

rootProject.name = "mavlink-kotlin-root"

include("api")
include("serialization")
include("generator")
include("mavlink-kotlin")
