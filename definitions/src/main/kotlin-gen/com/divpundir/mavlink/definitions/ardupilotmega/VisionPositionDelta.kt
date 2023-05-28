package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
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
import kotlin.collections.List

/**
 * Camera vision based attitude and position deltas.
 */
@GeneratedMavMessage(
  id = 11_011u,
  crcExtra = 106,
)
public data class VisionPositionDelta(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Time since the last reported camera frame.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeDeltaUsec: ULong = 0uL,
  /**
   * Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the
   * previous MAV_FRAME_BODY_FRD.
   */
  @GeneratedMavField(type = "float[3]")
  public val angleDelta: List<Float> = emptyList(),
  /**
   * Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD rotated
   * to the current MAV_FRAME_BODY_FRD.
   */
  @GeneratedMavField(type = "float[3]")
  public val positionDelta: List<Float> = emptyList(),
  /**
   * Normalised confidence value from 0 to 100.
   */
  @GeneratedMavField(type = "float")
  public val confidence: Float = 0F,
) : MavMessage<VisionPositionDelta> {
  public override val instanceMetadata: MavMessage.Metadata<VisionPositionDelta> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt64(timeDeltaUsec)
    outputBuffer.encodeFloatArray(angleDelta, 12)
    outputBuffer.encodeFloatArray(positionDelta, 12)
    outputBuffer.encodeFloat(confidence)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt64(timeDeltaUsec)
    outputBuffer.encodeFloatArray(angleDelta, 12)
    outputBuffer.encodeFloatArray(positionDelta, 12)
    outputBuffer.encodeFloat(confidence)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11_011u

    private const val CRC_EXTRA: Byte = 106

    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    private val DESERIALIZER: MavDeserializer<VisionPositionDelta> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val timeDeltaUsec = inputBuffer.decodeUInt64()
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


    private val METADATA: MavMessage.Metadata<VisionPositionDelta> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VisionPositionDelta> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): VisionPositionDelta =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var timeDeltaUsec: ULong = 0uL

    public var angleDelta: List<Float> = emptyList()

    public var positionDelta: List<Float> = emptyList()

    public var confidence: Float = 0F

    public fun build(): VisionPositionDelta = VisionPositionDelta(
      timeUsec = timeUsec,
      timeDeltaUsec = timeDeltaUsec,
      angleDelta = angleDelta,
      positionDelta = positionDelta,
      confidence = confidence,
    )
  }
}
