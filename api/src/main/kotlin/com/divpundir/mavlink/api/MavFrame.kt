package com.divpundir.mavlink.api

/**
 * An in-memory representation a basic MAVLink frame. It contains the [MavMessage] and other wire-format metadata.
 *
 * The contents of this class are sufficient for a MAVLinkV1 frame.
 *
 * @param T The type of this frame's payload.
 */
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
