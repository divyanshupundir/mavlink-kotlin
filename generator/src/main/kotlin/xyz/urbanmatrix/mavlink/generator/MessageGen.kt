package xyz.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.generator.models.FieldModel
import xyz.urbanmatrix.mavlink.generator.models.MessageModel
import xyz.urbanmatrix.mavlink.generator.models.sortedByPosition
import java.nio.ByteBuffer
import java.nio.ByteOrder

fun MessageModel.generateMessageFile(packageName: String, enumResolver: EnumResolver): FileSpec {
    val message = TypeSpec.classBuilder(formattedName)
        .addModifiers(KModifier.DATA)
        .addSuperinterface(MavMessage::class.asClassName().parameterizedBy(getClassName(packageName)))
        .primaryConstructor(generatePrimaryConstructor(enumResolver))
        .apply { fields.sortedByPosition().forEach { addProperty(it.generateConstructorProperty(enumResolver)) } }
        .apply {
            if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
            if (workInProgress) addAnnotation(WorkInProgress::class)
            if (description != null) addKdoc(description.replace("%", "%%"))
        }
        .addAnnotation(generateGeneratedAnnotation())
        .addProperty(generateInstanceMetadata(packageName))
        .addFunction(generateSerializeV1())
        .addFunction(generateSerializeV2())
        .addType(generateCompanionObject(packageName))
        .addType(generateBuilderClass(enumResolver, packageName))
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
    .addFunction(generateBuilderFunction(packageName))
    .build()

private fun MessageModel.generateGeneratedAnnotation() = AnnotationSpec
    .builder(GeneratedMavMessage::class)
    .addMember("id = %L", id)
    .addMember("crc = %L", crc)
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
            beginControlFlow("%T·{ bytes ->", MavDeserializer::class)

            addStatement(
                "val inputBuffer = %T.wrap(bytes).order(%T.LITTLE_ENDIAN)",
                ByteBuffer::class,
                ByteOrder::class
            )
            fields.sorted().forEach { add(it.generateDeserializeStatement("inputBuffer")) }

            addStatement("")

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

private fun MessageModel.generateSerializeV1() = FunSpec
    .builder("serializeV1")
    .addModifiers(KModifier.OVERRIDE)
    .returns(ByteArray::class)
    .addCode(
        buildCodeBlock {
            addStatement(
                "val outputBuffer = %T.allocate(SIZE).order(%T.LITTLE_ENDIAN)",
                ByteBuffer::class,
                ByteOrder::class
            )
            fields.filter { !it.extension }.sorted().forEach { add(it.generateSerializeStatement("outputBuffer")) }
            addStatement("return outputBuffer.array()")
        }
    )
    .build()

private fun MessageModel.generateSerializeV2() = FunSpec
    .builder("serializeV2")
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
            addStatement("return outputBuffer.array().%M()", truncateZerosMemberName)
        }
    )
    .build()

private fun MessageModel.generateBuilderClass(enumResolver: EnumResolver, packageName: String) = TypeSpec.classBuilder("Builder")
    .apply { fields.sortedByPosition().forEach { addProperty(it.generateBuilderProperty(enumResolver)) } }
    .addFunction(generateBuildMethod(packageName))
    .build()

private fun MessageModel.generateBuildMethod(packageName: String) = FunSpec.builder("build")
    .returns(getClassName(packageName))
    .addCode(
        buildCodeBlock {
            add("return %T(\n", getClassName(packageName))
            indent()
            fields.sortedByPosition().forEach { add("${it.formattedName} = ${it.formattedName},\n") }
            unindent()
            add(")")
        }
    )
    .build()

private fun MessageModel.generateBuilderFunction(packageName: String) = FunSpec.builder("builder")
    .addParameter(ParameterSpec("builderAction", LambdaTypeName.get(getClassName(packageName).nestedClass("Builder"), emptyList(), Unit::class.asTypeName())))
    .addCode("return %T().apply(builderAction).build()", getClassName(packageName).nestedClass("Builder"))
    .build()

private val MessageModel.size: Int
    get() = fields.sumOf { it.size }

private val truncateZerosMemberName = MemberName("xyz.urbanmatrix.mavlink.serialization", "truncateZeros")

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
            .onEach {
                crc.accumulate(
                    it.type
                        .substringBeforeLast("_mavlink_version")
                        .substringBeforeLast("[") +
                        " "
                )
            }
            .onEach { crc.accumulate(it.name + " ") }
            .filterIsInstance<FieldModel.PrimitiveArray>()
            .forEach { crc.accumulate(it.arrayLength) }

        return crc.get() and 0xFF
    }
