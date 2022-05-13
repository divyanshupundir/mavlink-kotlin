pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
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
