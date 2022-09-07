package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint32

/**
 * Reports the current commanded vehicle position, velocity, and acceleration as specified by the
 * autopilot. This should match the commands sent in SET_POSITION_TARGET_GLOBAL_INT if the vehicle is
 * being controlled this way.
 */
@GeneratedMavMessage(
  id = 87,
  crc = 150,
)
public data class PositionTargetGlobalInt(
  /**
   * Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow
   * the system to compensate for the transport delay of the setpoint. This allows the system to
   * compensate processing latency.
   */
  public val timeBootMs: Long = 0L,
  /**
   * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6,
   * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11
   */
  public val coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  public val typeMask: MavEnumValue<PositionTargetTypemask> = MavEnumValue.fromValue(0),
  /**
   * X Position in WGS84 frame
   */
  public val latInt: Int = 0,
  /**
   * Y Position in WGS84 frame
   */
  public val lonInt: Int = 0,
  /**
   * Altitude (MSL, AGL or relative to home altitude, depending on frame)
   */
  public val alt: Float = 0F,
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
) : MavMessage<PositionTargetGlobalInt> {
  public override val instanceMetadata: MavMessage.Metadata<PositionTargetGlobalInt> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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
    outputBuffer.encodeEnumValue(typeMask.value, 2)
    outputBuffer.encodeEnumValue(coordinateFrame.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 87

    private const val CRC: Int = 150

    private const val SIZE: Int = 51

    private val DESERIALIZER: MavDeserializer<PositionTargetGlobalInt> = MavDeserializer { bytes ->
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
      val typeMask = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = PositionTargetTypemask.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val coordinateFrame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      PositionTargetGlobalInt(
        timeBootMs = timeBootMs,
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


    private val METADATA: MavMessage.Metadata<PositionTargetGlobalInt> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PositionTargetGlobalInt> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0)

    public var typeMask: MavEnumValue<PositionTargetTypemask> = MavEnumValue.fromValue(0)

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

    public fun build(): PositionTargetGlobalInt = PositionTargetGlobalInt(
      timeBootMs = timeBootMs,
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
