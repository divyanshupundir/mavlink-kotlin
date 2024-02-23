package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A
 *
 * @param sueTime Serial UDB Extra Time
 * @param sueStatus Serial UDB Extra Status
 * @param sueLatitude Serial UDB Extra Latitude
 * @param sueLongitude Serial UDB Extra Longitude
 * @param sueAltitude Serial UDB Extra Altitude
 * @param sueWaypointIndex Serial UDB Extra Waypoint Index
 * @param sueRmat0 Serial UDB Extra Rmat 0
 * @param sueRmat1 Serial UDB Extra Rmat 1
 * @param sueRmat2 Serial UDB Extra Rmat 2
 * @param sueRmat3 Serial UDB Extra Rmat 3
 * @param sueRmat4 Serial UDB Extra Rmat 4
 * @param sueRmat5 Serial UDB Extra Rmat 5
 * @param sueRmat6 Serial UDB Extra Rmat 6
 * @param sueRmat7 Serial UDB Extra Rmat 7
 * @param sueRmat8 Serial UDB Extra Rmat 8
 * @param sueCog Serial UDB Extra GPS Course Over Ground
 * @param sueSog Serial UDB Extra Speed Over Ground
 * @param sueCpuLoad Serial UDB Extra CPU Load
 * @param sueAirSpeed3dimu Serial UDB Extra 3D IMU Air Speed
 * @param sueEstimatedWind0 Serial UDB Extra Estimated Wind 0
 * @param sueEstimatedWind1 Serial UDB Extra Estimated Wind 1
 * @param sueEstimatedWind2 Serial UDB Extra Estimated Wind 2
 * @param sueMagfieldearth0 Serial UDB Extra Magnetic Field Earth 0 
 * @param sueMagfieldearth1 Serial UDB Extra Magnetic Field Earth 1 
 * @param sueMagfieldearth2 Serial UDB Extra Magnetic Field Earth 2 
 * @param sueSvs Serial UDB Extra Number of Satellites in View
 * @param sueHdop Serial UDB Extra GPS Horizontal Dilution of Precision
 */
