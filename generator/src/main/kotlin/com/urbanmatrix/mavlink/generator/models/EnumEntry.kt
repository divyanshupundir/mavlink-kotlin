package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

data class EnumEntryModel(
    val value: Int,
    val name: String,
    val params: List<ParamModel>,
    val deprecated: DeprecatedModel?,
    val description: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "entry")
data class EnumEntryXml(

    @JacksonXmlProperty(localName = "value", isAttribute = true)
    val value: Int,

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    val name: String,

    @JacksonXmlProperty(localName = "deprecated")
    val deprecated: DeprecatedXml?,

    @JacksonXmlProperty(localName = "description")
    val description: String?
) {
    val params = mutableListOf<ParamXml>()

    @JsonSetter("param")
    fun addParam(param: ParamXml) {
        params += param
    }

    fun toModel() = EnumEntryModel(
        value,
        name,
        params.map { it.toModel() },
        deprecated?.toModel(),
        description
    )
}
