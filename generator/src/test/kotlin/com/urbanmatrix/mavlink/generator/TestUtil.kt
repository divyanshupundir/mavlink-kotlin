package com.urbanmatrix.mavlink.generator

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.urbanmatrix.mavlink.generator.plugin.MavlinkDefinitionParser
import java.io.File

val BASE_PACKAGE = "com.urbanmatrix.mavlink.test"

fun createXmlMapper() = XmlMapper.builder()
    .defaultUseWrapper(false)
    .build()
    .registerKotlinModule()

fun readCommonMavlink() = MavlinkDefinitionParser.parse(File("src/test/resources/common.xml"))
