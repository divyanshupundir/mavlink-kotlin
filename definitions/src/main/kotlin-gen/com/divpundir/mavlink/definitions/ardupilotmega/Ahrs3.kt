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
 * Status of third AHRS filter if available. This is for ANU research group (Ali and Sean).
 */
@GeneratedMavMessage(
  id = 182u,
  crcExtra = -27,
)
public data class Ahrs3(
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
  /**
   * Test variable1.
   */
  @GeneratedMavField(type = "float")
  public val v1: Float = 0F,
  /**
   * Test variable2.
   */
  @GeneratedMavField(type = "float")
  public val v2: Float = 0F,
  /**
   * Test variable3.
   */
  @GeneratedMavField(type = "float")
  public val v3: Float = 0F,
  /**
   * Test variable4.
   */
  @GeneratedMavField(type = "float")
  public val v4: Float = 0F,
) : MavMessage<Ahrs3> {
  public override val instanceCompanion: MavMessage.MavCompanion<Ahrs3> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(altitude)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    buffer.encodeFloat(v1)
    buffer.encodeFloat(v2)
    buffer.encodeFloat(v3)
    buffer.encodeFloat(v4)
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
    buffer.encodeFloat(v1)
    buffer.encodeFloat(v2)
    buffer.encodeFloat(v3)
    buffer.encodeFloat(v4)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Ahrs3> {
    public override val id: UInt = 182u

    public override val crcExtra: Byte = -27

    public override fun deserialize(bytes: ByteArray): Ahrs3 {
      val buffer = Buffer().write(bytes)

      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val altitude = buffer.decodeFloat()
      val lat = buffer.decodeInt32()
      val lng = buffer.decodeInt32()
      val v1 = buffer.decodeFloat()
      val v2 = buffer.decodeFloat()
      val v3 = buffer.decodeFloat()
      val v4 = buffer.decodeFloat()

      return Ahrs3(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        altitude = altitude,
        lat = lat,
        lng = lng,
        v1 = v1,
        v2 = v2,
        v3 = v3,
        v4 = v4,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Ahrs3 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var altitude: Float = 0F

    public var lat: Int = 0

    public var lng: Int = 0

    public var v1: Float = 0F

    public var v2: Float = 0F

    public var v3: Float = 0F

    public var v4: Float = 0F

    public fun build(): Ahrs3 = Ahrs3(
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      altitude = altitude,
      lat = lat,
      lng = lng,
      v1 = v1,
      v2 = v2,
      v3 = v3,
      v4 = v4,
    )
  }
}
