package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Information about a low level gimbal. This message should be requested by the gimbal manager or a
 * ground station using MAV_CMD_REQUEST_MESSAGE. The maximum angles and rates are the limits by
 * hardware. However, the limits by software used are likely different/smaller and dependent on
 * mode/settings/etc..
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 283u,
  crcExtra = 74,
)
public data class GimbalDeviceInformation(
  /**
   * Timestamp (time since system boot).
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
   * Minimum hardware pitch angle (positive: up, negative: down)
   */
  @GeneratedMavField(type = "float")
  public val pitchMin: Float = 0F,
  /**
   * Maximum hardware pitch angle (positive: up, negative: down)
   */
  @GeneratedMavField(type = "float")
  public val pitchMax: Float = 0F,
  /**
   * Minimum hardware yaw angle (positive: to the right, negative: to the left)
   */
  @GeneratedMavField(type = "float")
  public val yawMin: Float = 0F,
  /**
   * Maximum hardware yaw angle (positive: to the right, negative: to the left)
   */
  @GeneratedMavField(type = "float")
  public val yawMax: Float = 0F,
) : MavMessage<GimbalDeviceInformation> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalDeviceInformation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(uid)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(firmwareVersion)
    outputBuffer.encodeUInt32(hardwareVersion)
    outputBuffer.encodeFloat(rollMin)
    outputBuffer.encodeFloat(rollMax)
    outputBuffer.encodeFloat(pitchMin)
    outputBuffer.encodeFloat(pitchMax)
    outputBuffer.encodeFloat(yawMin)
    outputBuffer.encodeFloat(yawMax)
    outputBuffer.encodeBitmaskValue(capFlags.value, 2)
    outputBuffer.encodeUInt16(customCapFlags)
    outputBuffer.encodeString(vendorName, 32)
    outputBuffer.encodeString(modelName, 32)
    outputBuffer.encodeString(customName, 32)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(uid)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(firmwareVersion)
    outputBuffer.encodeUInt32(hardwareVersion)
    outputBuffer.encodeFloat(rollMin)
    outputBuffer.encodeFloat(rollMax)
    outputBuffer.encodeFloat(pitchMin)
    outputBuffer.encodeFloat(pitchMax)
    outputBuffer.encodeFloat(yawMin)
    outputBuffer.encodeFloat(yawMax)
    outputBuffer.encodeBitmaskValue(capFlags.value, 2)
    outputBuffer.encodeUInt16(customCapFlags)
    outputBuffer.encodeString(vendorName, 32)
    outputBuffer.encodeString(modelName, 32)
    outputBuffer.encodeString(customName, 32)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 283u

    private const val CRC_EXTRA: Byte = 74

    private const val SIZE_V1: Int = 144

    private const val SIZE_V2: Int = 144

    private val DESERIALIZER: MavDeserializer<GimbalDeviceInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val uid = inputBuffer.decodeUInt64()
      val timeBootMs = inputBuffer.decodeUInt32()
      val firmwareVersion = inputBuffer.decodeUInt32()
      val hardwareVersion = inputBuffer.decodeUInt32()
      val rollMin = inputBuffer.decodeFloat()
      val rollMax = inputBuffer.decodeFloat()
      val pitchMin = inputBuffer.decodeFloat()
      val pitchMax = inputBuffer.decodeFloat()
      val yawMin = inputBuffer.decodeFloat()
      val yawMax = inputBuffer.decodeFloat()
      val capFlags = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val customCapFlags = inputBuffer.decodeUInt16()
      val vendorName = inputBuffer.decodeString(32)
      val modelName = inputBuffer.decodeString(32)
      val customName = inputBuffer.decodeString(32)

      GimbalDeviceInformation(
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
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalDeviceInformation> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalDeviceInformation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GimbalDeviceInformation =
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
    )
  }
}
