package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * ID of the GPS for multiple GPS inputs
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsId: Int = 0,
  /**
   * Bitmap indicating which GPS input flags fields to ignore.  All other fields must be provided.
   */
  @GeneratedMavField(type = "uint16_t")
  public val ignoreFlags: MavBitmaskValue<GpsInputIgnoreFlags> = MavBitmaskValue.fromValue(0),
  /**
   * GPS time (from start of GPS week)
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeWeekMs: Long = 0L,
  /**
   * GPS week number
   */
  @GeneratedMavField(type = "uint16_t")
  public val timeWeek: Int = 0,
  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK
   */
  @GeneratedMavField(type = "uint8_t")
  public val fixType: Int = 0,
  /**
   * Latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "float")
  public val hdop: Float = 0F,
  /**
   * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "float")
  public val vdop: Float = 0F,
  /**
   * GPS velocity in north direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val vn: Float = 0F,
  /**
   * GPS velocity in east direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val ve: Float = 0F,
  /**
   * GPS velocity in down direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val vd: Float = 0F,
  /**
   * GPS speed accuracy
   */
  @GeneratedMavField(type = "float")
  public val speedAccuracy: Float = 0F,
  /**
   * GPS horizontal accuracy
   */
  @GeneratedMavField(type = "float")
  public val horizAccuracy: Float = 0F,
  /**
   * GPS vertical accuracy
   */
  @GeneratedMavField(type = "float")
  public val vertAccuracy: Float = 0F,
  /**
   * Number of satellites visible.
   */
  @GeneratedMavField(type = "uint8_t")
  public val satellitesVisible: Int = 0,
  /**
   * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: Int = 0,
) : MavMessage<GpsInput> {
  public override val instanceMetadata: MavMessage.Metadata<GpsInput> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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
    outputBuffer.encodeBitmaskValue(ignoreFlags.value, 2)
    outputBuffer.encodeUint16(timeWeek)
    outputBuffer.encodeUint8(gpsId)
    outputBuffer.encodeUint8(fixType)
    outputBuffer.encodeUint8(satellitesVisible)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    outputBuffer.encodeBitmaskValue(ignoreFlags.value, 2)
    outputBuffer.encodeUint16(timeWeek)
    outputBuffer.encodeUint8(gpsId)
    outputBuffer.encodeUint8(fixType)
    outputBuffer.encodeUint8(satellitesVisible)
    outputBuffer.encodeUint16(yaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 232

    private const val CRC: Int = 151

    private const val SIZE_V1: Int = 63

    private const val SIZE_V2: Int = 65

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
      val ignoreFlags = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = GpsInputIgnoreFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var gpsId: Int = 0

    public var ignoreFlags: MavBitmaskValue<GpsInputIgnoreFlags> = MavBitmaskValue.fromValue(0)

    public var timeWeekMs: Long = 0L

    public var timeWeek: Int = 0

    public var fixType: Int = 0

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Float = 0F

    public var hdop: Float = 0F

    public var vdop: Float = 0F

    public var vn: Float = 0F

    public var ve: Float = 0F

    public var vd: Float = 0F

    public var speedAccuracy: Float = 0F

    public var horizAccuracy: Float = 0F

    public var vertAccuracy: Float = 0F

    public var satellitesVisible: Int = 0

    public var yaw: Int = 0

    public fun build(): GpsInput = GpsInput(
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
}
