package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeUsec Timestamp (synced to UNIX time or since system boot).
 * units = us
 * @param timeDeltaUsec Time since the last reported camera frame.
 * units = us
 * @param angleDelta Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD
 * from the previous MAV_FRAME_BODY_FRD.
 * units = rad
 * @param positionDelta Change in position to the current MAV_FRAME_BODY_FRD from the previous
 * FRAME_BODY_FRD rotated to the current MAV_FRAME_BODY_FRD.
 * units = m
 * @param confidence Normalised confidence value from 0 to 100.
 * units = %
 */
@GeneratedMavMessage(
  id = 11_011u,
  crcExtra = 106,
)
public data class VisionPositionDelta(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Time since the last reported camera frame.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeDeltaUsec: ULong = 0uL,
  /**
   * Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the
   * previous MAV_FRAME_BODY_FRD.
   * units = rad
   */
  @GeneratedMavField(type = "float[3]")
  public val angleDelta: List<Float> = emptyList(),
  /**
   * Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD rotated
   * to the current MAV_FRAME_BODY_FRD.
   * units = m
   */
  @GeneratedMavField(type = "float[3]")
  public val positionDelta: List<Float> = emptyList(),
  /**
   * Normalised confidence value from 0 to 100.
   * units = %
   */
  @GeneratedMavField(type = "float")
  public val confidence: Float = 0F,
) : MavMessage<VisionPositionDelta> {
  override val instanceCompanion: MavMessage.MavCompanion<VisionPositionDelta> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt64(timeDeltaUsec)
    encoder.encodeFloatArray(angleDelta, 12)
    encoder.encodeFloatArray(positionDelta, 12)
    encoder.encodeFloat(confidence)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt64(timeDeltaUsec)
    encoder.encodeFloatArray(angleDelta, 12)
    encoder.encodeFloatArray(positionDelta, 12)
    encoder.encodeFloat(confidence)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VisionPositionDelta> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    override val id: UInt = 11_011u

    override val crcExtra: Byte = 106

    override fun deserialize(bytes: ByteArray): VisionPositionDelta {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val timeDeltaUsec = decoder.safeDecodeUInt64()
      val angleDelta = decoder.safeDecodeFloatArray(12)
      val positionDelta = decoder.safeDecodeFloatArray(12)
      val confidence = decoder.safeDecodeFloat()

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
