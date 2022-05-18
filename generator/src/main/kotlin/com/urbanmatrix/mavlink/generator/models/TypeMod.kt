package com.urbanmatrix.mavlink.generator.models

sealed class TypeMod(name: String, unitLength: Int) {

    data class UnitType(val name: String, val unitLength: Int) : TypeMod(name, unitLength)

    data class ArrayType(val name: String, val unitLength: Int, val arrayLength: Int) : TypeMod(name, unitLength)
}
