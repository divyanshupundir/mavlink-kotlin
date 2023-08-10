@file:Suppress("ConstPropertyName")

import org.gradle.api.JavaVersion

object Config {
    const val group = "com.divpundir.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "1.0.0"
        const val developmentVersion = "1.0.1"

        const val releaseApi = "com.divpundir.mavlink:api:$releaseVersion"
        const val releaseSerialization = "com.divpundir.mavlink:serialization:$releaseVersion"
    }

    object Lib {
        const val developmentVersion = "1.0.1"
    }
}
