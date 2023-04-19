package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<Airspeeds> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt16(airspeedImu)
    outputBuffer.encodeInt16(airspeedPitot)
    outputBuffer.encodeInt16(airspeedHotWire)
    outputBuffer.encodeInt16(airspeedUltrasonic)
    outputBuffer.encodeInt16(aoa)
    outputBuffer.encodeInt16(aoy)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt16(airspeedImu)
    outputBuffer.encodeInt16(airspeedPitot)
    outputBuffer.encodeInt16(airspeedHotWire)
    outputBuffer.encodeInt16(airspeedUltrasonic)
    outputBuffer.encodeInt16(aoa)
    outputBuffer.encodeInt16(aoy)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 182u

    private const val CRC_EXTRA: Byte = -102

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<Airspeeds> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val airspeedImu = inputBuffer.decodeInt16()
      val airspeedPitot = inputBuffer.decodeInt16()
      val airspeedHotWire = inputBuffer.decodeInt16()
      val airspeedUltrasonic = inputBuffer.decodeInt16()
      val aoa = inputBuffer.decodeInt16()
      val aoy = inputBuffer.decodeInt16()

      Airspeeds(
        timeBootMs = timeBootMs,
        airspeedImu = airspeedImu,
        airspeedPitot = airspeedPitot,
        airspeedHotWire = airspeedHotWire,
        airspeedUltrasonic = airspeedUltrasonic,
        aoa = aoa,
        aoy = aoy,
      )
    }


    private val METADATA: MavMessage.Metadata<Airspeeds> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Airspeeds> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Airspeeds =
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
