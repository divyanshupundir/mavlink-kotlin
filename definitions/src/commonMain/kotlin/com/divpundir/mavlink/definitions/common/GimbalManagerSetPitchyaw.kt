package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
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
 * Set gimbal manager pitch and yaw angles (high rate message). This message is to be sent to the
 * gimbal manager (e.g. from a ground station) and will be ignored by gimbal devices. Angles and rates
 * can be set to NaN according to use case. Use MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW for low-rate
 * adjustments that require confirmation.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param flags High level gimbal manager flags to use.
 * @param gimbalDeviceId Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0
 * for all gimbal device components. Send command multiple times for more than one gimbal (but not all
 * gimbals).
 * @param pitch Pitch angle (positive: up, negative: down, NaN to be ignored).
 * units = rad
 * @param yaw Yaw angle (positive: to the right, negative: to the left, NaN to be ignored).
 * units = rad
 * @param pitchRate Pitch angular rate (positive: up, negative: down, NaN to be ignored).
 * units = rad/s
 * @param yawRate Yaw angular rate (positive: to the right, negative: to the left, NaN to be
 * ignored).
 * units = rad/s
 */
@GeneratedMavMessage(
  id = 287u,
  crcExtra = 1,
)
public data class GimbalManagerSetPitchyaw(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * High level gimbal manager flags to use.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalDeviceId: UByte = 0u,
  /**
   * Pitch angle (positive: up, negative: down, NaN to be ignored).
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle (positive: to the right, negative: to the left, NaN to be ignored).
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Pitch angular rate (positive: up, negative: down, NaN to be ignored).
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val pitchRate: Float = 0F,
  /**
   * Yaw angular rate (positive: to the right, negative: to the left, NaN to be ignored).
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<GimbalManagerSetPitchyaw> {
  override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerSetPitchyaw> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(pitchRate)
    encoder.encodeFloat(yawRate)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(pitchRate)
    encoder.encodeFloat(yawRate)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerSetPitchyaw> {
    private const val SIZE_V1: Int = 23

    private const val SIZE_V2: Int = 23

    override val id: UInt = 287u

    override val crcExtra: Byte = 1

    override fun deserialize(bytes: ByteArray): GimbalManagerSetPitchyaw {
      val decoder = MavDataDecoder(bytes)

      val flags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val pitchRate = decoder.safeDecodeFloat()
      val yawRate = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val gimbalDeviceId = decoder.safeDecodeUInt8()

      return GimbalManagerSetPitchyaw(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        flags = flags,
        gimbalDeviceId = gimbalDeviceId,
        pitch = pitch,
        yaw = yaw,
        pitchRate = pitchRate,
        yawRate = yawRate,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalManagerSetPitchyaw =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u)

    public var gimbalDeviceId: UByte = 0u

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var pitchRate: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): GimbalManagerSetPitchyaw = GimbalManagerSetPitchyaw(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      flags = flags,
      gimbalDeviceId = gimbalDeviceId,
      pitch = pitch,
      yaw = yaw,
      pitchRate = pitchRate,
      yawRate = yawRate,
    )
  }
}
