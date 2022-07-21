package com.urbanmatrix.mavlink

import com.urbanmatrix.mavlink.api.MavDialect
import com.urbanmatrix.mavlink.api.MavEnum
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.connection.MavConnection
import com.urbanmatrix.mavlink.raw.MavRawFrameReader
import java.io.InputStream
import java.net.Socket

fun <E : MavEnum> E.wrap() = MavEnumValue.of(this)

fun InputStream.mavRawFrameReader() = MavRawFrameReader(this)

fun Socket.mavConnection(dialect: MavDialect) = MavConnection(
    getInputStream(),
    getOutputStream(),
    dialect
)
