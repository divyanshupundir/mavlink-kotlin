package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Information about a low level gimbal. This message should be requested by the gimbal manager or a
 * ground station using MAV_CMD_REQUEST_MESSAGE. The maximum angles and rates are the limits by
 * hardware. However, the limits by software used are likely different/smaller and dependent on
 * mode/settings/etc..
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param vendorName Name of the gimbal vendor.
 * @param modelName Name of the gimbal model.
 * @param customName Custom name of the gimbal given to it by the user.
 * @param firmwareVersion Version of the gimbal firmware, encoded as: (Dev & 0xff) << 24 | (Patch &
 * 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff).
 * @param hardwareVersion Version of the gimbal hardware, encoded as: (Dev & 0xff) << 24 | (Patch &
 * 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff).
 * @param uid UID of gimbal hardware (0 if unknown).
 * @param capFlags Bitmap of gimbal capability flags.
 * @param customCapFlags Bitmap for use for gimbal-specific capability flags.
 * @param rollMin Minimum hardware roll angle (positive: rolling to the right, negative: rolling to
 * the left). NAN if unknown.
 * units = rad
 * @param rollMax Maximum hardware roll angle (positive: rolling to the right, negative: rolling to
 * the left). NAN if unknown.
 * units = rad
 * @param pitchMin Minimum hardware pitch angle (positive: up, negative: down). NAN if unknown.
 * units = rad
 * @param pitchMax Maximum hardware pitch angle (positive: up, negative: down). NAN if unknown.
 * units = rad
 * @param yawMin Minimum hardware yaw angle (positive: to the right, negative: to the left). NAN if
 * unknown.
 * units = rad
 * @param yawMax Maximum hardware yaw angle (positive: to the right, negative: to the left). NAN if
 * unknown.
 * units = rad
 * @param gimbalDeviceId This field is to be used if the gimbal manager and the gimbal device are
 * the same component and hence have the same component ID. This field is then set to a number between
 * 1-6. If the component ID is separate, this field is not required and must be set to 0.
 */
