package xyz.urbanmatrix.mavlink

import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavEnum
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.raw.MavRawFrameReader
import java.io.InputStream

fun <E : MavEnum> E.wrap() = MavEnumValue.of(this)

fun <E : MavBitmask> E.wrap() = MavBitmaskValue.of(this)

fun <E : MavBitmask> List<E>.wrap() = MavBitmaskValue.of(this)

fun InputStream.mavRawFrameReader() = MavRawFrameReader(this)
