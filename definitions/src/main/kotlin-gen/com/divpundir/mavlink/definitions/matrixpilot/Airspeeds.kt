package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

/**
 * The airspeed measured by sensors and IMU
 */
@GeneratedMavMessage(
  id = 182u,
  crcExtra = -102,
)
public data class Airspeeds(
  /**
   * Timestamp (milliseconds since system boot)
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Airspeed estimate from IMU, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedImu: Short = 0,
  /**
   * Pitot measured forward airpseed, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedPitot: Short = 0,
  /**
   * Hot wire anenometer measured airspeed, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedHotWire: Short = 0,
  /**
   * Ultrasonic measured airspeed, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedUltrasonic: Short = 0,
  /**
   * Angle of attack sensor, degrees * 10
   */
  @GeneratedMavField(type = "int16_t")
  public val aoa: Short = 0,
  /**
   * Yaw angle sensor, degrees * 10
   */
  @GeneratedMavField(type = "int16_t")
  public val aoy: Short = 0,
) : MavMessage<Airspeeds> {
  public override val instanceCompanion: MavMessage.MavCompanion<Airspeeds> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt16(airspeedImu)
    encoder.encodeInt16(airspeedPitot)
    encoder.encodeInt16(airspeedHotWire)
    encoder.encodeInt16(airspeedUltrasonic)
    encoder.encodeInt16(aoa)
    encoder.encodeInt16(aoy)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt16(airspeedImu)
    encoder.encodeInt16(airspeedPitot)
    encoder.encodeInt16(airspeedHotWire)
    encoder.encodeInt16(airspeedUltrasonic)
    encoder.encodeInt16(aoa)
    encoder.encodeInt16(aoy)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Airspeeds> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    public override val id: UInt = 182u

    public override val crcExtra: Byte = -102

    public override fun deserialize(bytes: ByteArray): Airspeeds {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val airspeedImu = decoder.safeDecodeInt16()
      val airspeedPitot = decoder.safeDecodeInt16()
      val airspeedHotWire = decoder.safeDecodeInt16()
      val airspeedUltrasonic = decoder.safeDecodeInt16()
      val aoa = decoder.safeDecodeInt16()
      val aoy = decoder.safeDecodeInt16()

      return Airspeeds(
        timeBootMs = timeBootMs,
        airspeedImu = airspeedImu,
        airspeedPitot = airspeedPitot,
        airspeedHotWire = airspeedHotWire,
        airspeedUltrasonic = airspeedUltrasonic,
        aoa = aoa,
        aoy = aoy,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Airspeeds =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var airspeedImu: Short = 0

    public var airspeedPitot: Short = 0

    public var airspeedHotWire: Short = 0

    public var airspeedUltrasonic: Short = 0

    public var aoa: Short = 0

    public var aoy: Short = 0

    public fun build(): Airspeeds = Airspeeds(
      timeBootMs = timeBootMs,
      airspeedImu = airspeedImu,
      airspeedPitot = airspeedPitot,
      airspeedHotWire = airspeedHotWire,
      airspeedUltrasonic = airspeedUltrasonic,
      aoa = aoa,
      aoy = aoy,
    )
  }
}
