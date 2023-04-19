package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
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
import kotlin.collections.List

/**
 * Message reporting the status of a gimbal device. This message should be broadcasted by a gimbal
 * device component. The angles encoded in the quaternion are relative to absolute North if the flag
 * GIMBAL_DEVICE_FLAGS_YAW_LOCK is set (roll: positive is rolling to the right, pitch: positive is
 * pitching up, yaw is turn to the right) or relative to the vehicle heading if the flag is not set.
 * This message should be broadcast at a low regular rate (e.g. 10Hz).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 285u,
  crcExtra = -119,
)
public data class GimbalDeviceAttitudeStatus(
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
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Current gimbal flags set.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on
   * whether the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity (NaN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity (NaN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity (NaN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityZ: Float = 0F,
  /**
   * Failure flags (0 for no failure)
   */
  @GeneratedMavField(type = "uint32_t")
  public val failureFlags: MavBitmaskValue<GimbalDeviceErrorFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<GimbalDeviceAttitudeStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalDeviceAttitudeStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(angularVelocityX)
    outputBuffer.encodeFloat(angularVelocityY)
    outputBuffer.encodeFloat(angularVelocityZ)
    outputBuffer.encodeBitmaskValue(failureFlags.value, 4)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(angularVelocityX)
    outputBuffer.encodeFloat(angularVelocityY)
    outputBuffer.encodeFloat(angularVelocityZ)
    outputBuffer.encodeBitmaskValue(failureFlags.value, 4)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 285u

    private const val CRC_EXTRA: Byte = -119

    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    private val DESERIALIZER: MavDeserializer<GimbalDeviceAttitudeStatus> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val q = inputBuffer.decodeFloatArray(16)
      val angularVelocityX = inputBuffer.decodeFloat()
      val angularVelocityY = inputBuffer.decodeFloat()
      val angularVelocityZ = inputBuffer.decodeFloat()
      val failureFlags = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = GimbalDeviceErrorFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val flags = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      GimbalDeviceAttitudeStatus(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        timeBootMs = timeBootMs,
        flags = flags,
        q = q,
        angularVelocityX = angularVelocityX,
        angularVelocityY = angularVelocityY,
        angularVelocityZ = angularVelocityZ,
        failureFlags = failureFlags,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalDeviceAttitudeStatus> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalDeviceAttitudeStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GimbalDeviceAttitudeStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var timeBootMs: UInt = 0u

    public var flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u)

    public var q: List<Float> = emptyList()

    public var angularVelocityX: Float = 0F

    public var angularVelocityY: Float = 0F

    public var angularVelocityZ: Float = 0F

    public var failureFlags: MavBitmaskValue<GimbalDeviceErrorFlags> = MavBitmaskValue.fromValue(0u)

    public fun build(): GimbalDeviceAttitudeStatus = GimbalDeviceAttitudeStatus(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      timeBootMs = timeBootMs,
      flags = flags,
      q = q,
      angularVelocityX = angularVelocityX,
      angularVelocityY = angularVelocityY,
      angularVelocityZ = angularVelocityZ,
      failureFlags = failureFlags,
    )
  }
}
