package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * The IMU readings in SI units in NED body frame
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param xacc X acceleration
 * units = m/s/s
 * @param yacc Y acceleration
 * units = m/s/s
 * @param zacc Z acceleration
 * units = m/s/s
 * @param xgyro Angular speed around X axis
 * units = rad/s
 * @param ygyro Angular speed around Y axis
 * units = rad/s
 * @param zgyro Angular speed around Z axis
 * units = rad/s
 * @param xmag X Magnetic field
 * units = gauss
 * @param ymag Y Magnetic field
 * units = gauss
 * @param zmag Z Magnetic field
 * units = gauss
 * @param absPressure Absolute pressure
 * units = hPa
 * @param diffPressure Differential pressure
 * units = hPa
 * @param pressureAlt Altitude calculated from pressure
 * @param temperature Temperature
 * units = degC
 * @param fieldsUpdated Bitmap for fields that have updated since last message
 * @param id Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a
 * message with id=0)
 */
@GeneratedMavMessage(
  id = 105u,
  crcExtra = 93,
)
public data class HighresImu(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * X acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
  /**
   * X Magnetic field
   * units = gauss
   */
  @GeneratedMavField(type = "float")
  public val xmag: Float = 0F,
  /**
   * Y Magnetic field
   * units = gauss
   */
  @GeneratedMavField(type = "float")
  public val ymag: Float = 0F,
  /**
   * Z Magnetic field
   * units = gauss
   */
  @GeneratedMavField(type = "float")
  public val zmag: Float = 0F,
  /**
   * Absolute pressure
   * units = hPa
   */
  @GeneratedMavField(type = "float")
  public val absPressure: Float = 0F,
  /**
   * Differential pressure
   * units = hPa
   */
  @GeneratedMavField(type = "float")
  public val diffPressure: Float = 0F,
  /**
   * Altitude calculated from pressure
   */
  @GeneratedMavField(type = "float")
  public val pressureAlt: Float = 0F,
  /**
   * Temperature
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val temperature: Float = 0F,
  /**
   * Bitmap for fields that have updated since last message
   */
  @GeneratedMavField(type = "uint16_t")
  public val fieldsUpdated: MavBitmaskValue<HighresImuUpdatedFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with
   * id=0)
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: UByte = 0u,
) : MavMessage<HighresImu> {
  override val instanceCompanion: MavMessage.MavCompanion<HighresImu> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(xacc)
    encoder.encodeFloat(yacc)
    encoder.encodeFloat(zacc)
    encoder.encodeFloat(xgyro)
    encoder.encodeFloat(ygyro)
    encoder.encodeFloat(zgyro)
    encoder.encodeFloat(xmag)
    encoder.encodeFloat(ymag)
    encoder.encodeFloat(zmag)
    encoder.encodeFloat(absPressure)
    encoder.encodeFloat(diffPressure)
    encoder.encodeFloat(pressureAlt)
    encoder.encodeFloat(temperature)
    encoder.encodeBitmaskValue(fieldsUpdated.value, 2)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(xacc)
    encoder.encodeFloat(yacc)
    encoder.encodeFloat(zacc)
    encoder.encodeFloat(xgyro)
    encoder.encodeFloat(ygyro)
    encoder.encodeFloat(zgyro)
    encoder.encodeFloat(xmag)
    encoder.encodeFloat(ymag)
    encoder.encodeFloat(zmag)
    encoder.encodeFloat(absPressure)
    encoder.encodeFloat(diffPressure)
    encoder.encodeFloat(pressureAlt)
    encoder.encodeFloat(temperature)
    encoder.encodeBitmaskValue(fieldsUpdated.value, 2)
    encoder.encodeUInt8(id)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HighresImu> {
    private const val SIZE_V1: Int = 62

    private const val SIZE_V2: Int = 63

    override val id: UInt = 105u

    override val crcExtra: Byte = 93

    override fun deserialize(bytes: ByteArray): HighresImu {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val xacc = decoder.safeDecodeFloat()
      val yacc = decoder.safeDecodeFloat()
      val zacc = decoder.safeDecodeFloat()
      val xgyro = decoder.safeDecodeFloat()
      val ygyro = decoder.safeDecodeFloat()
      val zgyro = decoder.safeDecodeFloat()
      val xmag = decoder.safeDecodeFloat()
      val ymag = decoder.safeDecodeFloat()
      val zmag = decoder.safeDecodeFloat()
      val absPressure = decoder.safeDecodeFloat()
      val diffPressure = decoder.safeDecodeFloat()
      val pressureAlt = decoder.safeDecodeFloat()
      val temperature = decoder.safeDecodeFloat()
      val fieldsUpdated = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = HighresImuUpdatedFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val id = decoder.safeDecodeUInt8()

      return HighresImu(
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
        absPressure = absPressure,
        diffPressure = diffPressure,
        pressureAlt = pressureAlt,
        temperature = temperature,
        fieldsUpdated = fieldsUpdated,
        id = id,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HighresImu =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var xacc: Float = 0F

    public var yacc: Float = 0F

    public var zacc: Float = 0F

    public var xgyro: Float = 0F

    public var ygyro: Float = 0F

    public var zgyro: Float = 0F

    public var xmag: Float = 0F

    public var ymag: Float = 0F

    public var zmag: Float = 0F

    public var absPressure: Float = 0F

    public var diffPressure: Float = 0F

    public var pressureAlt: Float = 0F

    public var temperature: Float = 0F

    public var fieldsUpdated: MavBitmaskValue<HighresImuUpdatedFlags> =
        MavBitmaskValue.fromValue(0u)

    public var id: UByte = 0u

    public fun build(): HighresImu = HighresImu(
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
      absPressure = absPressure,
      diffPressure = diffPressure,
      pressureAlt = pressureAlt,
      temperature = temperature,
      fieldsUpdated = fieldsUpdated,
      id = id,
    )
  }
}
