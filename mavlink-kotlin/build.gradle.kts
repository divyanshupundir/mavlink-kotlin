plugins {
    kotlin("jvm")
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

dependencies {
    api(Deps.mavlinkKotlinApi)
    api(Deps.mavlinkKotlinSerialization)

    testImplementation(project(":definitions"))
    testImplementation(TestDeps.droneFleetMavlink)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
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
