package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param capFlags Bitmap of gimbal capability flags.
 * @param gimbalDeviceId Gimbal device ID that this gimbal manager is responsible for. Component ID
 * of gimbal device (or 1-6 for non-MAVLink gimbal).
 * @param rollMin Minimum hardware roll angle (positive: rolling to the right, negative: rolling to
 * the left)
 * units = rad
 * @param rollMax Maximum hardware roll angle (positive: rolling to the right, negative: rolling to
 * the left)
 * units = rad
 * @param pitchMin Minimum pitch angle (positive: up, negative: down)
 * units = rad
 * @param pitchMax Maximum pitch angle (positive: up, negative: down)
 * units = rad
 * @param yawMin Minimum yaw angle (positive: to the right, negative: to the left)
 * units = rad
 * @param yawMax Maximum yaw angle (positive: to the right, negative: to the left)
 * units = rad
 */
@GeneratedMavMessage(
  id = 280u,
  crcExtra = 70,
)
public data class GimbalManagerInformation(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Bitmap of gimbal capability flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val capFlags: MavBitmaskValue<GimbalManagerCapFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal device ID that this gimbal manager is responsible for. Component ID of gimbal device (or
   * 1-6 for non-MAVLink gimbal).
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalDeviceId: UByte = 0u,
  /**
   * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val rollMin: Float = 0F,
  /**
   * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val rollMax: Float = 0F,
  /**
   * Minimum pitch angle (positive: up, negative: down)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val pitchMin: Float = 0F,
  /**
   * Maximum pitch angle (positive: up, negative: down)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val pitchMax: Float = 0F,
  /**
   * Minimum yaw angle (positive: to the right, negative: to the left)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yawMin: Float = 0F,
  /**
   * Maximum yaw angle (positive: to the right, negative: to the left)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yawMax: Float = 0F,
) : MavMessage<GimbalManagerInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeBitmaskValue(capFlags.value, 4)
    encoder.encodeFloat(rollMin)
    encoder.encodeFloat(rollMax)
    encoder.encodeFloat(pitchMin)
    encoder.encodeFloat(pitchMax)
    encoder.encodeFloat(yawMin)
    encoder.encodeFloat(yawMax)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeBitmaskValue(capFlags.value, 4)
    encoder.encodeFloat(rollMin)
    encoder.encodeFloat(rollMax)
    encoder.encodeFloat(pitchMin)
    encoder.encodeFloat(pitchMax)
    encoder.encodeFloat(yawMin)
    encoder.encodeFloat(yawMax)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerInformation> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    override val id: UInt = 280u

    override val crcExtra: Byte = 70

    override fun deserialize(bytes: ByteArray): GimbalManagerInformation {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val capFlags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val rollMin = decoder.safeDecodeFloat()
      val rollMax = decoder.safeDecodeFloat()
      val pitchMin = decoder.safeDecodeFloat()
      val pitchMax = decoder.safeDecodeFloat()
      val yawMin = decoder.safeDecodeFloat()
      val yawMax = decoder.safeDecodeFloat()
      val gimbalDeviceId = decoder.safeDecodeUInt8()

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
