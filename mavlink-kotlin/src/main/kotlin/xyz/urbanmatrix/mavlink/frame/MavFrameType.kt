package xyz.urbanmatrix.mavlink.frame

internal enum class MavFrameType(val magic: UByte) {
    V1(0xFEu),
    V2(0xFDu)
}
