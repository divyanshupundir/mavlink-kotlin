package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting
 *
 * @param timeLastBaselineMs Time since boot of last baseline message received.
 * units = ms
 * @param rtkReceiverId Identification of connected RTK receiver.
 * @param wn GPS Week Number of last baseline
 * @param tow GPS Time of Week of last baseline
 * units = ms
 * @param rtkHealth GPS-specific health report for RTK data.
 * @param rtkRate Rate of baseline messages being received by GPS
 * units = Hz
 * @param nsats Current number of sats used for RTK calculation.
 * @param baselineCoordsType Coordinate system of baseline
 * @param baselineAMm Current baseline in ECEF x or NED north component.
 * units = mm
 * @param baselineBMm Current baseline in ECEF y or NED east component.
 * units = mm
 * @param baselineCMm Current baseline in ECEF z or NED down component.
 * units = mm
 * @param accuracy Current estimate of baseline accuracy.
 * @param iarNumHypotheses Current number of integer ambiguity hypotheses.
 */
@GeneratedMavMessage(
  id = 127u,
  crcExtra = 25,
)
public data class GpsRtk(
  /**
   * Time since boot of last baseline message received.
   * units = ms
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
   * units = ms
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
   * units = Hz
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
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineAMm: Int = 0,
  /**
   * Current baseline in ECEF y or NED east component.
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineBMm: Int = 0,
  /**
   * Current baseline in ECEF z or NED down component.
   * units = mm
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
  override val instanceCompanion: MavMessage.MavCompanion<GpsRtk> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeLastBaselineMs)
    encoder.encodeUInt32(tow)
    encoder.encodeInt32(baselineAMm)
    encoder.encodeInt32(baselineBMm)
    encoder.encodeInt32(baselineCMm)
    encoder.encodeUInt32(accuracy)
    encoder.encodeInt32(iarNumHypotheses)
    encoder.encodeUInt16(wn)
    encoder.encodeUInt8(rtkReceiverId)
    encoder.encodeUInt8(rtkHealth)
    encoder.encodeUInt8(rtkRate)
    encoder.encodeUInt8(nsats)
    encoder.encodeEnumValue(baselineCoordsType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeLastBaselineMs)
    encoder.encodeUInt32(tow)
    encoder.encodeInt32(baselineAMm)
    encoder.encodeInt32(baselineBMm)
    encoder.encodeInt32(baselineCMm)
    encoder.encodeUInt32(accuracy)
    encoder.encodeInt32(iarNumHypotheses)
    encoder.encodeUInt16(wn)
    encoder.encodeUInt8(rtkReceiverId)
    encoder.encodeUInt8(rtkHealth)
    encoder.encodeUInt8(rtkRate)
    encoder.encodeUInt8(nsats)
    encoder.encodeEnumValue(baselineCoordsType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsRtk> {
    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 35

    override val id: UInt = 127u

    override val crcExtra: Byte = 25

    override fun deserialize(bytes: ByteArray): GpsRtk {
      val decoder = MavDataDecoder(bytes)

      val timeLastBaselineMs = decoder.safeDecodeUInt32()
      val tow = decoder.safeDecodeUInt32()
      val baselineAMm = decoder.safeDecodeInt32()
      val baselineBMm = decoder.safeDecodeInt32()
      val baselineCMm = decoder.safeDecodeInt32()
      val accuracy = decoder.safeDecodeUInt32()
      val iarNumHypotheses = decoder.safeDecodeInt32()
      val wn = decoder.safeDecodeUInt16()
      val rtkReceiverId = decoder.safeDecodeUInt8()
      val rtkHealth = decoder.safeDecodeUInt8()
      val rtkRate = decoder.safeDecodeUInt8()
      val nsats = decoder.safeDecodeUInt8()
      val baselineCoordsType = decoder.safeDecodeEnumValue(1).let { value ->
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
