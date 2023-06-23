package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Regular broadcast for the current latest event sequence number for a component. This is used to
 * check for dropped events.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 411u,
  crcExtra = 106,
)
public data class CurrentEventSequence(
  /**
   * Sequence number.
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: UShort = 0u,
  /**
   * Flag bitset.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavEnumValue<MavEventCurrentSequenceFlags> = MavEnumValue.fromValue(0u),
) : MavMessage<CurrentEventSequence> {
  public override val instanceCompanion: MavMessage.MavCompanion<CurrentEventSequence> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeEnumValue(flags.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeEnumValue(flags.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CurrentEventSequence> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 411u

    public override val crcExtra: Byte = 106

    public override fun deserialize(source: BufferedSource): CurrentEventSequence {
      val sequence = source.decodeUInt16()
      val flags = source.decodeEnumValue(1).let { value ->
        val entry = MavEventCurrentSequenceFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return CurrentEventSequence(
        sequence = sequence,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CurrentEventSequence =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sequence: UShort = 0u

    public var flags: MavEnumValue<MavEventCurrentSequenceFlags> = MavEnumValue.fromValue(0u)

    public fun build(): CurrentEventSequence = CurrentEventSequence(
      sequence = sequence,
      flags = flags,
    )
  }
}
