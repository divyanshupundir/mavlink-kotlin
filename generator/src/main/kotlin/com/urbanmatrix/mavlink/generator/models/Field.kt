package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

sealed class FieldModel {

    abstract val position: Int
    abstract val type: TypeModel
    abstract val name: String
    abstract val extension: Boolean
    abstract val display: String?
    abstract val units: String?
    abstract val invalid: String?
    abstract val printFormat: String?
    abstract val content: String?

    data class ValueFieldModel(
        override val position: Int,
        override val type: TypeModel,
        override val name: String,
        override val extension: Boolean,
        override val display: String?,
        override val units: String?,
        override val invalid: String?,
        override val printFormat: String?,
        override val content: String?
    ) : FieldModel()

    data class EnumFieldModel(
        val enum: String,
        override val position: Int,
        override val type: TypeModel,
        override val name: String,
        override val extension: Boolean,
        override val display: String?,
        override val units: String?,
        override val invalid: String?,
        override val printFormat: String?,
        override val content: String?
    ) : FieldModel()
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

    val typeModel: TypeModel
        get() {
            return if (type.endsWith("]")) {
                val rawType = type.substringBefore("[")
                val arrayLength = type.substringAfter("[").substringBefore("]").toInt()
                TypeModel.ArrayTypeModel(rawType, arrayLength)
            } else {
                TypeModel.UnitTypeModel(type)
            }
        }

    var position: Int = -1

    var extension: Boolean = false

    fun toModel(): FieldModel {
        return if (enum == null) {
            FieldModel.ValueFieldModel(
                position,
                typeModel,
                name,
                extension,
                display,
                units,
                invalid,
                printFormat,
                content
            )
        } else {
            FieldModel.EnumFieldModel(
                enum,
                position,
                typeModel,
                name,
                extension,
                display,
                units,
                invalid,
                printFormat,
                content
            )
        }
    }
}
