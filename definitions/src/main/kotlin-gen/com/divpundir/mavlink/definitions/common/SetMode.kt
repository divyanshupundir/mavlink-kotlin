package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Deprecated
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is
 * by definition for the overall aircraft, not only for one component.
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
  public override val instanceCompanion: MavMessage.MavCompanion<SetMode> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(customMode)
    output.encodeUInt8(targetSystem)
    output.encodeEnumValue(baseMode.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(customMode)
    output.encodeUInt8(targetSystem)
    output.encodeEnumValue(baseMode.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SetMode> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 11u

    public override val crcExtra: Byte = 89

    public override fun deserialize(source: BufferedSource): SetMode {
      val customMode = source.decodeUInt32()
      val targetSystem = source.decodeUInt8()
      val baseMode = source.decodeEnumValue(1).let { value ->
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
