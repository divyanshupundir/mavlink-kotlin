package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 */
@GeneratedMavMessage(
  id = 8_009u,
  crcExtra = -112,
)
public data class SensAtmos(
  /**
   * Time since system boot
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  Ambient temperature
   */
  @GeneratedMavField(type = "float")
  public val tempambient: Float = 0F,
  /**
   *  Relative humidity
   */
  @GeneratedMavField(type = "float")
  public val humidity: Float = 0F,
) : MavMessage<SensAtmos> {
  public override val instanceMetadata: MavMessage.Metadata<SensAtmos> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(tempambient)
    outputBuffer.encodeFloat(humidity)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(tempambient)
    outputBuffer.encodeFloat(humidity)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8_009u

    private const val CRC_EXTRA: Byte = -112

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<SensAtmos> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val tempambient = inputBuffer.decodeFloat()
      val humidity = inputBuffer.decodeFloat()

      SensAtmos(
        timestamp = timestamp,
        tempambient = tempambient,
        humidity = humidity,
      )
    }


    private val METADATA: MavMessage.Metadata<SensAtmos> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensAtmos> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SensAtmos =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var tempambient: Float = 0F

    public var humidity: Float = 0F

    public fun build(): SensAtmos = SensAtmos(
      timestamp = timestamp,
      tempambient = tempambient,
      humidity = humidity,
    )
  }
}
