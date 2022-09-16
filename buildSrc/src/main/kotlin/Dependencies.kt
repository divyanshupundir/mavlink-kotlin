object Deps {
    const val jacksonDataFormatXml = "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.0"
    const val jacksonModuleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2"

    const val kotlinPoet = "com.squareup:kotlinpoet:1.11.0"
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:2.2.21"
    const val rxJava3 = "io.reactivex.rxjava3:rxjava:3.1.5"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"

    const val mavlinkKotlinApi = "xyz.urbanmatrix.mavlink:api:${Specs.Plugin.releaseVersion}"
    const val mavlinkKotlinSerialization = "xyz.urbanmatrix.mavlink:serialization:${Specs.Plugin.releaseVersion}"
}

object TestDeps {
    const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:5.8.2"
    const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:5.8.2"

    const val droneFleetMavlink = "io.dronefleet.mavlink:mavlink:1.1.9"
}
