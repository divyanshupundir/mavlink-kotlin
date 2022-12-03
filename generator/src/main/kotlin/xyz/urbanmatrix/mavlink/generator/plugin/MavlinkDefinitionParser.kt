package xyz.urbanmatrix.mavlink.generator.plugin

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import xyz.urbanmatrix.mavlink.generator.models.MavlinkModel
import xyz.urbanmatrix.mavlink.generator.models.MavlinkXml
import java.io.File
import java.io.IOException

internal object MavlinkDefinitionParser {

    private val xmlMapper = XmlMapper.builder()
        .defaultUseWrapper(false)
        .build()
        .registerKotlinModule()

    @Throws(IOException::class)
    fun parse(definition: File): MavlinkModel {
        return xmlMapper
            .readValue(definition, MavlinkXml::class.java)
            .toModel(definition.nameWithoutExtension)
    }
}
