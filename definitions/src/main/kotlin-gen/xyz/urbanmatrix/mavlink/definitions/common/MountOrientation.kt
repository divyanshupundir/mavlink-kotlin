package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Orientation of a mount
 */
@Deprecated(message =
    "This message is being superseded by MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW. The message can still be used to communicate with legacy gimbals implementing it.")
@GeneratedMavMessage(
  id = 265,
  crc = 26,
)
public data class MountOrientation(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * Roll in global frame (set to NaN for invalid).
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch in global frame (set to NaN for invalid).
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw relative to vehicle (set to NaN for invalid).
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Yaw in absolute frame relative to Earth's North, north is 0 (set to NaN for invalid).
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val yawAbsolute: Float = 0F,
) : MavMessage<MountOrientation> {
  public override val instanceMetadata: MavMessage.Metadata<MountOrientation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(yawAbsolute)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 265

    private const val CRC: Int = 26

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 20

    private val DESERIALIZER: MavDeserializer<MountOrientation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val yawAbsolute = inputBuffer.decodeFloat()

      MountOrientation(
        timeBootMs = timeBootMs,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        yawAbsolute = yawAbsolute,
      )
    }


    private val METADATA: MavMessage.Metadata<MountOrientation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MountOrientation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var yawAbsolute: Float = 0F

    public fun build(): MountOrientation = MountOrientation(
      timeBootMs = timeBootMs,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      yawAbsolute = yawAbsolute,
    )
  }
}
