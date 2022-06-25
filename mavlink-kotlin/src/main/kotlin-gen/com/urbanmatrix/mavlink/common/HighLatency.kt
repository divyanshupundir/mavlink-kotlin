package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.minimal.MavModeFlag
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
public data class HighLatency(
  /**
   * Longitude
   */
  public val longitude: Int = 0,
  /**
   * Latitude
   */
  public val latitude: Int = 0,
  /**
   * A bitfield for use for autopilot-specific flags.
   */
  public val customMode: Long = 0L,
  /**
   * distance to target
   */
  public val wpDistance: Int = 0,
  /**
   * Altitude setpoint relative to the home position
   */
  public val altitudeSp: Int = 0,
  /**
   * Altitude above mean sea level
   */
  public val altitudeAmsl: Int = 0,
  /**
   * heading setpoint
   */
  public val headingSp: Int = 0,
  /**
   * heading
   */
  public val heading: Int = 0,
  /**
   * pitch
   */
  public val pitch: Int = 0,
  /**
   * roll
   */
  public val roll: Int = 0,
  /**
   * current waypoint number
   */
  public val wpNum: Int = 0,
  /**
   * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt,
   * bit2:GPS, bit3:GCS, bit4:fence)
   */
  public val failsafe: Int = 0,
  /**
   * Air temperature (degrees C) from airspeed sensor
   */
  public val temperatureAir: Int = 0,
  /**
   * Autopilot temperature (degrees C)
   */
  public val temperature: Int = 0,
  /**
   * Remaining battery (percentage)
   */
  public val batteryRemaining: Int = 0,
  /**
   * GPS Fix type.
   */
  public val gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0),
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  public val gpsNsat: Int = 0,
  /**
   * climb rate
   */
  public val climbRate: Int = 0,
  /**
   * groundspeed
   */
  public val groundspeed: Int = 0,
  /**
   * airspeed setpoint
   */
  public val airspeedSp: Int = 0,
  /**
   * airspeed
   */
  public val airspeed: Int = 0,
  /**
   * throttle (percentage)
   */
  public val throttle: Int = 0,
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0),
  /**
   * Bitmap of enabled system modes.
   */
  public val baseMode: MavEnumValue<MavModeFlag> = MavEnumValue.fromValue(0),
) : MavMessage<HighLatency> {
  public override val instanceMetadata: MavMessage.Metadata<HighLatency> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeUint16(wpDistance)
    outputBuffer.encodeInt16(altitudeSp)
    outputBuffer.encodeInt16(altitudeAmsl)
    outputBuffer.encodeInt16(headingSp)
    outputBuffer.encodeUint16(heading)
    outputBuffer.encodeInt16(pitch)
    outputBuffer.encodeInt16(roll)
    outputBuffer.encodeUint8(wpNum)
    outputBuffer.encodeUint8(failsafe)
    outputBuffer.encodeInt8(temperatureAir)
    outputBuffer.encodeInt8(temperature)
    outputBuffer.encodeUint8(batteryRemaining)
    outputBuffer.encodeEnumValue(gpsFixType.value, 1)
    outputBuffer.encodeUint8(gpsNsat)
    outputBuffer.encodeInt8(climbRate)
    outputBuffer.encodeUint8(groundspeed)
    outputBuffer.encodeUint8(airspeedSp)
    outputBuffer.encodeUint8(airspeed)
    outputBuffer.encodeInt8(throttle)
    outputBuffer.encodeEnumValue(landedState.value, 1)
    outputBuffer.encodeEnumValue(baseMode.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 234

    private const val CRC: Int = 225

    private val DESERIALIZER: MavDeserializer<HighLatency> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val longitude = inputBuffer.decodeInt32()
      val latitude = inputBuffer.decodeInt32()
      val customMode = inputBuffer.decodeUint32()
      val wpDistance = inputBuffer.decodeUint16()
      val altitudeSp = inputBuffer.decodeInt16()
      val altitudeAmsl = inputBuffer.decodeInt16()
      val headingSp = inputBuffer.decodeInt16()
      val heading = inputBuffer.decodeUint16()
      val pitch = inputBuffer.decodeInt16()
      val roll = inputBuffer.decodeInt16()
      val wpNum = inputBuffer.decodeUint8()
      val failsafe = inputBuffer.decodeUint8()
      val temperatureAir = inputBuffer.decodeInt8()
      val temperature = inputBuffer.decodeInt8()
      val batteryRemaining = inputBuffer.decodeUint8()
      val gpsFixType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gpsNsat = inputBuffer.decodeUint8()
      val climbRate = inputBuffer.decodeInt8()
      val groundspeed = inputBuffer.decodeUint8()
      val airspeedSp = inputBuffer.decodeUint8()
      val airspeed = inputBuffer.decodeUint8()
      val throttle = inputBuffer.decodeInt8()
      val landedState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val baseMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavModeFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      HighLatency(
        longitude = longitude,
        latitude = latitude,
        customMode = customMode,
        wpDistance = wpDistance,
        altitudeSp = altitudeSp,
        altitudeAmsl = altitudeAmsl,
        headingSp = headingSp,
        heading = heading,
        pitch = pitch,
        roll = roll,
        wpNum = wpNum,
        failsafe = failsafe,
        temperatureAir = temperatureAir,
        temperature = temperature,
        batteryRemaining = batteryRemaining,
        gpsFixType = gpsFixType,
        gpsNsat = gpsNsat,
        climbRate = climbRate,
        groundspeed = groundspeed,
        airspeedSp = airspeedSp,
        airspeed = airspeed,
        throttle = throttle,
        landedState = landedState,
        baseMode = baseMode,
      )
    }


    private val METADATA: MavMessage.Metadata<HighLatency> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HighLatency> = METADATA
  }
}
