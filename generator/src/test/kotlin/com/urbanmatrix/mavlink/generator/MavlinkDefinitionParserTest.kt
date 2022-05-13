package com.urbanmatrix.mavlink.generator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class MavlinkDefinitionParserTest {
    @Test
    fun parse() {
        MavlinkDefinitionParser(File("src/test/resources/common.xml"))
            .parse()

        MavlinkDefinitionParser(File("src/test/resources/ardupilotmega.xml"))
            .parse()
    }
}
