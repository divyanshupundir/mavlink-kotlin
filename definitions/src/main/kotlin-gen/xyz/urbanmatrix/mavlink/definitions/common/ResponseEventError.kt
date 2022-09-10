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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Response to a REQUEST_EVENT in case of an error (e.g. the event is not available anymore).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 413,
  crc = 77,
)
public data class ResponseEventError(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Sequence number.
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: Int = 0,
  /**
   * Oldest Sequence number that is still available after the sequence set in REQUEST_EVENT.
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequenceOldestAvailable: Int = 0,
  /**
   * Error reason.
   */
  @GeneratedMavField(type = "uint8_t")
  public val reason: MavEnumValue<MavEventErrorReason> = MavEnumValue.fromValue(0),
) : MavMessage<ResponseEventError> {
  public override val instanceMetadata: MavMessage.Metadata<ResponseEventError> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(sequence)
    outputBuffer.encodeUint16(sequenceOldestAvailable)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(reason.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(sequence)
    outputBuffer.encodeUint16(sequenceOldestAvailable)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(reason.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 413

    private const val CRC: Int = 77

    private const val SIZE: Int = 7

    private val DESERIALIZER: MavDeserializer<ResponseEventError> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sequence = inputBuffer.decodeUint16()
      val sequenceOldestAvailable = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val reason = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavEventErrorReason.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      ResponseEventError(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
        sequenceOldestAvailable = sequenceOldestAvailable,
        reason = reason,
      )
    }


    private val METADATA: MavMessage.Metadata<ResponseEventError> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ResponseEventError> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var sequence: Int = 0

    public var sequenceOldestAvailable: Int = 0

    public var reason: MavEnumValue<MavEventErrorReason> = MavEnumValue.fromValue(0)

    public fun build(): ResponseEventError = ResponseEventError(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      sequence = sequence,
      sequenceOldestAvailable = sequenceOldestAvailable,
      reason = reason,
    )
  }
}
