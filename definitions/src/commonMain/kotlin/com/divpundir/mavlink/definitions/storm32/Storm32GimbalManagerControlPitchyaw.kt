package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.GimbalDeviceFlags
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
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
 * Message to a gimbal manager to control the gimbal tilt and pan angles. Angles and rates can be
 * set to NaN according to use case. A gimbal device is never to react to this message.
 */
@GeneratedMavMessage(
  id = 60_013u,
  crcExtra = -127,
)
public data class Storm32GimbalManagerControlPitchyaw(
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
   * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for
   * all gimbals). Send command multiple times for more than one but not all gimbals.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalId: UByte = 0u,
  /**
   * Client which is contacting the gimbal manager (must be set).
   */
  @GeneratedMavField(type = "uint8_t")
  public val client: MavEnumValue<MavStorm32GimbalManagerClient> = MavEnumValue.fromValue(0u),
  /**
   * Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in
   * GIMBAL_DEVICE_SET_ATTITUDE.
   */
  @GeneratedMavField(type = "uint16_t")
  public val deviceFlags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal manager flags to be applied (0 to be ignored).
   */
  @GeneratedMavField(type = "uint16_t")
  public val managerFlags: MavBitmaskValue<MavStorm32GimbalManagerFlags> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Pitch/tilt angle (positive: tilt up). NaN to be ignored.
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw/pan angle (positive: pan the right). NaN to be ignored. The frame is determined by the
   * GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags.
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Pitch/tilt angular rate (positive: tilt up). NaN to be ignored.
   */
  @GeneratedMavField(type = "float")
  public val pitchRate: Float = 0F,
  /**
   * Yaw/pan angular rate (positive: pan to the right). NaN to be ignored. The frame is determined
   * by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags.
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<Storm32GimbalManagerControlPitchyaw> {
  public override val instanceCompanion:
      MavMessage.MavCompanion<Storm32GimbalManagerControlPitchyaw> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(pitchRate)
    encoder.encodeFloat(yawRate)
    encoder.encodeBitmaskValue(deviceFlags.value, 2)
    encoder.encodeBitmaskValue(managerFlags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalId)
    encoder.encodeEnumValue(client.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(pitchRate)
    encoder.encodeFloat(yawRate)
    encoder.encodeBitmaskValue(deviceFlags.value, 2)
    encoder.encodeBitmaskValue(managerFlags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalId)
    encoder.encodeEnumValue(client.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Storm32GimbalManagerControlPitchyaw> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    public override val id: UInt = 60_013u

    public override val crcExtra: Byte = -127

    public override fun deserialize(bytes: ByteArray): Storm32GimbalManagerControlPitchyaw {
      val decoder = MavDataDecoder(bytes)

      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val pitchRate = decoder.safeDecodeFloat()
      val yawRate = decoder.safeDecodeFloat()
      val deviceFlags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val managerFlags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = MavStorm32GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val gimbalId = decoder.safeDecodeUInt8()
      val client = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavStorm32GimbalManagerClient.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return Storm32GimbalManagerControlPitchyaw(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        gimbalId = gimbalId,
        client = client,
        deviceFlags = deviceFlags,
        managerFlags = managerFlags,
        pitch = pitch,
        yaw = yaw,
        pitchRate = pitchRate,
        yawRate = yawRate,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit):
        Storm32GimbalManagerControlPitchyaw = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var gimbalId: UByte = 0u

    public var client: MavEnumValue<MavStorm32GimbalManagerClient> = MavEnumValue.fromValue(0u)

    public var deviceFlags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u)

    public var managerFlags: MavBitmaskValue<MavStorm32GimbalManagerFlags> =
        MavBitmaskValue.fromValue(0u)

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var pitchRate: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): Storm32GimbalManagerControlPitchyaw = Storm32GimbalManagerControlPitchyaw(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      gimbalId = gimbalId,
      client = client,
      deviceFlags = deviceFlags,
      managerFlags = managerFlags,
      pitch = pitch,
      yaw = yaw,
      pitchRate = pitchRate,
      yawRate = yawRate,
    )
  }
}
