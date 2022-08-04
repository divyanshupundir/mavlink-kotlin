package com.urbanmatrix.mavlink.adapters.rxjava2

import com.urbanmatrix.mavlink.connection.tcp.TcpClientMavConnection
import com.urbanmatrix.mavlink.definitions.common.CommonDialect
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class Rx2MavConnectionImplTest {

    @Test
    fun read() {
        val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asRx2()

        connection.connect().blockingAwait()
        connection.mavFrame
            .limit(100)
            .blockingSubscribe(::println)
        connection.close().blockingAwait()

        TimeUnit.SECONDS.sleep(5)

        connection.connect().blockingAwait()
        connection.mavFrame
            .limit(100)
            .blockingSubscribe(::println)
        connection.close().blockingAwait()
    }
}
