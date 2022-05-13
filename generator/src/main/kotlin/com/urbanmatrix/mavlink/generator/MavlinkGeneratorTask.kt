package com.urbanmatrix.mavlink.generator

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

class MavlinkGeneratorTask : DefaultTask() {

    @OutputDirectory
    var generatedSourcesDir: File? = null

    private val definitions = mutableListOf<File>()

    fun include(file: File){
        definitions.add(file)
    }

    @TaskAction
    fun generate() {

    }
}
