package com.urbanmatrix.mavlink.generator.models

sealed class Field(
    position: Int,
    type: Type,
    name: String,
    extension: Boolean,
    display: String?,
    units: String?,
    invalid: String?,
    printFormat: String?,
    description: String?,
) {
    data class ValueField(
        val position: Int,
        val type: Type,
        val name: String,
        val extension: Boolean,
        val display: String?,
        val units: String?,
        val invalid: String?,
        val printFormat: String?,
        val description: String?
    ) : Field(
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

    data class EnumField(
        val position: Int,
        val type: Type,
        val name: String,
        val enum: String,
        val extension: Boolean,
        val display: String?,
        val units: String?,
        val invalid: String?,
        val printFormat: String?,
        val description: String?
    ) : Field(
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
