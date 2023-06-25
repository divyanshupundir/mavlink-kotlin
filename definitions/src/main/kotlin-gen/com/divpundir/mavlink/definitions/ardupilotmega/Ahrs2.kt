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
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Status of secondary AHRS filter if available.
 */
@GeneratedMavMessage(
  id = 178u,
  crcExtra = 47,
)
public data class Ahrs2(
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
   * Altitude (MSL).
   */
  @GeneratedMavField(type = "float")
  public val altitude: Float = 0F,
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
) : MavMessage<Ahrs2> {
  public override val instanceCompanion: MavMessage.MavCompanion<Ahrs2> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(altitude)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(altitude)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Ahrs2> {
    public override val id: UInt = 178u

    public override val crcExtra: Byte = 47

    public override fun deserialize(bytes: ByteArray): Ahrs2 {
      val buffer = Buffer().write(bytes)

      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val altitude = buffer.decodeFloat()
      val lat = buffer.decodeInt32()
      val lng = buffer.decodeInt32()

      return Ahrs2(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        altitude = altitude,
        lat = lat,
        lng = lng,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Ahrs2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var altitude: Float = 0F

    public var lat: Int = 0

    public var lng: Int = 0

    public fun build(): Ahrs2 = Ahrs2(
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      altitude = altitude,
      lat = lat,
      lng = lng,
    )
  }
}
