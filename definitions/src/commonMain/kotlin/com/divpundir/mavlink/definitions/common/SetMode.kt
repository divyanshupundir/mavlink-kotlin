package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is
 * by definition for the overall aircraft, not only for one component.
 *
 * @param targetSystem The system setting the mode
 * @param baseMode The new base mode.
 * @param customMode The new autopilot-specific mode. This field can be ignored by an autopilot.
 */
@Deprecated(message = "Use COMMAND_LONG with MAV_CMD_DO_SET_MODE instead")
@GeneratedMavMessage(
  id = 11u,
  crcExtra = 89,
)
public data class SetMode(
  /**
   * The system setting the mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * The new base mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val baseMode: MavEnumValue<MavMode> = MavEnumValue.fromValue(0u),
  /**
   * The new autopilot-specific mode. This field can be ignored by an autopilot.
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: UInt = 0u,
) : MavMessage<SetMode> {
  override val instanceCompanion: MavMessage.MavCompanion<SetMode> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(customMode)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeEnumValue(baseMode.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(customMode)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeEnumValue(baseMode.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetMode> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 11u

    override val crcExtra: Byte = 89

    override fun deserialize(bytes: ByteArray): SetMode {
      val decoder = MavDataDecoder(bytes)

      val customMode = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val baseMode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return SetMode(
        targetSystem = targetSystem,
        baseMode = baseMode,
        customMode = customMode,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetMode =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var baseMode: MavEnumValue<MavMode> = MavEnumValue.fromValue(0u)

    public var customMode: UInt = 0u

    public fun build(): SetMode = SetMode(
      targetSystem = targetSystem,
      baseMode = baseMode,
      customMode = customMode,
    )
  }
}
