object Deps {

    object Jackson {
        const val dataFormatXml = "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.0"
        const val moduleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2"
    }

    object ReactiveX {
        const val rxJava2 = "io.reactivex.rxjava2:rxjava:2.2.21"
        const val rxJava3 = "io.reactivex.rxjava3:rxjava:3.1.5"
    }

    object Square {
        const val kotlinPoet = "com.squareup:kotlinpoet:1.11.0"
    }

    object MavlinkKotlin {
        const val api = "xyz.urbanmatrix.mavlink:api:${Config.Plugin.releaseVersion}"
        const val serialization = "xyz.urbanmatrix.mavlink:serialization:${Config.Plugin.releaseVersion}"
    }
}

object TestDeps {

    object DroneFleet {
        const val mavlink = "io.dronefleet.mavlink:mavlink:1.1.9"
    }

    object Jupiter {
        const val api = "org.junit.jupiter:junit-jupiter-api:5.8.2"
        const val engine = "org.junit.jupiter:junit-jupiter-engine:5.8.2"
    }
}
