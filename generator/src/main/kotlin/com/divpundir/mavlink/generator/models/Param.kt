package com.divpundir.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

internal data class ParamModel(
    val index: Int,
    val label: String?,
    val units: String?,
    val content: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "param")
internal data class ParamXml(

    @JacksonXmlProperty(localName = "index", isAttribute = true)
    val index: Int,

    @JacksonXmlProperty(localName = "label", isAttribute = true)
    val label: String?,

    @JacksonXmlProperty(localName = "units", isAttribute = true)
    val units: String?
) {
    @JacksonXmlText
    var content: String? = null

    fun toModel() = ParamModel(
        index,
        label,
        units,
        content
    )
}
