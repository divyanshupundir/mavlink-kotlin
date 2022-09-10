package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.definitions.minimal.MavAutopilot
import xyz.urbanmatrix.mavlink.definitions.minimal.MavType
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Message appropriate for high latency connections like Iridium (version 2)
 */
@GeneratedMavMessage(
  id = 235,
  crc = 179,
)
public data class HighLatency2(
  /**
   * Timestamp (milliseconds since boot or Unix epoch)
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: Long = 0L,
  /**
   * Type of the MAV (quadrotor, helicopter, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavType> = MavEnumValue.fromValue(0),
  /**
   * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight
   * controllers.
   */
  @GeneratedMavField(type = "uint8_t")
  public val autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0),
  /**
   * A bitfield for use for autopilot-specific flags (2 byte version).
   */
  @GeneratedMavField(type = "uint16_t")
  public val customMode: Int = 0,
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
  public val altitude: Int = 0,
  /**
   * Altitude setpoint
   */
  @GeneratedMavField(type = "int16_t")
  public val targetAltitude: Int = 0,
  /**
   * Heading
   */
  @GeneratedMavField(type = "uint8_t")
  public val heading: Int = 0,
  /**
   * Heading setpoint
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetHeading: Int = 0,
  /**
   * Distance to target waypoint or position
   */
  @GeneratedMavField(type = "uint16_t")
  public val targetDistance: Int = 0,
  /**
   * Throttle
   */
  @GeneratedMavField(type = "uint8_t")
  public val throttle: Int = 0,
  /**
   * Airspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeed: Int = 0,
  /**
   * Airspeed setpoint
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeedSp: Int = 0,
  /**
   * Groundspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val groundspeed: Int = 0,
  /**
   * Windspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val windspeed: Int = 0,
  /**
   * Wind heading
   */
  @GeneratedMavField(type = "uint8_t")
  public val windHeading: Int = 0,
  /**
   * Maximum error horizontal position since last message
   */
  @GeneratedMavField(type = "uint8_t")
  public val eph: Int = 0,
  /**
   * Maximum error vertical position since last message
   */
  @GeneratedMavField(type = "uint8_t")
  public val epv: Int = 0,
  /**
   * Air temperature from airspeed sensor
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureAir: Int = 0,
  /**
   * Maximum climb rate magnitude since last message
   */
  @GeneratedMavField(type = "int8_t")
  public val climbRate: Int = 0,
  /**
   * Battery level (-1 if field not provided).
   */
  @GeneratedMavField(type = "int8_t")
  public val battery: Int = 0,
  /**
   * Current waypoint number
   */
  @GeneratedMavField(type = "uint16_t")
  public val wpNum: Int = 0,
  /**
   * Bitmap of failure flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val failureFlags: MavEnumValue<HlFailureFlag> = MavEnumValue.fromValue(0),
  /**
   * Field for custom payload.
   */
  @GeneratedMavField(type = "int8_t")
  public val custom0: Int = 0,
  /**
   * Field for custom payload.
   */
  @GeneratedMavField(type = "int8_t")
  public val custom1: Int = 0,
  /**
   * Field for custom payload.
   */
  @GeneratedMavField(type = "int8_t")
  public val custom2: Int = 0,
) : MavMessage<HighLatency2> {
  public override val instanceMetadata: MavMessage.Metadata<HighLatency2> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timestamp)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeUint16(customMode)
    outputBuffer.encodeInt16(altitude)
    outputBuffer.encodeInt16(targetAltitude)
    outputBuffer.encodeUint16(targetDistance)
    outputBuffer.encodeUint16(wpNum)
    outputBuffer.encodeEnumValue(failureFlags.value, 2)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeUint8(heading)
    outputBuffer.encodeUint8(targetHeading)
    outputBuffer.encodeUint8(throttle)
    outputBuffer.encodeUint8(airspeed)
    outputBuffer.encodeUint8(airspeedSp)
    outputBuffer.encodeUint8(groundspeed)
    outputBuffer.encodeUint8(windspeed)
    outputBuffer.encodeUint8(windHeading)
    outputBuffer.encodeUint8(eph)
    outputBuffer.encodeUint8(epv)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeInt8(battery)
    outputBuffer.encodeInt8(custom0)
    outputBuffer.encodeInt8(custom1)
    outputBuffer.encodeInt8(custom2)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timestamp)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeUint16(customMode)
    outputBuffer.encodeInt16(altitude)
    outputBuffer.encodeInt16(targetAltitude)
    outputBuffer.encodeUint16(targetDistance)
    outputBuffer.encodeUint16(wpNum)
    outputBuffer.encodeEnumValue(failureFlags.value, 2)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeUint8(heading)
    outputBuffer.encodeUint8(targetHeading)
    outputBuffer.encodeUint8(throttle)
    outputBuffer.encodeUint8(airspeed)
    outputBuffer.encodeUint8(airspeedSp)
    outputBuffer.encodeUint8(groundspeed)
    outputBuffer.encodeUint8(windspeed)
    outputBuffer.encodeUint8(windHeading)
    outputBuffer.encodeUint8(eph)
    outputBuffer.encodeUint8(epv)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeInt8(battery)
    outputBuffer.encodeInt8(custom0)
    outputBuffer.encodeInt8(custom1)
    outputBuffer.encodeInt8(custom2)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 235

    private const val CRC: Int = 179

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    private val DESERIALIZER: MavDeserializer<HighLatency2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint32()
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val customMode = inputBuffer.decodeUint16()
      val altitude = inputBuffer.decodeInt16()
      val targetAltitude = inputBuffer.decodeInt16()
      val targetDistance = inputBuffer.decodeUint16()
      val wpNum = inputBuffer.decodeUint16()
      val failureFlags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = HlFailureFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val heading = inputBuffer.decodeUint8()
      val targetHeading = inputBuffer.decodeUint8()
      val throttle = inputBuffer.decodeUint8()
      val airspeed = inputBuffer.decodeUint8()
      val airspeedSp = inputBuffer.decodeUint8()
      val groundspeed = inputBuffer.decodeUint8()
      val windspeed = inputBuffer.decodeUint8()
      val windHeading = inputBuffer.decodeUint8()
      val eph = inputBuffer.decodeUint8()
      val epv = inputBuffer.decodeUint8()
      val temperatureAir = inputBuffer.decodeInt8()
      val climbRate = inputBuffer.decodeInt8()
      val battery = inputBuffer.decodeInt8()
      val custom0 = inputBuffer.decodeInt8()
      val custom1 = inputBuffer.decodeInt8()
      val custom2 = inputBuffer.decodeInt8()

      HighLatency2(
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


    private val METADATA: MavMessage.Metadata<HighLatency2> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HighLatency2> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: Long = 0L

    public var type: MavEnumValue<MavType> = MavEnumValue.fromValue(0)

    public var autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0)

    public var customMode: Int = 0

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitude: Int = 0

    public var targetAltitude: Int = 0

    public var heading: Int = 0

    public var targetHeading: Int = 0

    public var targetDistance: Int = 0

    public var throttle: Int = 0

    public var airspeed: Int = 0

    public var airspeedSp: Int = 0

    public var groundspeed: Int = 0

    public var windspeed: Int = 0

    public var windHeading: Int = 0

    public var eph: Int = 0

    public var epv: Int = 0

    public var temperatureAir: Int = 0

    public var climbRate: Int = 0

    public var battery: Int = 0

    public var wpNum: Int = 0

    public var failureFlags: MavEnumValue<HlFailureFlag> = MavEnumValue.fromValue(0)

    public var custom0: Int = 0

    public var custom1: Int = 0

    public var custom2: Int = 0

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
