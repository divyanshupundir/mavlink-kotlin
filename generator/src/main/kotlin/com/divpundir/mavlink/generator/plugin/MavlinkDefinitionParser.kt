package com.divpundir.mavlink.generator.plugin

import com.divpundir.mavlink.generator.models.DialectModel
import com.divpundir.mavlink.generator.models.DialectXml
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import java.io.File
import java.io.IOException

internal object MavlinkDefinitionParser {

    private val xmlMapper = XmlMapper
        .builder()
        .defaultUseWrapper(false)
        .build()
        .registerModule(kotlinModule())

    @Throws(IOException::class)
    fun parse(definition: File): DialectModel {
        return xmlMapper
            .readValue(definition, DialectXml::class.java)
            .toModel(definition.nameWithoutExtension)
    }
}
