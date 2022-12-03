package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Status of simulation environment, if used
 */
@GeneratedMavMessage(
  id = 108,
  crc = 32,
)
public data class SimState(
  /**
   * True attitude quaternion component 1, w (1 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q1: Float = 0F,
  /**
   * True attitude quaternion component 2, x (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q2: Float = 0F,
  /**
   * True attitude quaternion component 3, y (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q3: Float = 0F,
  /**
   * True attitude quaternion component 4, z (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q4: Float = 0F,
  /**
   * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * X acceleration
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
  /**
   * Latitude
   */
  @GeneratedMavField(type = "float")
  public val lat: Float = 0F,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "float")
  public val lon: Float = 0F,
  /**
   * Altitude
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * Horizontal position standard deviation
   */
  @GeneratedMavField(type = "float")
  public val stdDevHorz: Float = 0F,
  /**
   * Vertical position standard deviation
   */
  @GeneratedMavField(type = "float")
  public val stdDevVert: Float = 0F,
  /**
   * True velocity in north direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val vn: Float = 0F,
  /**
   * True velocity in east direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val ve: Float = 0F,
  /**
   * True velocity in down direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val vd: Float = 0F,
) : MavMessage<SimState> {
  public override val instanceMetadata: MavMessage.Metadata<SimState> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 108

    private const val CRC: Int = 32

    private const val SIZE_V1: Int = 84

    private const val SIZE_V2: Int = 84

    private val DESERIALIZER: MavDeserializer<SimState> = MavDeserializer { bytes ->
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

    public fun builder(builderAction: Builder.() -> Unit): SimState =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var q1: Float = 0F

    public var q2: Float = 0F

    public var q3: Float = 0F

    public var q4: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var xacc: Float = 0F

    public var yacc: Float = 0F

    public var zacc: Float = 0F

    public var xgyro: Float = 0F

    public var ygyro: Float = 0F

    public var zgyro: Float = 0F

    public var lat: Float = 0F

    public var lon: Float = 0F

    public var alt: Float = 0F

    public var stdDevHorz: Float = 0F

    public var stdDevVert: Float = 0F

    public var vn: Float = 0F

    public var ve: Float = 0F

    public var vd: Float = 0F

    public fun build(): SimState = SimState(
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
}
