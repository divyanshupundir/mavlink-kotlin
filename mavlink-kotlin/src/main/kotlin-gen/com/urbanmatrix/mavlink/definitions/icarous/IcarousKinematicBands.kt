package com.urbanmatrix.mavlink.definitions.icarous

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Kinematic multi bands (track) output from Daidalus
 */
public data class IcarousKinematicBands(
  /**
   * Number of track bands
   */
  public val numbands: Int = 0,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  public val type1: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0),
  /**
   * min angle (degrees)
   */
  public val min1: Float = 0F,
  /**
   * max angle (degrees)
   */
  public val max1: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  public val type2: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0),
  /**
   * min angle (degrees)
   */
  public val min2: Float = 0F,
  /**
   * max angle (degrees)
   */
  public val max2: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  public val type3: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0),
  /**
   * min angle (degrees)
   */
  public val min3: Float = 0F,
  /**
   * max angle (degrees)
   */
  public val max3: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  public val type4: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0),
  /**
   * min angle (degrees)
   */
  public val min4: Float = 0F,
  /**
   * max angle (degrees)
   */
  public val max4: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  public val type5: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0),
  /**
   * min angle (degrees)
   */
  public val min5: Float = 0F,
  /**
   * max angle (degrees)
   */
  public val max5: Float = 0F,
) : MavMessage<IcarousKinematicBands> {
  public override val instanceMetadata: MavMessage.Metadata<IcarousKinematicBands> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(min1)
    outputBuffer.encodeFloat(max1)
    outputBuffer.encodeFloat(min2)
    outputBuffer.encodeFloat(max2)
    outputBuffer.encodeFloat(min3)
    outputBuffer.encodeFloat(max3)
    outputBuffer.encodeFloat(min4)
    outputBuffer.encodeFloat(max4)
    outputBuffer.encodeFloat(min5)
    outputBuffer.encodeFloat(max5)
    outputBuffer.encodeInt8(numbands)
    outputBuffer.encodeEnumValue(type1.value, 1)
    outputBuffer.encodeEnumValue(type2.value, 1)
    outputBuffer.encodeEnumValue(type3.value, 1)
    outputBuffer.encodeEnumValue(type4.value, 1)
    outputBuffer.encodeEnumValue(type5.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 42001

    private const val CRC: Int = 239

    private const val SIZE: Int = 46

    private val DESERIALIZER: MavDeserializer<IcarousKinematicBands> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val min1 = inputBuffer.decodeFloat()
      val max1 = inputBuffer.decodeFloat()
      val min2 = inputBuffer.decodeFloat()
      val max2 = inputBuffer.decodeFloat()
      val min3 = inputBuffer.decodeFloat()
      val max3 = inputBuffer.decodeFloat()
      val min4 = inputBuffer.decodeFloat()
      val max4 = inputBuffer.decodeFloat()
      val min5 = inputBuffer.decodeFloat()
      val max5 = inputBuffer.decodeFloat()
      val numbands = inputBuffer.decodeInt8()
      val type1 = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type2 = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type3 = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type4 = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type5 = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      IcarousKinematicBands(
        numbands = numbands,
        type1 = type1,
        min1 = min1,
        max1 = max1,
        type2 = type2,
        min2 = min2,
        max2 = max2,
        type3 = type3,
        min3 = min3,
        max3 = max3,
        type4 = type4,
        min4 = min4,
        max4 = max4,
        type5 = type5,
        min5 = min5,
        max5 = max5,
      )
    }


    private val METADATA: MavMessage.Metadata<IcarousKinematicBands> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<IcarousKinematicBands> = METADATA
  }
}
