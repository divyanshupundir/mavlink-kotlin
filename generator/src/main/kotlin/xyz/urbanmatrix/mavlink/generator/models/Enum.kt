package xyz.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import xyz.urbanmatrix.mavlink.generator.CaseFormat

data class EnumModel(
    val name: String,
    val bitmask: Boolean,
    val entries: List<EnumEntryModel>,
    val deprecated: DeprecatedModel?,
    val description: String?
) {
    val formattedName = CaseFormat.fromSnake(name).toUpperCamel()
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "enum")
data class EnumXml(

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    val name: String,

    @JacksonXmlProperty(localName = "bitmask", isAttribute = true)
    val bitmask: String,

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

    fun toModel() = EnumModel(
        name,
        bitmask.toBoolean(),
        entries
            .let { if (deprecated == null) it.reversed() else it } // Deprecate tag reverses content
            .map { it.toModel() },
        deprecated?.toModel(),
        description
    )
}
