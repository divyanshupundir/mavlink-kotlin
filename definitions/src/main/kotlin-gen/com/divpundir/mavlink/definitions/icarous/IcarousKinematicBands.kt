package com.divpundir.mavlink.definitions.icarous

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Kinematic multi bands (track) output from Daidalus
 */
@GeneratedMavMessage(
  id = 42_001u,
  crcExtra = -17,
)
public data class IcarousKinematicBands(
  /**
   * Number of track bands
   */
  @GeneratedMavField(type = "int8_t")
  public val numbands: Byte = 0,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type1: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u),
  /**
   * min angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val min1: Float = 0F,
  /**
   * max angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val max1: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type2: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u),
  /**
   * min angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val min2: Float = 0F,
  /**
   * max angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val max2: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type3: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u),
  /**
   * min angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val min3: Float = 0F,
  /**
   * max angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val max3: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type4: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u),
  /**
   * min angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val min4: Float = 0F,
  /**
   * max angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val max4: Float = 0F,
  /**
   * See the TRACK_BAND_TYPES enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type5: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u),
  /**
   * min angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val min5: Float = 0F,
  /**
   * max angle (degrees)
   */
  @GeneratedMavField(type = "float")
  public val max5: Float = 0F,
) : MavMessage<IcarousKinematicBands> {
  public override val instanceCompanion: MavMessage.MavCompanion<IcarousKinematicBands> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeFloat(min1)
    encoder.encodeFloat(max1)
    encoder.encodeFloat(min2)
    encoder.encodeFloat(max2)
    encoder.encodeFloat(min3)
    encoder.encodeFloat(max3)
    encoder.encodeFloat(min4)
    encoder.encodeFloat(max4)
    encoder.encodeFloat(min5)
    encoder.encodeFloat(max5)
    encoder.encodeInt8(numbands)
    encoder.encodeEnumValue(type1.value, 1)
    encoder.encodeEnumValue(type2.value, 1)
    encoder.encodeEnumValue(type3.value, 1)
    encoder.encodeEnumValue(type4.value, 1)
    encoder.encodeEnumValue(type5.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeFloat(min1)
    encoder.encodeFloat(max1)
    encoder.encodeFloat(min2)
    encoder.encodeFloat(max2)
    encoder.encodeFloat(min3)
    encoder.encodeFloat(max3)
    encoder.encodeFloat(min4)
    encoder.encodeFloat(max4)
    encoder.encodeFloat(min5)
    encoder.encodeFloat(max5)
    encoder.encodeInt8(numbands)
    encoder.encodeEnumValue(type1.value, 1)
    encoder.encodeEnumValue(type2.value, 1)
    encoder.encodeEnumValue(type3.value, 1)
    encoder.encodeEnumValue(type4.value, 1)
    encoder.encodeEnumValue(type5.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<IcarousKinematicBands> {
    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    public override val id: UInt = 42_001u

    public override val crcExtra: Byte = -17

    public override fun deserialize(bytes: ByteArray): IcarousKinematicBands {
      val decoder = MavDataDecoder.wrap(bytes)

      val min1 = decoder.safeDecodeFloat()
      val max1 = decoder.safeDecodeFloat()
      val min2 = decoder.safeDecodeFloat()
      val max2 = decoder.safeDecodeFloat()
      val min3 = decoder.safeDecodeFloat()
      val max3 = decoder.safeDecodeFloat()
      val min4 = decoder.safeDecodeFloat()
      val max4 = decoder.safeDecodeFloat()
      val min5 = decoder.safeDecodeFloat()
      val max5 = decoder.safeDecodeFloat()
      val numbands = decoder.safeDecodeInt8()
      val type1 = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type2 = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type3 = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type4 = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type5 = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return IcarousKinematicBands(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): IcarousKinematicBands =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var numbands: Byte = 0

    public var type1: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u)

    public var min1: Float = 0F

    public var max1: Float = 0F

    public var type2: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u)

    public var min2: Float = 0F

    public var max2: Float = 0F

    public var type3: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u)

    public var min3: Float = 0F

    public var max3: Float = 0F

    public var type4: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u)

    public var min4: Float = 0F

    public var max4: Float = 0F

    public var type5: MavEnumValue<IcarousTrackBandTypes> = MavEnumValue.fromValue(0u)

    public var min5: Float = 0F

    public var max5: Float = 0F

    public fun build(): IcarousKinematicBands = IcarousKinematicBands(
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
}
