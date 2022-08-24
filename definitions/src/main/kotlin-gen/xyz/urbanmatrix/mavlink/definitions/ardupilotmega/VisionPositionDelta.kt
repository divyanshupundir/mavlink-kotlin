package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

/**
 * Camera vision based attitude and position deltas.
 */
@GeneratedMavMessage(
  id = 11011,
  crc = 106,
)
public data class VisionPositionDelta(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Time since the last reported camera frame.
   */
  public val timeDeltaUsec: BigInteger = BigInteger.ZERO,
  /**
   * Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the
   * previous MAV_FRAME_BODY_FRD.
   */
  public val angleDelta: List<Float> = emptyList(),
  /**
   * Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD rotated
   * to the current MAV_FRAME_BODY_FRD.
   */
  public val positionDelta: List<Float> = emptyList(),
  /**
   * Normalised confidence value from 0 to 100.
   */
  public val confidence: Float = 0F,
) : MavMessage<VisionPositionDelta> {
  public override val instanceMetadata: MavMessage.Metadata<VisionPositionDelta> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint64(timeDeltaUsec)
    outputBuffer.encodeFloatArray(angleDelta, 12)
    outputBuffer.encodeFloatArray(positionDelta, 12)
    outputBuffer.encodeFloat(confidence)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11011

    private const val CRC: Int = 106

    private const val SIZE: Int = 44

    private val DESERIALIZER: MavDeserializer<VisionPositionDelta> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val timeDeltaUsec = inputBuffer.decodeUint64()
      val angleDelta = inputBuffer.decodeFloatArray(12)
      val positionDelta = inputBuffer.decodeFloatArray(12)
      val confidence = inputBuffer.decodeFloat()

      VisionPositionDelta(
        timeUsec = timeUsec,
        timeDeltaUsec = timeDeltaUsec,
        angleDelta = angleDelta,
        positionDelta = positionDelta,
        confidence = confidence,
      )
    }


    private val METADATA: MavMessage.Metadata<VisionPositionDelta> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VisionPositionDelta> = METADATA
  }
}
