package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<GpsRtk> = METADATA

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

  public companion object {
    private const val ID: UInt = 127u

    private const val CRC_EXTRA: Byte = 25

    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 35

    private val DESERIALIZER: MavDeserializer<GpsRtk> = MavDeserializer { bytes ->
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

      GpsRtk(
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


    private val METADATA: MavMessage.Metadata<GpsRtk> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsRtk> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GpsRtk =
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
