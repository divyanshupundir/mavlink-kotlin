package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Water depth
 */
@GeneratedMavMessage(
  id = 11038u,
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
  public override val instanceMetadata: MavMessage.Metadata<WaterDepth> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeUInt8(id)
    outputBuffer.encodeUInt8(healthy)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeUInt8(id)
    outputBuffer.encodeUInt8(healthy)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11038u

    private const val CRC_EXTRA: Byte = 47

    private const val SIZE_V1: Int = 38

    private const val SIZE_V2: Int = 38

    private val DESERIALIZER: MavDeserializer<WaterDepth> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val distance = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeFloat()
      val id = inputBuffer.decodeUInt8()
      val healthy = inputBuffer.decodeUInt8()

      WaterDepth(
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


    private val METADATA: MavMessage.Metadata<WaterDepth> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WaterDepth> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): WaterDepth =
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
