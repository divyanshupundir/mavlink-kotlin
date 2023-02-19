package xyz.urbanmatrix.mavlink.frame

import xyz.urbanmatrix.mavlink.api.MavFrameV1

internal data class MavFrameV1Impl<T>(
    private val rawFrame: MavRawFrame,
    override val message: T
) : MavFrameV1<T> {

    override val sequence: UByte get() = rawFrame.seq

    override val systemId: UByte get() = rawFrame.systemId

    override val componentId: UByte get() = rawFrame.componentId

    override val checksum: UShort get() = rawFrame.checksum
}
