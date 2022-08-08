package com.urbanmatrix.mavlink.definitions.avssuas

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 *  Drone IMU data. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0
 * 0).
 */
@GeneratedMavMessage(
  id = 60052,
  crc = 101,
)
public data class AvssDroneImu(
  /**
   * Timestamp (time since FC boot).
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
   * X acceleration
   */
  public val xacc: Float = 0F,
  /**
   * Y acceleration
   */
  public val yacc: Float = 0F,
  /**
   * Z acceleration
   */
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis
   */
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis
   */
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis
   */
  public val zgyro: Float = 0F,
) : MavMessage<AvssDroneImu> {
  public override val instanceMetadata: MavMessage.Metadata<AvssDroneImu> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(q1)
    outputBuffer.encodeFloat(q2)
    outputBuffer.encodeFloat(q3)
    outputBuffer.encodeFloat(q4)
    outputBuffer.encodeFloat(xacc)
    outputBuffer.encodeFloat(yacc)
    outputBuffer.encodeFloat(zacc)
    outputBuffer.encodeFloat(xgyro)
    outputBuffer.encodeFloat(ygyro)
    outputBuffer.encodeFloat(zgyro)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 60052

    private const val CRC: Int = 101

    private const val SIZE: Int = 44

    private val DESERIALIZER: MavDeserializer<AvssDroneImu> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val q1 = inputBuffer.decodeFloat()
      val q2 = inputBuffer.decodeFloat()
      val q3 = inputBuffer.decodeFloat()
      val q4 = inputBuffer.decodeFloat()
      val xacc = inputBuffer.decodeFloat()
      val yacc = inputBuffer.decodeFloat()
      val zacc = inputBuffer.decodeFloat()
      val xgyro = inputBuffer.decodeFloat()
      val ygyro = inputBuffer.decodeFloat()
      val zgyro = inputBuffer.decodeFloat()

      AvssDroneImu(
        timeBootMs = timeBootMs,
        q1 = q1,
        q2 = q2,
        q3 = q3,
        q4 = q4,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
      )
    }


    private val METADATA: MavMessage.Metadata<AvssDroneImu> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AvssDroneImu> = METADATA
  }
}
