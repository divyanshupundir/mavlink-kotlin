package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
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

/**
 * Sets a desired vehicle position in a local north-east-down coordinate frame. Used by an external
 * controller to command the vehicle (manual controller or other system).
 */
@GeneratedMavMessage(
  id = 84u,
  crcExtra = -113,
)
public data class SetPositionTargetLocalNed(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
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
   * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, MAV_FRAME_BODY_NED
   * = 8, MAV_FRAME_BODY_OFFSET_NED = 9
   */
  @GeneratedMavField(type = "uint8_t")
  public val coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  @GeneratedMavField(type = "uint16_t")
  public val typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0u),
  /**
   * X Position in NED frame
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position in NED frame
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position in NED frame (note, altitude is negative in NED)
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * X velocity in NED frame
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y velocity in NED frame
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z velocity in NED frame
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  @GeneratedMavField(type = "float")
  public val afx: Float = 0F,
  /**
   * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  @GeneratedMavField(type = "float")
  public val afy: Float = 0F,
  /**
   * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  @GeneratedMavField(type = "float")
  public val afz: Float = 0F,
  /**
   * yaw setpoint
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * yaw rate setpoint
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<SetPositionTargetLocalNed> {
  public override val instanceCompanion: MavMessage.MavCompanion<SetPositionTargetLocalNed> =
      Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
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
    outputBuffer.encodeBitmaskValue(typeMask.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(coordinateFrame.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
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
    outputBuffer.encodeBitmaskValue(typeMask.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(coordinateFrame.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetPositionTargetLocalNed> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    public override val id: UInt = 84u

    public override val crcExtra: Byte = -113

    public override fun deserialize(bytes: ByteArray): SetPositionTargetLocalNed {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
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
      val typeMask = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = PositionTargetTypemask.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val coordinateFrame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return SetPositionTargetLocalNed(
        timeBootMs = timeBootMs,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        coordinateFrame = coordinateFrame,
        typeMask = typeMask,
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
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetPositionTargetLocalNed =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0u)

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var afx: Float = 0F

    public var afy: Float = 0F

    public var afz: Float = 0F

    public var yaw: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): SetPositionTargetLocalNed = SetPositionTargetLocalNed(
      timeBootMs = timeBootMs,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      coordinateFrame = coordinateFrame,
      typeMask = typeMask,
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
    )
  }
}
