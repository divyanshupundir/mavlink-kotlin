package xyz.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

data class DeprecatedModel(
    val since: String,
    val replacedBy: String,
    val content: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "deprecated")
data class DeprecatedXml(

    @JacksonXmlProperty(localName = "since", isAttribute = true)
    val since: String,

    @JacksonXmlProperty(localName = "replaced_by", isAttribute = true)
    val replacedBy: String
) {
    @JacksonXmlText
    var content: String? = null

    fun toModel() = DeprecatedModel(
        since,
        replacedBy,
        content
    )
}
