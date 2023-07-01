import org.gradle.api.JavaVersion

object Config {
    const val group = "com.divpundir.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "0.20.0-alpha.5"
        const val developmentVersion = "0.20.0-alpha.6"
    }

    object Lib {
        const val developmentVersion = "0.20.0-alpha.6"
    }
}
