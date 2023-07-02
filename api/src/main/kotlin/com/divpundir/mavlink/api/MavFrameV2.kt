package com.divpundir.mavlink.api

/**
 * Represents a MAVLink v2 frame.
 */
public interface MavFrameV2<T> : MavFrame<T> {

    /**
     * Flag to check if the frame is signed or not.
     */
    public val isSigned: Boolean

    /**
     * ID of the link on which this frame is sent. This value is `0u` if this packet is not signed.
     */
    public val signatureLinkId: UByte

    /**
     * Timestamp in 10 microsecond units since 1st January 2015 GMT time. This value or `0u` if this packet is not signed.
     */
    public val signatureTimestamp: UInt

    /**
     * The signature of this frame.
     */
    public val signature: ByteArray

    /**
     * Validates this frame's signature, using its own link ID, timestamp and the given [secretKey].
     */
    public fun validateSignature(secretKey: ByteArray): Boolean
}
