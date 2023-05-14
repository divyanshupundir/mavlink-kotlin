package com.divpundir.mavlink.api

/**
 * A high-level representation of a MAVLink enum.
 */
public interface MavEnum {
    public val value: UInt

    public interface Companion<T : MavEnum> {
        public fun getEntryFromValueOrNull(v: UInt): T?
    }
}
