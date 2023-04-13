package com.divpundir.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.MavBitmask
import com.divpundir.mavlink.api.MavEnum
import com.divpundir.mavlink.generator.models.EnumEntryModel
import com.divpundir.mavlink.generator.models.EnumModel

internal fun EnumModel.generateEnumFile(packageName: String): FileSpec {
    val enum = TypeSpec.enumBuilder(formattedName)
        .addSuperinterface(if (bitmask) MavBitmask::class else MavEnum::class)
        .primaryConstructor(generatePrimaryConstructor())
        .addProperty(generateValueProperty())
        .apply {
            entries.forEach { addEnumConstant(it.getSimpleName(name), it.generateEnumConstant()) }
            if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
            if (description != null) addKdoc(description.replace("%", "%%"))
        }
        .addAnnotation(generateGeneratedAnnotation())
        .addType(generateCompanionObject(packageName))
        .build()

    return FileSpec.builder(packageName, formattedName)
        .addType(enum)
        .build()
}

private fun generatePrimaryConstructor() = FunSpec
    .constructorBuilder()
    .addParameter("value", UInt::class)
    .build()

private fun generateValueProperty() = PropertySpec
    .builder("value", UInt::class, KModifier.OVERRIDE)
    .initializer("value")
    .build()

private fun EnumModel.generateGeneratedAnnotation() = AnnotationSpec
    .builder(GeneratedMavEnum::class)
    .apply { if (bitmask) addMember("bitmask = true") }
    .build()

private fun EnumModel.generateCompanionObject(packageName: String) = TypeSpec
    .companionObjectBuilder()
    .addSuperinterface(MavEnum.Companion::class.asTypeName().parameterizedBy(getClassName(packageName)))
    .apply { if (bitmask) addSuperinterface(MavBitmask.Companion::class.asTypeName().parameterizedBy(getClassName(packageName))) }
    .addFunction(generateGetEntryFromValueOrNull(packageName))
    .apply { if (bitmask) addFunction(generateGetFlagsFromValue(packageName)) }
    .build()

private fun EnumModel.generateGetEntryFromValueOrNull(packageName: String) = FunSpec
    .builder("getEntryFromValueOrNull")
    .addModifiers(KModifier.OVERRIDE)
    .addParameter(ParameterSpec("v", UInt::class.asTypeName()))
    .returns(getClassName(packageName).copy(nullable = true))
    .addCode(
        buildCodeBlock {
            beginControlFlow("return when (v) {")
            entries.forEach { addStatement("${it.value}u -> ${it.getSimpleName(name)}") }
            addStatement("else -> null")
            endControlFlow()
        }
    )
    .build()

private fun EnumModel.generateGetFlagsFromValue(packageName: String) = FunSpec
    .builder("getFlagsFromValue")
    .addModifiers(KModifier.OVERRIDE)
    .addParameter(ParameterSpec("v", UInt::class.asTypeName()))
    .returns(List::class.asTypeName().parameterizedBy(getClassName(packageName)))
    .addCode(
        buildCodeBlock {
            beginControlFlow("return buildList {")
            entries.forEach { addStatement("if (v and ${it.value}u == ${it.value}u) add(${it.getSimpleName(name)})") }
            endControlFlow()
        }
    )
    .build()

private fun EnumModel.getClassName(packageName: String): ClassName =
    ClassName(packageName, formattedName)

private fun EnumEntryModel.getSimpleName(enumName: String): String {
    val simpleName = name.substringAfter(enumName + "_")
    return if (simpleName.first().isJavaIdentifierStart()) simpleName else "_$simpleName"
}
