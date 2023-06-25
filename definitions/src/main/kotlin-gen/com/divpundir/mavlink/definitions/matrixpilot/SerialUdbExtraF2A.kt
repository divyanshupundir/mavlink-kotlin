package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A
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
   * Serial UDB Extra Number of Sattelites in View
   */
  @GeneratedMavField(type = "int16_t")
  public val sueSvs: Short = 0,
  /**
   * Serial UDB Extra GPS Horizontal Dilution of Precision
   */
  @GeneratedMavField(type = "int16_t")
  public val sueHdop: Short = 0,
) : MavMessage<SerialUdbExtraF2A> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF2A> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(sueTime)
    buffer.encodeInt32(sueLatitude)
    buffer.encodeInt32(sueLongitude)
    buffer.encodeInt32(sueAltitude)
    buffer.encodeUInt16(sueWaypointIndex)
    buffer.encodeInt16(sueRmat0)
    buffer.encodeInt16(sueRmat1)
    buffer.encodeInt16(sueRmat2)
    buffer.encodeInt16(sueRmat3)
    buffer.encodeInt16(sueRmat4)
    buffer.encodeInt16(sueRmat5)
    buffer.encodeInt16(sueRmat6)
    buffer.encodeInt16(sueRmat7)
    buffer.encodeInt16(sueRmat8)
    buffer.encodeUInt16(sueCog)
    buffer.encodeInt16(sueSog)
    buffer.encodeUInt16(sueCpuLoad)
    buffer.encodeUInt16(sueAirSpeed3dimu)
    buffer.encodeInt16(sueEstimatedWind0)
    buffer.encodeInt16(sueEstimatedWind1)
    buffer.encodeInt16(sueEstimatedWind2)
    buffer.encodeInt16(sueMagfieldearth0)
    buffer.encodeInt16(sueMagfieldearth1)
    buffer.encodeInt16(sueMagfieldearth2)
    buffer.encodeInt16(sueSvs)
    buffer.encodeInt16(sueHdop)
    buffer.encodeUInt8(sueStatus)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(sueTime)
    buffer.encodeInt32(sueLatitude)
    buffer.encodeInt32(sueLongitude)
    buffer.encodeInt32(sueAltitude)
    buffer.encodeUInt16(sueWaypointIndex)
    buffer.encodeInt16(sueRmat0)
    buffer.encodeInt16(sueRmat1)
    buffer.encodeInt16(sueRmat2)
    buffer.encodeInt16(sueRmat3)
    buffer.encodeInt16(sueRmat4)
    buffer.encodeInt16(sueRmat5)
    buffer.encodeInt16(sueRmat6)
    buffer.encodeInt16(sueRmat7)
    buffer.encodeInt16(sueRmat8)
    buffer.encodeUInt16(sueCog)
    buffer.encodeInt16(sueSog)
    buffer.encodeUInt16(sueCpuLoad)
    buffer.encodeUInt16(sueAirSpeed3dimu)
    buffer.encodeInt16(sueEstimatedWind0)
    buffer.encodeInt16(sueEstimatedWind1)
    buffer.encodeInt16(sueEstimatedWind2)
    buffer.encodeInt16(sueMagfieldearth0)
    buffer.encodeInt16(sueMagfieldearth1)
    buffer.encodeInt16(sueMagfieldearth2)
    buffer.encodeInt16(sueSvs)
    buffer.encodeInt16(sueHdop)
    buffer.encodeUInt8(sueStatus)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF2A> {
    public override val id: UInt = 170u

    public override val crcExtra: Byte = 103

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF2A {
      val buffer = Buffer().write(bytes)

      val sueTime = buffer.decodeUInt32()
      val sueLatitude = buffer.decodeInt32()
      val sueLongitude = buffer.decodeInt32()
      val sueAltitude = buffer.decodeInt32()
      val sueWaypointIndex = buffer.decodeUInt16()
      val sueRmat0 = buffer.decodeInt16()
      val sueRmat1 = buffer.decodeInt16()
      val sueRmat2 = buffer.decodeInt16()
      val sueRmat3 = buffer.decodeInt16()
      val sueRmat4 = buffer.decodeInt16()
      val sueRmat5 = buffer.decodeInt16()
      val sueRmat6 = buffer.decodeInt16()
      val sueRmat7 = buffer.decodeInt16()
      val sueRmat8 = buffer.decodeInt16()
      val sueCog = buffer.decodeUInt16()
      val sueSog = buffer.decodeInt16()
      val sueCpuLoad = buffer.decodeUInt16()
      val sueAirSpeed3dimu = buffer.decodeUInt16()
      val sueEstimatedWind0 = buffer.decodeInt16()
      val sueEstimatedWind1 = buffer.decodeInt16()
      val sueEstimatedWind2 = buffer.decodeInt16()
      val sueMagfieldearth0 = buffer.decodeInt16()
      val sueMagfieldearth1 = buffer.decodeInt16()
      val sueMagfieldearth2 = buffer.decodeInt16()
      val sueSvs = buffer.decodeInt16()
      val sueHdop = buffer.decodeInt16()
      val sueStatus = buffer.decodeUInt8()

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
