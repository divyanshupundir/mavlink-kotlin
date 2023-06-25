package com.divpundir.mavlink.definitions.icarous

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeFloat(min1)
    buffer.encodeFloat(max1)
    buffer.encodeFloat(min2)
    buffer.encodeFloat(max2)
    buffer.encodeFloat(min3)
    buffer.encodeFloat(max3)
    buffer.encodeFloat(min4)
    buffer.encodeFloat(max4)
    buffer.encodeFloat(min5)
    buffer.encodeFloat(max5)
    buffer.encodeInt8(numbands)
    buffer.encodeEnumValue(type1.value, 1)
    buffer.encodeEnumValue(type2.value, 1)
    buffer.encodeEnumValue(type3.value, 1)
    buffer.encodeEnumValue(type4.value, 1)
    buffer.encodeEnumValue(type5.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(min1)
    buffer.encodeFloat(max1)
    buffer.encodeFloat(min2)
    buffer.encodeFloat(max2)
    buffer.encodeFloat(min3)
    buffer.encodeFloat(max3)
    buffer.encodeFloat(min4)
    buffer.encodeFloat(max4)
    buffer.encodeFloat(min5)
    buffer.encodeFloat(max5)
    buffer.encodeInt8(numbands)
    buffer.encodeEnumValue(type1.value, 1)
    buffer.encodeEnumValue(type2.value, 1)
    buffer.encodeEnumValue(type3.value, 1)
    buffer.encodeEnumValue(type4.value, 1)
    buffer.encodeEnumValue(type5.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<IcarousKinematicBands> {
    public override val id: UInt = 42_001u

    public override val crcExtra: Byte = -17

    public override fun deserialize(bytes: ByteArray): IcarousKinematicBands {
      val buffer = Buffer().write(bytes)

      val min1 = buffer.decodeFloat()
      val max1 = buffer.decodeFloat()
      val min2 = buffer.decodeFloat()
      val max2 = buffer.decodeFloat()
      val min3 = buffer.decodeFloat()
      val max3 = buffer.decodeFloat()
      val min4 = buffer.decodeFloat()
      val max4 = buffer.decodeFloat()
      val min5 = buffer.decodeFloat()
      val max5 = buffer.decodeFloat()
      val numbands = buffer.decodeInt8()
      val type1 = buffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type2 = buffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type3 = buffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type4 = buffer.decodeEnumValue(1).let { value ->
        val entry = IcarousTrackBandTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type5 = buffer.decodeEnumValue(1).let { value ->
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
