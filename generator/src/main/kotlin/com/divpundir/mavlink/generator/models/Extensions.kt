package com.divpundir.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "extensions")
internal class ExtensionsXml
