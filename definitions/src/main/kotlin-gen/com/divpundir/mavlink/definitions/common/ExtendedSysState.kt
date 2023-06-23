package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Provides state for additional features
 */
@GeneratedMavMessage(
  id = 245u,
  crcExtra = -126,
)
public data class ExtendedSysState(
  /**
   * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL
   * configuration.
   */
  @GeneratedMavField(type = "uint8_t")
  public val vtolState: MavEnumValue<MavVtolState> = MavEnumValue.fromValue(0u),
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u),
) : MavMessage<ExtendedSysState> {
  public override val instanceCompanion: MavMessage.MavCompanion<ExtendedSysState> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(vtolState.value, 1)
    output.encodeEnumValue(landedState.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(vtolState.value, 1)
    output.encodeEnumValue(landedState.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ExtendedSysState> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    public override val id: UInt = 245u

    public override val crcExtra: Byte = -126

    public override fun deserialize(source: BufferedSource): ExtendedSysState {
      val vtolState = source.decodeEnumValue(1).let { value ->
        val entry = MavVtolState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val landedState = source.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ExtendedSysState(
        vtolState = vtolState,
        landedState = landedState,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ExtendedSysState =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var vtolState: MavEnumValue<MavVtolState> = MavEnumValue.fromValue(0u)

    public var landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u)

    public fun build(): ExtendedSysState = ExtendedSysState(
      vtolState = vtolState,
      landedState = landedState,
    )
  }
}
