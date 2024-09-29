@file:Suppress("ConstPropertyName")

object Config {
    const val group = "com.divpundir.mavlink"

    object Plugin {
        const val releaseVersion = "1.2.8"
        const val developmentVersion = "1.2.9-alpha"

        const val releaseApi = "$group:api:$releaseVersion"
        const val releaseSerialization = "$group:serialization:$releaseVersion"
    }

    object Lib {
        const val developmentVersion = "1.2.9-alpha"
    }
}
