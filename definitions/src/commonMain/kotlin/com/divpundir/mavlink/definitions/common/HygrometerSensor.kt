package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Temperature and humidity from hygrometer.
 *
 * @param id Hygrometer ID
 * @param temperature Temperature
 * units = cdegC
 * @param humidity Humidity
 * units = c%
 */
@GeneratedMavMessage(
  id = 12_920u,
  crcExtra = 20,
)
public data class HygrometerSensor(
  /**
   * Hygrometer ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Temperature
   * units = cdegC
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Humidity
   * units = c%
   */
  @GeneratedMavField(type = "uint16_t")
  public val humidity: UShort = 0u,
) : MavMessage<HygrometerSensor> {
  override val instanceCompanion: MavMessage.MavCompanion<HygrometerSensor> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(temperature)
    encoder.encodeUInt16(humidity)
    encoder.encodeUInt8(id)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(temperature)
    encoder.encodeUInt16(humidity)
    encoder.encodeUInt8(id)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HygrometerSensor> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    override val id: UInt = 12_920u

    override val crcExtra: Byte = 20

    override fun deserialize(bytes: ByteArray): HygrometerSensor {
      val decoder = MavDataDecoder(bytes)

      val temperature = decoder.safeDecodeInt16()
      val humidity = decoder.safeDecodeUInt16()
      val id = decoder.safeDecodeUInt8()

      return HygrometerSensor(
        id = id,
        temperature = temperature,
        humidity = humidity,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HygrometerSensor =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UByte = 0u

    public var temperature: Short = 0

    public var humidity: UShort = 0u

    public fun build(): HygrometerSensor = HygrometerSensor(
      id = id,
      temperature = temperature,
      humidity = humidity,
    )
  }
}
