package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.definitions.minimal.MavAutopilot
import com.urbanmatrix.mavlink.definitions.minimal.MavType
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeInt8
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeInt8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Message appropriate for high latency connections like Iridium (version 2)
 */
public data class HighLatency2(
  /**
   * Timestamp (milliseconds since boot or Unix epoch)
   */
  public val timestamp: Long = 0L,
  /**
   * Type of the MAV (quadrotor, helicopter, etc.)
   */
  public val type: MavEnumValue<MavType> = MavEnumValue.fromValue(0),
  /**
   * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight
   * controllers.
   */
  public val autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0),
  /**
   * A bitfield for use for autopilot-specific flags (2 byte version).
   */
  public val customMode: Int = 0,
  /**
   * Latitude
   */
  public val latitude: Int = 0,
  /**
   * Longitude
   */
  public val longitude: Int = 0,
  /**
   * Altitude above mean sea level
   */
  public val altitude: Int = 0,
  /**
   * Altitude setpoint
   */
  public val targetAltitude: Int = 0,
  /**
   * Heading
   */
  public val heading: Int = 0,
  /**
   * Heading setpoint
   */
  public val targetHeading: Int = 0,
  /**
   * Distance to target waypoint or position
   */
  public val targetDistance: Int = 0,
  /**
   * Throttle
   */
  public val throttle: Int = 0,
  /**
   * Airspeed
   */
  public val airspeed: Int = 0,
  /**
   * Airspeed setpoint
   */
  public val airspeedSp: Int = 0,
  /**
   * Groundspeed
   */
  public val groundspeed: Int = 0,
  /**
   * Windspeed
   */
  public val windspeed: Int = 0,
  /**
   * Wind heading
   */
  public val windHeading: Int = 0,
  /**
   * Maximum error horizontal position since last message
   */
  public val eph: Int = 0,
  /**
   * Maximum error vertical position since last message
   */
  public val epv: Int = 0,
  /**
   * Air temperature from airspeed sensor
   */
  public val temperatureAir: Int = 0,
  /**
   * Maximum climb rate magnitude since last message
   */
  public val climbRate: Int = 0,
  /**
   * Battery level (-1 if field not provided).
   */
  public val battery: Int = 0,
  /**
   * Current waypoint number
   */
  public val wpNum: Int = 0,
  /**
   * Bitmap of failure flags.
   */
  public val failureFlags: MavEnumValue<HlFailureFlag> = MavEnumValue.fromValue(0),
  /**
   * Field for custom payload.
   */
  public val custom0: Int = 0,
  /**
   * Field for custom payload.
   */
  public val custom1: Int = 0,
  /**
   * Field for custom payload.
   */
  public val custom2: Int = 0,
) : MavMessage<HighLatency2> {
  public override val instanceMetadata: MavMessage.Metadata<HighLatency2> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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

  public companion object {
    private const val ID: Int = 235

    private const val CRC: Int = 179

    private const val SIZE: Int = 42

    private val DESERIALIZER: MavDeserializer<HighLatency2> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for HighLatency2: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
  }
}