@GeneratedMavMessage(
  id = 170u,
  crcExtra = 103,
)
public data class SerialUdbExtraF2A(
  /**
   * Serial UDB Extra Time
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueTime: UInt = 0u,
  /**
   * Serial UDB Extra Status
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueStatus: UByte = 0u,
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
  public val sueWaypointIndex: UShort = 0u,
  /**
   * Serial UDB Extra Rmat 0
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat0: Short = 0,
  /**
   * Serial UDB Extra Rmat 1
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat1: Short = 0,
  /**
   * Serial UDB Extra Rmat 2
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat2: Short = 0,
  /**
   * Serial UDB Extra Rmat 3
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat3: Short = 0,
  /**
   * Serial UDB Extra Rmat 4
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat4: Short = 0,
  /**
   * Serial UDB Extra Rmat 5
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat5: Short = 0,
  /**
   * Serial UDB Extra Rmat 6
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat6: Short = 0,
  /**
   * Serial UDB Extra Rmat 7
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat7: Short = 0,
  /**
   * Serial UDB Extra Rmat 8
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRmat8: Short = 0,
  /**
   * Serial UDB Extra GPS Course Over Ground
   */
  @GeneratedMavField(type = "uint16_t")
  public val sueCog: UShort = 0u,
  /**
   * Serial UDB Extra Speed Over Ground
   */
  @GeneratedMavField(type = "int16_t")
  public val sueSog: Short = 0,
  /**
   * Serial UDB Extra CPU Load
   */
  @GeneratedMavField(type = "uint16_t")
  public val sueCpuLoad: UShort = 0u,
  /**
   * Serial UDB Extra 3D IMU Air Speed
   */
  @GeneratedMavField(type = "uint16_t")
  public val sueAirSpeed3dimu: UShort = 0u,
  /**
   * Serial UDB Extra Estimated Wind 0
   */
  @GeneratedMavField(type = "int16_t")
  public val sueEstimatedWind0: Short = 0,
  /**
   * Serial UDB Extra Estimated Wind 1
   */
  @GeneratedMavField(type = "int16_t")
  public val sueEstimatedWind1: Short = 0,
  /**
   * Serial UDB Extra Estimated Wind 2
   */
  @GeneratedMavField(type = "int16_t")
  public val sueEstimatedWind2: Short = 0,
  /**
   * Serial UDB Extra Magnetic Field Earth 0 
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMagfieldearth0: Short = 0,
  /**
   * Serial UDB Extra Magnetic Field Earth 1 
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMagfieldearth1: Short = 0,
  /**
   * Serial UDB Extra Magnetic Field Earth 2 
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMagfieldearth2: Short = 0,
  /**
   * Serial UDB Extra Number of Satellites in View
   */
  @GeneratedMavField(type = "int16_t")
  public val sueSvs: Short = 0,
  /**
   * Serial UDB Extra GPS Horizontal Dilution of Precision
   */
  @GeneratedMavField(type = "int16_t")
  public val sueHdop: Short = 0,
) : MavMessage<SerialUdbExtraF2A> {
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF2A> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(sueTime)
    encoder.encodeInt32(sueLatitude)
    encoder.encodeInt32(sueLongitude)
    encoder.encodeInt32(sueAltitude)
    encoder.encodeUInt16(sueWaypointIndex)
    encoder.encodeInt16(sueRmat0)
    encoder.encodeInt16(sueRmat1)
    encoder.encodeInt16(sueRmat2)
    encoder.encodeInt16(sueRmat3)
    encoder.encodeInt16(sueRmat4)
    encoder.encodeInt16(sueRmat5)
    encoder.encodeInt16(sueRmat6)
    encoder.encodeInt16(sueRmat7)
    encoder.encodeInt16(sueRmat8)
    encoder.encodeUInt16(sueCog)
    encoder.encodeInt16(sueSog)
    encoder.encodeUInt16(sueCpuLoad)
    encoder.encodeUInt16(sueAirSpeed3dimu)
    encoder.encodeInt16(sueEstimatedWind0)
    encoder.encodeInt16(sueEstimatedWind1)
    encoder.encodeInt16(sueEstimatedWind2)
    encoder.encodeInt16(sueMagfieldearth0)
    encoder.encodeInt16(sueMagfieldearth1)
    encoder.encodeInt16(sueMagfieldearth2)
    encoder.encodeInt16(sueSvs)
    encoder.encodeInt16(sueHdop)
    encoder.encodeUInt8(sueStatus)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(sueTime)
    encoder.encodeInt32(sueLatitude)
    encoder.encodeInt32(sueLongitude)
    encoder.encodeInt32(sueAltitude)
    encoder.encodeUInt16(sueWaypointIndex)
    encoder.encodeInt16(sueRmat0)
    encoder.encodeInt16(sueRmat1)
    encoder.encodeInt16(sueRmat2)
    encoder.encodeInt16(sueRmat3)
    encoder.encodeInt16(sueRmat4)
    encoder.encodeInt16(sueRmat5)
    encoder.encodeInt16(sueRmat6)
    encoder.encodeInt16(sueRmat7)
    encoder.encodeInt16(sueRmat8)
    encoder.encodeUInt16(sueCog)
    encoder.encodeInt16(sueSog)
    encoder.encodeUInt16(sueCpuLoad)
    encoder.encodeUInt16(sueAirSpeed3dimu)
    encoder.encodeInt16(sueEstimatedWind0)
    encoder.encodeInt16(sueEstimatedWind1)
    encoder.encodeInt16(sueEstimatedWind2)
    encoder.encodeInt16(sueMagfieldearth0)
    encoder.encodeInt16(sueMagfieldearth1)
    encoder.encodeInt16(sueMagfieldearth2)
    encoder.encodeInt16(sueSvs)
    encoder.encodeInt16(sueHdop)
    encoder.encodeUInt8(sueStatus)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF2A> {
    private const val SIZE_V1: Int = 61

    private const val SIZE_V2: Int = 61

    override val id: UInt = 170u

    override val crcExtra: Byte = 103

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF2A {
      val decoder = MavDataDecoder(bytes)

      val sueTime = decoder.safeDecodeUInt32()
      val sueLatitude = decoder.safeDecodeInt32()
      val sueLongitude = decoder.safeDecodeInt32()
      val sueAltitude = decoder.safeDecodeInt32()
      val sueWaypointIndex = decoder.safeDecodeUInt16()
      val sueRmat0 = decoder.safeDecodeInt16()
      val sueRmat1 = decoder.safeDecodeInt16()
      val sueRmat2 = decoder.safeDecodeInt16()
      val sueRmat3 = decoder.safeDecodeInt16()
      val sueRmat4 = decoder.safeDecodeInt16()
      val sueRmat5 = decoder.safeDecodeInt16()
      val sueRmat6 = decoder.safeDecodeInt16()
      val sueRmat7 = decoder.safeDecodeInt16()
      val sueRmat8 = decoder.safeDecodeInt16()
      val sueCog = decoder.safeDecodeUInt16()
      val sueSog = decoder.safeDecodeInt16()
      val sueCpuLoad = decoder.safeDecodeUInt16()
      val sueAirSpeed3dimu = decoder.safeDecodeUInt16()
      val sueEstimatedWind0 = decoder.safeDecodeInt16()
      val sueEstimatedWind1 = decoder.safeDecodeInt16()
      val sueEstimatedWind2 = decoder.safeDecodeInt16()
      val sueMagfieldearth0 = decoder.safeDecodeInt16()
      val sueMagfieldearth1 = decoder.safeDecodeInt16()
      val sueMagfieldearth2 = decoder.safeDecodeInt16()
      val sueSvs = decoder.safeDecodeInt16()
      val sueHdop = decoder.safeDecodeInt16()
      val sueStatus = decoder.safeDecodeUInt8()

      return SerialUdbExtraF2A(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF2A =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueTime: UInt = 0u

    public var sueStatus: UByte = 0u

    public var sueLatitude: Int = 0

    public var sueLongitude: Int = 0

    public var sueAltitude: Int = 0

    public var sueWaypointIndex: UShort = 0u

    public var sueRmat0: Short = 0

    public var sueRmat1: Short = 0

    public var sueRmat2: Short = 0

    public var sueRmat3: Short = 0

    public var sueRmat4: Short = 0

    public var sueRmat5: Short = 0

    public var sueRmat6: Short = 0

    public var sueRmat7: Short = 0

    public var sueRmat8: Short = 0

    public var sueCog: UShort = 0u

    public var sueSog: Short = 0

    public var sueCpuLoad: UShort = 0u

    public var sueAirSpeed3dimu: UShort = 0u

    public var sueEstimatedWind0: Short = 0

    public var sueEstimatedWind1: Short = 0

    public var sueEstimatedWind2: Short = 0

    public var sueMagfieldearth0: Short = 0

    public var sueMagfieldearth1: Short = 0

    public var sueMagfieldearth2: Short = 0

    public var sueSvs: Short = 0

    public var sueHdop: Short = 0

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
