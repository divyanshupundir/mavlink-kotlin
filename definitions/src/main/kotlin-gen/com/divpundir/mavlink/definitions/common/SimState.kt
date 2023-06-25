package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Status of simulation environment, if used
 */
@GeneratedMavMessage(
  id = 108u,
  crcExtra = 32,
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
  public override val instanceCompanion: MavMessage.MavCompanion<SimState> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(q1)
    buffer.encodeFloat(q2)
    buffer.encodeFloat(q3)
    buffer.encodeFloat(q4)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(xacc)
    buffer.encodeFloat(yacc)
    buffer.encodeFloat(zacc)
    buffer.encodeFloat(xgyro)
    buffer.encodeFloat(ygyro)
    buffer.encodeFloat(zgyro)
    buffer.encodeFloat(lat)
    buffer.encodeFloat(lon)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(stdDevHorz)
    buffer.encodeFloat(stdDevVert)
    buffer.encodeFloat(vn)
    buffer.encodeFloat(ve)
    buffer.encodeFloat(vd)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(q1)
    buffer.encodeFloat(q2)
    buffer.encodeFloat(q3)
    buffer.encodeFloat(q4)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(xacc)
    buffer.encodeFloat(yacc)
    buffer.encodeFloat(zacc)
    buffer.encodeFloat(xgyro)
    buffer.encodeFloat(ygyro)
    buffer.encodeFloat(zgyro)
    buffer.encodeFloat(lat)
    buffer.encodeFloat(lon)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(stdDevHorz)
    buffer.encodeFloat(stdDevVert)
    buffer.encodeFloat(vn)
    buffer.encodeFloat(ve)
    buffer.encodeFloat(vd)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SimState> {
    public override val id: UInt = 108u

    public override val crcExtra: Byte = 32

    public override fun deserialize(bytes: ByteArray): SimState {
      val buffer = Buffer().write(bytes)

      val q1 = buffer.decodeFloat()
      val q2 = buffer.decodeFloat()
      val q3 = buffer.decodeFloat()
      val q4 = buffer.decodeFloat()
      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val xacc = buffer.decodeFloat()
      val yacc = buffer.decodeFloat()
      val zacc = buffer.decodeFloat()
      val xgyro = buffer.decodeFloat()
      val ygyro = buffer.decodeFloat()
      val zgyro = buffer.decodeFloat()
      val lat = buffer.decodeFloat()
      val lon = buffer.decodeFloat()
      val alt = buffer.decodeFloat()
      val stdDevHorz = buffer.decodeFloat()
      val stdDevVert = buffer.decodeFloat()
      val vn = buffer.decodeFloat()
      val ve = buffer.decodeFloat()
      val vd = buffer.decodeFloat()

      return SimState(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SimState =
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
