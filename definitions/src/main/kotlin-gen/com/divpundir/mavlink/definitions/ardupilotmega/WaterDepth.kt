package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Water depth
 */
@GeneratedMavMessage(
  id = 11_038u,
  crcExtra = 47,
)
public data class WaterDepth(
  /**
   * Timestamp (time since system boot)
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Onboard ID of the sensor
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Sensor data healthy (0=unhealthy, 1=healthy)
   */
  @GeneratedMavField(type = "uint8_t")
  public val healthy: UByte = 0u,
  /**
   * Latitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
  /**
   * Altitude (MSL) of vehicle
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * Roll angle
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Distance (uncorrected)
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
  /**
   * Water temperature
   */
  @GeneratedMavField(type = "float")
  public val temperature: Float = 0F,
) : MavMessage<WaterDepth> {
  public override val instanceCompanion: MavMessage.MavCompanion<WaterDepth> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(distance)
    buffer.encodeFloat(temperature)
    buffer.encodeUInt8(id)
    buffer.encodeUInt8(healthy)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(distance)
    buffer.encodeFloat(temperature)
    buffer.encodeUInt8(id)
    buffer.encodeUInt8(healthy)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WaterDepth> {
    public override val id: UInt = 11_038u

    public override val crcExtra: Byte = 47

    public override fun deserialize(bytes: ByteArray): WaterDepth {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val lat = buffer.decodeInt32()
      val lng = buffer.decodeInt32()
      val alt = buffer.decodeFloat()
      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val distance = buffer.decodeFloat()
      val temperature = buffer.decodeFloat()
      val id = buffer.decodeUInt8()
      val healthy = buffer.decodeUInt8()

      return WaterDepth(
        timeBootMs = timeBootMs,
        id = id,
        healthy = healthy,
        lat = lat,
        lng = lng,
        alt = alt,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        distance = distance,
        temperature = temperature,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WaterDepth =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var id: UByte = 0u

    public var healthy: UByte = 0u

    public var lat: Int = 0

    public var lng: Int = 0

    public var alt: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var distance: Float = 0F

    public var temperature: Float = 0F

    public fun build(): WaterDepth = WaterDepth(
      timeBootMs = timeBootMs,
      id = id,
      healthy = healthy,
      lat = lat,
      lng = lng,
      alt = alt,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      distance = distance,
      temperature = temperature,
    )
  }
}
