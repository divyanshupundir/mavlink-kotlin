package xyz.urbanmatrix.mavlink.definitions.icarous

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Kinematic multi bands (track) output from Daidalus
 */
@GeneratedMavMessage(
  id = 42001u,
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
  public override val instanceMetadata: MavMessage.Metadata<IcarousKinematicBands> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 42001u

    private const val CRC_EXTRA: Byte = -17

    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

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


    private val METADATA: MavMessage.Metadata<IcarousKinematicBands> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<IcarousKinematicBands> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): IcarousKinematicBands =
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
