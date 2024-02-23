package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.minimal.MavAutopilot
import com.divpundir.mavlink.definitions.minimal.MavType
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Message appropriate for high latency connections like Iridium (version 2)
 *
 * @param timestamp Timestamp (milliseconds since boot or Unix epoch)
 * units = ms
 * @param type Type of the MAV (quadrotor, helicopter, etc.)
 * @param autopilot Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not
 * flight controllers.
 * @param customMode A bitfield for use for autopilot-specific flags (2 byte version).
 * @param latitude Latitude
 * units = degE7
 * @param longitude Longitude
 * units = degE7
 * @param altitude Altitude above mean sea level
 * units = m
 * @param targetAltitude Altitude setpoint
 * units = m
 * @param heading Heading
 * units = deg/2
 * @param targetHeading Heading setpoint
 * units = deg/2
 * @param targetDistance Distance to target waypoint or position
 * units = dam
 * @param throttle Throttle
 * units = %
 * @param airspeed Airspeed
 * units = m/s*5
 * @param airspeedSp Airspeed setpoint
 * units = m/s*5
 * @param groundspeed Groundspeed
 * units = m/s*5
 * @param windspeed Windspeed
 * units = m/s*5
 * @param windHeading Wind heading
 * units = deg/2
 * @param eph Maximum error horizontal position since last message
 * units = dm
 * @param epv Maximum error vertical position since last message
 * units = dm
 * @param temperatureAir Air temperature from airspeed sensor
 * units = degC
 * @param climbRate Maximum climb rate magnitude since last message
 * units = dm/s
 * @param battery Battery level (-1 if field not provided).
 * units = %
 * @param wpNum Current waypoint number
 * @param failureFlags Bitmap of failure flags.
 * @param custom0 Field for custom payload.
 * @param custom1 Field for custom payload.
 * @param custom2 Field for custom payload.
 */
