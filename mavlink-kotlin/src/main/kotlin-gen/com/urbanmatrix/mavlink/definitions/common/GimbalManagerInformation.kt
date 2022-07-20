package com.urbanmatrix.mavlink.definitions.common

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
 * Information about a high level gimbal manager. This message should be requested by a ground
 * station using MAV_CMD_REQUEST_MESSAGE.
 */
public data class GimbalManagerInformation(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Bitmap of gimbal capability flags.
   */
  public val capFlags: MavEnumValue<GimbalManagerCapFlags> = MavEnumValue.fromValue(0),
  /**
   * Gimbal device ID that this gimbal manager is responsible for.
   */
  public val gimbalDeviceId: Int = 0,
  /**
   * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left)
   */
  public val rollMin: Float = 0F,
  /**
   * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left)
   */
  public val rollMax: Float = 0F,
  /**
   * Minimum pitch angle (positive: up, negative: down)
   */
  public val pitchMin: Float = 0F,
  /**
   * Maximum pitch angle (positive: up, negative: down)
   */
  public val pitchMax: Float = 0F,
  /**
   * Minimum yaw angle (positive: to the right, negative: to the left)
   */
  public val yawMin: Float = 0F,
  /**
   * Maximum yaw angle (positive: to the right, negative: to the left)
   */
  public val yawMax: Float = 0F,
) : MavMessage<GimbalManagerInformation> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalManagerInformation> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeEnumValue(capFlags.value, 4)
    outputBuffer.encodeFloat(rollMin)
    outputBuffer.encodeFloat(rollMax)
    outputBuffer.encodeFloat(pitchMin)
    outputBuffer.encodeFloat(pitchMax)
    outputBuffer.encodeFloat(yawMin)
    outputBuffer.encodeFloat(yawMax)
    outputBuffer.encodeUint8(gimbalDeviceId)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 280

    private const val CRC: Int = 70

    private const val SIZE: Int = 33

    private val DESERIALIZER: MavDeserializer<GimbalManagerInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val capFlags = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = GimbalManagerCapFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rollMin = inputBuffer.decodeFloat()
      val rollMax = inputBuffer.decodeFloat()
      val pitchMin = inputBuffer.decodeFloat()
      val pitchMax = inputBuffer.decodeFloat()
      val yawMin = inputBuffer.decodeFloat()
      val yawMax = inputBuffer.decodeFloat()
      val gimbalDeviceId = inputBuffer.decodeUint8()

      GimbalManagerInformation(
        timeBootMs = timeBootMs,
        capFlags = capFlags,
        gimbalDeviceId = gimbalDeviceId,
        rollMin = rollMin,
        rollMax = rollMax,
        pitchMin = pitchMin,
        pitchMax = pitchMax,
        yawMin = yawMin,
        yawMax = yawMax,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalManagerInformation> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalManagerInformation> = METADATA
  }
}
