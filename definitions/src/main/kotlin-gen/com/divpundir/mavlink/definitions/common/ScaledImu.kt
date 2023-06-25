package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * The RAW IMU readings for the usual 9DOF sensor setup. This message should contain the scaled
 * values to the described units
 */
@GeneratedMavMessage(
  id = 26u,
  crcExtra = -86,
)
public data class ScaledImu(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * X acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Short = 0,
  /**
   * Y acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Short = 0,
  /**
   * Z acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Short = 0,
  /**
   * Angular speed around X axis
   */
  @GeneratedMavField(type = "int16_t")
  public val xgyro: Short = 0,
  /**
   * Angular speed around Y axis
   */
  @GeneratedMavField(type = "int16_t")
  public val ygyro: Short = 0,
  /**
   * Angular speed around Z axis
   */
  @GeneratedMavField(type = "int16_t")
  public val zgyro: Short = 0,
  /**
   * X Magnetic field
   */
  @GeneratedMavField(type = "int16_t")
  public val xmag: Short = 0,
  /**
   * Y Magnetic field
   */
  @GeneratedMavField(type = "int16_t")
  public val ymag: Short = 0,
  /**
   * Z Magnetic field
   */
  @GeneratedMavField(type = "int16_t")
  public val zmag: Short = 0,
  /**
   * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1
   * (0.01C).
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperature: Short = 0,
) : MavMessage<ScaledImu> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScaledImu> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt16(xacc)
    buffer.encodeInt16(yacc)
    buffer.encodeInt16(zacc)
    buffer.encodeInt16(xgyro)
    buffer.encodeInt16(ygyro)
    buffer.encodeInt16(zgyro)
    buffer.encodeInt16(xmag)
    buffer.encodeInt16(ymag)
    buffer.encodeInt16(zmag)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt16(xacc)
    buffer.encodeInt16(yacc)
    buffer.encodeInt16(zacc)
    buffer.encodeInt16(xgyro)
    buffer.encodeInt16(ygyro)
    buffer.encodeInt16(zgyro)
    buffer.encodeInt16(xmag)
    buffer.encodeInt16(ymag)
    buffer.encodeInt16(zmag)
    buffer.encodeInt16(temperature)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScaledImu> {
    public override val id: UInt = 26u

    public override val crcExtra: Byte = -86

    public override fun deserialize(bytes: ByteArray): ScaledImu {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val xacc = buffer.decodeInt16()
      val yacc = buffer.decodeInt16()
      val zacc = buffer.decodeInt16()
      val xgyro = buffer.decodeInt16()
      val ygyro = buffer.decodeInt16()
      val zgyro = buffer.decodeInt16()
      val xmag = buffer.decodeInt16()
      val ymag = buffer.decodeInt16()
      val zmag = buffer.decodeInt16()
      val temperature = buffer.decodeInt16()

      return ScaledImu(
        timeBootMs = timeBootMs,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        xmag = xmag,
        ymag = ymag,
        zmag = zmag,
        temperature = temperature,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScaledImu =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var xacc: Short = 0

    public var yacc: Short = 0

    public var zacc: Short = 0

    public var xgyro: Short = 0

    public var ygyro: Short = 0

    public var zgyro: Short = 0

    public var xmag: Short = 0

    public var ymag: Short = 0

    public var zmag: Short = 0

    public var temperature: Short = 0

    public fun build(): ScaledImu = ScaledImu(
      timeBootMs = timeBootMs,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
      xgyro = xgyro,
      ygyro = ygyro,
      zgyro = zgyro,
      xmag = xmag,
      ymag = ymag,
      zmag = zmag,
      temperature = temperature,
    )
  }
}