@GeneratedMavMessage(
  id = 235u,
  crcExtra = -77,
)
public data class HighLatency2(
  /**
   * Timestamp (milliseconds since boot or Unix epoch)
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: UInt = 0u,
  /**
   * Type of the MAV (quadrotor, helicopter, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavType> = MavEnumValue.fromValue(0u),
  /**
   * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight
   * controllers.
   */
  @GeneratedMavField(type = "uint8_t")
  public val autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0u),
  /**
   * A bitfield for use for autopilot-specific flags (2 byte version).
   */
  @GeneratedMavField(type = "uint16_t")
  public val customMode: UShort = 0u,
  /**
   * Latitude
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Longitude
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * Altitude above mean sea level
   * units = m
   */
  @GeneratedMavField(type = "int16_t")
  public val altitude: Short = 0,
  /**
   * Altitude setpoint
   * units = m
   */
  @GeneratedMavField(type = "int16_t")
  public val targetAltitude: Short = 0,
  /**
   * Heading
   * units = deg/2
   */
  @GeneratedMavField(type = "uint8_t")
  public val heading: UByte = 0u,
  /**
   * Heading setpoint
   * units = deg/2
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetHeading: UByte = 0u,
  /**
   * Distance to target waypoint or position
   * units = dam
   */
  @GeneratedMavField(type = "uint16_t")
  public val targetDistance: UShort = 0u,
  /**
   * Throttle
   * units = %
   */
  @GeneratedMavField(type = "uint8_t")
  public val throttle: UByte = 0u,
  /**
   * Airspeed
   * units = m/s*5
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeed: UByte = 0u,
  /**
   * Airspeed setpoint
   * units = m/s*5
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeedSp: UByte = 0u,
  /**
   * Groundspeed
   * units = m/s*5
   */
  @GeneratedMavField(type = "uint8_t")
  public val groundspeed: UByte = 0u,
  /**
   * Windspeed
   * units = m/s*5
   */
  @GeneratedMavField(type = "uint8_t")
  public val windspeed: UByte = 0u,
  /**
   * Wind heading
   * units = deg/2
   */
  @GeneratedMavField(type = "uint8_t")
  public val windHeading: UByte = 0u,
  /**
   * Maximum error horizontal position since last message
   * units = dm
   */
  @GeneratedMavField(type = "uint8_t")
  public val eph: UByte = 0u,
  /**
   * Maximum error vertical position since last message
   * units = dm
   */
  @GeneratedMavField(type = "uint8_t")
  public val epv: UByte = 0u,
  /**
   * Air temperature from airspeed sensor
   * units = degC
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureAir: Byte = 0,
  /**
   * Maximum climb rate magnitude since last message
   * units = dm/s
   */
  @GeneratedMavField(type = "int8_t")
  public val climbRate: Byte = 0,
  /**
   * Battery level (-1 if field not provided).
   * units = %
   */
  @GeneratedMavField(type = "int8_t")
  public val battery: Byte = 0,
  /**
   * Current waypoint number
   */
  @GeneratedMavField(type = "uint16_t")
  public val wpNum: UShort = 0u,
  /**
   * Bitmap of failure flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val failureFlags: MavBitmaskValue<HlFailureFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * Field for custom payload.
   */
  @GeneratedMavField(type = "int8_t")
  public val custom0: Byte = 0,
  /**
   * Field for custom payload.
   */
  @GeneratedMavField(type = "int8_t")
  public val custom1: Byte = 0,
  /**
   * Field for custom payload.
   */
  @GeneratedMavField(type = "int8_t")
  public val custom2: Byte = 0,
) : MavMessage<HighLatency2> {
  override val instanceCompanion: MavMessage.MavCompanion<HighLatency2> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timestamp)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeUInt16(customMode)
    encoder.encodeInt16(altitude)
    encoder.encodeInt16(targetAltitude)
    encoder.encodeUInt16(targetDistance)
    encoder.encodeUInt16(wpNum)
    encoder.encodeBitmaskValue(failureFlags.value, 2)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeEnumValue(autopilot.value, 1)
    encoder.encodeUInt8(heading)
    encoder.encodeUInt8(targetHeading)
    encoder.encodeUInt8(throttle)
    encoder.encodeUInt8(airspeed)
    encoder.encodeUInt8(airspeedSp)
    encoder.encodeUInt8(groundspeed)
    encoder.encodeUInt8(windspeed)
    encoder.encodeUInt8(windHeading)
    encoder.encodeUInt8(eph)
    encoder.encodeUInt8(epv)
    encoder.encodeInt8(temperatureAir)
    encoder.encodeInt8(climbRate)
    encoder.encodeInt8(battery)
    encoder.encodeInt8(custom0)
    encoder.encodeInt8(custom1)
    encoder.encodeInt8(custom2)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timestamp)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeUInt16(customMode)
    encoder.encodeInt16(altitude)
    encoder.encodeInt16(targetAltitude)
    encoder.encodeUInt16(targetDistance)
    encoder.encodeUInt16(wpNum)
    encoder.encodeBitmaskValue(failureFlags.value, 2)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeEnumValue(autopilot.value, 1)
    encoder.encodeUInt8(heading)
    encoder.encodeUInt8(targetHeading)
    encoder.encodeUInt8(throttle)
    encoder.encodeUInt8(airspeed)
    encoder.encodeUInt8(airspeedSp)
    encoder.encodeUInt8(groundspeed)
    encoder.encodeUInt8(windspeed)
    encoder.encodeUInt8(windHeading)
    encoder.encodeUInt8(eph)
    encoder.encodeUInt8(epv)
    encoder.encodeInt8(temperatureAir)
    encoder.encodeInt8(climbRate)
    encoder.encodeInt8(battery)
    encoder.encodeInt8(custom0)
    encoder.encodeInt8(custom1)
    encoder.encodeInt8(custom2)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HighLatency2> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    override val id: UInt = 235u

    override val crcExtra: Byte = -77

    override fun deserialize(bytes: ByteArray): HighLatency2 {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt32()
      val latitude = decoder.safeDecodeInt32()
      val longitude = decoder.safeDecodeInt32()
      val customMode = decoder.safeDecodeUInt16()
      val altitude = decoder.safeDecodeInt16()
      val targetAltitude = decoder.safeDecodeInt16()
      val targetDistance = decoder.safeDecodeUInt16()
      val wpNum = decoder.safeDecodeUInt16()
      val failureFlags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = HlFailureFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val heading = decoder.safeDecodeUInt8()
      val targetHeading = decoder.safeDecodeUInt8()
      val throttle = decoder.safeDecodeUInt8()
      val airspeed = decoder.safeDecodeUInt8()
      val airspeedSp = decoder.safeDecodeUInt8()
      val groundspeed = decoder.safeDecodeUInt8()
      val windspeed = decoder.safeDecodeUInt8()
      val windHeading = decoder.safeDecodeUInt8()
      val eph = decoder.safeDecodeUInt8()
      val epv = decoder.safeDecodeUInt8()
      val temperatureAir = decoder.safeDecodeInt8()
      val climbRate = decoder.safeDecodeInt8()
      val battery = decoder.safeDecodeInt8()
      val custom0 = decoder.safeDecodeInt8()
      val custom1 = decoder.safeDecodeInt8()
      val custom2 = decoder.safeDecodeInt8()

      return HighLatency2(
        timestamp = timestamp,
        type = type,
        autopilot = autopilot,
        customMode = customMode,
        latitude = latitude,
        longitude = longitude,
        altitude = altitude,
        targetAltitude = targetAltitude,
        heading = heading,
        targetHeading = targetHeading,
        targetDistance = targetDistance,
        throttle = throttle,
        airspeed = airspeed,
        airspeedSp = airspeedSp,
        groundspeed = groundspeed,
        windspeed = windspeed,
        windHeading = windHeading,
        eph = eph,
        epv = epv,
        temperatureAir = temperatureAir,
        climbRate = climbRate,
        battery = battery,
        wpNum = wpNum,
        failureFlags = failureFlags,
        custom0 = custom0,
        custom1 = custom1,
        custom2 = custom2,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HighLatency2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: UInt = 0u

    public var type: MavEnumValue<MavType> = MavEnumValue.fromValue(0u)

    public var autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0u)

    public var customMode: UShort = 0u

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitude: Short = 0

    public var targetAltitude: Short = 0

    public var heading: UByte = 0u

    public var targetHeading: UByte = 0u

    public var targetDistance: UShort = 0u

    public var throttle: UByte = 0u

    public var airspeed: UByte = 0u

    public var airspeedSp: UByte = 0u

    public var groundspeed: UByte = 0u

    public var windspeed: UByte = 0u

    public var windHeading: UByte = 0u

    public var eph: UByte = 0u

    public var epv: UByte = 0u

    public var temperatureAir: Byte = 0

    public var climbRate: Byte = 0

    public var battery: Byte = 0

    public var wpNum: UShort = 0u

    public var failureFlags: MavBitmaskValue<HlFailureFlag> = MavBitmaskValue.fromValue(0u)

    public var custom0: Byte = 0

    public var custom1: Byte = 0

    public var custom2: Byte = 0

    public fun build(): HighLatency2 = HighLatency2(
      timestamp = timestamp,
      type = type,
      autopilot = autopilot,
      customMode = customMode,
      latitude = latitude,
      longitude = longitude,
      altitude = altitude,
      targetAltitude = targetAltitude,
      heading = heading,
      targetHeading = targetHeading,
      targetDistance = targetDistance,
      throttle = throttle,
      airspeed = airspeed,
      airspeedSp = airspeedSp,
      groundspeed = groundspeed,
      windspeed = windspeed,
      windHeading = windHeading,
      eph = eph,
      epv = epv,
      temperatureAir = temperatureAir,
      climbRate = climbRate,
      battery = battery,
      wpNum = wpNum,
      failureFlags = failureFlags,
      custom0 = custom0,
      custom1 = custom1,
      custom2 = custom2,
    )
  }
}
