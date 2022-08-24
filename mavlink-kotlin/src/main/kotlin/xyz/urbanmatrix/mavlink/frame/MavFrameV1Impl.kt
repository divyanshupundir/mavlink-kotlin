package xyz.urbanmatrix.mavlink.frame

import xyz.urbanmatrix.mavlink.api.MavFrameV1
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.raw.MavRawFrame

data class MavFrameV1Impl<T : MavMessage<T>>(
    private val rawFrame: MavRawFrame,
    override val message: T
) : MavFrameV1<T> {

    override val sequence: Int get() = rawFrame.seq

    override val systemId: Int get() = rawFrame.systemId

    override val componentId: Int get() = rawFrame.componentId

    override val frameBytes: ByteArray get() = rawFrame.rawBytes.clone()

    override val checksum: Int get() = rawFrame.checksum
}
