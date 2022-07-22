package com.urbanmatrix.mavlink

import com.urbanmatrix.mavlink.api.MavEnum
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.raw.MavRawFrameReader
import java.io.InputStream

fun <E : MavEnum> E.wrap() = MavEnumValue.of(this)

fun InputStream.mavRawFrameReader() = MavRawFrameReader(this)
