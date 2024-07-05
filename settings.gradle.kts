pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    // Disable the repositoriesMode for now, as it causes issues with publishing
    // repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
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

rootProject.name = "mavlink-kotlin"

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

include(":examples:connection-tcp-client")
include(":examples:connection-tcp-server")
include(":examples:connection-udp-client")
include(":examples:connection-udp-server")
