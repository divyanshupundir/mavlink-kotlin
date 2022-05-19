package com.urbanmatrix.mavlink.generator.models

sealed class TypeMod {

    abstract val name: String

    data class UnitTypeMod(override val name: String) : TypeMod()

    data class ArrayTypeMod(override val name: String, val arrayLength: Int) : TypeMod()

    val unitLength: Int
        get() {
            return when (name) {
                "char" -> 1
                "float" -> 4
                "double" -> 8
                "uint8_t_mavlink_version" -> 1
                "uint8_t", "int8_t" -> 1
                "uint16_t", "int16_t" -> 2
                "uint32_t", "int32_t" -> 4
                "uint64_t", "int64_t" -> 8
                else -> throw RuntimeException("Invalid type")
            }
        }
}
