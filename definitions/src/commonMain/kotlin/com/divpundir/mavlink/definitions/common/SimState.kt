package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Status of simulation environment, if used
 *
 * @param q1 True attitude quaternion component 1, w (1 in null-rotation)
 * @param q2 True attitude quaternion component 2, x (0 in null-rotation)
 * @param q3 True attitude quaternion component 3, y (0 in null-rotation)
 * @param q4 True attitude quaternion component 4, z (0 in null-rotation)
 * @param roll Attitude roll expressed as Euler angles, not recommended except for human-readable
 * outputs
 * units = rad
 * @param pitch Attitude pitch expressed as Euler angles, not recommended except for human-readable
 * outputs
 * units = rad
 * @param yaw Attitude yaw expressed as Euler angles, not recommended except for human-readable
 * outputs
 * units = rad
 * @param xacc X acceleration
 * units = m/s/s
 * @param yacc Y acceleration
 * units = m/s/s
 * @param zacc Z acceleration
 * units = m/s/s
 * @param xgyro Angular speed around X axis
 * units = rad/s
 * @param ygyro Angular speed around Y axis
 * units = rad/s
 * @param zgyro Angular speed around Z axis
 * units = rad/s
 * @param lat Latitude (lower precision). Both this and the lat_int field should be set.
 * units = deg
 * @param lon Longitude (lower precision). Both this and the lon_int field should be set.
 * units = deg
 * @param alt Altitude
 * units = m
 * @param stdDevHorz Horizontal position standard deviation
 * @param stdDevVert Vertical position standard deviation
 * @param vn True velocity in north direction in earth-fixed NED frame
 * units = m/s
 * @param ve True velocity in east direction in earth-fixed NED frame
 * units = m/s
 * @param vd True velocity in down direction in earth-fixed NED frame
 * units = m/s
 * @param latInt Latitude (higher precision). If 0, recipients should use the lat field value
 * (otherwise this field is preferred).
 * units = degE7
 * @param lonInt Longitude (higher precision). If 0, recipients should use the lon field value
 * (otherwise this field is preferred).
 * units = degE7
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
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * X acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
  /**
   * Latitude (lower precision). Both this and the lat_int field should be set.
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val lat: Float = 0F,
  /**
   * Longitude (lower precision). Both this and the lon_int field should be set.
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val lon: Float = 0F,
  /**
   * Altitude
   * units = m
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
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vn: Float = 0F,
  /**
   * True velocity in east direction in earth-fixed NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val ve: Float = 0F,
  /**
   * True velocity in down direction in earth-fixed NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vd: Float = 0F,
  /**
   * Latitude (higher precision). If 0, recipients should use the lat field value (otherwise this
   * field is preferred).
   * units = degE7
   */
  @GeneratedMavField(
    type = "int32_t",
    extension = true,
  )
  public val latInt: Int = 0,
  /**
   * Longitude (higher precision). If 0, recipients should use the lon field value (otherwise this
   * field is preferred).
   * units = degE7
   */
  @GeneratedMavField(
    type = "int32_t",
    extension = true,
  )
  public val lonInt: Int = 0,
) : MavMessage<SimState> {
  override val instanceCompanion: MavMessage.MavCompanion<SimState> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(q1)
    encoder.encodeFloat(q2)
    encoder.encodeFloat(q3)
    encoder.encodeFloat(q4)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(xacc)
    encoder.encodeFloat(yacc)
    encoder.encodeFloat(zacc)
    encoder.encodeFloat(xgyro)
    encoder.encodeFloat(ygyro)
    encoder.encodeFloat(zgyro)
    encoder.encodeFloat(lat)
    encoder.encodeFloat(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(stdDevHorz)
    encoder.encodeFloat(stdDevVert)
    encoder.encodeFloat(vn)
    encoder.encodeFloat(ve)
    encoder.encodeFloat(vd)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(q1)
    encoder.encodeFloat(q2)
    encoder.encodeFloat(q3)
    encoder.encodeFloat(q4)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(xacc)
    encoder.encodeFloat(yacc)
    encoder.encodeFloat(zacc)
    encoder.encodeFloat(xgyro)
    encoder.encodeFloat(ygyro)
    encoder.encodeFloat(zgyro)
    encoder.encodeFloat(lat)
    encoder.encodeFloat(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(stdDevHorz)
    encoder.encodeFloat(stdDevVert)
    encoder.encodeFloat(vn)
    encoder.encodeFloat(ve)
    encoder.encodeFloat(vd)
    encoder.encodeInt32(latInt)
    encoder.encodeInt32(lonInt)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SimState> {
    private const val SIZE_V1: Int = 84

    private const val SIZE_V2: Int = 92

    override val id: UInt = 108u

    override val crcExtra: Byte = 32

    override fun deserialize(bytes: ByteArray): SimState {
      val decoder = MavDataDecoder(bytes)

      val q1 = decoder.safeDecodeFloat()
      val q2 = decoder.safeDecodeFloat()
      val q3 = decoder.safeDecodeFloat()
      val q4 = decoder.safeDecodeFloat()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val xacc = decoder.safeDecodeFloat()
      val yacc = decoder.safeDecodeFloat()
      val zacc = decoder.safeDecodeFloat()
      val xgyro = decoder.safeDecodeFloat()
      val ygyro = decoder.safeDecodeFloat()
      val zgyro = decoder.safeDecodeFloat()
      val lat = decoder.safeDecodeFloat()
      val lon = decoder.safeDecodeFloat()
      val alt = decoder.safeDecodeFloat()
      val stdDevHorz = decoder.safeDecodeFloat()
      val stdDevVert = decoder.safeDecodeFloat()
      val vn = decoder.safeDecodeFloat()
      val ve = decoder.safeDecodeFloat()
      val vd = decoder.safeDecodeFloat()
      val latInt = decoder.safeDecodeInt32()
      val lonInt = decoder.safeDecodeInt32()

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
        latInt = latInt,
        lonInt = lonInt,
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

    public var latInt: Int = 0

    public var lonInt: Int = 0

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
      latInt = latInt,
      lonInt = lonInt,
    )
  }
}
