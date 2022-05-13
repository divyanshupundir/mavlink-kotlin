package com.urbanmatrix.mavlink.generator

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class MavlinkGeneratorTask : DefaultTask() {

    @OutputDirectory
    lateinit var generatedSourcesDir: File

    private val definitions = mutableListOf<File>()

    fun include(file: File){
        definitions.add(file)
    }

    @TaskAction
    fun generate() { }
}
