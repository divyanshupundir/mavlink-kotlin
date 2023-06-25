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
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timestamp)
    buffer.encodeInt32(latitude)
    buffer.encodeInt32(longitude)
    buffer.encodeUInt16(customMode)
    buffer.encodeInt16(altitude)
    buffer.encodeInt16(targetAltitude)
    buffer.encodeUInt16(targetDistance)
    buffer.encodeUInt16(wpNum)
    buffer.encodeBitmaskValue(failureFlags.value, 2)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeEnumValue(autopilot.value, 1)
    buffer.encodeUInt8(heading)
    buffer.encodeUInt8(targetHeading)
    buffer.encodeUInt8(throttle)
    buffer.encodeUInt8(airspeed)
    buffer.encodeUInt8(airspeedSp)
    buffer.encodeUInt8(groundspeed)
    buffer.encodeUInt8(windspeed)
    buffer.encodeUInt8(windHeading)
    buffer.encodeUInt8(eph)
    buffer.encodeUInt8(epv)
    buffer.encodeInt8(temperatureAir)
    buffer.encodeInt8(climbRate)
    buffer.encodeInt8(battery)
    buffer.encodeInt8(custom0)
    buffer.encodeInt8(custom1)
    buffer.encodeInt8(custom2)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timestamp)
    buffer.encodeInt32(latitude)
    buffer.encodeInt32(longitude)
    buffer.encodeUInt16(customMode)
    buffer.encodeInt16(altitude)
    buffer.encodeInt16(targetAltitude)
    buffer.encodeUInt16(targetDistance)
    buffer.encodeUInt16(wpNum)
    buffer.encodeBitmaskValue(failureFlags.value, 2)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeEnumValue(autopilot.value, 1)
    buffer.encodeUInt8(heading)
    buffer.encodeUInt8(targetHeading)
    buffer.encodeUInt8(throttle)
    buffer.encodeUInt8(airspeed)
    buffer.encodeUInt8(airspeedSp)
    buffer.encodeUInt8(groundspeed)
    buffer.encodeUInt8(windspeed)
    buffer.encodeUInt8(windHeading)
    buffer.encodeUInt8(eph)
    buffer.encodeUInt8(epv)
    buffer.encodeInt8(temperatureAir)
    buffer.encodeInt8(climbRate)
    buffer.encodeInt8(battery)
    buffer.encodeInt8(custom0)
    buffer.encodeInt8(custom1)
    buffer.encodeInt8(custom2)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HighLatency2> {
    public override val id: UInt = 235u

    public override val crcExtra: Byte = -77

    public override fun deserialize(bytes: ByteArray): HighLatency2 {
      val buffer = Buffer().write(bytes)

      val timestamp = buffer.decodeUInt32()
      val latitude = buffer.decodeInt32()
      val longitude = buffer.decodeInt32()
      val customMode = buffer.decodeUInt16()
      val altitude = buffer.decodeInt16()
      val targetAltitude = buffer.decodeInt16()
      val targetDistance = buffer.decodeUInt16()
      val wpNum = buffer.decodeUInt16()
      val failureFlags = buffer.decodeBitmaskValue(2).let { value ->
        val flags = HlFailureFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val type = buffer.decodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = buffer.decodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val heading = buffer.decodeUInt8()
      val targetHeading = buffer.decodeUInt8()
      val throttle = buffer.decodeUInt8()
      val airspeed = buffer.decodeUInt8()
      val airspeedSp = buffer.decodeUInt8()
      val groundspeed = buffer.decodeUInt8()
      val windspeed = buffer.decodeUInt8()
      val windHeading = buffer.decodeUInt8()
      val eph = buffer.decodeUInt8()
      val epv = buffer.decodeUInt8()
      val temperatureAir = buffer.decodeInt8()
      val climbRate = buffer.decodeInt8()
      val battery = buffer.decodeInt8()
      val custom0 = buffer.decodeInt8()
      val custom1 = buffer.decodeInt8()
      val custom2 = buffer.decodeInt8()

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
