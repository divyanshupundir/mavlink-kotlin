object Deps {
    const val jacksonDataFormatXml = "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.0"
    const val jacksonModuleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2"

    const val kotlinPoet = "com.squareup:kotlinpoet:1.11.0"
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:2.2.21"

    const val mavlinkKotlin = "com.urbanmatrix.mavlink:mavlink-kotlin:${Specs.Lib.releaseVersion}"
    const val mavlinkKotlinApi = "com.urbanmatrix.mavlink:api:${Specs.Lib.releaseVersion}"
    const val mavlinkKotlinSerialization = "com.urbanmatrix.mavlink:serialization:${Specs.Lib.releaseVersion}"
    const val mavlinkKotlinDefinitions = "com.urbanmatrix.mavlink:definitions:${Specs.Lib.releaseVersion}"
}

object TestDeps {
    const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:5.8.2"
    const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:5.8.2"
}