@GeneratedMavMessage(
  id = 283u,
  crcExtra = 74,
)
public data class GimbalDeviceInformation(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Name of the gimbal vendor.
   */
  @GeneratedMavField(type = "char[32]")
  public val vendorName: String = "",
  /**
   * Name of the gimbal model.
   */
  @GeneratedMavField(type = "char[32]")
  public val modelName: String = "",
  /**
   * Custom name of the gimbal given to it by the user.
   */
  @GeneratedMavField(type = "char[32]")
  public val customName: String = "",
  /**
   * Version of the gimbal firmware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor
   * & 0xff) << 8 | (Major & 0xff).
   */
  @GeneratedMavField(type = "uint32_t")
  public val firmwareVersion: UInt = 0u,
  /**
   * Version of the gimbal hardware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor
   * & 0xff) << 8 | (Major & 0xff).
   */
  @GeneratedMavField(type = "uint32_t")
  public val hardwareVersion: UInt = 0u,
  /**
   * UID of gimbal hardware (0 if unknown).
   */
  @GeneratedMavField(type = "uint64_t")
  public val uid: ULong = 0uL,
  /**
   * Bitmap of gimbal capability flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val capFlags: MavBitmaskValue<GimbalDeviceCapFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Bitmap for use for gimbal-specific capability flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val customCapFlags: UShort = 0u,
  /**
   * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left).
   * NAN if unknown.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val rollMin: Float = 0F,
  /**
   * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left).
   * NAN if unknown.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val rollMax: Float = 0F,
  /**
   * Minimum hardware pitch angle (positive: up, negative: down). NAN if unknown.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val pitchMin: Float = 0F,
  /**
   * Maximum hardware pitch angle (positive: up, negative: down). NAN if unknown.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val pitchMax: Float = 0F,
  /**
   * Minimum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yawMin: Float = 0F,
  /**
   * Maximum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yawMax: Float = 0F,
  /**
   * This field is to be used if the gimbal manager and the gimbal device are the same component and
   * hence have the same component ID. This field is then set to a number between 1-6. If the component
   * ID is separate, this field is not required and must be set to 0.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val gimbalDeviceId: UByte = 0u,
) : MavMessage<GimbalDeviceInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<GimbalDeviceInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(uid)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(firmwareVersion)
    encoder.encodeUInt32(hardwareVersion)
    encoder.encodeFloat(rollMin)
    encoder.encodeFloat(rollMax)
    encoder.encodeFloat(pitchMin)
    encoder.encodeFloat(pitchMax)
    encoder.encodeFloat(yawMin)
    encoder.encodeFloat(yawMax)
    encoder.encodeBitmaskValue(capFlags.value, 2)
    encoder.encodeUInt16(customCapFlags)
    encoder.encodeString(vendorName, 32)
    encoder.encodeString(modelName, 32)
    encoder.encodeString(customName, 32)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(uid)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(firmwareVersion)
    encoder.encodeUInt32(hardwareVersion)
    encoder.encodeFloat(rollMin)
    encoder.encodeFloat(rollMax)
    encoder.encodeFloat(pitchMin)
    encoder.encodeFloat(pitchMax)
    encoder.encodeFloat(yawMin)
    encoder.encodeFloat(yawMax)
    encoder.encodeBitmaskValue(capFlags.value, 2)
    encoder.encodeUInt16(customCapFlags)
    encoder.encodeString(vendorName, 32)
    encoder.encodeString(modelName, 32)
    encoder.encodeString(customName, 32)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalDeviceInformation> {
    private const val SIZE_V1: Int = 144

    private const val SIZE_V2: Int = 145

    override val id: UInt = 283u

    override val crcExtra: Byte = 74

    override fun deserialize(bytes: ByteArray): GimbalDeviceInformation {
      val decoder = MavDataDecoder(bytes)

      val uid = decoder.safeDecodeUInt64()
      val timeBootMs = decoder.safeDecodeUInt32()
      val firmwareVersion = decoder.safeDecodeUInt32()
      val hardwareVersion = decoder.safeDecodeUInt32()
      val rollMin = decoder.safeDecodeFloat()
      val rollMax = decoder.safeDecodeFloat()
      val pitchMin = decoder.safeDecodeFloat()
      val pitchMax = decoder.safeDecodeFloat()
      val yawMin = decoder.safeDecodeFloat()
      val yawMax = decoder.safeDecodeFloat()
      val capFlags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val customCapFlags = decoder.safeDecodeUInt16()
      val vendorName = decoder.safeDecodeString(32)
      val modelName = decoder.safeDecodeString(32)
      val customName = decoder.safeDecodeString(32)
      val gimbalDeviceId = decoder.safeDecodeUInt8()

      return GimbalDeviceInformation(
        timeBootMs = timeBootMs,
        vendorName = vendorName,
        modelName = modelName,
        customName = customName,
        firmwareVersion = firmwareVersion,
        hardwareVersion = hardwareVersion,
        uid = uid,
        capFlags = capFlags,
        customCapFlags = customCapFlags,
        rollMin = rollMin,
        rollMax = rollMax,
        pitchMin = pitchMin,
        pitchMax = pitchMax,
        yawMin = yawMin,
        yawMax = yawMax,
        gimbalDeviceId = gimbalDeviceId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalDeviceInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var vendorName: String = ""

    public var modelName: String = ""

    public var customName: String = ""

    public var firmwareVersion: UInt = 0u

    public var hardwareVersion: UInt = 0u

    public var uid: ULong = 0uL

    public var capFlags: MavBitmaskValue<GimbalDeviceCapFlags> = MavBitmaskValue.fromValue(0u)

    public var customCapFlags: UShort = 0u

    public var rollMin: Float = 0F

    public var rollMax: Float = 0F

    public var pitchMin: Float = 0F

    public var pitchMax: Float = 0F

    public var yawMin: Float = 0F

    public var yawMax: Float = 0F

    public var gimbalDeviceId: UByte = 0u

    public fun build(): GimbalDeviceInformation = GimbalDeviceInformation(
      timeBootMs = timeBootMs,
      vendorName = vendorName,
      modelName = modelName,
      customName = customName,
      firmwareVersion = firmwareVersion,
      hardwareVersion = hardwareVersion,
      uid = uid,
      capFlags = capFlags,
      customCapFlags = customCapFlags,
      rollMin = rollMin,
      rollMax = rollMax,
      pitchMin = pitchMin,
      pitchMax = pitchMax,
      yawMin = yawMin,
      yawMax = yawMax,
      gimbalDeviceId = gimbalDeviceId,
    )
  }
}
