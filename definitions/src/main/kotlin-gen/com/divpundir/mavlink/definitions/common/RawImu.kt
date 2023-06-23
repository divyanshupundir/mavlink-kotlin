package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The RAW IMU readings for a 9DOF sensor, which is identified by the id (default IMU1). This
 * message should always contain the true raw values without any scaling to allow data capture and
 * system debugging.
 */
@GeneratedMavMessage(
  id = 27u,
  crcExtra = -112,
)
public data class RawImu(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * X acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Short = 0,
  /**
   * Y acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Short = 0,
  /**
   * Z acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Short = 0,
  /**
   * Angular speed around X axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xgyro: Short = 0,
  /**
   * Angular speed around Y axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val ygyro: Short = 0,
  /**
   * Angular speed around Z axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zgyro: Short = 0,
  /**
   * X Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xmag: Short = 0,
  /**
   * Y Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val ymag: Short = 0,
  /**
   * Z Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zmag: Short = 0,
  /**
   * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with
   * id=0)
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: UByte = 0u,
  /**
   * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1
   * (0.01C).
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperature: Short = 0,
) : MavMessage<RawImu> {
  public override val instanceCompanion: MavMessage.MavCompanion<RawImu> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt16(xacc)
    output.encodeInt16(yacc)
    output.encodeInt16(zacc)
    output.encodeInt16(xgyro)
    output.encodeInt16(ygyro)
    output.encodeInt16(zgyro)
    output.encodeInt16(xmag)
    output.encodeInt16(ymag)
    output.encodeInt16(zmag)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt16(xacc)
    output.encodeInt16(yacc)
    output.encodeInt16(zacc)
    output.encodeInt16(xgyro)
    output.encodeInt16(ygyro)
    output.encodeInt16(zgyro)
    output.encodeInt16(xmag)
    output.encodeInt16(ymag)
    output.encodeInt16(zmag)
    output.encodeUInt8(id)
    output.encodeInt16(temperature)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<RawImu> {
    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 29

    public override val id: UInt = 27u

    public override val crcExtra: Byte = -112

    public override fun deserialize(source: BufferedSource): RawImu {
      val timeUsec = source.decodeUInt64()
      val xacc = source.decodeInt16()
      val yacc = source.decodeInt16()
      val zacc = source.decodeInt16()
      val xgyro = source.decodeInt16()
      val ygyro = source.decodeInt16()
      val zgyro = source.decodeInt16()
      val xmag = source.decodeInt16()
      val ymag = source.decodeInt16()
      val zmag = source.decodeInt16()
      val id = source.decodeUInt8()
      val temperature = source.decodeInt16()

      return RawImu(
        timeUsec = timeUsec,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        xmag = xmag,
        ymag = ymag,
        zmag = zmag,
        id = id,
        temperature = temperature,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RawImu =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var xacc: Short = 0

    public var yacc: Short = 0

    public var zacc: Short = 0

    public var xgyro: Short = 0

    public var ygyro: Short = 0

    public var zgyro: Short = 0

    public var xmag: Short = 0

    public var ymag: Short = 0

    public var zmag: Short = 0

    public var id: UByte = 0u

    public var temperature: Short = 0

    public fun build(): RawImu = RawImu(
      timeUsec = timeUsec,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
      xgyro = xgyro,
      ygyro = ygyro,
      zgyro = zgyro,
      xmag = xmag,
      ymag = ymag,
      zmag = zmag,
      id = id,
      temperature = temperature,
    )
  }
}
