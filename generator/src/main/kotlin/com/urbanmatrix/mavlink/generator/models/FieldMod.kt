package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

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

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "field")
data class FieldXml(

    @JacksonXmlProperty(localName = "type", isAttribute = true)
    val type: String,

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    val name: String,

    @JacksonXmlProperty(localName = "enum", isAttribute = true)
    val enum: String?,

    @JacksonXmlProperty(localName = "display", isAttribute = true)
    val display: String?,

    @JacksonXmlProperty(localName = "units", isAttribute = true)
    val units: String?,

    @JacksonXmlProperty(localName = "invalid", isAttribute = true)
    val invalid: String?,

    @JacksonXmlProperty(localName = "print_format", isAttribute = true)
    val printFormat: String?,
) {
    var position: Int? = null

    var extension: Boolean? = null

    @JacksonXmlText
    var content: String? = null

    fun getTypeMod(): TypeMod {
        return if (type.endsWith("]")) {
            val rawType = type.substringBefore("[")
            val arrayLength = type.substringAfter("[").substringBefore("]").toInt()
            TypeMod.ArrayTypeMod(rawType, arrayLength)
        } else {
            TypeMod.UnitTypeMod(type)
        }
    }
}
