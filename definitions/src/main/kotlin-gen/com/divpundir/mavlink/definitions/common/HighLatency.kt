package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.minimal.MavModeFlag
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
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Message appropriate for high latency connections like Iridium
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 234u,
  crcExtra = -106,
)
public data class HighLatency(
  /**
   * Bitmap of enabled system modes.
   */
  @GeneratedMavField(type = "uint8_t")
  public val baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * A bitfield for use for autopilot-specific flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: UInt = 0u,
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u),
  /**
   * roll
   */
  @GeneratedMavField(type = "int16_t")
  public val roll: Short = 0,
  /**
   * pitch
   */
  @GeneratedMavField(type = "int16_t")
  public val pitch: Short = 0,
  /**
   * heading
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: UShort = 0u,
  /**
   * throttle (percentage)
   */
  @GeneratedMavField(type = "int8_t")
  public val throttle: Byte = 0,
  /**
   * heading setpoint
   */
  @GeneratedMavField(type = "int16_t")
  public val headingSp: Short = 0,
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
  public val altitudeAmsl: Short = 0,
  /**
   * Altitude setpoint relative to the home position
   */
  @GeneratedMavField(type = "int16_t")
  public val altitudeSp: Short = 0,
  /**
   * airspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeed: UByte = 0u,
  /**
   * airspeed setpoint
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeedSp: UByte = 0u,
  /**
   * groundspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val groundspeed: UByte = 0u,
  /**
   * climb rate
   */
  @GeneratedMavField(type = "int8_t")
  public val climbRate: Byte = 0,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsNsat: UByte = 0u,
  /**
   * GPS Fix type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0u),
  /**
   * Remaining battery (percentage)
   */
  @GeneratedMavField(type = "uint8_t")
  public val batteryRemaining: UByte = 0u,
  /**
   * Autopilot temperature (degrees C)
   */
  @GeneratedMavField(type = "int8_t")
  public val temperature: Byte = 0,
  /**
   * Air temperature (degrees C) from airspeed sensor
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureAir: Byte = 0,
  /**
   * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt,
   * bit2:GPS, bit3:GCS, bit4:fence)
   */
  @GeneratedMavField(type = "uint8_t")
  public val failsafe: UByte = 0u,
  /**
   * current waypoint number
   */
  @GeneratedMavField(type = "uint8_t")
  public val wpNum: UByte = 0u,
  /**
   * distance to target
   */
  @GeneratedMavField(type = "uint16_t")
  public val wpDistance: UShort = 0u,
) : MavMessage<HighLatency> {
  public override val instanceCompanion: MavMessage.MavCompanion<HighLatency> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(customMode)
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt16(roll)
    output.encodeInt16(pitch)
    output.encodeUInt16(heading)
    output.encodeInt16(headingSp)
    output.encodeInt16(altitudeAmsl)
    output.encodeInt16(altitudeSp)
    output.encodeUInt16(wpDistance)
    output.encodeBitmaskValue(baseMode.value, 1)
    output.encodeEnumValue(landedState.value, 1)
    output.encodeInt8(throttle)
    output.encodeUInt8(airspeed)
    output.encodeUInt8(airspeedSp)
    output.encodeUInt8(groundspeed)
    output.encodeInt8(climbRate)
    output.encodeUInt8(gpsNsat)
    output.encodeEnumValue(gpsFixType.value, 1)
    output.encodeUInt8(batteryRemaining)
    output.encodeInt8(temperature)
    output.encodeInt8(temperatureAir)
    output.encodeUInt8(failsafe)
    output.encodeUInt8(wpNum)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(customMode)
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt16(roll)
    output.encodeInt16(pitch)
    output.encodeUInt16(heading)
    output.encodeInt16(headingSp)
    output.encodeInt16(altitudeAmsl)
    output.encodeInt16(altitudeSp)
    output.encodeUInt16(wpDistance)
    output.encodeBitmaskValue(baseMode.value, 1)
    output.encodeEnumValue(landedState.value, 1)
    output.encodeInt8(throttle)
    output.encodeUInt8(airspeed)
    output.encodeUInt8(airspeedSp)
    output.encodeUInt8(groundspeed)
    output.encodeInt8(climbRate)
    output.encodeUInt8(gpsNsat)
    output.encodeEnumValue(gpsFixType.value, 1)
    output.encodeUInt8(batteryRemaining)
    output.encodeInt8(temperature)
    output.encodeInt8(temperatureAir)
    output.encodeUInt8(failsafe)
    output.encodeUInt8(wpNum)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<HighLatency> {
    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    public override val id: UInt = 234u

    public override val crcExtra: Byte = -106

    public override fun deserialize(source: BufferedSource): HighLatency {
      val customMode = source.decodeUInt32()
      val latitude = source.decodeInt32()
      val longitude = source.decodeInt32()
      val roll = source.decodeInt16()
      val pitch = source.decodeInt16()
      val heading = source.decodeUInt16()
      val headingSp = source.decodeInt16()
      val altitudeAmsl = source.decodeInt16()
      val altitudeSp = source.decodeInt16()
      val wpDistance = source.decodeUInt16()
      val baseMode = source.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val landedState = source.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val throttle = source.decodeInt8()
      val airspeed = source.decodeUInt8()
      val airspeedSp = source.decodeUInt8()
      val groundspeed = source.decodeUInt8()
      val climbRate = source.decodeInt8()
      val gpsNsat = source.decodeUInt8()
      val gpsFixType = source.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val batteryRemaining = source.decodeUInt8()
      val temperature = source.decodeInt8()
      val temperatureAir = source.decodeInt8()
      val failsafe = source.decodeUInt8()
      val wpNum = source.decodeUInt8()

      return HighLatency(
        baseMode = baseMode,
        customMode = customMode,
        landedState = landedState,
        roll = roll,
        pitch = pitch,
        heading = heading,
        throttle = throttle,
        headingSp = headingSp,
        latitude = latitude,
        longitude = longitude,
        altitudeAmsl = altitudeAmsl,
        altitudeSp = altitudeSp,
        airspeed = airspeed,
        airspeedSp = airspeedSp,
        groundspeed = groundspeed,
        climbRate = climbRate,
        gpsNsat = gpsNsat,
        gpsFixType = gpsFixType,
        batteryRemaining = batteryRemaining,
        temperature = temperature,
        temperatureAir = temperatureAir,
        failsafe = failsafe,
        wpNum = wpNum,
        wpDistance = wpDistance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HighLatency =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u)

    public var customMode: UInt = 0u

    public var landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u)

    public var roll: Short = 0

    public var pitch: Short = 0

    public var heading: UShort = 0u

    public var throttle: Byte = 0

    public var headingSp: Short = 0

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitudeAmsl: Short = 0

    public var altitudeSp: Short = 0

    public var airspeed: UByte = 0u

    public var airspeedSp: UByte = 0u

    public var groundspeed: UByte = 0u

    public var climbRate: Byte = 0

    public var gpsNsat: UByte = 0u

    public var gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0u)

    public var batteryRemaining: UByte = 0u

    public var temperature: Byte = 0

    public var temperatureAir: Byte = 0

    public var failsafe: UByte = 0u

    public var wpNum: UByte = 0u

    public var wpDistance: UShort = 0u

    public fun build(): HighLatency = HighLatency(
      baseMode = baseMode,
      customMode = customMode,
      landedState = landedState,
      roll = roll,
      pitch = pitch,
      heading = heading,
      throttle = throttle,
      headingSp = headingSp,
      latitude = latitude,
      longitude = longitude,
      altitudeAmsl = altitudeAmsl,
      altitudeSp = altitudeSp,
      airspeed = airspeed,
      airspeedSp = airspeedSp,
      groundspeed = groundspeed,
      climbRate = climbRate,
      gpsNsat = gpsNsat,
      gpsFixType = gpsFixType,
      batteryRemaining = batteryRemaining,
      temperature = temperature,
      temperatureAir = temperatureAir,
      failsafe = failsafe,
      wpNum = wpNum,
      wpDistance = wpDistance,
    )
  }
}
