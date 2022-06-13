package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.generator.models.FieldModel
import com.urbanmatrix.mavlink.generator.models.MessageModel
import java.nio.ByteBuffer
import java.nio.ByteOrder

fun MessageModel.generateMessageFile(packageName: String, enumResolver: EnumResolver): FileSpec {
    val message = TypeSpec.classBuilder(CaseFormat.fromSnake(name).toUpperCamel())
        .addModifiers(KModifier.DATA)
        .addSuperinterface(MavMessage::class.asClassName().parameterizedBy(getClassName(packageName)))
        .primaryConstructor(generatePrimaryConstructor(enumResolver))
        .apply { fields.forEach { addProperty(it.generateProperty(enumResolver)) } }
        .addType(generateCompanionObject(packageName))
        .apply {
            if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
            if (description != null) addKdoc(description.replace("%", "%%"))
        }
        .addProperty(generateInstanceMetadata(packageName))
        .addFunction(generateSerialize())
        .build()

    return FileSpec.builder(packageName, CaseFormat.fromSnake(name).toUpperCamel())
        .addType(message)
        .build()
}

private fun MessageModel.generatePrimaryConstructor(enumResolver: EnumResolver) = FunSpec
    .constructorBuilder()
    .apply { fields.forEach { addParameter(it.generateConstructorParameter(enumResolver)) } }
    .build()

private fun MessageModel.generateCompanionObject(packageName: String) = TypeSpec
    .companionObjectBuilder()
    .addProperty(generateIdProperty())
    .addProperty(generateCrcProperty())
    .addProperty(generateDeserializer(packageName))
    .addProperty(generateMetadataProperty(packageName))
    .addProperty(generateClassMetadata(packageName))
    .build()

private fun MessageModel.generateIdProperty() = PropertySpec
    .builder("ID", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", id)
    .build()

private fun MessageModel.generateCrcProperty() = PropertySpec
    .builder("CRC", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", crc)
    .build()

private fun MessageModel.generateDeserializer(packageName: String) = PropertySpec
    .builder(
        "DESERIALIZER",
        MavDeserializer::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.PRIVATE
    )
    .initializer("MavDeserializer { TODO() }")
    .build()

private fun MessageModel.generateMetadataProperty(packageName: String) = PropertySpec
    .builder(
        "METADATA",
        MavMessage.Metadata::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.PRIVATE
    )
    .initializer("%T(ID, CRC, DESERIALIZER)", MavMessage.Metadata::class)
    .build()

private fun MessageModel.generateClassMetadata(packageName: String) = PropertySpec
    .builder(
        "classMetadata",
        MavMessage.Metadata::class.asClassName().parameterizedBy(getClassName(packageName))
    )
    .initializer("METADATA")
    .build()

private fun MessageModel.generateInstanceMetadata(packageName: String) = PropertySpec
    .builder(
        "instanceMetadata",
        MavMessage.Metadata::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.OVERRIDE
    )
    .initializer("METADATA")
    .build()

private fun MessageModel.generateSerialize() = FunSpec
    .builder("serialize")
    .addModifiers(KModifier.OVERRIDE)
    .returns(ByteArray::class)
    .apply {
        val c = CodeBlock.builder()

        c.addStatement(
            "val outputBuffer = %T.allocate($size).order(%T.LITTLE_ENDIAN)",
            ByteBuffer::class,
            ByteOrder::class
        )
        fields.forEach { it.generateSerializeStatement("outputBuffer", c) }
        c.addStatement("return outputBuffer.array()")

        addCode(c.build())
    }
    .build()

private val MessageModel.size: Int
    get() = fields.sumOf { it.size }

private fun MessageModel.getClassName(packageName: String): ClassName =
    ClassName(packageName, CaseFormat.fromSnake(name).toUpperCamel())

val MessageModel.crc: Int
    get() {
        val crc = CrcX25().apply {
            accumulate("$name ")
        }

        fields
            .asSequence()
            .sorted()
            .filter { !it.extension }
            .onEach { crc.accumulate(it.type + " ") }
            .onEach { crc.accumulate(it.name + " ") }
            .filterIsInstance<FieldModel.PrimitiveArray>()
            .toList()
            .forEach { crc.accumulate(it.arrayLength) }

        return crc.get() and 0xFF
    }
