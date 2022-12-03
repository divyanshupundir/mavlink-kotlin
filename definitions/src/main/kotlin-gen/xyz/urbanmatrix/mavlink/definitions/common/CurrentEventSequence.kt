package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Regular broadcast for the current latest event sequence number for a component. This is used to
 * check for dropped events.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 411,
  crc = 106,
)
public data class CurrentEventSequence(
  /**
   * Sequence number.
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: Int = 0,
  /**
   * Flag bitset.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavEnumValue<MavEventCurrentSequenceFlags> = MavEnumValue.fromValue(0),
) : MavMessage<CurrentEventSequence> {
  public override val instanceMetadata: MavMessage.Metadata<CurrentEventSequence> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(sequence)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(sequence)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 411

    private const val CRC: Int = 106

    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    private val DESERIALIZER: MavDeserializer<CurrentEventSequence> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sequence = inputBuffer.decodeUint16()
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavEventCurrentSequenceFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      CurrentEventSequence(
        sequence = sequence,
        flags = flags,
      )
    }


    private val METADATA: MavMessage.Metadata<CurrentEventSequence> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CurrentEventSequence> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CurrentEventSequence =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sequence: Int = 0

    public var flags: MavEnumValue<MavEventCurrentSequenceFlags> = MavEnumValue.fromValue(0)

    public fun build(): CurrentEventSequence = CurrentEventSequence(
      sequence = sequence,
      flags = flags,
    )
  }
}
