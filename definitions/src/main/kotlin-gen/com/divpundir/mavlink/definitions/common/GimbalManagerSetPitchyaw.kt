package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * High level message to control a gimbal's pitch and yaw angles. This message is to be sent to the
 * gimbal manager (e.g. from a ground station). Angles and rates can be set to NaN according to use
 * case.
 */
@WorkInProgress
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
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle (positive: to the right, negative: to the left, NaN to be ignored).
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Pitch angular rate (positive: up, negative: down, NaN to be ignored).
   */
  @GeneratedMavField(type = "float")
  public val pitchRate: Float = 0F,
  /**
   * Yaw angular rate (positive: to the right, negative: to the left, NaN to be ignored).
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<GimbalManagerSetPitchyaw> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerSetPitchyaw> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeBitmaskValue(flags.value, 4)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(pitchRate)
    buffer.encodeFloat(yawRate)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(gimbalDeviceId)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeBitmaskValue(flags.value, 4)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(pitchRate)
    buffer.encodeFloat(yawRate)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(gimbalDeviceId)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerSetPitchyaw> {
    public override val id: UInt = 287u

    public override val crcExtra: Byte = 1

    public override fun deserialize(bytes: ByteArray): GimbalManagerSetPitchyaw {
      val buffer = Buffer().write(bytes)

      val flags = buffer.decodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val pitchRate = buffer.decodeFloat()
      val yawRate = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val gimbalDeviceId = buffer.decodeUInt8()

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
