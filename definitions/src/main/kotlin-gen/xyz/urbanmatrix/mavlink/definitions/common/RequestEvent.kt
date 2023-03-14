package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Request one or more events to be (re-)sent. If first_sequence==last_sequence, only a single event
 * is requested. Note that first_sequence can be larger than last_sequence (because the sequence number
 * can wrap). Each sequence will trigger an EVENT or EVENT_ERROR response.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 412u,
  crcExtra = 33,
)
public data class RequestEvent(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * First sequence number of the requested event.
   */
  @GeneratedMavField(type = "uint16_t")
  public val firstSequence: UShort = 0u,
  /**
   * Last sequence number of the requested event.
   */
  @GeneratedMavField(type = "uint16_t")
  public val lastSequence: UShort = 0u,
) : MavMessage<RequestEvent> {
  public override val instanceMetadata: MavMessage.Metadata<RequestEvent> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(firstSequence)
    outputBuffer.encodeUInt16(lastSequence)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(firstSequence)
    outputBuffer.encodeUInt16(lastSequence)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 412u

    private const val CRC_EXTRA: Byte = 33

    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    private val DESERIALIZER: MavDeserializer<RequestEvent> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val firstSequence = inputBuffer.decodeUInt16()
      val lastSequence = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      RequestEvent(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        firstSequence = firstSequence,
        lastSequence = lastSequence,
      )
    }


    private val METADATA: MavMessage.Metadata<RequestEvent> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RequestEvent> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RequestEvent =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var firstSequence: UShort = 0u

    public var lastSequence: UShort = 0u

    public fun build(): RequestEvent = RequestEvent(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      firstSequence = firstSequence,
      lastSequence = lastSequence,
    )
  }
}
