package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

fun createXmlMapper() = XmlMapper.builder()
    .defaultUseWrapper(false)
    .build()
    .registerKotlinModule()
