package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Airspeed information from a sensor.
 *
 * @param id Sensor ID.
 * @param airspeed Calibrated airspeed (CAS).
 * units = m/s
 * @param temperature Temperature.
 * units = cdegC
 * @param rawPress Raw differential pressure.
 * units = hPa
 * @param flags Airspeed sensor flags.
 */
@GeneratedMavMessage(
  id = 295u,
  crcExtra = -22,
)
public data class Airspeed(
  /**
   * Sensor ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Calibrated airspeed (CAS).
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val airspeed: Float = 0F,
  /**
   * Temperature.
   * units = cdegC
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Raw differential pressure.
   * units = hPa
   */
  @GeneratedMavField(type = "float")
  public val rawPress: Float = 0F,
  /**
   * Airspeed sensor flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<AirspeedSensorFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<Airspeed> {
  override val instanceCompanion: MavMessage.MavCompanion<Airspeed> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloat(rawPress)
    encoder.encodeInt16(temperature)
    encoder.encodeUInt8(id)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloat(rawPress)
    encoder.encodeInt16(temperature)
    encoder.encodeUInt8(id)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Airspeed> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    override val id: UInt = 295u

    override val crcExtra: Byte = -22

    override fun deserialize(bytes: ByteArray): Airspeed {
      val decoder = MavDataDecoder(bytes)

      val airspeed = decoder.safeDecodeFloat()
      val rawPress = decoder.safeDecodeFloat()
      val temperature = decoder.safeDecodeInt16()
      val id = decoder.safeDecodeUInt8()
      val flags = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = AirspeedSensorFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return Airspeed(
        id = id,
        airspeed = airspeed,
        temperature = temperature,
        rawPress = rawPress,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Airspeed =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UByte = 0u

    public var airspeed: Float = 0F

    public var temperature: Short = 0

    public var rawPress: Float = 0F

    public var flags: MavBitmaskValue<AirspeedSensorFlags> = MavBitmaskValue.fromValue(0u)

    public fun build(): Airspeed = Airspeed(
      id = id,
      airspeed = airspeed,
      temperature = temperature,
      rawPress = rawPress,
      flags = flags,
    )
  }
}
