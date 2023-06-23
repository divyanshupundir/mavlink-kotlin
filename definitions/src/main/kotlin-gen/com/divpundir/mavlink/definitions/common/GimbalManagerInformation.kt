package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Information about a high level gimbal manager. This message should be requested by a ground
 * station using MAV_CMD_REQUEST_MESSAGE.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 280u,
  crcExtra = 70,
)
public data class GimbalManagerInformation(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Bitmap of gimbal capability flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val capFlags: MavBitmaskValue<GimbalManagerCapFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal device ID that this gimbal manager is responsible for.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalDeviceId: UByte = 0u,
  /**
   * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left)
   */
  @GeneratedMavField(type = "float")
  public val rollMin: Float = 0F,
  /**
   * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left)
   */
  @GeneratedMavField(type = "float")
  public val rollMax: Float = 0F,
  /**
   * Minimum pitch angle (positive: up, negative: down)
   */
  @GeneratedMavField(type = "float")
  public val pitchMin: Float = 0F,
  /**
   * Maximum pitch angle (positive: up, negative: down)
   */
  @GeneratedMavField(type = "float")
  public val pitchMax: Float = 0F,
  /**
   * Minimum yaw angle (positive: to the right, negative: to the left)
   */
  @GeneratedMavField(type = "float")
  public val yawMin: Float = 0F,
  /**
   * Maximum yaw angle (positive: to the right, negative: to the left)
   */
  @GeneratedMavField(type = "float")
  public val yawMax: Float = 0F,
) : MavMessage<GimbalManagerInformation> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerInformation> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeBitmaskValue(capFlags.value, 4)
    output.encodeFloat(rollMin)
    output.encodeFloat(rollMax)
    output.encodeFloat(pitchMin)
    output.encodeFloat(pitchMax)
    output.encodeFloat(yawMin)
    output.encodeFloat(yawMax)
    output.encodeUInt8(gimbalDeviceId)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeBitmaskValue(capFlags.value, 4)
    output.encodeFloat(rollMin)
    output.encodeFloat(rollMax)
    output.encodeFloat(pitchMin)
    output.encodeFloat(pitchMax)
    output.encodeFloat(yawMin)
    output.encodeFloat(yawMax)
    output.encodeUInt8(gimbalDeviceId)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerInformation> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    public override val id: UInt = 280u

    public override val crcExtra: Byte = 70

    public override fun deserialize(source: BufferedSource): GimbalManagerInformation {
      val timeBootMs = source.decodeUInt32()
      val capFlags = source.decodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val rollMin = source.decodeFloat()
      val rollMax = source.decodeFloat()
      val pitchMin = source.decodeFloat()
      val pitchMax = source.decodeFloat()
      val yawMin = source.decodeFloat()
      val yawMax = source.decodeFloat()
      val gimbalDeviceId = source.decodeUInt8()

      return GimbalManagerInformation(
        timeBootMs = timeBootMs,
        capFlags = capFlags,
        gimbalDeviceId = gimbalDeviceId,
        rollMin = rollMin,
        rollMax = rollMax,
        pitchMin = pitchMin,
        pitchMax = pitchMax,
        yawMin = yawMin,
        yawMax = yawMax,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalManagerInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var capFlags: MavBitmaskValue<GimbalManagerCapFlags> = MavBitmaskValue.fromValue(0u)

    public var gimbalDeviceId: UByte = 0u

    public var rollMin: Float = 0F

    public var rollMax: Float = 0F

    public var pitchMin: Float = 0F

    public var pitchMax: Float = 0F

    public var yawMin: Float = 0F

    public var yawMax: Float = 0F

    public fun build(): GimbalManagerInformation = GimbalManagerInformation(
      timeBootMs = timeBootMs,
      capFlags = capFlags,
      gimbalDeviceId = gimbalDeviceId,
      rollMin = rollMin,
      rollMax = rollMax,
      pitchMin = pitchMin,
      pitchMax = pitchMax,
      yawMin = yawMin,
      yawMax = yawMax,
    )
  }
}
