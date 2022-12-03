package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import java.io.IOException

public interface CoroutinesMavConnection {

    public val mavFrame: SharedFlow<MavFrame<out MavMessage<*>>>

    @Throws(IOException::class)
    public suspend fun connect(readerScope: CoroutineScope)

    @Throws(IOException::class)
    public suspend fun close()

    @Throws(IOException::class)
    public suspend fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    )

    @Throws(IOException::class)
    public suspend fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    )

    @Throws(IOException::class)
    public suspend fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    )
}
