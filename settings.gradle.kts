pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "1.8.21"
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
include(":mavlink-kotlin")

include(":adapters:rxjava2")
include(":adapters:rxjava3")
include(":adapters:coroutines")
