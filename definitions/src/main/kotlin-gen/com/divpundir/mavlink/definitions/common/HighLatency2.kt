package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.minimal.MavAutopilot
import com.divpundir.mavlink.definitions.minimal.MavType
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Message appropriate for high latency connections like Iridium (version 2)
 */
@GeneratedMavMessage(
  id = 235u,
  crcExtra = -77,
)
public data class HighLatency2(
  /**
   * Timestamp (milliseconds since boot or Unix epoch)
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
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * Altitude above mean sea level
   */
  @GeneratedMavField(type = "int16_t")
  public val altitude: Short = 0,
  /**
   * Altitude setpoint
   */
  @GeneratedMavField(type = "int16_t")
  public val targetAltitude: Short = 0,
  /**
   * Heading
   */
  @GeneratedMavField(type = "uint8_t")
  public val heading: UByte = 0u,
  /**
   * Heading setpoint
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetHeading: UByte = 0u,
  /**
   * Distance to target waypoint or position
   */
  @GeneratedMavField(type = "uint16_t")
  public val targetDistance: UShort = 0u,
  /**
   * Throttle
   */
  @GeneratedMavField(type = "uint8_t")
  public val throttle: UByte = 0u,
  /**
   * Airspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeed: UByte = 0u,
  /**
   * Airspeed setpoint
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeedSp: UByte = 0u,
  /**
   * Groundspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val groundspeed: UByte = 0u,
  /**
   * Windspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val windspeed: UByte = 0u,
  /**
   * Wind heading
   */
  @GeneratedMavField(type = "uint8_t")
  public val windHeading: UByte = 0u,
  /**
   * Maximum error horizontal position since last message
   */
  @GeneratedMavField(type = "uint8_t")
  public val eph: UByte = 0u,
  /**
   * Maximum error vertical position since last message
   */
  @GeneratedMavField(type = "uint8_t")
  public val epv: UByte = 0u,
  /**
   * Air temperature from airspeed sensor
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureAir: Byte = 0,
  /**
   * Maximum climb rate magnitude since last message
   */
  @GeneratedMavField(type = "int8_t")
  public val climbRate: Byte = 0,
  /**
   * Battery level (-1 if field not provided).
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
  public override val instanceCompanion: MavMessage.MavCompanion<HighLatency2> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timestamp)
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeUInt16(customMode)
    output.encodeInt16(altitude)
    output.encodeInt16(targetAltitude)
    output.encodeUInt16(targetDistance)
    output.encodeUInt16(wpNum)
    output.encodeBitmaskValue(failureFlags.value, 2)
    output.encodeEnumValue(type.value, 1)
    output.encodeEnumValue(autopilot.value, 1)
    output.encodeUInt8(heading)
    output.encodeUInt8(targetHeading)
    output.encodeUInt8(throttle)
    output.encodeUInt8(airspeed)
    output.encodeUInt8(airspeedSp)
    output.encodeUInt8(groundspeed)
    output.encodeUInt8(windspeed)
    output.encodeUInt8(windHeading)
    output.encodeUInt8(eph)
    output.encodeUInt8(epv)
    output.encodeInt8(temperatureAir)
    output.encodeInt8(climbRate)
    output.encodeInt8(battery)
    output.encodeInt8(custom0)
    output.encodeInt8(custom1)
    output.encodeInt8(custom2)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timestamp)
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeUInt16(customMode)
    output.encodeInt16(altitude)
    output.encodeInt16(targetAltitude)
    output.encodeUInt16(targetDistance)
    output.encodeUInt16(wpNum)
    output.encodeBitmaskValue(failureFlags.value, 2)
    output.encodeEnumValue(type.value, 1)
    output.encodeEnumValue(autopilot.value, 1)
    output.encodeUInt8(heading)
    output.encodeUInt8(targetHeading)
    output.encodeUInt8(throttle)
    output.encodeUInt8(airspeed)
    output.encodeUInt8(airspeedSp)
    output.encodeUInt8(groundspeed)
    output.encodeUInt8(windspeed)
    output.encodeUInt8(windHeading)
    output.encodeUInt8(eph)
    output.encodeUInt8(epv)
    output.encodeInt8(temperatureAir)
    output.encodeInt8(climbRate)
    output.encodeInt8(battery)
    output.encodeInt8(custom0)
    output.encodeInt8(custom1)
    output.encodeInt8(custom2)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<HighLatency2> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 235u

    public override val crcExtra: Byte = -77

    public override fun deserialize(source: BufferedSource): HighLatency2 {
      val timestamp = source.decodeUInt32()
      val latitude = source.decodeInt32()
      val longitude = source.decodeInt32()
      val customMode = source.decodeUInt16()
      val altitude = source.decodeInt16()
      val targetAltitude = source.decodeInt16()
      val targetDistance = source.decodeUInt16()
      val wpNum = source.decodeUInt16()
      val failureFlags = source.decodeBitmaskValue(2).let { value ->
        val flags = HlFailureFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val type = source.decodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = source.decodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val heading = source.decodeUInt8()
      val targetHeading = source.decodeUInt8()
      val throttle = source.decodeUInt8()
      val airspeed = source.decodeUInt8()
      val airspeedSp = source.decodeUInt8()
      val groundspeed = source.decodeUInt8()
      val windspeed = source.decodeUInt8()
      val windHeading = source.decodeUInt8()
      val eph = source.decodeUInt8()
      val epv = source.decodeUInt8()
      val temperatureAir = source.decodeInt8()
      val climbRate = source.decodeInt8()
      val battery = source.decodeInt8()
      val custom0 = source.decodeInt8()
      val custom1 = source.decodeInt8()
      val custom2 = source.decodeInt8()

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
