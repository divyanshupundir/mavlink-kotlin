package com.divpundir.mavlink.definitions.ardupilotmega

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
 * Status of simulation environment, if used.
 *
 * @param roll Roll angle.
 * units = rad
 * @param pitch Pitch angle.
 * units = rad
 * @param yaw Yaw angle.
 * units = rad
 * @param xacc X acceleration.
 * units = m/s/s
 * @param yacc Y acceleration.
 * units = m/s/s
 * @param zacc Z acceleration.
 * units = m/s/s
 * @param xgyro Angular speed around X axis.
 * units = rad/s
 * @param ygyro Angular speed around Y axis.
 * units = rad/s
 * @param zgyro Angular speed around Z axis.
 * units = rad/s
 * @param lat Latitude.
 * units = degE7
 * @param lng Longitude.
 * units = degE7
 */
@GeneratedMavMessage(
  id = 164u,
  crcExtra = -102,
)
public data class Simstate(
  /**
   * Roll angle.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * X acceleration.
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration.
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration.
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
  /**
   * Latitude.
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude.
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
) : MavMessage<Simstate> {
  override val instanceCompanion: MavMessage.MavCompanion<Simstate> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(xacc)
    encoder.encodeFloat(yacc)
    encoder.encodeFloat(zacc)
    encoder.encodeFloat(xgyro)
    encoder.encodeFloat(ygyro)
    encoder.encodeFloat(zgyro)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(xacc)
    encoder.encodeFloat(yacc)
    encoder.encodeFloat(zacc)
    encoder.encodeFloat(xgyro)
    encoder.encodeFloat(ygyro)
    encoder.encodeFloat(zgyro)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Simstate> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    override val id: UInt = 164u

    override val crcExtra: Byte = -102

    override fun deserialize(bytes: ByteArray): Simstate {
      val decoder = MavDataDecoder(bytes)

      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val xacc = decoder.safeDecodeFloat()
      val yacc = decoder.safeDecodeFloat()
      val zacc = decoder.safeDecodeFloat()
      val xgyro = decoder.safeDecodeFloat()
      val ygyro = decoder.safeDecodeFloat()
      val zgyro = decoder.safeDecodeFloat()
      val lat = decoder.safeDecodeInt32()
      val lng = decoder.safeDecodeInt32()

      return Simstate(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): Simstate =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var xacc: Float = 0F

    public var yacc: Float = 0F

    public var zacc: Float = 0F

    public var xgyro: Float = 0F

    public var ygyro: Float = 0F

    public var zgyro: Float = 0F

    public var lat: Int = 0

    public var lng: Int = 0

    public fun build(): Simstate = Simstate(
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
}
