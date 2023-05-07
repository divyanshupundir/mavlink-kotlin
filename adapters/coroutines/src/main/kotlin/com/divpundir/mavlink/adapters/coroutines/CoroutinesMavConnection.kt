package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import java.io.IOException

public interface CoroutinesMavConnection {

    public val mavFrame: SharedFlow<MavFrame<out MavMessage<*>>>

    @Throws(IOException::class)
    public suspend fun connect(readerScope: CoroutineScope)

    @Throws(IOException::class)
    public suspend fun close()

    @Throws(IOException::class)
    public suspend fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

    @Throws(IOException::class)
    public suspend fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

    @Throws(IOException::class)
    public suspend fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    )
}
