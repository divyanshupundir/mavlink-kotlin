package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt16(airspeedImu)
    buffer.encodeInt16(airspeedPitot)
    buffer.encodeInt16(airspeedHotWire)
    buffer.encodeInt16(airspeedUltrasonic)
    buffer.encodeInt16(aoa)
    buffer.encodeInt16(aoy)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt16(airspeedImu)
    buffer.encodeInt16(airspeedPitot)
    buffer.encodeInt16(airspeedHotWire)
    buffer.encodeInt16(airspeedUltrasonic)
    buffer.encodeInt16(aoa)
    buffer.encodeInt16(aoy)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Airspeeds> {
    public override val id: UInt = 182u

    public override val crcExtra: Byte = -102

    public override fun deserialize(bytes: ByteArray): Airspeeds {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val airspeedImu = buffer.decodeInt16()
      val airspeedPitot = buffer.decodeInt16()
      val airspeedHotWire = buffer.decodeInt16()
      val airspeedUltrasonic = buffer.decodeInt16()
      val aoa = buffer.decodeInt16()
      val aoy = buffer.decodeInt16()

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
