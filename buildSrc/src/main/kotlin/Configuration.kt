import org.gradle.api.JavaVersion

object Config {
    const val group = "com.divpundir.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "0.19.0-alpha"
        const val developmentVersion = "0.19.0-alpha.2"
    }

    object Lib {
        const val developmentVersion = "0.19.0-alpha"
    }
}
