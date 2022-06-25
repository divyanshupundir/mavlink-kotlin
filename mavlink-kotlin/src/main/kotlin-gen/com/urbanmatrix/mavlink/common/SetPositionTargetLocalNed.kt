package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Sets a desired vehicle position in a local north-east-down coordinate frame. Used by an external
 * controller to command the vehicle (manual controller or other system).
 */
public data class SetPositionTargetLocalNed(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * X Position in NED frame
   */
  public val x: Float = 0F,
  /**
   * Y Position in NED frame
   */
  public val y: Float = 0F,
  /**
   * Z Position in NED frame (note, altitude is negative in NED)
   */
  public val z: Float = 0F,
  /**
   * X velocity in NED frame
   */
  public val vx: Float = 0F,
  /**
   * Y velocity in NED frame
   */
  public val vy: Float = 0F,
  /**
   * Z velocity in NED frame
   */
  public val vz: Float = 0F,
  /**
   * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  public val afx: Float = 0F,
  /**
   * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  public val afy: Float = 0F,
  /**
   * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  public val afz: Float = 0F,
  /**
   * yaw setpoint
   */
  public val yaw: Float = 0F,
  /**
   * yaw rate setpoint
   */
  public val yawRate: Float = 0F,
  /**
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  public val typeMask: MavEnumValue<PositionTargetTypemask> = MavEnumValue.fromValue(0),
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, MAV_FRAME_BODY_NED
   * = 8, MAV_FRAME_BODY_OFFSET_NED = 9
   */
  public val coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
) : MavMessage<SetPositionTargetLocalNed> {
  public override val instanceMetadata: MavMessage.Metadata<SetPositionTargetLocalNed> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(53).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(afx)
    outputBuffer.encodeFloat(afy)
    outputBuffer.encodeFloat(afz)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(yawRate)
    outputBuffer.encodeEnumValue(typeMask.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(coordinateFrame.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 84

    private const val CRC: Int = 143

    private val DESERIALIZER: MavDeserializer<SetPositionTargetLocalNed> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val vx = inputBuffer.decodeFloat()
      val vy = inputBuffer.decodeFloat()
      val vz = inputBuffer.decodeFloat()
      val afx = inputBuffer.decodeFloat()
      val afy = inputBuffer.decodeFloat()
      val afz = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val yawRate = inputBuffer.decodeFloat()
      val typeMask = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = PositionTargetTypemask.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val coordinateFrame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      SetPositionTargetLocalNed(
        timeBootMs = timeBootMs,
        x = x,
        y = y,
        z = z,
        vx = vx,
        vy = vy,
        vz = vz,
        afx = afx,
        afy = afy,
        afz = afz,
        yaw = yaw,
        yawRate = yawRate,
        typeMask = typeMask,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        coordinateFrame = coordinateFrame,
      )
    }


    private val METADATA: MavMessage.Metadata<SetPositionTargetLocalNed> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetPositionTargetLocalNed> = METADATA
  }
}
