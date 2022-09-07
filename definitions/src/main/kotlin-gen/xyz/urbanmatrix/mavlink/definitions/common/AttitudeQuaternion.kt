package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint32

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as
 * quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).
 */
@GeneratedMavMessage(
  id = 31,
  crc = 246,
)
public data class AttitudeQuaternion(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Quaternion component 1, w (1 in null-rotation)
   */
  public val q1: Float = 0F,
  /**
   * Quaternion component 2, x (0 in null-rotation)
   */
  public val q2: Float = 0F,
  /**
   * Quaternion component 3, y (0 in null-rotation)
   */
  public val q3: Float = 0F,
  /**
   * Quaternion component 4, z (0 in null-rotation)
   */
  public val q4: Float = 0F,
  /**
   * Roll angular speed
   */
  public val rollspeed: Float = 0F,
  /**
   * Pitch angular speed
   */
  public val pitchspeed: Float = 0F,
  /**
   * Yaw angular speed
   */
  public val yawspeed: Float = 0F,
  /**
   * Rotation offset by which the attitude quaternion and angular speed vector should be rotated for
   * user display (quaternion with [w, x, y, z] order, zero-rotation is [1, 0, 0, 0], send [0, 0, 0, 0]
   * if field not supported). This field is intended for systems in which the reference attitude may
   * change during flight. For example, tailsitters VTOLs rotate their reference attitude by 90 degrees
   * between hover mode and fixed wing mode, thus repr_offset_q is equal to [1, 0, 0, 0] in hover mode
   * and equal to [0.7071, 0, 0.7071, 0] in fixed wing mode.
   */
  public val reprOffsetQ: List<Float> = emptyList(),
) : MavMessage<AttitudeQuaternion> {
  public override val instanceMetadata: MavMessage.Metadata<AttitudeQuaternion> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(q1)
    outputBuffer.encodeFloat(q2)
    outputBuffer.encodeFloat(q3)
    outputBuffer.encodeFloat(q4)
    outputBuffer.encodeFloat(rollspeed)
    outputBuffer.encodeFloat(pitchspeed)
    outputBuffer.encodeFloat(yawspeed)
    outputBuffer.encodeFloatArray(reprOffsetQ, 16)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 31

    private const val CRC: Int = 246

    private const val SIZE: Int = 48

    private val DESERIALIZER: MavDeserializer<AttitudeQuaternion> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val q1 = inputBuffer.decodeFloat()
      val q2 = inputBuffer.decodeFloat()
      val q3 = inputBuffer.decodeFloat()
      val q4 = inputBuffer.decodeFloat()
      val rollspeed = inputBuffer.decodeFloat()
      val pitchspeed = inputBuffer.decodeFloat()
      val yawspeed = inputBuffer.decodeFloat()
      val reprOffsetQ = inputBuffer.decodeFloatArray(16)

      AttitudeQuaternion(
        timeBootMs = timeBootMs,
        q1 = q1,
        q2 = q2,
        q3 = q3,
        q4 = q4,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        reprOffsetQ = reprOffsetQ,
      )
    }


    private val METADATA: MavMessage.Metadata<AttitudeQuaternion> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AttitudeQuaternion> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var q1: Float = 0F

    public var q2: Float = 0F

    public var q3: Float = 0F

    public var q4: Float = 0F

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var reprOffsetQ: List<Float> = emptyList()

    public fun build(): AttitudeQuaternion = AttitudeQuaternion(
      timeBootMs = timeBootMs,
      q1 = q1,
      q2 = q2,
      q3 = q3,
      q4 = q4,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
      reprOffsetQ = reprOffsetQ,
    )
  }
}
