package com.divpundir.mavlink.api

/**
 * A high-level representation of a MAVLink bitmask enum.
 */
public interface MavBitmask : MavEnum {

    /**
     * The companion object for a [MavBitmask].
     */
    public interface MavCompanion<T : MavBitmask> : MavEnum.MavCompanion<T> {

        /**
         * Returns the list of entries corresponding to the given bitmask value.
         */
        public fun getFlagsFromValue(v: UInt): List<T>
    }
}
