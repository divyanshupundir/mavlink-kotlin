package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Double
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeDoubleArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeDoubleArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Cumulative distance traveled for each reported wheel.
 */
@GeneratedMavMessage(
  id = 9000,
  crc = 113,
)
public data class WheelDistance(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Number of wheels reported.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: Int = 0,
  /**
   * Distance reported by individual wheel encoders. Forward rotations increase values, reverse
   * rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of
   * encoders to wheel positions must be agreed/understood by the endpoints.
   */
  @GeneratedMavField(type = "double[16]")
  public val distance: List<Double> = emptyList(),
) : MavMessage<WheelDistance> {
  public override val instanceMetadata: MavMessage.Metadata<WheelDistance> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeDoubleArray(distance, 128)
    outputBuffer.encodeUint8(count)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeDoubleArray(distance, 128)
    outputBuffer.encodeUint8(count)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 9000

    private const val CRC: Int = 113

    private const val SIZE: Int = 137

    private val DESERIALIZER: MavDeserializer<WheelDistance> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val distance = inputBuffer.decodeDoubleArray(128)
      val count = inputBuffer.decodeUint8()

      WheelDistance(
        timeUsec = timeUsec,
        count = count,
        distance = distance,
      )
    }


    private val METADATA: MavMessage.Metadata<WheelDistance> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WheelDistance> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var count: Int = 0

    public var distance: List<Double> = emptyList()

    public fun build(): WheelDistance = WheelDistance(
      timeUsec = timeUsec,
      count = count,
      distance = distance,
    )
  }
}
