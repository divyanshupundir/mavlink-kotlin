plugins {
    kotlin("jvm")
    `maven-publish`
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    implementation(Deps.mavlinkKotlin)
    api(Deps.rxJava3)

    testImplementation(Deps.mavlinkKotlinDefinitions)
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
