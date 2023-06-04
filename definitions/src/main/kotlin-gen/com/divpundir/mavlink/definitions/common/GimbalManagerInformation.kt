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

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeBitmaskValue(capFlags.value, 4)
    outputBuffer.encodeFloat(rollMin)
    outputBuffer.encodeFloat(rollMax)
    outputBuffer.encodeFloat(pitchMin)
    outputBuffer.encodeFloat(pitchMax)
    outputBuffer.encodeFloat(yawMin)
    outputBuffer.encodeFloat(yawMax)
    outputBuffer.encodeUInt8(gimbalDeviceId)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeBitmaskValue(capFlags.value, 4)
    outputBuffer.encodeFloat(rollMin)
    outputBuffer.encodeFloat(rollMax)
    outputBuffer.encodeFloat(pitchMin)
    outputBuffer.encodeFloat(pitchMax)
    outputBuffer.encodeFloat(yawMin)
    outputBuffer.encodeFloat(yawMax)
    outputBuffer.encodeUInt8(gimbalDeviceId)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerInformation> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    public override val id: UInt = 280u

    public override val crcExtra: Byte = 70

    public override fun deserialize(bytes: ByteArray): GimbalManagerInformation {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val capFlags = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val rollMin = inputBuffer.decodeFloat()
      val rollMax = inputBuffer.decodeFloat()
      val pitchMin = inputBuffer.decodeFloat()
      val pitchMax = inputBuffer.decodeFloat()
      val yawMin = inputBuffer.decodeFloat()
      val yawMax = inputBuffer.decodeFloat()
      val gimbalDeviceId = inputBuffer.decodeUInt8()

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
