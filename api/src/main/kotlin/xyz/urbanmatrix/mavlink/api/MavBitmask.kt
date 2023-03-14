package xyz.urbanmatrix.mavlink.api

public interface MavBitmask : MavEnum {

    public interface Companion<T : MavBitmask> {
        public fun getFlagsFromValue(v: UInt): List<T>
    }
}
