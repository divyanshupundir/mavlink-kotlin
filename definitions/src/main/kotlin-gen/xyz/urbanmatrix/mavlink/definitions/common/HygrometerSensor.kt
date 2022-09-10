package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Temperature and humidity from hygrometer.
 */
@GeneratedMavMessage(
  id = 12920,
  crc = 20,
)
public data class HygrometerSensor(
  /**
   * Hygrometer ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: Int = 0,
  /**
   * Temperature
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Int = 0,
  /**
   * Humidity
   */
  @GeneratedMavField(type = "uint16_t")
  public val humidity: Int = 0,
) : MavMessage<HygrometerSensor> {
  public override val instanceMetadata: MavMessage.Metadata<HygrometerSensor> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUint16(humidity)
    outputBuffer.encodeUint8(id)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUint16(humidity)
    outputBuffer.encodeUint8(id)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 12920

    private const val CRC: Int = 20

    private const val SIZE: Int = 5

    private val DESERIALIZER: MavDeserializer<HygrometerSensor> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val temperature = inputBuffer.decodeInt16()
      val humidity = inputBuffer.decodeUint16()
      val id = inputBuffer.decodeUint8()

      HygrometerSensor(
        id = id,
        temperature = temperature,
        humidity = humidity,
      )
    }


    private val METADATA: MavMessage.Metadata<HygrometerSensor> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HygrometerSensor> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: Int = 0

    public var temperature: Int = 0

    public var humidity: Int = 0

    public fun build(): HygrometerSensor = HygrometerSensor(
      id = id,
      temperature = temperature,
      humidity = humidity,
    )
  }
}
