package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.generator.models.FieldModel
import java.math.BigInteger

fun FieldModel.generateConstructorParameter(enumResolver: EnumResolver) = ParameterSpec
    .builder(CaseFormat.fromSnake(name).toLowerCamel(), resolveKotlinType(enumResolver))
    .build()

fun FieldModel.generateProperty(enumResolver: EnumResolver) = PropertySpec
    .builder(CaseFormat.fromSnake(name).toLowerCamel(), resolveKotlinType(enumResolver))
    .initializer(CaseFormat.fromSnake(name).toLowerCamel())
    .build()

fun FieldModel.resolveKotlinType(enumResolver: EnumResolver): TypeName = when (this) {
    is FieldModel.Primitive -> resolveKotlinPrimitiveType(this.type)
    is FieldModel.PrimitiveArray -> List::class.asTypeName().parameterizedBy(resolveKotlinPrimitiveType(this.primitiveType))
    is FieldModel.Enum -> MavEnumValue::class.asTypeName().parameterizedBy(enumResolver.resolve(this.enumType))
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


