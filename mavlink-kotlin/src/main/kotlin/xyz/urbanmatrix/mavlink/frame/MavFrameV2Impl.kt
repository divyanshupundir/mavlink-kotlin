package xyz.urbanmatrix.mavlink.frame

import xyz.urbanmatrix.mavlink.api.MavFrameV2
import xyz.urbanmatrix.mavlink.raw.MavRawFrame

data class MavFrameV2Impl<T>(
    private val rawFrame: MavRawFrame,
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
