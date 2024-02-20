package com.divpundir.mavlink.generator.models

import com.divpundir.mavlink.generator.CaseFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

internal data class MessageModel(
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
internal data class MessageXml(

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: Int,

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    val name: String,

    @JacksonXmlProperty(localName = "deprecated")
    val deprecated: DeprecatedXml?,

    @JacksonXmlProperty(localName = "description")
    val description: String?
) {

    @Suppress("MemberVisibilityCanBePrivate")
    var workInProgress: WipXml? = null
        @JsonSetter("wip") set

    // Jackson reads lists form the bottom. Assuming all fields form the bottom
    // to be extensions. When the extensions tag comes, setting extensions field
    // to be null. If extensions is never null, then no field is an extension.
    var extensions: ExtensionsXml? = null
        @JsonSetter("extensions") set(_) {
            field = ExtensionsXml()
            if (deprecated == null) {
                fields.onEach { it.extension = true }
            }
        }

    var fields = mutableListOf<FieldXml>()

    @JsonSetter("field")
    fun addField(field: FieldXml) {
        field.extension = extensions != null

        if (deprecated == null && extensions != null) {
            field.extension = false
        }

        fields += field
    }

    fun toModel() = MessageModel(
        id,
        name,
        fields
            .let { if (deprecated == null) it.reversed() else it } // Deprecate tag reverses content again
            .onEachIndexed { i, f -> f.position = i + 1 }
            .map { it.toModel() },
        workInProgress != null,
        deprecated?.toModel(),
        description
    )
}
