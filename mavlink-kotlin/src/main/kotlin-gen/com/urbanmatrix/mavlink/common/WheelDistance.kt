package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeDoubleArray
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeDoubleArray
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Cumulative distance traveled for each reported wheel.
 */
public data class WheelDistance(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Distance reported by individual wheel encoders. Forward rotations increase values, reverse
   * rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of
   * encoders to wheel positions must be agreed/understood by the endpoints.
   */
  public val distance: List<Double> = emptyList(),
  /**
   * Number of wheels reported.
   */
  public val count: Int = 0,
) : MavMessage<WheelDistance> {
  public override val instanceMetadata: MavMessage.Metadata<WheelDistance> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(137).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeDoubleArray(distance, 128)
    outputBuffer.encodeUint8(count)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 9000

    private const val CRC: Int = 254

    private val DESERIALIZER: MavDeserializer<WheelDistance> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val distance = inputBuffer.decodeDoubleArray(128)
      val count = inputBuffer.decodeUint8()
      WheelDistance(
        timeUsec = timeUsec,
        distance = distance,
        count = count,
      )
    }


    private val METADATA: MavMessage.Metadata<WheelDistance> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WheelDistance> = METADATA
  }
}
