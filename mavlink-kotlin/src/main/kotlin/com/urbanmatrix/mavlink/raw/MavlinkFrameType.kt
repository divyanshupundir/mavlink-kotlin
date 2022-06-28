package com.urbanmatrix.mavlink.raw

enum class MavlinkFrameType(val magic: Int) {
    V1(0xFE),
    V2(0xFD)
}
