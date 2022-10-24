package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage

interface CoroutinesMavConnection {

    val mavFrame: SharedFlow<MavFrame<out MavMessage<*>>>

    suspend fun connect(readerScope: CoroutineScope)

    suspend fun close()

    suspend fun <T: MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    )

    suspend fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    )

    suspend fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    )
}