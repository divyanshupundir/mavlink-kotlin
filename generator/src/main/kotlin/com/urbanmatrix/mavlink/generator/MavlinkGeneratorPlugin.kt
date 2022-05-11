package com.urbanmatrix.mavlink.generator

import org.gradle.api.Plugin
import org.gradle.api.Project

class MavlinkGeneratorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val generateMavlink = target.tasks.create(
            "generateMavlink",
            MavlinkGeneratorTask::class.java
        )

        target.tasks
            .getByName("compileJava")
            .dependsOn(generateMavlink)
    }
}