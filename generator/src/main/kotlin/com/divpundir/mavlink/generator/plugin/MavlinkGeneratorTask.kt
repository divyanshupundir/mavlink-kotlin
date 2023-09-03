package com.divpundir.mavlink.generator.plugin

import com.divpundir.mavlink.generator.EnumHelper
import com.divpundir.mavlink.generator.generateDialectFile
import com.divpundir.mavlink.generator.generateEnumFile
import com.divpundir.mavlink.generator.generateMessageFile
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.IOException

public abstract class MavlinkGeneratorTask : DefaultTask() {

    private companion object {
        private const val BASE_PACKAGE = "com.divpundir.mavlink.definitions"
    }

    @OutputDirectory
    public lateinit var generatedSourcesDir: File

    private val definitions = mutableSetOf<File>()

    public fun include(file: File) {
        definitions += file
    }

    public fun includeDir(dir: File) {
        definitions += dir.listFiles()!!.toSet()
    }

    @TaskAction
    public fun generate() {
        if (definitions.isEmpty())
            throw IllegalArgumentException("No XML definition provided.")

        for (def in definitions) if (!def.isFile)
            throw IllegalArgumentException("Not a file: $def")

        for (def in definitions) if (def.extension != "xml")
            throw IllegalArgumentException("Not a mavlink definition file: $def")

        if (!this::generatedSourcesDir.isInitialized)
            throw IllegalArgumentException("No generated source directory provided.")

        if (!generatedSourcesDir.isDirectory)
            throw IllegalArgumentException("Generated sources directory should be a directory.")

        if (generatedSourcesDir.exists() && !generatedSourcesDir.deleteRecursively())
            throw IllegalArgumentException("Cannot delete generated sources directory.")

        if (!generatedSourcesDir.mkdirs())
            throw IllegalArgumentException("Cannot create generated sources directory.")

        val dialectModels = definitions.map {
            try {
                MavlinkDefinitionParser.parse(it)
            } catch (e: IOException) {
                throw IllegalArgumentException("Invalid mavlink dialect: $it")
            }
        }

        val enumHelper = EnumHelper(BASE_PACKAGE, dialectModels)

        for (dialect in dialectModels) {
            dialect
                .generateDialectFile(BASE_PACKAGE)
                .writeTo(generatedSourcesDir)

            val packageName = "$BASE_PACKAGE.${dialect.subPackageName}"

            for (enum in dialect.enums) {
                enum
                    .generateEnumFile(packageName)
                    .writeTo(generatedSourcesDir)
            }

            for (message in dialect.messages) {
                message
                    .generateMessageFile(packageName, enumHelper)
                    .writeTo(generatedSourcesDir)
            }
        }
    }
}
