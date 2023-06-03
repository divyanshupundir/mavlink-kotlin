package com.divpundir.mavlink.api

/**
 * A high-level representation of a MAVLink enum.
 */
public interface MavEnum {

    /**
     * The value of the enum entry according to the XML schema.
     */
    public val value: UInt

    /**
     * The companion object for a [MavEnum].
     */
    public interface MavCompanion<T : MavEnum> {

        /**
         * Returns the entry corresponding to the given value if it exists in the enum, null otherwise.
         */
        public fun getEntryFromValueOrNull(v: UInt): T?
    }
}
