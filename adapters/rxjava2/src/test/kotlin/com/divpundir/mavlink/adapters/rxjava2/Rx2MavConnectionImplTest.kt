package com.divpundir.mavlink.adapters.rxjava2

import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.Test
import com.divpundir.mavlink.connection.tcp.TcpClientMavConnection
import com.divpundir.mavlink.definitions.common.CommonDialect
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

    @Test
    fun reconnect() {
        val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asRx2 {
            Schedulers.io().scheduleDirect {
                while (connect().blockingGet() != null) {
                    TimeUnit.SECONDS.sleep(2)
                }
            }
        }
        Schedulers.io().scheduleDirect {
            while (connection.connect().blockingGet() != null) {
                TimeUnit.SECONDS.sleep(2)
            }
        }

        connection.mavFrame.blockingSubscribe(::println)
    }
}
