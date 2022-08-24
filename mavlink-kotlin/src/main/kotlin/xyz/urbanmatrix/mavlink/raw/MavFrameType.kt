package xyz.urbanmatrix.mavlink.raw

enum class MavFrameType(val magic: Int) {
    V1(0xFE),
    V2(0xFD)
}
