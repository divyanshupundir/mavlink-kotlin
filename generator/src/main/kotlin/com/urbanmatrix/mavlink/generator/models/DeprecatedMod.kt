package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

class DeprecatedMod(
    val since: String,
    val replacedBy: String,
    val message: String?
)

@JacksonXmlRootElement(localName = "deprecated")
class DeprecatedXml {

    @JacksonXmlProperty(localName = "since", isAttribute = true)
    var since: String? = null

    @JacksonXmlProperty(localName = "replaced_by", isAttribute = true)
    var replacedBy: String? = null

    @JacksonXmlProperty(isAttribute = false)
    var message: String? = null
}
