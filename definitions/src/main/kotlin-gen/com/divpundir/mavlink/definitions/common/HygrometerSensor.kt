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
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(temperature)
    output.encodeUInt16(humidity)
    output.encodeUInt8(id)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(temperature)
    output.encodeUInt16(humidity)
    output.encodeUInt8(id)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<HygrometerSensor> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    public override val id: UInt = 12_920u

    public override val crcExtra: Byte = 20

    public override fun deserialize(source: BufferedSource): HygrometerSensor {
      val temperature = source.decodeInt16()
      val humidity = source.decodeUInt16()
      val id = source.decodeUInt8()

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
