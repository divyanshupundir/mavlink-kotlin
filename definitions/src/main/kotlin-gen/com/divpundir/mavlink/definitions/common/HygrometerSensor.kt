package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<HygrometerSensor> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUInt16(humidity)
    outputBuffer.encodeUInt8(id)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUInt16(humidity)
    outputBuffer.encodeUInt8(id)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 12_920u

    private const val CRC_EXTRA: Byte = 20

    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    private val DESERIALIZER: MavDeserializer<HygrometerSensor> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val temperature = inputBuffer.decodeInt16()
      val humidity = inputBuffer.decodeUInt16()
      val id = inputBuffer.decodeUInt8()

      HygrometerSensor(
        id = id,
        temperature = temperature,
        humidity = humidity,
      )
    }


    private val METADATA: MavMessage.Metadata<HygrometerSensor> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HygrometerSensor> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HygrometerSensor =
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
