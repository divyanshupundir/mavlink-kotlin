package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.definitions.minimal.MavModeFlag
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
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long

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
  public val baseMode: MavEnumValue<MavModeFlag> = MavEnumValue.fromValue(0),
  /**
   * A bitfield for use for autopilot-specific flags.
   */
  public val customMode: Long = 0L,
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0),
  /**
   * roll
   */
  public val roll: Int = 0,
  /**
   * pitch
   */
  public val pitch: Int = 0,
  /**
   * heading
   */
  public val heading: Int = 0,
  /**
   * throttle (percentage)
   */
  public val throttle: Int = 0,
  /**
   * heading setpoint
   */
  public val headingSp: Int = 0,
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
  public val altitudeAmsl: Int = 0,
  /**
   * Altitude setpoint relative to the home position
   */
  public val altitudeSp: Int = 0,
  /**
   * airspeed
   */
  public val airspeed: Int = 0,
  /**
   * airspeed setpoint
   */
  public val airspeedSp: Int = 0,
  /**
   * groundspeed
   */
  public val groundspeed: Int = 0,
  /**
   * climb rate
   */
  public val climbRate: Int = 0,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  public val gpsNsat: Int = 0,
  /**
   * GPS Fix type.
   */
  public val gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0),
  /**
   * Remaining battery (percentage)
   */
  public val batteryRemaining: Int = 0,
  /**
   * Autopilot temperature (degrees C)
   */
  public val temperature: Int = 0,
  /**
   * Air temperature (degrees C) from airspeed sensor
   */
  public val temperatureAir: Int = 0,
  /**
   * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt,
   * bit2:GPS, bit3:GCS, bit4:fence)
   */
  public val failsafe: Int = 0,
  /**
   * current waypoint number
   */
  public val wpNum: Int = 0,
  /**
   * distance to target
   */
  public val wpDistance: Int = 0,
) : MavMessage<HighLatency> {
  public override val instanceMetadata: MavMessage.Metadata<HighLatency> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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
    outputBuffer.encodeEnumValue(baseMode.value, 1)
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

  public companion object {
    private const val ID: Int = 234

    private const val CRC: Int = 150

    private const val SIZE: Int = 40

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
      val baseMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavModeFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
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
  }
}
