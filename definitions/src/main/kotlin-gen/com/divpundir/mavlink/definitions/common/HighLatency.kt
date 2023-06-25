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
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(customMode)
    buffer.encodeInt32(latitude)
    buffer.encodeInt32(longitude)
    buffer.encodeInt16(roll)
    buffer.encodeInt16(pitch)
    buffer.encodeUInt16(heading)
    buffer.encodeInt16(headingSp)
    buffer.encodeInt16(altitudeAmsl)
    buffer.encodeInt16(altitudeSp)
    buffer.encodeUInt16(wpDistance)
    buffer.encodeBitmaskValue(baseMode.value, 1)
    buffer.encodeEnumValue(landedState.value, 1)
    buffer.encodeInt8(throttle)
    buffer.encodeUInt8(airspeed)
    buffer.encodeUInt8(airspeedSp)
    buffer.encodeUInt8(groundspeed)
    buffer.encodeInt8(climbRate)
    buffer.encodeUInt8(gpsNsat)
    buffer.encodeEnumValue(gpsFixType.value, 1)
    buffer.encodeUInt8(batteryRemaining)
    buffer.encodeInt8(temperature)
    buffer.encodeInt8(temperatureAir)
    buffer.encodeUInt8(failsafe)
    buffer.encodeUInt8(wpNum)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(customMode)
    buffer.encodeInt32(latitude)
    buffer.encodeInt32(longitude)
    buffer.encodeInt16(roll)
    buffer.encodeInt16(pitch)
    buffer.encodeUInt16(heading)
    buffer.encodeInt16(headingSp)
    buffer.encodeInt16(altitudeAmsl)
    buffer.encodeInt16(altitudeSp)
    buffer.encodeUInt16(wpDistance)
    buffer.encodeBitmaskValue(baseMode.value, 1)
    buffer.encodeEnumValue(landedState.value, 1)
    buffer.encodeInt8(throttle)
    buffer.encodeUInt8(airspeed)
    buffer.encodeUInt8(airspeedSp)
    buffer.encodeUInt8(groundspeed)
    buffer.encodeInt8(climbRate)
    buffer.encodeUInt8(gpsNsat)
    buffer.encodeEnumValue(gpsFixType.value, 1)
    buffer.encodeUInt8(batteryRemaining)
    buffer.encodeInt8(temperature)
    buffer.encodeInt8(temperatureAir)
    buffer.encodeUInt8(failsafe)
    buffer.encodeUInt8(wpNum)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HighLatency> {
    public override val id: UInt = 234u

    public override val crcExtra: Byte = -106

    public override fun deserialize(bytes: ByteArray): HighLatency {
      val buffer = Buffer().write(bytes)

      val customMode = buffer.decodeUInt32()
      val latitude = buffer.decodeInt32()
      val longitude = buffer.decodeInt32()
      val roll = buffer.decodeInt16()
      val pitch = buffer.decodeInt16()
      val heading = buffer.decodeUInt16()
      val headingSp = buffer.decodeInt16()
      val altitudeAmsl = buffer.decodeInt16()
      val altitudeSp = buffer.decodeInt16()
      val wpDistance = buffer.decodeUInt16()
      val baseMode = buffer.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val landedState = buffer.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val throttle = buffer.decodeInt8()
      val airspeed = buffer.decodeUInt8()
      val airspeedSp = buffer.decodeUInt8()
      val groundspeed = buffer.decodeUInt8()
      val climbRate = buffer.decodeInt8()
      val gpsNsat = buffer.decodeUInt8()
      val gpsFixType = buffer.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val batteryRemaining = buffer.decodeUInt8()
      val temperature = buffer.decodeInt8()
      val temperatureAir = buffer.decodeInt8()
      val failsafe = buffer.decodeUInt8()
      val wpNum = buffer.decodeUInt8()

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
