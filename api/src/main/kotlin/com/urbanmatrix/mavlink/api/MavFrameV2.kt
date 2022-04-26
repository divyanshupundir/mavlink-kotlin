package com.urbanmatrix.mavlink.api

interface MavFrameV2<T : MavMessage<T>> : MavFrame<T> {
    /**
     * Flag to check if the frame is signed or not.
     */
    val isSigned: Boolean

    /**
     * The link ID in this frame's signature, or `-1` if this packet is not signed.
     */
    val signatureLinkId: Int

    /**
     * The timestamp in this frame's signature, or `-1` if this packet is not signed.
     */
    val signatureTimestamp: Long

    /**
     * The complete signature of this message.
     */
    val signature: ByteArray

    /**
     * Validates this frame's signature, using its own link ID and timestamp.
     *
     * @param secretKey The secret key to use when validating the signature.
     * @return `true` if the signature validation passed, or `false` otherwise.
     */
    fun validateSignature(secretKey: ByteArray): Boolean
}
