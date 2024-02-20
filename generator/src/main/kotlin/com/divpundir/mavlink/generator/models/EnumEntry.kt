package com.divpundir.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

internal data class EnumEntryModel(
    val value: Long,
    val name: String,
    val params: List<ParamModel>,
    val workInProgress: Boolean,
    val deprecated: DeprecatedModel?,
    val description: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "entry")
internal data class EnumEntryXml(

    @JacksonXmlProperty(localName = "value", isAttribute = true)
    val value: String,

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

    @Suppress("MemberVisibilityCanBePrivate")
    var workInProgress: WipXml? = null
        @JsonSetter("wip") set

    fun toModel() = EnumEntryModel(
        value.parseValue(),
        name,
        params
            .let { if (deprecated == null) it.reversed() else it } // Deprecate tag reverses content
            .map { it.toModel() },
        workInProgress != null,
        deprecated?.toModel(),
        description
    )
}

private fun String.parseValue(): Long = if (startsWith("2**")) {
    val exponent = substringAfter("2**").toInt()
    1L shl exponent
} else {
    toLong()
}
