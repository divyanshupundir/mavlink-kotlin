package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Status of simulation environment, if used.
 */
@GeneratedMavMessage(
  id = 164,
  crc = 154,
)
public data class Simstate(
  /**
   * Roll angle.
   */
  public val roll: Float = 0F,
  /**
   * Pitch angle.
   */
  public val pitch: Float = 0F,
  /**
   * Yaw angle.
   */
  public val yaw: Float = 0F,
  /**
   * X acceleration.
   */
  public val xacc: Float = 0F,
  /**
   * Y acceleration.
   */
  public val yacc: Float = 0F,
  /**
   * Z acceleration.
   */
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis.
   */
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis.
   */
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis.
   */
  public val zgyro: Float = 0F,
  /**
   * Latitude.
   */
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  public val lng: Int = 0,
) : MavMessage<Simstate> {
  public override val instanceMetadata: MavMessage.Metadata<Simstate> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(xacc)
    outputBuffer.encodeFloat(yacc)
    outputBuffer.encodeFloat(zacc)
    outputBuffer.encodeFloat(xgyro)
    outputBuffer.encodeFloat(ygyro)
    outputBuffer.encodeFloat(zgyro)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 164

    private const val CRC: Int = 154

    private const val SIZE: Int = 44

    private val DESERIALIZER: MavDeserializer<Simstate> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val xacc = inputBuffer.decodeFloat()
      val yacc = inputBuffer.decodeFloat()
      val zacc = inputBuffer.decodeFloat()
      val xgyro = inputBuffer.decodeFloat()
      val ygyro = inputBuffer.decodeFloat()
      val zgyro = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()

      Simstate(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        lat = lat,
        lng = lng,
      )
    }


    private val METADATA: MavMessage.Metadata<Simstate> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Simstate> = METADATA
  }
}
