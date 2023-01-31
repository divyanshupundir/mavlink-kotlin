import org.gradle.api.JavaVersion

object Config {
    const val group = "xyz.urbanmatrix.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "0.16.0-alpha"
        const val developmentVersion = "0.16.1-alpha"
    }

    object Lib {
        const val developmentVersion = "0.16.0-alpha"
    }
}
