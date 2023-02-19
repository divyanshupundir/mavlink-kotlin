package xyz.urbanmatrix.mavlink.api

/**
 * Represents a basic Mavlink frame. The contents of this class are sufficient
 * for a MavlinkV1 frame.
 *
 * @param <T> The type of this frame's payload.
</T> */
public interface MavFrame<T> {
    /**
     * The sequence of this frame.
     */
    public val sequence: UByte

    /**
     * The ID of the system that originated this frame.
     */
    public val systemId: UByte

    /**
     * The ID of the component that originated this frame.
     */
    public val componentId: UByte

    /**
     * The message/payload of this frame.
     */
    public val message: T

    /**
     * The checksum of this frame.
     */
    public val checksum: UShort
}
