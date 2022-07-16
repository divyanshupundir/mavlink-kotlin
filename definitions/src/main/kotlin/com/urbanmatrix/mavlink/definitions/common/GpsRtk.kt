package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting
 */
public data class GpsRtk(
  /**
   * Time since boot of last baseline message received.
   */
  public val timeLastBaselineMs: Long = 0L,
  /**
   * Identification of connected RTK receiver.
   */
  public val rtkReceiverId: Int = 0,
  /**
   * GPS Week Number of last baseline
   */
  public val wn: Int = 0,
  /**
   * GPS Time of Week of last baseline
   */
  public val tow: Long = 0L,
  /**
   * GPS-specific health report for RTK data.
   */
  public val rtkHealth: Int = 0,
  /**
   * Rate of baseline messages being received by GPS
   */
  public val rtkRate: Int = 0,
  /**
   * Current number of sats used for RTK calculation.
   */
  public val nsats: Int = 0,
  /**
   * Coordinate system of baseline
   */
  public val baselineCoordsType: MavEnumValue<RtkBaselineCoordinateSystem> =
      MavEnumValue.fromValue(0),
  /**
   * Current baseline in ECEF x or NED north component.
   */
  public val baselineAMm: Int = 0,
  /**
   * Current baseline in ECEF y or NED east component.
   */
  public val baselineBMm: Int = 0,
  /**
   * Current baseline in ECEF z or NED down component.
   */
  public val baselineCMm: Int = 0,
  /**
   * Current estimate of baseline accuracy.
   */
  public val accuracy: Long = 0L,
  /**
   * Current number of integer ambiguity hypotheses.
   */
  public val iarNumHypotheses: Int = 0,
) : MavMessage<GpsRtk> {
  public override val instanceMetadata: MavMessage.Metadata<GpsRtk> = METADATA

  public override fun serialize(): ByteArray {
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

  public companion object {
    private const val ID: Int = 127

    private const val CRC: Int = 25

    private const val SIZE: Int = 35

    private val DESERIALIZER: MavDeserializer<GpsRtk> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for GpsRtk: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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


    private val METADATA: MavMessage.Metadata<GpsRtk> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsRtk> = METADATA
  }
}
