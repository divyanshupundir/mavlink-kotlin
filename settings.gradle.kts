pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(uri("generator/build/localPluginRepository"))
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/urbanmatrix/mavlink-kotlin")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    plugins {
        kotlin("jvm") version "1.6.20"
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
