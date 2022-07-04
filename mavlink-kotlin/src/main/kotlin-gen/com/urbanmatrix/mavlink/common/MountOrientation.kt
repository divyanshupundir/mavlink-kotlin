package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Orientation of a mount
 */
@Deprecated(message =
    "This message is being superseded by MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW. The message can still be used to communicate with legacy gimbals implementing it.")
public data class MountOrientation(
  /**
   * Yaw in absolute frame relative to Earth's North, north is 0 (set to NaN for invalid).
   */
  public val yawAbsolute: Float = 0F,
  /**
   * Yaw relative to vehicle (set to NaN for invalid).
   */
  public val yaw: Float = 0F,
  /**
   * Pitch in global frame (set to NaN for invalid).
   */
  public val pitch: Float = 0F,
  /**
   * Roll in global frame (set to NaN for invalid).
   */
  public val roll: Float = 0F,
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
) : MavMessage<MountOrientation> {
  public override val instanceMetadata: MavMessage.Metadata<MountOrientation> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(yawAbsolute)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeUint32(timeBootMs)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 265

    private const val CRC: Int = 210

    private const val SIZE: Int = 20

    private val DESERIALIZER: MavDeserializer<MountOrientation> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for MountOrientation: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val yawAbsolute = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val timeBootMs = inputBuffer.decodeUint32()

      MountOrientation(
        yawAbsolute = yawAbsolute,
        yaw = yaw,
        pitch = pitch,
        roll = roll,
        timeBootMs = timeBootMs,
      )
    }


    private val METADATA: MavMessage.Metadata<MountOrientation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MountOrientation> = METADATA
  }
}
