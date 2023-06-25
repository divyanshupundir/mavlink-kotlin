package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Temperature and humidity from hygrometer.
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
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Humidity
   */
  @GeneratedMavField(type = "uint16_t")
  public val humidity: UShort = 0u,
) : MavMessage<HygrometerSensor> {
  public override val instanceCompanion: MavMessage.MavCompanion<HygrometerSensor> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(temperature)
    buffer.encodeUInt16(humidity)
    buffer.encodeUInt8(id)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(temperature)
    buffer.encodeUInt16(humidity)
    buffer.encodeUInt8(id)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HygrometerSensor> {
    public override val id: UInt = 12_920u

    public override val crcExtra: Byte = 20

    public override fun deserialize(bytes: ByteArray): HygrometerSensor {
      val buffer = Buffer().write(bytes)

      val temperature = buffer.decodeInt16()
      val humidity = buffer.decodeUInt16()
      val id = buffer.decodeUInt8()

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
