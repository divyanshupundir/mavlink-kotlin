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
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Sets a desired vehicle attitude. Used by an external controller to command the vehicle (manual
 * controller or other system).
 */
@GeneratedMavMessage(
  id = 82,
  crc = 49,
)
public data class SetAttitudeTarget(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  public val typeMask: MavEnumValue<AttitudeTargetTypemask> = MavEnumValue.fromValue(0),
  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  public val q: List<Float> = emptyList(),
  /**
   * Body roll rate
   */
  public val bodyRollRate: Float = 0F,
  /**
   * Body pitch rate
   */
  public val bodyPitchRate: Float = 0F,
  /**
   * Body yaw rate
   */
  public val bodyYawRate: Float = 0F,
  /**
   * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)
   */
  public val thrust: Float = 0F,
  /**
   * 3D thrust setpoint in the body NED frame, normalized to -1 .. 1
   */
  public val thrustBody: List<Float> = emptyList(),
) : MavMessage<SetAttitudeTarget> {
  public override val instanceMetadata: MavMessage.Metadata<SetAttitudeTarget> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(bodyRollRate)
    outputBuffer.encodeFloat(bodyPitchRate)
    outputBuffer.encodeFloat(bodyYawRate)
    outputBuffer.encodeFloat(thrust)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(typeMask.value, 1)
    outputBuffer.encodeFloatArray(thrustBody, 12)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 82

    private const val CRC: Int = 49

    private const val SIZE: Int = 51

    private val DESERIALIZER: MavDeserializer<SetAttitudeTarget> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val q = inputBuffer.decodeFloatArray(16)
      val bodyRollRate = inputBuffer.decodeFloat()
      val bodyPitchRate = inputBuffer.decodeFloat()
      val bodyYawRate = inputBuffer.decodeFloat()
      val thrust = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val typeMask = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = AttitudeTargetTypemask.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val thrustBody = inputBuffer.decodeFloatArray(12)

      SetAttitudeTarget(
        timeBootMs = timeBootMs,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        typeMask = typeMask,
        q = q,
        bodyRollRate = bodyRollRate,
        bodyPitchRate = bodyPitchRate,
        bodyYawRate = bodyYawRate,
        thrust = thrust,
        thrustBody = thrustBody,
      )
    }


    private val METADATA: MavMessage.Metadata<SetAttitudeTarget> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetAttitudeTarget> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var typeMask: MavEnumValue<AttitudeTargetTypemask> = MavEnumValue.fromValue(0)

    public var q: List<Float> = emptyList()

    public var bodyRollRate: Float = 0F

    public var bodyPitchRate: Float = 0F

    public var bodyYawRate: Float = 0F

    public var thrust: Float = 0F

    public var thrustBody: List<Float> = emptyList()

    public fun build(): SetAttitudeTarget = SetAttitudeTarget(
      timeBootMs = timeBootMs,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      typeMask = typeMask,
      q = q,
      bodyRollRate = bodyRollRate,
      bodyPitchRate = bodyPitchRate,
      bodyYawRate = bodyYawRate,
      thrust = thrust,
      thrustBody = thrustBody,
    )
  }
}
