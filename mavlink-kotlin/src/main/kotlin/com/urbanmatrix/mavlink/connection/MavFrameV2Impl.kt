package com.urbanmatrix.mavlink.connection

import com.urbanmatrix.mavlink.api.MavFrameV2
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.raw.MavlinkRawFrame

data class MavFrameV2Impl<T : MavMessage<T>>(
    private val rawFrame: MavlinkRawFrame,
    override val message: T
) : MavFrameV2<T> {

    override val sequence: Int get() = rawFrame.seq

    override val systemId: Int get() = rawFrame.systemId

    override val componentId: Int get() = rawFrame.componentId

    override val frameBytes: ByteArray get() = rawFrame.rawBytes.clone()

    override val checksum: Int get() = rawFrame.checksum

    override val isSigned: Boolean get() = rawFrame.isSigned

    override val signatureLinkId: Int get() = rawFrame.signatureLinkId

    override val signatureTimestamp: Long get() = rawFrame.signatureTimestamp

    override val signature: ByteArray get() = rawFrame.signature

    override fun validateSignature(secretKey: ByteArray): Boolean = rawFrame.validateSignature(secretKey)
}
