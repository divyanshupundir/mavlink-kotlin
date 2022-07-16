package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * Event message. Each new event from a particular component gets a new sequence number. The same
 * message might be sent multiple times if (re-)requested. Most events are broadcast, some can be
 * specific to a target component (as receivers keep track of the sequence for missed events, all
 * events need to be broadcast. Thus we use destination_component instead of target_component).
 */
public data class Event(
  /**
   * Component ID
   */
  public val destinationComponent: Int = 0,
  /**
   * System ID
   */
  public val destinationSystem: Int = 0,
  /**
   * Event ID (as defined in the component metadata)
   */
  public val id: Long = 0L,
  /**
   * Timestamp (time since system boot when the event happened).
   */
  public val eventTimeBootMs: Long = 0L,
  /**
   * Sequence number.
   */
  public val sequence: Int = 0,
  /**
   * Log levels: 4 bits MSB: internal (for logging purposes), 4 bits LSB: external. Levels:
   * Emergency = 0, Alert = 1, Critical = 2, Error = 3, Warning = 4, Notice = 5, Info = 6, Debug = 7,
   * Protocol = 8, Disabled = 9
   */
  public val logLevels: Int = 0,
  /**
   * Arguments (depend on event ID).
   */
  public val arguments: List<Int> = emptyList(),
) : MavMessage<Event> {
  public override val instanceMetadata: MavMessage.Metadata<Event> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(id)
    outputBuffer.encodeUint32(eventTimeBootMs)
    outputBuffer.encodeUint16(sequence)
    outputBuffer.encodeUint8(destinationComponent)
    outputBuffer.encodeUint8(destinationSystem)
    outputBuffer.encodeUint8(logLevels)
    outputBuffer.encodeUint8Array(arguments, 40)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 410

    private const val CRC: Int = 38

    private const val SIZE: Int = 53

    private val DESERIALIZER: MavDeserializer<Event> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for Event: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val id = inputBuffer.decodeUint32()
      val eventTimeBootMs = inputBuffer.decodeUint32()
      val sequence = inputBuffer.decodeUint16()
      val destinationComponent = inputBuffer.decodeUint8()
      val destinationSystem = inputBuffer.decodeUint8()
      val logLevels = inputBuffer.decodeUint8()
      val arguments = inputBuffer.decodeUint8Array(40)

      Event(
        destinationComponent = destinationComponent,
        destinationSystem = destinationSystem,
        id = id,
        eventTimeBootMs = eventTimeBootMs,
        sequence = sequence,
        logLevels = logLevels,
        arguments = arguments,
      )
    }


    private val METADATA: MavMessage.Metadata<Event> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Event> = METADATA
  }
}
