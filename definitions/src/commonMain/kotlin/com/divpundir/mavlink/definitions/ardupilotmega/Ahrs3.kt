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
 * Status of third AHRS filter if available. This is for ANU research group (Ali and Sean).
 *
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
  override val instanceCompanion: MavMessage.MavCompanion<Ahrs3> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(altitude)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    encoder.encodeFloat(v1)
    encoder.encodeFloat(v2)
    encoder.encodeFloat(v3)
    encoder.encodeFloat(v4)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(altitude)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    encoder.encodeFloat(v1)
    encoder.encodeFloat(v2)
    encoder.encodeFloat(v3)
    encoder.encodeFloat(v4)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Ahrs3> {
    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    override val id: UInt = 182u

    override val crcExtra: Byte = -27

    override fun deserialize(bytes: ByteArray): Ahrs3 {
      val decoder = MavDataDecoder(bytes)

      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val altitude = decoder.safeDecodeFloat()
      val lat = decoder.safeDecodeInt32()
      val lng = decoder.safeDecodeInt32()
      val v1 = decoder.safeDecodeFloat()
      val v2 = decoder.safeDecodeFloat()
      val v3 = decoder.safeDecodeFloat()
      val v4 = decoder.safeDecodeFloat()

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
