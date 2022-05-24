package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

sealed class FieldMod {

    abstract val position: Int
    abstract val type: TypeMod
    abstract val name: String
    abstract val extension: Boolean
    abstract val display: String?
    abstract val units: String?
    abstract val invalid: String?
    abstract val printFormat: String?
    abstract val content: String?

    data class ValueFieldMod(
        override val position: Int,
        override val type: TypeMod,
        override val name: String,
        override val extension: Boolean,
        override val display: String?,
        override val units: String?,
        override val invalid: String?,
        override val printFormat: String?,
        override val content: String?
    ) : FieldMod()

    data class EnumFieldMod(
        val enum: String,
        override val position: Int,
        override val type: TypeMod,
        override val name: String,
        override val extension: Boolean,
        override val display: String?,
        override val units: String?,
        override val invalid: String?,
        override val printFormat: String?,
        override val content: String?
    ) : FieldMod()
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
    @JacksonXmlText
    var content: String? = null

    val typeMod: TypeMod
        get() {
            return if (type.endsWith("]")) {
                val rawType = type.substringBefore("[")
                val arrayLength = type.substringAfter("[").substringBefore("]").toInt()
                TypeMod.ArrayTypeMod(rawType, arrayLength)
            } else {
                TypeMod.UnitTypeMod(type)
            }
        }

    fun toMod(pos: Int, ext: Boolean): FieldMod {
        return if (enum == null) {
            FieldMod.ValueFieldMod(
                pos,
                typeMod,
                name,
                ext,
                display,
                units,
                invalid,
                printFormat,
                content
            )
        } else {
            FieldMod.EnumFieldMod(
                enum,
                pos,
                typeMod,
                name,
                ext,
                display,
                units,
                invalid,
                printFormat,
                content
            )
        }
    }
}
