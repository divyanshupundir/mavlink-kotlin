package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Get the current mode.
 *         This should be emitted on any mode change, and broadcast at low rate (nominally 0.5 Hz).
 *         It may be requested using MAV_CMD_REQUEST_MESSAGE.
 *         See https://mavlink.io/en/services/standard_modes.html
 *       
 *
 * @param standardMode Standard mode.
 * @param customMode A bitfield for use for autopilot-specific flags
 * @param intendedCustomMode The custom_mode of the mode that was last commanded by the user (for
 * example, with MAV_CMD_DO_SET_STANDARD_MODE, MAV_CMD_DO_SET_MODE or via RC). This should usually be
 * the same as custom_mode. It will be different if the vehicle is unable to enter the intended mode,
 * or has left that mode due to a failsafe condition. 0 indicates the intended custom mode is
 * unknown/not supplied
 */
@GeneratedMavMessage(
  id = 436u,
  crcExtra = -63,
)
public data class CurrentMode(
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
   * The custom_mode of the mode that was last commanded by the user (for example, with
   * MAV_CMD_DO_SET_STANDARD_MODE, MAV_CMD_DO_SET_MODE or via RC). This should usually be the same as
   * custom_mode. It will be different if the vehicle is unable to enter the intended mode, or has left
   * that mode due to a failsafe condition. 0 indicates the intended custom mode is unknown/not
   * supplied
   */
  @GeneratedMavField(type = "uint32_t")
  public val intendedCustomMode: UInt = 0u,
) : MavMessage<CurrentMode> {
  override val instanceCompanion: MavMessage.MavCompanion<CurrentMode> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(customMode)
    encoder.encodeUInt32(intendedCustomMode)
    encoder.encodeEnumValue(standardMode.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(customMode)
    encoder.encodeUInt32(intendedCustomMode)
    encoder.encodeEnumValue(standardMode.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CurrentMode> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 436u

    override val crcExtra: Byte = -63

    override fun deserialize(bytes: ByteArray): CurrentMode {
      val decoder = MavDataDecoder(bytes)

      val customMode = decoder.safeDecodeUInt32()
      val intendedCustomMode = decoder.safeDecodeUInt32()
      val standardMode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavStandardMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return CurrentMode(
        standardMode = standardMode,
        customMode = customMode,
        intendedCustomMode = intendedCustomMode,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CurrentMode =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var standardMode: MavEnumValue<MavStandardMode> = MavEnumValue.fromValue(0u)

    public var customMode: UInt = 0u

    public var intendedCustomMode: UInt = 0u

    public fun build(): CurrentMode = CurrentMode(
      standardMode = standardMode,
      customMode = customMode,
      intendedCustomMode = intendedCustomMode,
    )
  }
}
