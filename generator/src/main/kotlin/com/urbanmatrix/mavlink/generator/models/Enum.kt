package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

data class EnumMod(
    val name: String,
    val entries: List<EnumEntryMod>,
    val deprecated: DeprecatedMod?,
    val description: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "enum")
data class EnumXml(

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    val name: String,

    @JacksonXmlProperty(localName = "deprecated")
    val deprecated: DeprecatedXml?,

    @JacksonXmlProperty(localName = "description")
    val description: String?
) {
    val entries = mutableListOf<EnumEntryXml>()

    @JsonSetter("entry")
    fun addEnumEntry(enumEntry: EnumEntryXml) {
        entries += enumEntry
    }

    fun toMod() = EnumMod(
        name,
        entries.map { it.toMod() },
        deprecated?.toMod(),
        description
    )
}
