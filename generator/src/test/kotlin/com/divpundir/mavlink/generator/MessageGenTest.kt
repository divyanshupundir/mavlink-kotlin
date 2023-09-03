package com.divpundir.mavlink.generator

import org.junit.jupiter.api.Test
import java.io.File

class MessageGenTest {

    @Test
    fun messageGeneration() {
        val dialects = listOf(readMavlinkMinimal(), readMavlinkCommon())
        val enumHelper = EnumHelper(BASE_PACKAGE, dialects)

        for (dialect in dialects) {
            dialect
                .generateDialectFile(BASE_PACKAGE)
                .writeTo(File(GENERATED_SOURCES_DIR))

            for (enum in dialect.enums) {
                enum
                    .generateEnumFile("$BASE_PACKAGE.${dialect.subPackageName}")
                    .writeTo(File(GENERATED_SOURCES_DIR))
            }

            for (message in dialect.messages) {
                message
                    .generateMessageFile("$BASE_PACKAGE.${dialect.subPackageName}", enumHelper)
                    .writeTo(File(GENERATED_SOURCES_DIR))
            }
        }
    }
}
