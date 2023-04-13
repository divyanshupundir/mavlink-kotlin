package com.divpundir.mavlink.generator

import org.junit.jupiter.api.Test
import java.io.File

class MessageGenTest {

    @Test
    fun messageGeneration() {
        val models = listOf(readMavlinkMinimal(), readMavlinkCommon())
        val enumHelper = EnumHelper(BASE_PACKAGE, models)

        for (model in models) {
            model
                .generateDialectFile(BASE_PACKAGE)
                .writeTo(File(GENERATED_SOURCES_DIR))

            for (enum in model.enums) {
                enum
                    .generateEnumFile("$BASE_PACKAGE.${model.subPackageName}")
                    .writeTo(File(GENERATED_SOURCES_DIR))
            }

            for (message in model.messages) {
                message
                    .generateMessageFile("$BASE_PACKAGE.${model.subPackageName}", enumHelper)
                    .writeTo(File(GENERATED_SOURCES_DIR))
            }
        }
    }
}
