package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.generator.models.FieldModel
import com.urbanmatrix.mavlink.generator.models.MessageModel
import com.urbanmatrix.mavlink.generator.models.sortedByPosition
import java.nio.ByteBuffer
import java.nio.ByteOrder

fun MessageModel.generateMessageFile(packageName: String, enumResolver: EnumResolver): FileSpec {
    val message = TypeSpec.classBuilder(formattedName)
        .addModifiers(KModifier.DATA)
        .addSuperinterface(MavMessage::class.asClassName().parameterizedBy(getClassName(packageName)))
        .primaryConstructor(generatePrimaryConstructor(enumResolver))
        .apply { fields.sortedByPosition().forEach { addProperty(it.generateProperty(enumResolver)) } }
        .apply {
            if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
            if (description != null) addKdoc(description.replace("%", "%%"))
        }
        .addProperty(generateInstanceMetadata(packageName))
        .addFunction(generateSerialize())
        .addType(generateCompanionObject(packageName))
        .build()

    return FileSpec.builder(packageName, formattedName)
        .addType(message)
        .build()
}

private fun MessageModel.generatePrimaryConstructor(enumResolver: EnumResolver) = FunSpec
    .constructorBuilder()
    .apply { fields.sortedByPosition().forEach { addParameter(it.generateConstructorParameter(enumResolver)) } }
    .build()

private fun MessageModel.generateCompanionObject(packageName: String) = TypeSpec
    .companionObjectBuilder()
    .addProperty(generateIdProperty())
    .addProperty(generateCrcProperty())
    .addProperty(generateSizeProperty())
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

private fun MessageModel.generateSizeProperty() = PropertySpec
    .builder("SIZE", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", size)
    .build()

private fun MessageModel.generateDeserializer(packageName: String) = PropertySpec
    .builder(
        "DESERIALIZER",
        MavDeserializer::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.PRIVATE
    )
    .initializer(
        buildCodeBlock {
            beginControlFlow("%T { bytes ->", MavDeserializer::class)

            addStatement(
                "val inputBuffer = %T.wrap(bytes).order(%T.LITTLE_ENDIAN)",
                ByteBuffer::class,
                ByteOrder::class
            )
            fields.sorted().forEach { add(it.generateDeserializeStatement("inputBuffer")) }

            addStatement("%T(", getClassName(packageName))
            indent()
            fields.sortedByPosition().forEach { add("${it.formattedName} = ${it.formattedName},\n") }
            unindent()
            addStatement(")")

            endControlFlow()
        }
    )
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
    .addCode(
        buildCodeBlock {
            addStatement(
                "val outputBuffer = %T.allocate(SIZE).order(%T.LITTLE_ENDIAN)",
                ByteBuffer::class,
                ByteOrder::class
            )
            fields.sorted().forEach { add(it.generateSerializeStatement("outputBuffer")) }
            addStatement("return outputBuffer.array()")
        }
    )
    .build()

private val MessageModel.size: Int
    get() = fields.sumOf { it.size }

private fun MessageModel.getClassName(packageName: String): ClassName =
    ClassName(packageName, formattedName)

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
            .forEach { crc.accumulate(it.arrayLength) }

        return crc.get() and 0xFF
    }
