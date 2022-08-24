package xyz.urbanmatrix.mavlink

import xyz.urbanmatrix.mavlink.api.MavEnum
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.raw.MavRawFrameReader
import java.io.InputStream

fun <E : MavEnum> E.wrap() = MavEnumValue.of(this)

fun InputStream.mavRawFrameReader() = MavRawFrameReader(this)
