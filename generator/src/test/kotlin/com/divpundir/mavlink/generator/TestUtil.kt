package com.divpundir.mavlink.generator

import com.divpundir.mavlink.generator.plugin.MavlinkDefinitionParser
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

internal const val BASE_PACKAGE = "com.divpundir.mavlink.test"
internal const val GENERATED_SOURCES_DIR = "build/generated/sources"

internal fun createXmlMapper() = XmlMapper.builder()
    .defaultUseWrapper(false)
    .build()
    .registerKotlinModule()

internal fun readMavlinkCommon() = MavlinkDefinitionParser.parse(File("src/test/resources/common.xml"))

internal fun readMavlinkMinimal() = MavlinkDefinitionParser.parse(File("src/test/resources/minimal.xml"))
