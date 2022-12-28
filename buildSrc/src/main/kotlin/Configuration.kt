import org.gradle.api.JavaVersion

object Config {
    const val group = "xyz.urbanmatrix.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "0.12.2"
        const val developmentVersion = "0.14.0"
    }

    object Lib {
        const val developmentVersion = "0.12.3"
    }
}
