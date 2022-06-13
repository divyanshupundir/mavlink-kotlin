package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.generator.models.FieldModel
import java.math.BigInteger

fun FieldModel.generateConstructorParameter(enumResolver: EnumResolver) = ParameterSpec
    .builder(CaseFormat.fromSnake(name).toLowerCamel(), resolveKotlinType(enumResolver))
    .defaultValue(defaultKotlinValue)
    .build()

fun FieldModel.generateProperty(enumResolver: EnumResolver) = PropertySpec
    .builder(CaseFormat.fromSnake(name).toLowerCamel(), resolveKotlinType(enumResolver))
    .initializer(CaseFormat.fromSnake(name).toLowerCamel())
    .build()

private fun FieldModel.resolveKotlinType(enumResolver: EnumResolver): TypeName = when (this) {
    is FieldModel.Primitive -> {
        resolveKotlinPrimitiveType(this.type)
    }
    is FieldModel.PrimitiveArray -> {
        if (this.primitiveType == "char") String::class.asTypeName()
        else List::class.asTypeName().parameterizedBy(resolveKotlinPrimitiveType(this.primitiveType))
    }
    is FieldModel.Enum -> {
        MavEnumValue::class.asTypeName().parameterizedBy(enumResolver.resolve(this.enumType))
    }
}

fun FieldModel.generateSerializeStatement(outputName: String, codeBuilder: CodeBlock.Builder): CodeBlock.Builder {
    val valName = CaseFormat.fromSnake(name).toLowerCamel()
    return when (this) {
        is FieldModel.Enum -> codeBuilder.addStatement("$outputName.%M($valName.toLong(), $size)", encodeMethodName)
        is FieldModel.Primitive -> codeBuilder.addStatement("$outputName.%M($valName)", encodeMethodName)
        is FieldModel.PrimitiveArray -> codeBuilder.addStatement("$outputName.%M($valName, $size)", encodeMethodName)
    }
}

private fun resolveKotlinPrimitiveType(primitiveType: String): TypeName = when (primitiveType) {
    "uint8_t", "int8_t", "uint16_t",
    "int16_t", "int32_t" -> Int::class.asTypeName()
    "uint32_t", "int64_t" -> Long::class.asTypeName()
    "uint64_t" -> BigInteger::class.asTypeName()
    "float" -> Float::class.asTypeName()
    "double" -> Double::class.asTypeName()
    "char" -> Char::class.asTypeName()
    else -> throw IllegalArgumentException("Unknown field type")
}

private val FieldModel.defaultKotlinValue: String
    get() = when (this) {
        is FieldModel.Primitive -> when (this.type) {
            "uint8_t", "int8_t", "uint16_t",
            "int16_t", "int32_t" -> "0"
            "uint32_t", "int64_t" -> "0L"
            "uint64_t" -> "BigInteger.ZERO"
            "float" -> "0F"
            "double" -> "0.0"
            "char" -> "''"
            else -> throw IllegalArgumentException("Unknown field type")
        }
        is FieldModel.PrimitiveArray -> if (this.primitiveType == "char") "\"\"" else "emptyList()"
        is FieldModel.Enum -> "MavEnumValue.fromValue(0)"
    }

private const val SERIALIZATION_PACKAGE = "com.urbanmatrix.mavlink.serialization"

private val FieldModel.encodeMethodName: MemberName get() {
    return when (this) {
        is FieldModel.Enum -> MemberName(SERIALIZATION_PACKAGE, "encodeEnumValue")
        is FieldModel.Primitive -> when (type) {
            "int8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt8")
            "uint8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint8")
            "int16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt16")
            "uint16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint16")
            "int32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt32")
            "uint32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint32")
            "int64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt64")
            "uint64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint64")
            "float" -> MemberName(SERIALIZATION_PACKAGE, "encodeFloat")
            "double" -> MemberName(SERIALIZATION_PACKAGE, "encodeDouble")
            "char" -> MemberName(SERIALIZATION_PACKAGE, "encodeChar")
            else -> throw IllegalArgumentException("Unknown Type")
        }
        is FieldModel.PrimitiveArray -> when (primitiveType) {
            "int8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt8Array")
            "uint8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint8Array")
            "int16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt16Array")
            "uint16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint16Array")
            "int32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt32Array")
            "uint32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint32Array")
            "int64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt64Array")
            "uint64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint64Array")
            "float" -> MemberName(SERIALIZATION_PACKAGE, "encodeFloatArray")
            "double" -> MemberName(SERIALIZATION_PACKAGE, "encodeDoubleArray")
            "char" -> MemberName(SERIALIZATION_PACKAGE, "encodeString")
            else -> throw IllegalArgumentException("Unknown Type")
        }
    }
}
