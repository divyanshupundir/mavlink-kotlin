package com.divpundir.mavlink.api

/**
 * A high-level representation of a MAVLink bitmask enum.
 */
public interface MavBitmask : MavEnum {

    public interface Companion<T : MavBitmask> : MavEnum.Companion<T> {
        public fun getFlagsFromValue(v: UInt): List<T>
    }
}
