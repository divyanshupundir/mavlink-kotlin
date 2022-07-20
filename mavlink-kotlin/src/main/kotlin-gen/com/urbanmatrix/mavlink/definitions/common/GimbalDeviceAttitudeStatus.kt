package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * Message reporting the status of a gimbal device. This message should be broadcasted by a gimbal
 * device component. The angles encoded in the quaternion are relative to absolute North if the flag
 * GIMBAL_DEVICE_FLAGS_YAW_LOCK is set (roll: positive is rolling to the right, pitch: positive is
 * pitching up, yaw is turn to the right) or relative to the vehicle heading if the flag is not set.
 * This message should be broadcast at a low regular rate (e.g. 10Hz).
 */
public data class GimbalDeviceAttitudeStatus(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Current gimbal flags set.
   */
  public val flags: MavEnumValue<GimbalDeviceFlags> = MavEnumValue.fromValue(0),
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on
   * whether the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set)
   */
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity (NaN if unknown)
   */
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity (NaN if unknown)
   */
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity (NaN if unknown)
   */
  public val angularVelocityZ: Float = 0F,
  /**
   * Failure flags (0 for no failure)
   */
  public val failureFlags: MavEnumValue<GimbalDeviceErrorFlags> = MavEnumValue.fromValue(0),
) : MavMessage<GimbalDeviceAttitudeStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalDeviceAttitudeStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(angularVelocityX)
    outputBuffer.encodeFloat(angularVelocityY)
    outputBuffer.encodeFloat(angularVelocityZ)
    outputBuffer.encodeEnumValue(failureFlags.value, 4)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 285

    private const val CRC: Int = 137

    private const val SIZE: Int = 40

    private val DESERIALIZER: MavDeserializer<GimbalDeviceAttitudeStatus> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val q = inputBuffer.decodeFloatArray(16)
      val angularVelocityX = inputBuffer.decodeFloat()
      val angularVelocityY = inputBuffer.decodeFloat()
      val angularVelocityZ = inputBuffer.decodeFloat()
      val failureFlags = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = GimbalDeviceErrorFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = GimbalDeviceFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

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
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalDeviceAttitudeStatus> = METADATA
  }
}
