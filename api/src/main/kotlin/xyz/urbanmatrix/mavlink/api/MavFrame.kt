package xyz.urbanmatrix.mavlink.api

/**
 * Represents a basic Mavlink frame. The contents of this class are sufficient
 * for a MavlinkV1 frame.
 *
 * @param <T> The type of this frame's payload.
</T> */
interface MavFrame<T : MavMessage<T>> {
    /**
     * The sequence of this frame.
     */
    val sequence: Int

    /**
     * The ID of the system that originated this frame.
     */
    val systemId: Int

    /**
     * The ID of the component that originated this frame.
     */
    val componentId: Int

    /**
     * The message/payload of this frame.
     */
    val message: T

    /**
     * A copy of the original raw bytes of this frame.
     */
    val frameBytes: ByteArray

    /**
     * The checksum of this frame.
     */
    val checksum: Int
}
