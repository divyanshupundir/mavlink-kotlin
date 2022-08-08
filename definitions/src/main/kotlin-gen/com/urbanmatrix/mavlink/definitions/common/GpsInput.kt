package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * GPS sensor input message.  This is a raw sensor value sent by the GPS. This is NOT the global
 * position estimate of the system.
 */
@GeneratedMavMessage(
  id = 232,
  crc = 151,
)
public data class GpsInput(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * ID of the GPS for multiple GPS inputs
   */
  public val gpsId: Int = 0,
  /**
   * Bitmap indicating which GPS input flags fields to ignore.  All other fields must be provided.
   */
  public val ignoreFlags: MavEnumValue<GpsInputIgnoreFlags> = MavEnumValue.fromValue(0),
  /**
   * GPS time (from start of GPS week)
   */
  public val timeWeekMs: Long = 0L,
  /**
   * GPS week number
   */
  public val timeWeek: Int = 0,
  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK
   */
  public val fixType: Int = 0,
  /**
   * Latitude (WGS84)
   */
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   */
  public val alt: Float = 0F,
  /**
   * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  public val hdop: Float = 0F,
  /**
   * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  public val vdop: Float = 0F,
  /**
   * GPS velocity in north direction in earth-fixed NED frame
   */
  public val vn: Float = 0F,
  /**
   * GPS velocity in east direction in earth-fixed NED frame
   */
  public val ve: Float = 0F,
  /**
   * GPS velocity in down direction in earth-fixed NED frame
   */
  public val vd: Float = 0F,
  /**
   * GPS speed accuracy
   */
  public val speedAccuracy: Float = 0F,
  /**
   * GPS horizontal accuracy
   */
  public val horizAccuracy: Float = 0F,
  /**
   * GPS vertical accuracy
   */
  public val vertAccuracy: Float = 0F,
  /**
   * Number of satellites visible.
   */
  public val satellitesVisible: Int = 0,
  /**
   * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north
   */
  public val yaw: Int = 0,
) : MavMessage<GpsInput> {
  public override val instanceMetadata: MavMessage.Metadata<GpsInput> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(timeWeekMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(hdop)
    outputBuffer.encodeFloat(vdop)
    outputBuffer.encodeFloat(vn)
    outputBuffer.encodeFloat(ve)
    outputBuffer.encodeFloat(vd)
    outputBuffer.encodeFloat(speedAccuracy)
    outputBuffer.encodeFloat(horizAccuracy)
    outputBuffer.encodeFloat(vertAccuracy)
    outputBuffer.encodeEnumValue(ignoreFlags.value, 2)
    outputBuffer.encodeUint16(timeWeek)
    outputBuffer.encodeUint8(gpsId)
    outputBuffer.encodeUint8(fixType)
    outputBuffer.encodeUint8(satellitesVisible)
    outputBuffer.encodeUint16(yaw)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 232

    private const val CRC: Int = 151

    private const val SIZE: Int = 65

    private val DESERIALIZER: MavDeserializer<GpsInput> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val timeWeekMs = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
      val hdop = inputBuffer.decodeFloat()
      val vdop = inputBuffer.decodeFloat()
      val vn = inputBuffer.decodeFloat()
      val ve = inputBuffer.decodeFloat()
      val vd = inputBuffer.decodeFloat()
      val speedAccuracy = inputBuffer.decodeFloat()
      val horizAccuracy = inputBuffer.decodeFloat()
      val vertAccuracy = inputBuffer.decodeFloat()
      val ignoreFlags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = GpsInputIgnoreFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val timeWeek = inputBuffer.decodeUint16()
      val gpsId = inputBuffer.decodeUint8()
      val fixType = inputBuffer.decodeUint8()
      val satellitesVisible = inputBuffer.decodeUint8()
      val yaw = inputBuffer.decodeUint16()

      GpsInput(
        timeUsec = timeUsec,
        gpsId = gpsId,
        ignoreFlags = ignoreFlags,
        timeWeekMs = timeWeekMs,
        timeWeek = timeWeek,
        fixType = fixType,
        lat = lat,
        lon = lon,
        alt = alt,
        hdop = hdop,
        vdop = vdop,
        vn = vn,
        ve = ve,
        vd = vd,
        speedAccuracy = speedAccuracy,
        horizAccuracy = horizAccuracy,
        vertAccuracy = vertAccuracy,
        satellitesVisible = satellitesVisible,
        yaw = yaw,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsInput> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsInput> = METADATA
  }
}
