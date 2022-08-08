package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.urbanmatrix.mavlink.generator.CaseFormat

data class MessageModel(
    val id: Int,
    val name: String,
    val fields: List<FieldModel>,
    val workInProgress: Boolean,
    val deprecated: DeprecatedModel?,
    val description: String?
) {
    val formattedName = CaseFormat.fromSnake(name).toUpperCamel()
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "entry")
data class MessageXml(

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: Int,

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    val name: String,

    @JacksonXmlProperty(localName = "deprecated")
    val deprecated: DeprecatedXml?,

    @JacksonXmlProperty(localName = "description")
    val description: String?
) {

    var workInProgress: WipXml? = null
        @JsonSetter("wip") set

    // Jackson reads lists form the bottom. Assuming all fields form the bottom
    // to be extensions. When the extensions tag comes, setting extensions field
    // to be null. If extensions is never null, then no field is an extension.
    var extensions: ExtensionsXml? = ExtensionsXml()
        @JsonSetter("extensions") set(_) {
            field = null
        }

    var fields = mutableListOf<FieldXml>()

    @JsonSetter("field")
    fun addField(field: FieldXml) {
        field.extension = extensions != null

        fields += field
    }

    fun toModel() = MessageModel(
        id,
        name,
        fields
            .let { if (deprecated == null) it.reversed() else it } // Deprecate tag reverses content
            .onEach { if (extensions != null) it.extension = false }
            .onEachIndexed { i, f -> f.position = i + 1 }
            .map { it.toModel() },
        workInProgress != null,
        deprecated?.toModel(),
        description
    )
}
