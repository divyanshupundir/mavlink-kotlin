package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Low level message to control a gimbal device's attitude. This message is to be sent from the
 * gimbal manager to the gimbal device component. Angles and rates can be set to NaN according to use
 * case.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 284,
  crc = 99,
)
public data class GimbalDeviceSetAttitude(
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
   * Low level gimbal flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0),
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on
   * whether the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, set all fields to NaN if only angular
   * velocity should be used)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity, positive is rolling to the right, NaN to be ignored.
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity, positive is pitching up, NaN to be ignored.
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity, positive is yawing to the right, NaN to be ignored.
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityZ: Float = 0F,
) : MavMessage<GimbalDeviceSetAttitude> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalDeviceSetAttitude> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(angularVelocityX)
    outputBuffer.encodeFloat(angularVelocityY)
    outputBuffer.encodeFloat(angularVelocityZ)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(angularVelocityX)
    outputBuffer.encodeFloat(angularVelocityY)
    outputBuffer.encodeFloat(angularVelocityZ)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 284

    private const val CRC: Int = 99

    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    private val DESERIALIZER: MavDeserializer<GimbalDeviceSetAttitude> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val q = inputBuffer.decodeFloatArray(16)
      val angularVelocityX = inputBuffer.decodeFloat()
      val angularVelocityY = inputBuffer.decodeFloat()
      val angularVelocityZ = inputBuffer.decodeFloat()
      val flags = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      GimbalDeviceSetAttitude(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        flags = flags,
        q = q,
        angularVelocityX = angularVelocityX,
        angularVelocityY = angularVelocityY,
        angularVelocityZ = angularVelocityZ,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalDeviceSetAttitude> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalDeviceSetAttitude> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GimbalDeviceSetAttitude =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0)

    public var q: List<Float> = emptyList()

    public var angularVelocityX: Float = 0F

    public var angularVelocityY: Float = 0F

    public var angularVelocityZ: Float = 0F

    public fun build(): GimbalDeviceSetAttitude = GimbalDeviceSetAttitude(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      flags = flags,
      q = q,
      angularVelocityX = angularVelocityX,
      angularVelocityY = angularVelocityY,
      angularVelocityZ = angularVelocityZ,
    )
  }
}
