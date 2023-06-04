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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeLastBaselineMs)
    outputBuffer.encodeUInt32(tow)
    outputBuffer.encodeInt32(baselineAMm)
    outputBuffer.encodeInt32(baselineBMm)
    outputBuffer.encodeInt32(baselineCMm)
    outputBuffer.encodeUInt32(accuracy)
    outputBuffer.encodeInt32(iarNumHypotheses)
    outputBuffer.encodeUInt16(wn)
    outputBuffer.encodeUInt8(rtkReceiverId)
    outputBuffer.encodeUInt8(rtkHealth)
    outputBuffer.encodeUInt8(rtkRate)
    outputBuffer.encodeUInt8(nsats)
    outputBuffer.encodeEnumValue(baselineCoordsType.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeLastBaselineMs)
    outputBuffer.encodeUInt32(tow)
    outputBuffer.encodeInt32(baselineAMm)
    outputBuffer.encodeInt32(baselineBMm)
    outputBuffer.encodeInt32(baselineCMm)
    outputBuffer.encodeUInt32(accuracy)
    outputBuffer.encodeInt32(iarNumHypotheses)
    outputBuffer.encodeUInt16(wn)
    outputBuffer.encodeUInt8(rtkReceiverId)
    outputBuffer.encodeUInt8(rtkHealth)
    outputBuffer.encodeUInt8(rtkRate)
    outputBuffer.encodeUInt8(nsats)
    outputBuffer.encodeEnumValue(baselineCoordsType.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsRtk> {
    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 35

    public override val id: UInt = 127u

    public override val crcExtra: Byte = 25

    public override fun deserialize(bytes: ByteArray): GpsRtk {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeLastBaselineMs = inputBuffer.decodeUInt32()
      val tow = inputBuffer.decodeUInt32()
      val baselineAMm = inputBuffer.decodeInt32()
      val baselineBMm = inputBuffer.decodeInt32()
      val baselineCMm = inputBuffer.decodeInt32()
      val accuracy = inputBuffer.decodeUInt32()
      val iarNumHypotheses = inputBuffer.decodeInt32()
      val wn = inputBuffer.decodeUInt16()
      val rtkReceiverId = inputBuffer.decodeUInt8()
      val rtkHealth = inputBuffer.decodeUInt8()
      val rtkRate = inputBuffer.decodeUInt8()
      val nsats = inputBuffer.decodeUInt8()
      val baselineCoordsType = inputBuffer.decodeEnumValue(1).let { value ->
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
