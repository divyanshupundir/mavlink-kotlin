package com.divpundir.mavlink.api

public interface MavFrameV2<T> : MavFrame<T> {
    /**
     * Flag to check if the frame is signed or not.
     */
    public val isSigned: Boolean

    /**
     * The link ID in this frame's signature, or `0u` if this packet is not signed.
     */
    public val signatureLinkId: UByte

    /**
     * The timestamp in this frame's signature, or `0u` if this packet is not signed.
     */
    public val signatureTimestamp: UInt

    /**
     * The complete signature of this message.
     */
    public val signature: ByteArray

    /**
     * Validates this frame's signature, using its own link ID and timestamp.
     *
     * @param secretKey The secret key to use when validating the signature.
     * @return `true` if the signature validation passed, or `false` otherwise.
     */
    public fun validateSignature(secretKey: ByteArray): Boolean
}
