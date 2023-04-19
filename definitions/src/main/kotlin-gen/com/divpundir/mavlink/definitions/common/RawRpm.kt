package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * RPM sensor data message.
 */
@GeneratedMavMessage(
  id = 339u,
  crcExtra = -57,
)
public data class RawRpm(
  /**
   * Index of this RPM sensor (0-indexed)
   */
  @GeneratedMavField(type = "uint8_t")
  public val index: UByte = 0u,
  /**
   * Indicated rate
   */
  @GeneratedMavField(type = "float")
  public val frequency: Float = 0F,
) : MavMessage<RawRpm> {
  public override val instanceMetadata: MavMessage.Metadata<RawRpm> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(frequency)
    outputBuffer.encodeUInt8(index)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(frequency)
    outputBuffer.encodeUInt8(index)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 339u

    private const val CRC_EXTRA: Byte = -57

    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    private val DESERIALIZER: MavDeserializer<RawRpm> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val frequency = inputBuffer.decodeFloat()
      val index = inputBuffer.decodeUInt8()

      RawRpm(
        index = index,
        frequency = frequency,
      )
    }


    private val METADATA: MavMessage.Metadata<RawRpm> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RawRpm> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RawRpm =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var index: UByte = 0u

    public var frequency: Float = 0F

    public fun build(): RawRpm = RawRpm(
      index = index,
      frequency = frequency,
    )
  }
}
