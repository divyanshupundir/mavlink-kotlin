package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

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
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt16(xacc)
    encoder.encodeInt16(yacc)
    encoder.encodeInt16(zacc)
    encoder.encodeInt16(xgyro)
    encoder.encodeInt16(ygyro)
    encoder.encodeInt16(zgyro)
    encoder.encodeInt16(xmag)
    encoder.encodeInt16(ymag)
    encoder.encodeInt16(zmag)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt16(xacc)
    encoder.encodeInt16(yacc)
    encoder.encodeInt16(zacc)
    encoder.encodeInt16(xgyro)
    encoder.encodeInt16(ygyro)
    encoder.encodeInt16(zgyro)
    encoder.encodeInt16(xmag)
    encoder.encodeInt16(ymag)
    encoder.encodeInt16(zmag)
    encoder.encodeInt16(temperature)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScaledImu> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 24

    public override val id: UInt = 26u

    public override val crcExtra: Byte = -86

    public override fun deserialize(bytes: ByteArray): ScaledImu {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val xacc = decoder.safeDecodeInt16()
      val yacc = decoder.safeDecodeInt16()
      val zacc = decoder.safeDecodeInt16()
      val xgyro = decoder.safeDecodeInt16()
      val ygyro = decoder.safeDecodeInt16()
      val zgyro = decoder.safeDecodeInt16()
      val xmag = decoder.safeDecodeInt16()
      val ymag = decoder.safeDecodeInt16()
      val zmag = decoder.safeDecodeInt16()
      val temperature = decoder.safeDecodeInt16()

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
