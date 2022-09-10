package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting
 */
@GeneratedMavMessage(
  id = 128,
  crc = 226,
)
public data class Gps2Rtk(
  /**
   * Time since boot of last baseline message received.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeLastBaselineMs: Long = 0L,
  /**
   * Identification of connected RTK receiver.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkReceiverId: Int = 0,
  /**
   * GPS Week Number of last baseline
   */
  @GeneratedMavField(type = "uint16_t")
  public val wn: Int = 0,
  /**
   * GPS Time of Week of last baseline
   */
  @GeneratedMavField(type = "uint32_t")
  public val tow: Long = 0L,
  /**
   * GPS-specific health report for RTK data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkHealth: Int = 0,
  /**
   * Rate of baseline messages being received by GPS
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkRate: Int = 0,
  /**
   * Current number of sats used for RTK calculation.
   */
  @GeneratedMavField(type = "uint8_t")
  public val nsats: Int = 0,
  /**
   * Coordinate system of baseline
   */
  @GeneratedMavField(type = "uint8_t")
  public val baselineCoordsType: MavEnumValue<RtkBaselineCoordinateSystem> =
      MavEnumValue.fromValue(0),
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
  public val accuracy: Long = 0L,
  /**
   * Current number of integer ambiguity hypotheses.
   */
  @GeneratedMavField(type = "int32_t")
  public val iarNumHypotheses: Int = 0,
) : MavMessage<Gps2Rtk> {
  public override val instanceMetadata: MavMessage.Metadata<Gps2Rtk> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeLastBaselineMs)
    outputBuffer.encodeUint32(tow)
    outputBuffer.encodeInt32(baselineAMm)
    outputBuffer.encodeInt32(baselineBMm)
    outputBuffer.encodeInt32(baselineCMm)
    outputBuffer.encodeUint32(accuracy)
    outputBuffer.encodeInt32(iarNumHypotheses)
    outputBuffer.encodeUint16(wn)
    outputBuffer.encodeUint8(rtkReceiverId)
    outputBuffer.encodeUint8(rtkHealth)
    outputBuffer.encodeUint8(rtkRate)
    outputBuffer.encodeUint8(nsats)
    outputBuffer.encodeEnumValue(baselineCoordsType.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeLastBaselineMs)
    outputBuffer.encodeUint32(tow)
    outputBuffer.encodeInt32(baselineAMm)
    outputBuffer.encodeInt32(baselineBMm)
    outputBuffer.encodeInt32(baselineCMm)
    outputBuffer.encodeUint32(accuracy)
    outputBuffer.encodeInt32(iarNumHypotheses)
    outputBuffer.encodeUint16(wn)
    outputBuffer.encodeUint8(rtkReceiverId)
    outputBuffer.encodeUint8(rtkHealth)
    outputBuffer.encodeUint8(rtkRate)
    outputBuffer.encodeUint8(nsats)
    outputBuffer.encodeEnumValue(baselineCoordsType.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 128

    private const val CRC: Int = 226

    private const val SIZE: Int = 35

    private val DESERIALIZER: MavDeserializer<Gps2Rtk> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeLastBaselineMs = inputBuffer.decodeUint32()
      val tow = inputBuffer.decodeUint32()
      val baselineAMm = inputBuffer.decodeInt32()
      val baselineBMm = inputBuffer.decodeInt32()
      val baselineCMm = inputBuffer.decodeInt32()
      val accuracy = inputBuffer.decodeUint32()
      val iarNumHypotheses = inputBuffer.decodeInt32()
      val wn = inputBuffer.decodeUint16()
      val rtkReceiverId = inputBuffer.decodeUint8()
      val rtkHealth = inputBuffer.decodeUint8()
      val rtkRate = inputBuffer.decodeUint8()
      val nsats = inputBuffer.decodeUint8()
      val baselineCoordsType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = RtkBaselineCoordinateSystem.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      Gps2Rtk(
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


    private val METADATA: MavMessage.Metadata<Gps2Rtk> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Gps2Rtk> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeLastBaselineMs: Long = 0L

    public var rtkReceiverId: Int = 0

    public var wn: Int = 0

    public var tow: Long = 0L

    public var rtkHealth: Int = 0

    public var rtkRate: Int = 0

    public var nsats: Int = 0

    public var baselineCoordsType: MavEnumValue<RtkBaselineCoordinateSystem> =
        MavEnumValue.fromValue(0)

    public var baselineAMm: Int = 0

    public var baselineBMm: Int = 0

    public var baselineCMm: Int = 0

    public var accuracy: Long = 0L

    public var iarNumHypotheses: Int = 0

    public fun build(): Gps2Rtk = Gps2Rtk(
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
