package com.urbanmatrix.mavlink.generator

import org.junit.jupiter.api.Test

class MessageGenKtTest {

    @Test
    fun basic() {
        val model = readCommonMavlink()
        val enumResolver = EnumResolver(BASE_PACKAGE, listOf(model))

        val fileSpec = model.messages[20].generateMessageFile(BASE_PACKAGE, enumResolver)

        val s = StringBuilder()
        fileSpec.writeTo(s)

        println(s)
    }
}
