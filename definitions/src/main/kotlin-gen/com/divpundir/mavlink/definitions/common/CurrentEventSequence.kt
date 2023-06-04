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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(sequence)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(sequence)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CurrentEventSequence> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 411u

    public override val crcExtra: Byte = 106

    public override fun deserialize(bytes: ByteArray): CurrentEventSequence {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sequence = inputBuffer.decodeUInt16()
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
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
