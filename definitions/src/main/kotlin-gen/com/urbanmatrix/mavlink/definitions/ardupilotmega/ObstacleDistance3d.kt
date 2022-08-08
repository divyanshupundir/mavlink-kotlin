package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.api.WorkInProgress
import com.urbanmatrix.mavlink.definitions.common.MavDistanceSensor
import com.urbanmatrix.mavlink.definitions.common.MavFrame
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Obstacle located as a 3D vector.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 11037,
  crc = 130,
)
public data class ObstacleDistance3d(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Class id of the distance sensor type.
   */
  public val sensorType: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0),
  /**
   * Coordinate frame of reference.
   */
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   *  Unique ID given to each obstacle so that its movement can be tracked. Use UINT16_MAX if object
   * ID is unknown or cannot be determined.
   */
  public val obstacleId: Int = 0,
  /**
   *  X position of the obstacle.
   */
  public val x: Float = 0F,
  /**
   *  Y position of the obstacle.
   */
  public val y: Float = 0F,
  /**
   *  Z position of the obstacle.
   */
  public val z: Float = 0F,
  /**
   * Minimum distance the sensor can measure.
   */
  public val minDistance: Float = 0F,
  /**
   * Maximum distance the sensor can measure.
   */
  public val maxDistance: Float = 0F,
) : MavMessage<ObstacleDistance3d> {
  public override val instanceMetadata: MavMessage.Metadata<ObstacleDistance3d> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(minDistance)
    outputBuffer.encodeFloat(maxDistance)
    outputBuffer.encodeUint16(obstacleId)
    outputBuffer.encodeEnumValue(sensorType.value, 1)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11037

    private const val CRC: Int = 130

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<ObstacleDistance3d> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val minDistance = inputBuffer.decodeFloat()
      val maxDistance = inputBuffer.decodeFloat()
      val obstacleId = inputBuffer.decodeUint16()
      val sensorType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      ObstacleDistance3d(
        timeBootMs = timeBootMs,
        sensorType = sensorType,
        frame = frame,
        obstacleId = obstacleId,
        x = x,
        y = y,
        z = z,
        minDistance = minDistance,
        maxDistance = maxDistance,
      )
    }


    private val METADATA: MavMessage.Metadata<ObstacleDistance3d> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ObstacleDistance3d> = METADATA
  }
}
