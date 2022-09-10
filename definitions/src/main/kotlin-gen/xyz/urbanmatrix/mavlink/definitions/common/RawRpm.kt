package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * RPM sensor data message.
 */
@GeneratedMavMessage(
  id = 339,
  crc = 199,
)
public data class RawRpm(
  /**
   * Index of this RPM sensor (0-indexed)
   */
  @GeneratedMavField(type = "uint8_t")
  public val index: Int = 0,
  /**
   * Indicated rate
   */
  @GeneratedMavField(type = "float")
  public val frequency: Float = 0F,
) : MavMessage<RawRpm> {
  public override val instanceMetadata: MavMessage.Metadata<RawRpm> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(frequency)
    outputBuffer.encodeUint8(index)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(frequency)
    outputBuffer.encodeUint8(index)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 339

    private const val CRC: Int = 199

    private const val SIZE: Int = 5

    private val DESERIALIZER: MavDeserializer<RawRpm> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val frequency = inputBuffer.decodeFloat()
      val index = inputBuffer.decodeUint8()

      RawRpm(
        index = index,
        frequency = frequency,
      )
    }


    private val METADATA: MavMessage.Metadata<RawRpm> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RawRpm> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var index: Int = 0

    public var frequency: Float = 0F

    public fun build(): RawRpm = RawRpm(
      index = index,
      frequency = frequency,
    )
  }
}
