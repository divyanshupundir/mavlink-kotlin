package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.definitions.minimal.MavModeFlag
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<HighLatency> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(customMode)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt16(roll)
    outputBuffer.encodeInt16(pitch)
    outputBuffer.encodeUInt16(heading)
    outputBuffer.encodeInt16(headingSp)
    outputBuffer.encodeInt16(altitudeAmsl)
    outputBuffer.encodeInt16(altitudeSp)
    outputBuffer.encodeUInt16(wpDistance)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(landedState.value, 1)
    outputBuffer.encodeInt8(throttle)
    outputBuffer.encodeUInt8(airspeed)
    outputBuffer.encodeUInt8(airspeedSp)
    outputBuffer.encodeUInt8(groundspeed)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeUInt8(gpsNsat)
    outputBuffer.encodeEnumValue(gpsFixType.value, 1)
    outputBuffer.encodeUInt8(batteryRemaining)
    outputBuffer.encodeInt8(temperature)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeUInt8(failsafe)
    outputBuffer.encodeUInt8(wpNum)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(customMode)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt16(roll)
    outputBuffer.encodeInt16(pitch)
    outputBuffer.encodeUInt16(heading)
    outputBuffer.encodeInt16(headingSp)
    outputBuffer.encodeInt16(altitudeAmsl)
    outputBuffer.encodeInt16(altitudeSp)
    outputBuffer.encodeUInt16(wpDistance)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(landedState.value, 1)
    outputBuffer.encodeInt8(throttle)
    outputBuffer.encodeUInt8(airspeed)
    outputBuffer.encodeUInt8(airspeedSp)
    outputBuffer.encodeUInt8(groundspeed)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeUInt8(gpsNsat)
    outputBuffer.encodeEnumValue(gpsFixType.value, 1)
    outputBuffer.encodeUInt8(batteryRemaining)
    outputBuffer.encodeInt8(temperature)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeUInt8(failsafe)
    outputBuffer.encodeUInt8(wpNum)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 234u

    private const val CRC_EXTRA: Byte = -106

    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    private val DESERIALIZER: MavDeserializer<HighLatency> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val customMode = inputBuffer.decodeUInt32()
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val roll = inputBuffer.decodeInt16()
      val pitch = inputBuffer.decodeInt16()
      val heading = inputBuffer.decodeUInt16()
      val headingSp = inputBuffer.decodeInt16()
      val altitudeAmsl = inputBuffer.decodeInt16()
      val altitudeSp = inputBuffer.decodeInt16()
      val wpDistance = inputBuffer.decodeUInt16()
      val baseMode = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val landedState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val throttle = inputBuffer.decodeInt8()
      val airspeed = inputBuffer.decodeUInt8()
      val airspeedSp = inputBuffer.decodeUInt8()
      val groundspeed = inputBuffer.decodeUInt8()
      val climbRate = inputBuffer.decodeInt8()
      val gpsNsat = inputBuffer.decodeUInt8()
      val gpsFixType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val batteryRemaining = inputBuffer.decodeUInt8()
      val temperature = inputBuffer.decodeInt8()
      val temperatureAir = inputBuffer.decodeInt8()
      val failsafe = inputBuffer.decodeUInt8()
      val wpNum = inputBuffer.decodeUInt8()

      HighLatency(
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


    private val METADATA: MavMessage.Metadata<HighLatency> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HighLatency> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HighLatency =
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
