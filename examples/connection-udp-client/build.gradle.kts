plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = Config.group
version = Config.Lib.developmentVersion

dependencies {
    implementation(project(":definitions"))
    implementation(project(":connections:connection-udp"))
    implementation(project(":adapters:adapter-coroutines"))
}
