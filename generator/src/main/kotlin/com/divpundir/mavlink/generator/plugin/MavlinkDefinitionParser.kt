package com.divpundir.mavlink.generator.plugin

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.divpundir.mavlink.generator.models.DialectModel
import com.divpundir.mavlink.generator.models.DialectXml
import java.io.File
import java.io.IOException

internal object MavlinkDefinitionParser {

    private val xmlMapper = XmlMapper
        .builder()
        .defaultUseWrapper(false)
        .build()
        .registerKotlinModule()

    @Throws(IOException::class)
    fun parse(definition: File): DialectModel {
        return xmlMapper
            .readValue(definition, DialectXml::class.java)
            .toModel(definition.nameWithoutExtension)
    }
}
