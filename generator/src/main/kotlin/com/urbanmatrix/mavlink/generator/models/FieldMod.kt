package com.urbanmatrix.mavlink.generator.models

sealed class FieldMod(
    position: Int,
    type: TypeMod,
    name: String,
    extension: Boolean,
    display: String?,
    units: String?,
    invalid: String?,
    printFormat: String?,
    description: String?,
) {
    data class ValueFieldMod(
        val position: Int,
        val type: TypeMod,
        val name: String,
        val extension: Boolean,
        val display: String?,
        val units: String?,
        val invalid: String?,
        val printFormat: String?,
        val description: String?
    ) : FieldMod(
        position = position,
        type = type,
        name = name,
        extension = extension,
        display = display,
        units = units,
        invalid = invalid,
        printFormat = printFormat,
        description = description
    )

    data class EnumFieldMod(
        val position: Int,
        val type: TypeMod,
        val name: String,
        val enum: String,
        val extension: Boolean,
        val display: String?,
        val units: String?,
        val invalid: String?,
        val printFormat: String?,
        val description: String?
    ) : FieldMod(
        position = position,
        type = type,
        name = name,
        extension = extension,
        display = display,
        units = units,
        invalid = invalid,
        printFormat = printFormat,
        description = description
    )
}
