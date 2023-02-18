import org.gradle.api.JavaVersion

object Config {
    const val group = "xyz.urbanmatrix.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "0.14.0"
        const val developmentVersion = "0.16.3-alpha"
    }

    object Lib {
        const val developmentVersion = "0.16.0-alpha"
    }
}
