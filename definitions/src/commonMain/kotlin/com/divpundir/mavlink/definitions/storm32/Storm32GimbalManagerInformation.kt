package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.GimbalDeviceCapFlags
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
 * Information about a gimbal manager. This message should be requested by a ground station using
 * MAV_CMD_REQUEST_MESSAGE. It mirrors some fields of the GIMBAL_DEVICE_INFORMATION message, but not
 * all. If the additional information is desired, also GIMBAL_DEVICE_INFORMATION should be requested.
 *
 */
@GeneratedMavMessage(
  id = 60_010u,
  crcExtra = -48,
)
public data class Storm32GimbalManagerInformation(
  /**
   * Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible
   * for.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalId: UByte = 0u,
  /**
   * Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The flag
   * is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero).
   */
  @GeneratedMavField(type = "uint32_t")
  public val deviceCapFlags: MavBitmaskValue<GimbalDeviceCapFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal manager capability flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val managerCapFlags: MavBitmaskValue<MavStorm32GimbalManagerCapFlags> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Hardware minimum roll angle (positive: roll to the right). NaN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val rollMin: Float = 0F,
  /**
   * Hardware maximum roll angle (positive: roll to the right). NaN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val rollMax: Float = 0F,
  /**
   * Hardware minimum pitch/tilt angle (positive: tilt up). NaN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val pitchMin: Float = 0F,
  /**
   * Hardware maximum pitch/tilt angle (positive: tilt up). NaN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val pitchMax: Float = 0F,
  /**
   * Hardware minimum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal
   * base). NaN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val yawMin: Float = 0F,
  /**
   * Hardware maximum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal
   * base). NaN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val yawMax: Float = 0F,
) : MavMessage<Storm32GimbalManagerInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<Storm32GimbalManagerInformation> =
      Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(deviceCapFlags.value, 4)
    encoder.encodeBitmaskValue(managerCapFlags.value, 4)
    encoder.encodeFloat(rollMin)
    encoder.encodeFloat(rollMax)
    encoder.encodeFloat(pitchMin)
    encoder.encodeFloat(pitchMax)
    encoder.encodeFloat(yawMin)
    encoder.encodeFloat(yawMax)
    encoder.encodeUInt8(gimbalId)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(deviceCapFlags.value, 4)
    encoder.encodeBitmaskValue(managerCapFlags.value, 4)
    encoder.encodeFloat(rollMin)
    encoder.encodeFloat(rollMax)
    encoder.encodeFloat(pitchMin)
    encoder.encodeFloat(pitchMax)
    encoder.encodeFloat(yawMin)
    encoder.encodeFloat(yawMax)
    encoder.encodeUInt8(gimbalId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Storm32GimbalManagerInformation> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    override val id: UInt = 60_010u

    override val crcExtra: Byte = -48

    override fun deserialize(bytes: ByteArray): Storm32GimbalManagerInformation {
      val decoder = MavDataDecoder(bytes)

      val deviceCapFlags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = GimbalDeviceCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val managerCapFlags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavStorm32GimbalManagerCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val rollMin = decoder.safeDecodeFloat()
      val rollMax = decoder.safeDecodeFloat()
      val pitchMin = decoder.safeDecodeFloat()
      val pitchMax = decoder.safeDecodeFloat()
      val yawMin = decoder.safeDecodeFloat()
      val yawMax = decoder.safeDecodeFloat()
      val gimbalId = decoder.safeDecodeUInt8()

      return Storm32GimbalManagerInformation(
        gimbalId = gimbalId,
        deviceCapFlags = deviceCapFlags,
        managerCapFlags = managerCapFlags,
        rollMin = rollMin,
        rollMax = rollMax,
        pitchMin = pitchMin,
        pitchMax = pitchMax,
        yawMin = yawMin,
        yawMax = yawMax,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Storm32GimbalManagerInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var gimbalId: UByte = 0u

    public var deviceCapFlags: MavBitmaskValue<GimbalDeviceCapFlags> = MavBitmaskValue.fromValue(0u)

    public var managerCapFlags: MavBitmaskValue<MavStorm32GimbalManagerCapFlags> =
        MavBitmaskValue.fromValue(0u)

    public var rollMin: Float = 0F

    public var rollMax: Float = 0F

    public var pitchMin: Float = 0F

    public var pitchMax: Float = 0F

    public var yawMin: Float = 0F

    public var yawMax: Float = 0F

    public fun build(): Storm32GimbalManagerInformation = Storm32GimbalManagerInformation(
      gimbalId = gimbalId,
      deviceCapFlags = deviceCapFlags,
      managerCapFlags = managerCapFlags,
      rollMin = rollMin,
      rollMax = rollMax,
      pitchMin = pitchMin,
      pitchMax = pitchMax,
      yawMin = yawMin,
      yawMax = yawMax,
    )
  }
}
