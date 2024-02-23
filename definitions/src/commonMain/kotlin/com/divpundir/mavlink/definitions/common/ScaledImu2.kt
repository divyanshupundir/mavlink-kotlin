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
 * The RAW IMU readings for secondary 9DOF sensor setup. This message should contain the scaled
 * values to the described units
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param xacc X acceleration
 * units = mG
 * @param yacc Y acceleration
 * units = mG
 * @param zacc Z acceleration
 * units = mG
 * @param xgyro Angular speed around X axis
 * units = mrad/s
 * @param ygyro Angular speed around Y axis
 * units = mrad/s
 * @param zgyro Angular speed around Z axis
 * units = mrad/s
 * @param xmag X Magnetic field
 * units = mgauss
 * @param ymag Y Magnetic field
 * units = mgauss
 * @param zmag Z Magnetic field
 * units = mgauss
 * @param temperature Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C
 * it must send 1 (0.01C).
 * units = cdegC
 */
@GeneratedMavMessage(
  id = 116u,
  crcExtra = 76,
)
public data class ScaledImu2(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * X acceleration
   * units = mG
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Short = 0,
  /**
   * Y acceleration
   * units = mG
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Short = 0,
  /**
   * Z acceleration
   * units = mG
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Short = 0,
  /**
   * Angular speed around X axis
   * units = mrad/s
   */
  @GeneratedMavField(type = "int16_t")
  public val xgyro: Short = 0,
  /**
   * Angular speed around Y axis
   * units = mrad/s
   */
  @GeneratedMavField(type = "int16_t")
  public val ygyro: Short = 0,
  /**
   * Angular speed around Z axis
   * units = mrad/s
   */
  @GeneratedMavField(type = "int16_t")
  public val zgyro: Short = 0,
  /**
   * X Magnetic field
   * units = mgauss
   */
  @GeneratedMavField(type = "int16_t")
  public val xmag: Short = 0,
  /**
   * Y Magnetic field
   * units = mgauss
   */
  @GeneratedMavField(type = "int16_t")
  public val ymag: Short = 0,
  /**
   * Z Magnetic field
   * units = mgauss
   */
  @GeneratedMavField(type = "int16_t")
  public val zmag: Short = 0,
  /**
   * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1
   * (0.01C).
   * units = cdegC
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperature: Short = 0,
) : MavMessage<ScaledImu2> {
  override val instanceCompanion: MavMessage.MavCompanion<ScaledImu2> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
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

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
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

  public companion object : MavMessage.MavCompanion<ScaledImu2> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 24

    override val id: UInt = 116u

    override val crcExtra: Byte = 76

    override fun deserialize(bytes: ByteArray): ScaledImu2 {
      val decoder = MavDataDecoder(bytes)

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

      return ScaledImu2(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): ScaledImu2 =
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

    public fun build(): ScaledImu2 = ScaledImu2(
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
