package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A
 */
@GeneratedMavMessage(
  id = 170,
  crc = 103,
)
public data class SerialUdbExtraF2A(
  /**
   * Serial UDB Extra Time
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueTime: Long = 0L,
  /**
   * Serial UDB Extra Status
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueStatus: Int = 0,
  /**
   * Serial UDB Extra Latitude
   */
  @GeneratedMavField(type = "int32_t")
  public val sueLatitude: Int = 0,
  /**
   * Serial UDB Extra Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val sueLongitude: Int = 0,
  /**
   * Serial UDB Extra Altitude
   */
  @GeneratedMavField(type = "int32_t")
  public val sueAltitude: Int = 0,
  /**
   * Serial UDB Extra Waypoint Index
   */
  @GeneratedMavField(type = "uint16_t")
  public val sueWaypointIndex: Int = 0,
  /**
   * Serial UDB Extra Rmat 0
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat0: Int = 0,
  /**
   * Serial UDB Extra Rmat 1
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat1: Int = 0,
  /**
   * Serial UDB Extra Rmat 2
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat2: Int = 0,
  /**
   * Serial UDB Extra Rmat 3
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat3: Int = 0,
  /**
   * Serial UDB Extra Rmat 4
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat4: Int = 0,
  /**
   * Serial UDB Extra Rmat 5
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat5: Int = 0,
  /**
   * Serial UDB Extra Rmat 6
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat6: Int = 0,
  /**
   * Serial UDB Extra Rmat 7
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat7: Int = 0,
  /**
   * Serial UDB Extra Rmat 8
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat8: Int = 0,
  /**
   * Serial UDB Extra GPS Course Over Ground
   */
  @GeneratedMavField(type = "uint16_t")
  public val sueCog: Int = 0,
  /**
   * Serial UDB Extra Speed Over Ground
   */
  @GeneratedMavField(type = "int16_t")
  public val sueSog: Int = 0,
  /**
   * Serial UDB Extra CPU Load
   */
  @GeneratedMavField(type = "uint16_t")
  public val sueCpuLoad: Int = 0,
  /**
   * Serial UDB Extra 3D IMU Air Speed
   */
  @GeneratedMavField(type = "uint16_t")
  public val sueAirSpeed3dimu: Int = 0,
  /**
   * Serial UDB Extra Estimated Wind 0
   */
  @GeneratedMavField(type = "int16_t")
  public val sueEstimatedWind0: Int = 0,
  /**
   * Serial UDB Extra Estimated Wind 1
   */
  @GeneratedMavField(type = "int16_t")
  public val sueEstimatedWind1: Int = 0,
  /**
   * Serial UDB Extra Estimated Wind 2
   */
  @GeneratedMavField(type = "int16_t")
  public val sueEstimatedWind2: Int = 0,
  /**
   * Serial UDB Extra Magnetic Field Earth 0 
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMagfieldearth0: Int = 0,
  /**
   * Serial UDB Extra Magnetic Field Earth 1 
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMagfieldearth1: Int = 0,
  /**
   * Serial UDB Extra Magnetic Field Earth 2 
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMagfieldearth2: Int = 0,
  /**
   * Serial UDB Extra Number of Sattelites in View
   */
  @GeneratedMavField(type = "int16_t")
  public val sueSvs: Int = 0,
  /**
   * Serial UDB Extra GPS Horizontal Dilution of Precision
   */
  @GeneratedMavField(type = "int16_t")
  public val sueHdop: Int = 0,
) : MavMessage<SerialUdbExtraF2A> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF2A> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(sueTime)
    outputBuffer.encodeInt32(sueLatitude)
    outputBuffer.encodeInt32(sueLongitude)
    outputBuffer.encodeInt32(sueAltitude)
    outputBuffer.encodeUint16(sueWaypointIndex)
    outputBuffer.encodeInt16(sueRmat0)
    outputBuffer.encodeInt16(sueRmat1)
    outputBuffer.encodeInt16(sueRmat2)
    outputBuffer.encodeInt16(sueRmat3)
    outputBuffer.encodeInt16(sueRmat4)
    outputBuffer.encodeInt16(sueRmat5)
    outputBuffer.encodeInt16(sueRmat6)
    outputBuffer.encodeInt16(sueRmat7)
    outputBuffer.encodeInt16(sueRmat8)
    outputBuffer.encodeUint16(sueCog)
    outputBuffer.encodeInt16(sueSog)
    outputBuffer.encodeUint16(sueCpuLoad)
    outputBuffer.encodeUint16(sueAirSpeed3dimu)
    outputBuffer.encodeInt16(sueEstimatedWind0)
    outputBuffer.encodeInt16(sueEstimatedWind1)
    outputBuffer.encodeInt16(sueEstimatedWind2)
    outputBuffer.encodeInt16(sueMagfieldearth0)
    outputBuffer.encodeInt16(sueMagfieldearth1)
    outputBuffer.encodeInt16(sueMagfieldearth2)
    outputBuffer.encodeInt16(sueSvs)
    outputBuffer.encodeInt16(sueHdop)
    outputBuffer.encodeUint8(sueStatus)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(sueTime)
    outputBuffer.encodeInt32(sueLatitude)
    outputBuffer.encodeInt32(sueLongitude)
    outputBuffer.encodeInt32(sueAltitude)
    outputBuffer.encodeUint16(sueWaypointIndex)
    outputBuffer.encodeInt16(sueRmat0)
    outputBuffer.encodeInt16(sueRmat1)
    outputBuffer.encodeInt16(sueRmat2)
    outputBuffer.encodeInt16(sueRmat3)
    outputBuffer.encodeInt16(sueRmat4)
    outputBuffer.encodeInt16(sueRmat5)
    outputBuffer.encodeInt16(sueRmat6)
    outputBuffer.encodeInt16(sueRmat7)
    outputBuffer.encodeInt16(sueRmat8)
    outputBuffer.encodeUint16(sueCog)
    outputBuffer.encodeInt16(sueSog)
    outputBuffer.encodeUint16(sueCpuLoad)
    outputBuffer.encodeUint16(sueAirSpeed3dimu)
    outputBuffer.encodeInt16(sueEstimatedWind0)
    outputBuffer.encodeInt16(sueEstimatedWind1)
    outputBuffer.encodeInt16(sueEstimatedWind2)
    outputBuffer.encodeInt16(sueMagfieldearth0)
    outputBuffer.encodeInt16(sueMagfieldearth1)
    outputBuffer.encodeInt16(sueMagfieldearth2)
    outputBuffer.encodeInt16(sueSvs)
    outputBuffer.encodeInt16(sueHdop)
    outputBuffer.encodeUint8(sueStatus)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 170

    private const val CRC: Int = 103

    private const val SIZE: Int = 61

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF2A> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueTime = inputBuffer.decodeUint32()
      val sueLatitude = inputBuffer.decodeInt32()
      val sueLongitude = inputBuffer.decodeInt32()
      val sueAltitude = inputBuffer.decodeInt32()
      val sueWaypointIndex = inputBuffer.decodeUint16()
      val sueRmat0 = inputBuffer.decodeInt16()
      val sueRmat1 = inputBuffer.decodeInt16()
      val sueRmat2 = inputBuffer.decodeInt16()
      val sueRmat3 = inputBuffer.decodeInt16()
      val sueRmat4 = inputBuffer.decodeInt16()
      val sueRmat5 = inputBuffer.decodeInt16()
      val sueRmat6 = inputBuffer.decodeInt16()
      val sueRmat7 = inputBuffer.decodeInt16()
      val sueRmat8 = inputBuffer.decodeInt16()
      val sueCog = inputBuffer.decodeUint16()
      val sueSog = inputBuffer.decodeInt16()
      val sueCpuLoad = inputBuffer.decodeUint16()
      val sueAirSpeed3dimu = inputBuffer.decodeUint16()
      val sueEstimatedWind0 = inputBuffer.decodeInt16()
      val sueEstimatedWind1 = inputBuffer.decodeInt16()
      val sueEstimatedWind2 = inputBuffer.decodeInt16()
      val sueMagfieldearth0 = inputBuffer.decodeInt16()
      val sueMagfieldearth1 = inputBuffer.decodeInt16()
      val sueMagfieldearth2 = inputBuffer.decodeInt16()
      val sueSvs = inputBuffer.decodeInt16()
      val sueHdop = inputBuffer.decodeInt16()
      val sueStatus = inputBuffer.decodeUint8()

      SerialUdbExtraF2A(
        sueTime = sueTime,
        sueStatus = sueStatus,
        sueLatitude = sueLatitude,
        sueLongitude = sueLongitude,
        sueAltitude = sueAltitude,
        sueWaypointIndex = sueWaypointIndex,
        sueRmat0 = sueRmat0,
        sueRmat1 = sueRmat1,
        sueRmat2 = sueRmat2,
        sueRmat3 = sueRmat3,
        sueRmat4 = sueRmat4,
        sueRmat5 = sueRmat5,
        sueRmat6 = sueRmat6,
        sueRmat7 = sueRmat7,
        sueRmat8 = sueRmat8,
        sueCog = sueCog,
        sueSog = sueSog,
        sueCpuLoad = sueCpuLoad,
        sueAirSpeed3dimu = sueAirSpeed3dimu,
        sueEstimatedWind0 = sueEstimatedWind0,
        sueEstimatedWind1 = sueEstimatedWind1,
        sueEstimatedWind2 = sueEstimatedWind2,
        sueMagfieldearth0 = sueMagfieldearth0,
        sueMagfieldearth1 = sueMagfieldearth1,
        sueMagfieldearth2 = sueMagfieldearth2,
        sueSvs = sueSvs,
        sueHdop = sueHdop,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF2A> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF2A> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueTime: Long = 0L

    public var sueStatus: Int = 0

    public var sueLatitude: Int = 0

    public var sueLongitude: Int = 0

    public var sueAltitude: Int = 0

    public var sueWaypointIndex: Int = 0

    public var sueRmat0: Int = 0

    public var sueRmat1: Int = 0

    public var sueRmat2: Int = 0

    public var sueRmat3: Int = 0

    public var sueRmat4: Int = 0

    public var sueRmat5: Int = 0

    public var sueRmat6: Int = 0

    public var sueRmat7: Int = 0

    public var sueRmat8: Int = 0

    public var sueCog: Int = 0

    public var sueSog: Int = 0

    public var sueCpuLoad: Int = 0

    public var sueAirSpeed3dimu: Int = 0

    public var sueEstimatedWind0: Int = 0

    public var sueEstimatedWind1: Int = 0

    public var sueEstimatedWind2: Int = 0

    public var sueMagfieldearth0: Int = 0

    public var sueMagfieldearth1: Int = 0

    public var sueMagfieldearth2: Int = 0

    public var sueSvs: Int = 0

    public var sueHdop: Int = 0

    public fun build(): SerialUdbExtraF2A = SerialUdbExtraF2A(
      sueTime = sueTime,
      sueStatus = sueStatus,
      sueLatitude = sueLatitude,
      sueLongitude = sueLongitude,
      sueAltitude = sueAltitude,
      sueWaypointIndex = sueWaypointIndex,
      sueRmat0 = sueRmat0,
      sueRmat1 = sueRmat1,
      sueRmat2 = sueRmat2,
      sueRmat3 = sueRmat3,
      sueRmat4 = sueRmat4,
      sueRmat5 = sueRmat5,
      sueRmat6 = sueRmat6,
      sueRmat7 = sueRmat7,
      sueRmat8 = sueRmat8,
      sueCog = sueCog,
      sueSog = sueSog,
      sueCpuLoad = sueCpuLoad,
      sueAirSpeed3dimu = sueAirSpeed3dimu,
      sueEstimatedWind0 = sueEstimatedWind0,
      sueEstimatedWind1 = sueEstimatedWind1,
      sueEstimatedWind2 = sueEstimatedWind2,
      sueMagfieldearth0 = sueMagfieldearth0,
      sueMagfieldearth1 = sueMagfieldearth1,
      sueMagfieldearth2 = sueMagfieldearth2,
      sueSvs = sueSvs,
      sueHdop = sueHdop,
    )
  }
}
