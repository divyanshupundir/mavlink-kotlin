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
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The RAW IMU readings for 3rd 9DOF sensor setup. This message should contain the scaled values to
 * the described units
 */
@GeneratedMavMessage(
  id = 129u,
  crcExtra = 46,
)
public data class ScaledImu3(
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
) : MavMessage<ScaledImu3> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScaledImu3> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
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
    output.encodeUInt32(timeBootMs)
    output.encodeInt16(xacc)
    output.encodeInt16(yacc)
    output.encodeInt16(zacc)
    output.encodeInt16(xgyro)
    output.encodeInt16(ygyro)
    output.encodeInt16(zgyro)
    output.encodeInt16(xmag)
    output.encodeInt16(ymag)
    output.encodeInt16(zmag)
    output.encodeInt16(temperature)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ScaledImu3> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 24

    public override val id: UInt = 129u

    public override val crcExtra: Byte = 46

    public override fun deserialize(source: BufferedSource): ScaledImu3 {
      val timeBootMs = source.decodeUInt32()
      val xacc = source.decodeInt16()
      val yacc = source.decodeInt16()
      val zacc = source.decodeInt16()
      val xgyro = source.decodeInt16()
      val ygyro = source.decodeInt16()
      val zgyro = source.decodeInt16()
      val xmag = source.decodeInt16()
      val ymag = source.decodeInt16()
      val zmag = source.decodeInt16()
      val temperature = source.decodeInt16()

      return ScaledImu3(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): ScaledImu3 =
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

    public fun build(): ScaledImu3 = ScaledImu3(
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
