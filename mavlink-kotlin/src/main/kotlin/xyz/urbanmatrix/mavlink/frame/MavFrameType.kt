package xyz.urbanmatrix.mavlink.frame

internal enum class MavFrameType(val magic: Int) {
    V1(0xFE),
    V2(0xFD)
}
