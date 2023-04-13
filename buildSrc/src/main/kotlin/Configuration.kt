import org.gradle.api.JavaVersion

object Config {
    const val group = "com.divpundir.mavlink"
    val javaVersion = JavaVersion.VERSION_1_8

    object Plugin {
        const val releaseVersion = "0.16.8"
        const val developmentVersion = "0.16.9"
    }

    object Lib {
        const val developmentVersion = "0.16.9"
    }
}
