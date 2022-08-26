plugins {
    kotlin("jvm")
    id("${Specs.group}.generator") version Specs.Plugin.releaseVersion
    idea
    `maven-publish`
}

version = Specs.Lib.developmentVersion

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

val genSrcDir = file("src/main/kotlin-gen")

tasks.getByName<xyz.urbanmatrix.mavlink.generator.plugin.MavlinkGeneratorTask>("generateMavlink") {
    include(file("mavlink/message_definitions/v1.0/minimal.xml"))
    include(file("mavlink/message_definitions/v1.0/common.xml"))
    include(file("mavlink/message_definitions/v1.0/ardupilotmega.xml"))
    include(file("mavlink/message_definitions/v1.0/ASLUAV.xml"))
    include(file("mavlink/message_definitions/v1.0/AVSSUAS.xml"))
    include(file("mavlink/message_definitions/v1.0/icarous.xml"))
    include(file("mavlink/message_definitions/v1.0/matrixpilot.xml"))
    include(file("mavlink/message_definitions/v1.0/paparazzi.xml"))
    include(file("mavlink/message_definitions/v1.0/standard.xml"))
    include(file("mavlink/message_definitions/v1.0/ualberta.xml"))
    include(file("mavlink/message_definitions/v1.0/uAvionix.xml"))

    generatedSourcesDir = genSrcDir
}

sourceSets.getByName("main") {
    java.srcDir(genSrcDir)
}

dependencies {
    implementation(Deps.mavlinkKotlinApi)
    implementation(Deps.mavlinkKotlinSerialization)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/urbanmatrix/mavlink-kotlin")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
