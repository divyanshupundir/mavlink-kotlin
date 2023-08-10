pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("testlibs") {
            from(files("gradle/testlibs.versions.toml"))
        }
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
