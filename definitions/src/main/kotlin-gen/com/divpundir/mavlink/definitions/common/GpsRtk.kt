package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting
 */
@GeneratedMavMessage(
  id = 127u,
  crcExtra = 25,
)
public data class GpsRtk(
  /**
   * Time since boot of last baseline message received.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeLastBaselineMs: UInt = 0u,
  /**
   * Identification of connected RTK receiver.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkReceiverId: UByte = 0u,
  /**
   * GPS Week Number of last baseline
   */
  @GeneratedMavField(type = "uint16_t")
  public val wn: UShort = 0u,
  /**
   * GPS Time of Week of last baseline
   */
  @GeneratedMavField(type = "uint32_t")
  public val tow: UInt = 0u,
  /**
   * GPS-specific health report for RTK data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkHealth: UByte = 0u,
  /**
   * Rate of baseline messages being received by GPS
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkRate: UByte = 0u,
  /**
   * Current number of sats used for RTK calculation.
   */
  @GeneratedMavField(type = "uint8_t")
  public val nsats: UByte = 0u,
  /**
   * Coordinate system of baseline
   */
  @GeneratedMavField(type = "uint8_t")
  public val baselineCoordsType: MavEnumValue<RtkBaselineCoordinateSystem> =
      MavEnumValue.fromValue(0u),
  /**
   * Current baseline in ECEF x or NED north component.
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineAMm: Int = 0,
  /**
   * Current baseline in ECEF y or NED east component.
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineBMm: Int = 0,
  /**
   * Current baseline in ECEF z or NED down component.
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineCMm: Int = 0,
  /**
   * Current estimate of baseline accuracy.
   */
  @GeneratedMavField(type = "uint32_t")
  public val accuracy: UInt = 0u,
  /**
   * Current number of integer ambiguity hypotheses.
   */
  @GeneratedMavField(type = "int32_t")
  public val iarNumHypotheses: Int = 0,
) : MavMessage<GpsRtk> {
  public override val instanceCompanion: MavMessage.MavCompanion<GpsRtk> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeLastBaselineMs)
    buffer.encodeUInt32(tow)
    buffer.encodeInt32(baselineAMm)
    buffer.encodeInt32(baselineBMm)
    buffer.encodeInt32(baselineCMm)
    buffer.encodeUInt32(accuracy)
    buffer.encodeInt32(iarNumHypotheses)
    buffer.encodeUInt16(wn)
    buffer.encodeUInt8(rtkReceiverId)
    buffer.encodeUInt8(rtkHealth)
    buffer.encodeUInt8(rtkRate)
    buffer.encodeUInt8(nsats)
    buffer.encodeEnumValue(baselineCoordsType.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeLastBaselineMs)
    buffer.encodeUInt32(tow)
    buffer.encodeInt32(baselineAMm)
    buffer.encodeInt32(baselineBMm)
    buffer.encodeInt32(baselineCMm)
    buffer.encodeUInt32(accuracy)
    buffer.encodeInt32(iarNumHypotheses)
    buffer.encodeUInt16(wn)
    buffer.encodeUInt8(rtkReceiverId)
    buffer.encodeUInt8(rtkHealth)
    buffer.encodeUInt8(rtkRate)
    buffer.encodeUInt8(nsats)
    buffer.encodeEnumValue(baselineCoordsType.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsRtk> {
    public override val id: UInt = 127u

    public override val crcExtra: Byte = 25

    public override fun deserialize(bytes: ByteArray): GpsRtk {
      val buffer = Buffer().write(bytes)

      val timeLastBaselineMs = buffer.decodeUInt32()
      val tow = buffer.decodeUInt32()
      val baselineAMm = buffer.decodeInt32()
      val baselineBMm = buffer.decodeInt32()
      val baselineCMm = buffer.decodeInt32()
      val accuracy = buffer.decodeUInt32()
      val iarNumHypotheses = buffer.decodeInt32()
      val wn = buffer.decodeUInt16()
      val rtkReceiverId = buffer.decodeUInt8()
      val rtkHealth = buffer.decodeUInt8()
      val rtkRate = buffer.decodeUInt8()
      val nsats = buffer.decodeUInt8()
      val baselineCoordsType = buffer.decodeEnumValue(1).let { value ->
        val entry = RtkBaselineCoordinateSystem.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return GpsRtk(
        timeLastBaselineMs = timeLastBaselineMs,
        rtkReceiverId = rtkReceiverId,
        wn = wn,
        tow = tow,
        rtkHealth = rtkHealth,
        rtkRate = rtkRate,
        nsats = nsats,
        baselineCoordsType = baselineCoordsType,
        baselineAMm = baselineAMm,
        baselineBMm = baselineBMm,
        baselineCMm = baselineCMm,
        accuracy = accuracy,
        iarNumHypotheses = iarNumHypotheses,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GpsRtk =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeLastBaselineMs: UInt = 0u

    public var rtkReceiverId: UByte = 0u

    public var wn: UShort = 0u

    public var tow: UInt = 0u

    public var rtkHealth: UByte = 0u

    public var rtkRate: UByte = 0u

    public var nsats: UByte = 0u

    public var baselineCoordsType: MavEnumValue<RtkBaselineCoordinateSystem> =
        MavEnumValue.fromValue(0u)

    public var baselineAMm: Int = 0

    public var baselineBMm: Int = 0

    public var baselineCMm: Int = 0

    public var accuracy: UInt = 0u

    public var iarNumHypotheses: Int = 0

    public fun build(): GpsRtk = GpsRtk(
      timeLastBaselineMs = timeLastBaselineMs,
      rtkReceiverId = rtkReceiverId,
      wn = wn,
      tow = tow,
      rtkHealth = rtkHealth,
      rtkRate = rtkRate,
      nsats = nsats,
      baselineCoordsType = baselineCoordsType,
      baselineAMm = baselineAMm,
      baselineBMm = baselineBMm,
      baselineCMm = baselineCMm,
      accuracy = accuracy,
      iarNumHypotheses = iarNumHypotheses,
    )
  }
}
