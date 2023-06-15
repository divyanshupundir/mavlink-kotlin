object Deps {

    object Jackson {
        const val dataFormatXml = "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.0"
        const val moduleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2"
    }

    object ReactiveX {
        const val rxJava2 = "io.reactivex.rxjava2:rxjava:2.2.21"
        const val rxJava3 = "io.reactivex.rxjava3:rxjava:3.1.6"
    }

    object Kotlin {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1"
    }

    object MavlinkKotlin {
        const val api = "com.divpundir.mavlink:api:${Config.Plugin.releaseVersion}"
        const val serialization = "com.divpundir.mavlink:serialization:${Config.Plugin.releaseVersion}"
    }

    const val kotlinPoet = "com.squareup:kotlinpoet:1.13.2"
    const val okio = "com.squareup.okio:okio:3.3.0"
}

object TestDeps {

    object DroneFleet {
        const val mavlink = "io.dronefleet.mavlink:mavlink:1.1.9"
    }

    object Jupiter {
        private const val version = "5.9.3"
        const val api = "org.junit.jupiter:junit-jupiter-api:$version"
        const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"
    }
}
