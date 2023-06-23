package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<VisionPositionDelta> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt64(timeDeltaUsec)
    output.encodeFloatArray(angleDelta, 12)
    output.encodeFloatArray(positionDelta, 12)
    output.encodeFloat(confidence)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt64(timeDeltaUsec)
    output.encodeFloatArray(angleDelta, 12)
    output.encodeFloatArray(positionDelta, 12)
    output.encodeFloat(confidence)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<VisionPositionDelta> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    public override val id: UInt = 11_011u

    public override val crcExtra: Byte = 106

    public override fun deserialize(source: BufferedSource): VisionPositionDelta {
      val timeUsec = source.decodeUInt64()
      val timeDeltaUsec = source.decodeUInt64()
      val angleDelta = source.decodeFloatArray(12)
      val positionDelta = source.decodeFloatArray(12)
      val confidence = source.decodeFloat()

      return VisionPositionDelta(
        timeUsec = timeUsec,
        timeDeltaUsec = timeDeltaUsec,
        angleDelta = angleDelta,
        positionDelta = positionDelta,
        confidence = confidence,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): VisionPositionDelta =
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
