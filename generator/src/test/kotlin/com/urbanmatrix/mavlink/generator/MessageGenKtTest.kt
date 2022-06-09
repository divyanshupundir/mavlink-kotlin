package com.urbanmatrix.mavlink.generator

import org.junit.jupiter.api.Test

class MessageGenKtTest {

    @Test
    fun messageGeneration() {
        val model = readCommonMavlink()
        val enumResolver = EnumResolver(BASE_PACKAGE, listOf(model))

        for (i in 1..20) {
            val fileSpec = model.messages[i].generateMessageFile(BASE_PACKAGE, enumResolver)

            with(StringBuilder()) {
                fileSpec.writeTo(this)
                println(this)
            }
        }
    }
}
