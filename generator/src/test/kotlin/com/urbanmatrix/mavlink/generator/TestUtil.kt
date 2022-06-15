package com.urbanmatrix.mavlink.generator

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.urbanmatrix.mavlink.generator.plugin.MavlinkDefinitionParser
import java.io.File

const val BASE_PACKAGE = "com.urbanmatrix.mavlink.test"
const val GENERATED_SOURCES_DIR = "build/generated/sources"

fun createXmlMapper() = XmlMapper.builder()
    .defaultUseWrapper(false)
    .build()
    .registerKotlinModule()

fun readMavlinkCommon() = MavlinkDefinitionParser.parse(File("src/test/resources/common.xml"))

fun readMavlinkMinimal() = MavlinkDefinitionParser.parse(File("src/test/resources/minimal.xml"))
