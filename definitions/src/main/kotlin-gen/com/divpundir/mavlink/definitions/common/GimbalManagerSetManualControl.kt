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
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * High level message to control a gimbal manually. The angles or angular rates are unitless; the
 * actual rates will depend on internal gimbal manager settings/configuration (e.g. set by parameters).
 * This message is to be sent to the gimbal manager (e.g. from a ground station). Angles and rates can
 * be set to NaN according to use case.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 288u,
  crcExtra = 20,
)
public data class GimbalManagerSetManualControl(
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
   * High level gimbal manager flags.
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
   * Pitch angle unitless (-1..1, positive: up, negative: down, NaN to be ignored).
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle unitless (-1..1, positive: to the right, negative: to the left, NaN to be ignored).
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Pitch angular rate unitless (-1..1, positive: up, negative: down, NaN to be ignored).
   */
  @GeneratedMavField(type = "float")
  public val pitchRate: Float = 0F,
  /**
   * Yaw angular rate unitless (-1..1, positive: to the right, negative: to the left, NaN to be
   * ignored).
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<GimbalManagerSetManualControl> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerSetManualControl> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(flags.value, 4)
    output.encodeFloat(pitch)
    output.encodeFloat(yaw)
    output.encodeFloat(pitchRate)
    output.encodeFloat(yawRate)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(gimbalDeviceId)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(flags.value, 4)
    output.encodeFloat(pitch)
    output.encodeFloat(yaw)
    output.encodeFloat(pitchRate)
    output.encodeFloat(yawRate)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(gimbalDeviceId)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerSetManualControl> {
    private const val SIZE_V1: Int = 23

    private const val SIZE_V2: Int = 23

    public override val id: UInt = 288u

    public override val crcExtra: Byte = 20

    public override fun deserialize(source: BufferedSource): GimbalManagerSetManualControl {
      val flags = source.decodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val pitch = source.decodeFloat()
      val yaw = source.decodeFloat()
      val pitchRate = source.decodeFloat()
      val yawRate = source.decodeFloat()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val gimbalDeviceId = source.decodeUInt8()

      return GimbalManagerSetManualControl(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalManagerSetManualControl =
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

    public fun build(): GimbalManagerSetManualControl = GimbalManagerSetManualControl(
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
