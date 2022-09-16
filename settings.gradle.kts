pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "1.7.10"
        id("com.vanniktech.maven.publish") version "0.22.0"
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
include("adapters:coroutines")
