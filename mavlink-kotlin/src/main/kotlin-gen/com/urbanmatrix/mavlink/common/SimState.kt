package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Status of simulation environment, if used
 */
public data class SimState(
  /**
   * True attitude quaternion component 1, w (1 in null-rotation)
   */
  public val q1: Float = 0F,
  /**
   * True attitude quaternion component 2, x (0 in null-rotation)
   */
  public val q2: Float = 0F,
  /**
   * True attitude quaternion component 3, y (0 in null-rotation)
   */
  public val q3: Float = 0F,
  /**
   * True attitude quaternion component 4, z (0 in null-rotation)
   */
  public val q4: Float = 0F,
  /**
   * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs
   */
  public val roll: Float = 0F,
  /**
   * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs
   */
  public val pitch: Float = 0F,
  /**
   * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs
   */
  public val yaw: Float = 0F,
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
  /**
   * Latitude
   */
  public val lat: Float = 0F,
  /**
   * Longitude
   */
  public val lon: Float = 0F,
  /**
   * Altitude
   */
  public val alt: Float = 0F,
  /**
   * Horizontal position standard deviation
   */
  public val stdDevHorz: Float = 0F,
  /**
   * Vertical position standard deviation
   */
  public val stdDevVert: Float = 0F,
  /**
   * True velocity in north direction in earth-fixed NED frame
   */
  public val vn: Float = 0F,
  /**
   * True velocity in east direction in earth-fixed NED frame
   */
  public val ve: Float = 0F,
  /**
   * True velocity in down direction in earth-fixed NED frame
   */
  public val vd: Float = 0F,
) : MavMessage<SimState> {
  public override val instanceMetadata: MavMessage.Metadata<SimState> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(q1)
    outputBuffer.encodeFloat(q2)
    outputBuffer.encodeFloat(q3)
    outputBuffer.encodeFloat(q4)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(xacc)
    outputBuffer.encodeFloat(yacc)
    outputBuffer.encodeFloat(zacc)
    outputBuffer.encodeFloat(xgyro)
    outputBuffer.encodeFloat(ygyro)
    outputBuffer.encodeFloat(zgyro)
    outputBuffer.encodeFloat(lat)
    outputBuffer.encodeFloat(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(stdDevHorz)
    outputBuffer.encodeFloat(stdDevVert)
    outputBuffer.encodeFloat(vn)
    outputBuffer.encodeFloat(ve)
    outputBuffer.encodeFloat(vd)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 108

    private const val CRC: Int = 32

    private const val SIZE: Int = 84

    private val DESERIALIZER: MavDeserializer<SimState> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SimState: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val q1 = inputBuffer.decodeFloat()
      val q2 = inputBuffer.decodeFloat()
      val q3 = inputBuffer.decodeFloat()
      val q4 = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val xacc = inputBuffer.decodeFloat()
      val yacc = inputBuffer.decodeFloat()
      val zacc = inputBuffer.decodeFloat()
      val xgyro = inputBuffer.decodeFloat()
      val ygyro = inputBuffer.decodeFloat()
      val zgyro = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeFloat()
      val lon = inputBuffer.decodeFloat()
      val alt = inputBuffer.decodeFloat()
      val stdDevHorz = inputBuffer.decodeFloat()
      val stdDevVert = inputBuffer.decodeFloat()
      val vn = inputBuffer.decodeFloat()
      val ve = inputBuffer.decodeFloat()
      val vd = inputBuffer.decodeFloat()

      SimState(
        q1 = q1,
        q2 = q2,
        q3 = q3,
        q4 = q4,
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
        lon = lon,
        alt = alt,
        stdDevHorz = stdDevHorz,
        stdDevVert = stdDevVert,
        vn = vn,
        ve = ve,
        vd = vd,
      )
    }


    private val METADATA: MavMessage.Metadata<SimState> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SimState> = METADATA
  }
}
