@file:Suppress("ConstPropertyName")

import org.gradle.api.JavaVersion

object Config {
    const val group = "com.divpundir.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "1.1.1"
        const val developmentVersion = "1.1.2"

        const val releaseApi = "$group:api:$releaseVersion"
        const val releaseSerialization = "$group:serialization:$releaseVersion"
    }

    object Lib {
        const val developmentVersion = "1.1.2"
    }
}
