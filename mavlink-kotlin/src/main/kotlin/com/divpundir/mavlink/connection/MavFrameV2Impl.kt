package com.divpundir.mavlink.connection

import com.divpundir.mavlink.api.MavFrameV2

internal data class MavFrameV2Impl<T>(
    private val rawFrame: MavRawFrame,
    override val message: T
) : MavFrameV2<T> {

    override val sequence: UByte get() = rawFrame.seq

    override val systemId: UByte get() = rawFrame.systemId

    override val componentId: UByte get() = rawFrame.componentId

    override val checksum: UShort get() = rawFrame.checksum

    override val isSigned: Boolean get() = rawFrame.isSigned

    override val signatureLinkId: UByte get() = rawFrame.signatureLinkId

    override val signatureTimestamp: UInt get() = rawFrame.signatureTimestamp

    override val signature: ByteArray get() = rawFrame.signature

    override fun validateSignature(secretKey: ByteArray): Boolean = rawFrame.validateSignature(secretKey)
}
