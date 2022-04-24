package com.urbanmatrix.mavlink.api

/**
 * Represents a basic Mavlink frame. The contents of this class are sufficient
 * for a MavlinkV1 frame.
 *
 * @param <T> The type of this frame's payload.
</T> */
interface MavFrame<T : MavMessage<T>> {
    /**
     * Returns the sequence of this frame.
     */
    val sequence: Int

    /**
     * Returns the ID of the system that originated this frame.
     */
    val systemId: Int

    /**
     * Returns the ID of the component that originated this frame.
     */
    val componentId: Int

    /**
     * Returns the message/payload of this frame.
     */
    val message: T

    /**
     * Returns a copy of the original raw bytes of this frame.
     */
    val frameBytes: ByteArray

    /**
     * Returns the checksum of this frame.
     */
    val checksum: Int
}
