package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Request one or more events to be (re-)sent. If first_sequence==last_sequence, only a single event
 * is requested. Note that first_sequence can be larger than last_sequence (because the sequence number
 * can wrap). Each sequence will trigger an EVENT or EVENT_ERROR response.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 412,
  crc = 33,
)
public data class RequestEvent(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * First sequence number of the requested event.
   */
  public val firstSequence: Int = 0,
  /**
   * Last sequence number of the requested event.
   */
  public val lastSequence: Int = 0,
) : MavMessage<RequestEvent> {
  public override val instanceMetadata: MavMessage.Metadata<RequestEvent> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(firstSequence)
    outputBuffer.encodeUint16(lastSequence)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 412

    private const val CRC: Int = 33

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<RequestEvent> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val firstSequence = inputBuffer.decodeUint16()
      val lastSequence = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      RequestEvent(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        firstSequence = firstSequence,
        lastSequence = lastSequence,
      )
    }


    private val METADATA: MavMessage.Metadata<RequestEvent> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RequestEvent> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var firstSequence: Int = 0

    public var lastSequence: Int = 0

    public fun build(): RequestEvent = RequestEvent(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      firstSequence = firstSequence,
      lastSequence = lastSequence,
    )
  }
}
