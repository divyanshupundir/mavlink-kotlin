package com.divpundir.mavlink.api

public interface MavEnum {
    public val value: UInt

    public interface Companion<T : MavEnum> {
        public fun getEntryFromValueOrNull(v: UInt): T?
    }
}
