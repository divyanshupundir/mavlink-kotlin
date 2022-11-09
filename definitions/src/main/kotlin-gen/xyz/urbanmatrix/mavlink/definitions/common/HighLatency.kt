package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
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
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Message appropriate for high latency connections like Iridium
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 234,
  crc = 150,
)
public data class HighLatency(
  /**
   * Bitmap of enabled system modes.
   */
  @GeneratedMavField(type = "uint8_t")
  public val baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0),
  /**
   * A bitfield for use for autopilot-specific flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: Long = 0L,
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0),
  /**
   * roll
   */
  @GeneratedMavField(type = "int16_t")
  public val roll: Int = 0,
  /**
   * pitch
   */
  @GeneratedMavField(type = "int16_t")
  public val pitch: Int = 0,
  /**
   * heading
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: Int = 0,
  /**
   * throttle (percentage)
   */
  @GeneratedMavField(type = "int8_t")
  public val throttle: Int = 0,
  /**
   * heading setpoint
   */
  @GeneratedMavField(type = "int16_t")
  public val headingSp: Int = 0,
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
  public val altitudeAmsl: Int = 0,
  /**
   * Altitude setpoint relative to the home position
   */
  @GeneratedMavField(type = "int16_t")
  public val altitudeSp: Int = 0,
  /**
   * airspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeed: Int = 0,
  /**
   * airspeed setpoint
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeedSp: Int = 0,
  /**
   * groundspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val groundspeed: Int = 0,
  /**
   * climb rate
   */
  @GeneratedMavField(type = "int8_t")
  public val climbRate: Int = 0,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsNsat: Int = 0,
  /**
   * GPS Fix type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0),
  /**
   * Remaining battery (percentage)
   */
  @GeneratedMavField(type = "uint8_t")
  public val batteryRemaining: Int = 0,
  /**
   * Autopilot temperature (degrees C)
   */
  @GeneratedMavField(type = "int8_t")
  public val temperature: Int = 0,
  /**
   * Air temperature (degrees C) from airspeed sensor
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureAir: Int = 0,
  /**
   * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt,
   * bit2:GPS, bit3:GCS, bit4:fence)
   */
  @GeneratedMavField(type = "uint8_t")
  public val failsafe: Int = 0,
  /**
   * current waypoint number
   */
  @GeneratedMavField(type = "uint8_t")
  public val wpNum: Int = 0,
  /**
   * distance to target
   */
  @GeneratedMavField(type = "uint16_t")
  public val wpDistance: Int = 0,
) : MavMessage<HighLatency> {
  public override val instanceMetadata: MavMessage.Metadata<HighLatency> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt16(roll)
    outputBuffer.encodeInt16(pitch)
    outputBuffer.encodeUint16(heading)
    outputBuffer.encodeInt16(headingSp)
    outputBuffer.encodeInt16(altitudeAmsl)
    outputBuffer.encodeInt16(altitudeSp)
    outputBuffer.encodeUint16(wpDistance)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(landedState.value, 1)
    outputBuffer.encodeInt8(throttle)
    outputBuffer.encodeUint8(airspeed)
    outputBuffer.encodeUint8(airspeedSp)
    outputBuffer.encodeUint8(groundspeed)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeUint8(gpsNsat)
    outputBuffer.encodeEnumValue(gpsFixType.value, 1)
    outputBuffer.encodeUint8(batteryRemaining)
    outputBuffer.encodeInt8(temperature)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeUint8(failsafe)
    outputBuffer.encodeUint8(wpNum)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt16(roll)
    outputBuffer.encodeInt16(pitch)
    outputBuffer.encodeUint16(heading)
    outputBuffer.encodeInt16(headingSp)
    outputBuffer.encodeInt16(altitudeAmsl)
    outputBuffer.encodeInt16(altitudeSp)
    outputBuffer.encodeUint16(wpDistance)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(landedState.value, 1)
    outputBuffer.encodeInt8(throttle)
    outputBuffer.encodeUint8(airspeed)
    outputBuffer.encodeUint8(airspeedSp)
    outputBuffer.encodeUint8(groundspeed)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeUint8(gpsNsat)
    outputBuffer.encodeEnumValue(gpsFixType.value, 1)
    outputBuffer.encodeUint8(batteryRemaining)
    outputBuffer.encodeInt8(temperature)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeUint8(failsafe)
    outputBuffer.encodeUint8(wpNum)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 234

    private const val CRC: Int = 150

    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    private val DESERIALIZER: MavDeserializer<HighLatency> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val customMode = inputBuffer.decodeUint32()
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val roll = inputBuffer.decodeInt16()
      val pitch = inputBuffer.decodeInt16()
      val heading = inputBuffer.decodeUint16()
      val headingSp = inputBuffer.decodeInt16()
      val altitudeAmsl = inputBuffer.decodeInt16()
      val altitudeSp = inputBuffer.decodeInt16()
      val wpDistance = inputBuffer.decodeUint16()
      val baseMode = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val landedState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val throttle = inputBuffer.decodeInt8()
      val airspeed = inputBuffer.decodeUint8()
      val airspeedSp = inputBuffer.decodeUint8()
      val groundspeed = inputBuffer.decodeUint8()
      val climbRate = inputBuffer.decodeInt8()
      val gpsNsat = inputBuffer.decodeUint8()
      val gpsFixType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val batteryRemaining = inputBuffer.decodeUint8()
      val temperature = inputBuffer.decodeInt8()
      val temperatureAir = inputBuffer.decodeInt8()
      val failsafe = inputBuffer.decodeUint8()
      val wpNum = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<HighLatency> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HighLatency> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0)

    public var customMode: Long = 0L

    public var landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0)

    public var roll: Int = 0

    public var pitch: Int = 0

    public var heading: Int = 0

    public var throttle: Int = 0

    public var headingSp: Int = 0

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitudeAmsl: Int = 0

    public var altitudeSp: Int = 0

    public var airspeed: Int = 0

    public var airspeedSp: Int = 0

    public var groundspeed: Int = 0

    public var climbRate: Int = 0

    public var gpsNsat: Int = 0

    public var gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0)

    public var batteryRemaining: Int = 0

    public var temperature: Int = 0

    public var temperatureAir: Int = 0

    public var failsafe: Int = 0

    public var wpNum: Int = 0

    public var wpDistance: Int = 0

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
