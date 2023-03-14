package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
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
import xyz.urbanmatrix.mavlink.definitions.minimal.MavAutopilot
import xyz.urbanmatrix.mavlink.definitions.minimal.MavType
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
  public override val instanceMetadata: MavMessage.Metadata<HighLatency2> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timestamp)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeUInt16(customMode)
    outputBuffer.encodeInt16(altitude)
    outputBuffer.encodeInt16(targetAltitude)
    outputBuffer.encodeUInt16(targetDistance)
    outputBuffer.encodeUInt16(wpNum)
    outputBuffer.encodeBitmaskValue(failureFlags.value, 2)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeUInt8(heading)
    outputBuffer.encodeUInt8(targetHeading)
    outputBuffer.encodeUInt8(throttle)
    outputBuffer.encodeUInt8(airspeed)
    outputBuffer.encodeUInt8(airspeedSp)
    outputBuffer.encodeUInt8(groundspeed)
    outputBuffer.encodeUInt8(windspeed)
    outputBuffer.encodeUInt8(windHeading)
    outputBuffer.encodeUInt8(eph)
    outputBuffer.encodeUInt8(epv)
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
    outputBuffer.encodeUInt32(timestamp)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeUInt16(customMode)
    outputBuffer.encodeInt16(altitude)
    outputBuffer.encodeInt16(targetAltitude)
    outputBuffer.encodeUInt16(targetDistance)
    outputBuffer.encodeUInt16(wpNum)
    outputBuffer.encodeBitmaskValue(failureFlags.value, 2)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeUInt8(heading)
    outputBuffer.encodeUInt8(targetHeading)
    outputBuffer.encodeUInt8(throttle)
    outputBuffer.encodeUInt8(airspeed)
    outputBuffer.encodeUInt8(airspeedSp)
    outputBuffer.encodeUInt8(groundspeed)
    outputBuffer.encodeUInt8(windspeed)
    outputBuffer.encodeUInt8(windHeading)
    outputBuffer.encodeUInt8(eph)
    outputBuffer.encodeUInt8(epv)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeInt8(battery)
    outputBuffer.encodeInt8(custom0)
    outputBuffer.encodeInt8(custom1)
    outputBuffer.encodeInt8(custom2)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 235u

    private const val CRC_EXTRA: Byte = -77

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    private val DESERIALIZER: MavDeserializer<HighLatency2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt32()
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val customMode = inputBuffer.decodeUInt16()
      val altitude = inputBuffer.decodeInt16()
      val targetAltitude = inputBuffer.decodeInt16()
      val targetDistance = inputBuffer.decodeUInt16()
      val wpNum = inputBuffer.decodeUInt16()
      val failureFlags = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = HlFailureFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val heading = inputBuffer.decodeUInt8()
      val targetHeading = inputBuffer.decodeUInt8()
      val throttle = inputBuffer.decodeUInt8()
      val airspeed = inputBuffer.decodeUInt8()
      val airspeedSp = inputBuffer.decodeUInt8()
      val groundspeed = inputBuffer.decodeUInt8()
      val windspeed = inputBuffer.decodeUInt8()
      val windHeading = inputBuffer.decodeUInt8()
      val eph = inputBuffer.decodeUInt8()
      val epv = inputBuffer.decodeUInt8()
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


    private val METADATA: MavMessage.Metadata<HighLatency2> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HighLatency2> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HighLatency2 =
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
