pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "1.9.0"
        id("com.vanniktech.maven.publish") version "0.24.0"
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "mavlink-kotlin-root"

include(":api")
include(":serialization")
include(":generator")

include(":definitions")

include(":connections:connection-core")
include(":connections:connection-tcp")
include(":connections:connection-udp")

include(":adapters:adapter-rxjava2")
include(":adapters:adapter-rxjava3")
include(":adapters:adapter-coroutines")
