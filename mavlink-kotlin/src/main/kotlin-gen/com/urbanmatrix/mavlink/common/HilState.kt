package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int

/**
 * Sent from simulation to autopilot. This packet is useful for high throughput applications such as
 * hardware in the loop simulations.
 */
@Deprecated(message = "Suffers from missing airspeed fields and singularities due to Euler angles")
public data class HilState(
  /**
   * Z acceleration
   */
  public val zacc: Int = 0,
  /**
   * Y acceleration
   */
  public val yacc: Int = 0,
  /**
   * X acceleration
   */
  public val xacc: Int = 0,
  /**
   * Ground Z Speed (Altitude)
   */
  public val vz: Int = 0,
  /**
   * Ground Y Speed (Longitude)
   */
  public val vy: Int = 0,
  /**
   * Ground X Speed (Latitude)
   */
  public val vx: Int = 0,
  /**
   * Altitude
   */
  public val alt: Int = 0,
  /**
   * Longitude
   */
  public val lon: Int = 0,
  /**
   * Latitude
   */
  public val lat: Int = 0,
  /**
   * Body frame yaw / psi angular speed
   */
  public val yawspeed: Float = 0F,
  /**
   * Body frame pitch / theta angular speed
   */
  public val pitchspeed: Float = 0F,
  /**
   * Body frame roll / phi angular speed
   */
  public val rollspeed: Float = 0F,
  /**
   * Yaw angle
   */
  public val yaw: Float = 0F,
  /**
   * Pitch angle
   */
  public val pitch: Float = 0F,
  /**
   * Roll angle
   */
  public val roll: Float = 0F,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
) : MavMessage<HilState> {
  public override val instanceMetadata: MavMessage.Metadata<HilState> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(56).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(zacc)
    outputBuffer.encodeInt16(yacc)
    outputBuffer.encodeInt16(xacc)
    outputBuffer.encodeInt16(vz)
    outputBuffer.encodeInt16(vy)
    outputBuffer.encodeInt16(vx)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeFloat(yawspeed)
    outputBuffer.encodeFloat(pitchspeed)
    outputBuffer.encodeFloat(rollspeed)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeUint64(timeUsec)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 90

    private const val CRC: Int = 216

    private val DESERIALIZER: MavDeserializer<HilState> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val zacc = inputBuffer.decodeInt16()
      val yacc = inputBuffer.decodeInt16()
      val xacc = inputBuffer.decodeInt16()
      val vz = inputBuffer.decodeInt16()
      val vy = inputBuffer.decodeInt16()
      val vx = inputBuffer.decodeInt16()
      val alt = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val lat = inputBuffer.decodeInt32()
      val yawspeed = inputBuffer.decodeFloat()
      val pitchspeed = inputBuffer.decodeFloat()
      val rollspeed = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val timeUsec = inputBuffer.decodeUint64()
      HilState(
        zacc = zacc,
        yacc = yacc,
        xacc = xacc,
        vz = vz,
        vy = vy,
        vx = vx,
        alt = alt,
        lon = lon,
        lat = lat,
        yawspeed = yawspeed,
        pitchspeed = pitchspeed,
        rollspeed = rollspeed,
        yaw = yaw,
        pitch = pitch,
        roll = roll,
        timeUsec = timeUsec,
      )
    }


    private val METADATA: MavMessage.Metadata<HilState> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilState> = METADATA
  }
}
