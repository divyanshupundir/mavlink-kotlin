package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Sets a desired vehicle position, velocity, and/or acceleration in a global coordinate system
 * (WGS84). Used by an external controller to command the vehicle (manual controller or other system).
 */
@GeneratedMavMessage(
  id = 86,
  crc = 5,
)
public data class SetPositionTargetGlobalInt(
  /**
   * Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow
   * the system to compensate for the transport delay of the setpoint. This allows the system to
   * compensate processing latency.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6,
   * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11
   */
  @GeneratedMavField(type = "uint8_t")
  public val coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  @GeneratedMavField(type = "uint16_t")
  public val typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0),
  /**
   * X Position in WGS84 frame
   */
  @GeneratedMavField(type = "int32_t")
  public val latInt: Int = 0,
  /**
   * Y Position in WGS84 frame
   */
  @GeneratedMavField(type = "int32_t")
  public val lonInt: Int = 0,
  /**
   * Altitude (MSL, Relative to home, or AGL - depending on frame)
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
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
) : MavMessage<SetPositionTargetGlobalInt> {
  public override val instanceMetadata: MavMessage.Metadata<SetPositionTargetGlobalInt> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(latInt)
    outputBuffer.encodeInt32(lonInt)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(afx)
    outputBuffer.encodeFloat(afy)
    outputBuffer.encodeFloat(afz)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(yawRate)
    outputBuffer.encodeBitmaskValue(typeMask.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(coordinateFrame.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(latInt)
    outputBuffer.encodeInt32(lonInt)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(afx)
    outputBuffer.encodeFloat(afy)
    outputBuffer.encodeFloat(afz)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(yawRate)
    outputBuffer.encodeBitmaskValue(typeMask.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(coordinateFrame.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 86

    private const val CRC: Int = 5

    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    private val DESERIALIZER: MavDeserializer<SetPositionTargetGlobalInt> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val latInt = inputBuffer.decodeInt32()
      val lonInt = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
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
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val coordinateFrame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      SetPositionTargetGlobalInt(
        timeBootMs = timeBootMs,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        coordinateFrame = coordinateFrame,
        typeMask = typeMask,
        latInt = latInt,
        lonInt = lonInt,
        alt = alt,
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


    private val METADATA: MavMessage.Metadata<SetPositionTargetGlobalInt> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetPositionTargetGlobalInt> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SetPositionTargetGlobalInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0)

    public var typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0)

    public var latInt: Int = 0

    public var lonInt: Int = 0

    public var alt: Float = 0F

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var afx: Float = 0F

    public var afy: Float = 0F

    public var afz: Float = 0F

    public var yaw: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): SetPositionTargetGlobalInt = SetPositionTargetGlobalInt(
      timeBootMs = timeBootMs,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      coordinateFrame = coordinateFrame,
      typeMask = typeMask,
      latInt = latInt,
      lonInt = lonInt,
      alt = alt,
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
