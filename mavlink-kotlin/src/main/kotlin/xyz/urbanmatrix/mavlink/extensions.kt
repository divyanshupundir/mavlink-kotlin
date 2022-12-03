package xyz.urbanmatrix.mavlink

import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavEnum
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.connection.stream.MavRawFrameReader
import java.io.InputStream

public fun <E : MavEnum> E.wrap(): MavEnumValue<E> = MavEnumValue.of(this)

public fun <E : MavBitmask> E.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

public fun <E : MavBitmask> List<E>.wrap(): MavBitmaskValue<E> = MavBitmaskValue.of(this)

internal fun InputStream.mavRawFrameReader() = MavRawFrameReader(this)
