package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Status of simulation environment, if used.
 */
@GeneratedMavMessage(
  id = 164u,
  crcExtra = -102,
)
public data class Simstate(
  /**
   * Roll angle.
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle.
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle.
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * X acceleration.
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration.
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration.
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis.
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis.
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis.
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
  /**
   * Latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
) : MavMessage<Simstate> {
  public override val instanceCompanion: MavMessage.MavCompanion<Simstate> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(roll)
    output.encodeFloat(pitch)
    output.encodeFloat(yaw)
    output.encodeFloat(xacc)
    output.encodeFloat(yacc)
    output.encodeFloat(zacc)
    output.encodeFloat(xgyro)
    output.encodeFloat(ygyro)
    output.encodeFloat(zgyro)
    output.encodeInt32(lat)
    output.encodeInt32(lng)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(roll)
    output.encodeFloat(pitch)
    output.encodeFloat(yaw)
    output.encodeFloat(xacc)
    output.encodeFloat(yacc)
    output.encodeFloat(zacc)
    output.encodeFloat(xgyro)
    output.encodeFloat(ygyro)
    output.encodeFloat(zgyro)
    output.encodeInt32(lat)
    output.encodeInt32(lng)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Simstate> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    public override val id: UInt = 164u

    public override val crcExtra: Byte = -102

    public override fun deserialize(source: BufferedSource): Simstate {
      val roll = source.decodeFloat()
      val pitch = source.decodeFloat()
      val yaw = source.decodeFloat()
      val xacc = source.decodeFloat()
      val yacc = source.decodeFloat()
      val zacc = source.decodeFloat()
      val xgyro = source.decodeFloat()
      val ygyro = source.decodeFloat()
      val zgyro = source.decodeFloat()
      val lat = source.decodeInt32()
      val lng = source.decodeInt32()

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
