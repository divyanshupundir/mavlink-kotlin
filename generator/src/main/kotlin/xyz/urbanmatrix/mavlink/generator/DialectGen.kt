package xyz.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.buildCodeBlock
import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect
import xyz.urbanmatrix.mavlink.generator.models.MavlinkModel

internal fun MavlinkModel.generateDialectFile(basePackageName: String): FileSpec {
    val packageName = "$basePackageName.$subPackageName"
    val dialect = TypeSpec.objectBuilder(dialectObjectName)
        .superclass(AbstractMavDialect::class)
        .addSuperclassConstructorParameter(generateDependencies(basePackageName))
        .addSuperclassConstructorParameter(generateMessages(basePackageName))
        .addAnnotation(GeneratedMavDialect::class)
        .build()

    return FileSpec.builder(packageName, dialectObjectName)
        .addType(dialect)
        .build()
}

private fun MavlinkModel.generateDependencies(basePackageName: String) = buildCodeBlock {
    addStatement("")
    indent()

    if (includes.isEmpty()) {
        add("emptySet()")
        unindent()
        return@buildCodeBlock
    }

    addStatement("setOf(")
    indent()
    includes
        .map { it.removeSuffix(".xml") }
        .map {
            ClassName(
                "$basePackageName.${it.lowercase()}",
                "${xyz.urbanmatrix.mavlink.generator.CaseFormat.fromSnake(it).toUpperCamel()}Dialect"
            )
        }
        .forEach { addStatement("%T,", it) }
    unindent()
    add(")")

    unindent()
}

private fun MavlinkModel.generateMessages(basePackageName: String) = buildCodeBlock {
    addStatement("")
    indent()

    if (messages.isEmpty()) {
        add("emptyMap()")
        unindent()
        return@buildCodeBlock
    }

    addStatement("mapOf(")
    indent()
    messages
        .map {
            ClassName(
                "$basePackageName.$subPackageName",
                it.formattedName
            )
        }
        .forEach { addStatement("%1T.classMetadata.id to %1T.classMetadata,", it) }
    unindent()
    addStatement(")")

    unindent()
}
