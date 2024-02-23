package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Provides state for additional features
 *
 * @param vtolState The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not
 * in VTOL configuration.
 * @param landedState The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is
 * unknown.
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
  override val instanceCompanion: MavMessage.MavCompanion<ExtendedSysState> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(vtolState.value, 1)
    encoder.encodeEnumValue(landedState.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(vtolState.value, 1)
    encoder.encodeEnumValue(landedState.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ExtendedSysState> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    override val id: UInt = 245u

    override val crcExtra: Byte = -126

    override fun deserialize(bytes: ByteArray): ExtendedSysState {
      val decoder = MavDataDecoder(bytes)

      val vtolState = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavVtolState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val landedState = decoder.safeDecodeEnumValue(1).let { value ->
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
