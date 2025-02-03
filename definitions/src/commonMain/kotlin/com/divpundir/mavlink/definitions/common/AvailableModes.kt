package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Information about a flight mode.
 *
 *         The message can be enumerated to get information for all modes, or requested for a
 * particular mode, using MAV_CMD_REQUEST_MESSAGE.
 *         Specify 0 in param2 to request that the message is emitted for all available modes or the
 * specific index for just one mode.
 *         The modes must be available/settable for the current vehicle/frame type.
 *         Each mode should only be emitted once (even if it is both standard and custom).
 *         Note that the current mode should be emitted in CURRENT_MODE, and that if the mode list
 * can change then AVAILABLE_MODES_MONITOR must be emitted on first change and subsequently streamed.
 *         See https://mavlink.io/en/services/standard_modes.html
 *       
 *
 * @param numberModes The total number of available modes for the current vehicle type.
 * @param modeIndex The current mode index within number_modes, indexed from 1. The index is not
 * guaranteed to be persistent, and may change between reboots or if the set of modes change.
 * @param standardMode Standard mode.
 * @param customMode A bitfield for use for autopilot-specific flags
 * @param properties Mode properties.
 * @param modeName Name of custom mode, with null termination character. Should be omitted for
 * standard modes.
 */
@GeneratedMavMessage(
  id = 435u,
  crcExtra = -122,
)
public data class AvailableModes(
  /**
   * The total number of available modes for the current vehicle type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val numberModes: UByte = 0u,
  /**
   * The current mode index within number_modes, indexed from 1. The index is not guaranteed to be
   * persistent, and may change between reboots or if the set of modes change.
   */
  @GeneratedMavField(type = "uint8_t")
  public val modeIndex: UByte = 0u,
  /**
   * Standard mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val standardMode: MavEnumValue<MavStandardMode> = MavEnumValue.fromValue(0u),
  /**
   * A bitfield for use for autopilot-specific flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: UInt = 0u,
  /**
   * Mode properties.
   */
  @GeneratedMavField(type = "uint32_t")
  public val properties: MavBitmaskValue<MavModeProperty> = MavBitmaskValue.fromValue(0u),
  /**
   * Name of custom mode, with null termination character. Should be omitted for standard modes.
   */
  @GeneratedMavField(type = "char[35]")
  public val modeName: String = "",
) : MavMessage<AvailableModes> {
  override val instanceCompanion: MavMessage.MavCompanion<AvailableModes> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(customMode)
    encoder.encodeBitmaskValue(properties.value, 4)
    encoder.encodeUInt8(numberModes)
    encoder.encodeUInt8(modeIndex)
    encoder.encodeEnumValue(standardMode.value, 1)
    encoder.encodeString(modeName, 35)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(customMode)
    encoder.encodeBitmaskValue(properties.value, 4)
    encoder.encodeUInt8(numberModes)
    encoder.encodeUInt8(modeIndex)
    encoder.encodeEnumValue(standardMode.value, 1)
    encoder.encodeString(modeName, 35)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvailableModes> {
    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    override val id: UInt = 435u

    override val crcExtra: Byte = -122

    override fun deserialize(bytes: ByteArray): AvailableModes {
      val decoder = MavDataDecoder(bytes)

      val customMode = decoder.safeDecodeUInt32()
      val properties = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavModeProperty.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val numberModes = decoder.safeDecodeUInt8()
      val modeIndex = decoder.safeDecodeUInt8()
      val standardMode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavStandardMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val modeName = decoder.safeDecodeString(35)

      return AvailableModes(
        numberModes = numberModes,
        modeIndex = modeIndex,
        standardMode = standardMode,
        customMode = customMode,
        properties = properties,
        modeName = modeName,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AvailableModes =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var numberModes: UByte = 0u

    public var modeIndex: UByte = 0u

    public var standardMode: MavEnumValue<MavStandardMode> = MavEnumValue.fromValue(0u)

    public var customMode: UInt = 0u

    public var properties: MavBitmaskValue<MavModeProperty> = MavBitmaskValue.fromValue(0u)

    public var modeName: String = ""

    public fun build(): AvailableModes = AvailableModes(
      numberModes = numberModes,
      modeIndex = modeIndex,
      standardMode = standardMode,
      customMode = customMode,
      properties = properties,
      modeName = modeName,
    )
  }
}
