pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(uri("build/localPluginRepository"))
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

include("api")
include("serialization")
include("generator")
include("mavlink-kotlin")
