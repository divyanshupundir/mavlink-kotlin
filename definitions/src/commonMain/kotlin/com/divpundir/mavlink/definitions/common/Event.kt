package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Event message. Each new event from a particular component gets a new sequence number. The same
 * message might be sent multiple times if (re-)requested. Most events are broadcast, some can be
 * specific to a target component (as receivers keep track of the sequence for missed events, all
 * events need to be broadcast. Thus we use destination_component instead of target_component).
 *
 * @param destinationComponent Component ID
 * @param destinationSystem System ID
 * @param id Event ID (as defined in the component metadata)
 * @param eventTimeBootMs Timestamp (time since system boot when the event happened).
 * units = ms
 * @param sequence Sequence number.
 * @param logLevels Log levels: 4 bits MSB: internal (for logging purposes), 4 bits LSB: external.
 * Levels: Emergency = 0, Alert = 1, Critical = 2, Error = 3, Warning = 4, Notice = 5, Info = 6, Debug
 * = 7, Protocol = 8, Disabled = 9
 * @param arguments Arguments (depend on event ID).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 410u,
  crcExtra = -96,
)
public data class Event(
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val destinationComponent: UByte = 0u,
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val destinationSystem: UByte = 0u,
  /**
   * Event ID (as defined in the component metadata)
   */
  @GeneratedMavField(type = "uint32_t")
  public val id: UInt = 0u,
  /**
   * Timestamp (time since system boot when the event happened).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val eventTimeBootMs: UInt = 0u,
  /**
   * Sequence number.
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: UShort = 0u,
  /**
   * Log levels: 4 bits MSB: internal (for logging purposes), 4 bits LSB: external. Levels:
   * Emergency = 0, Alert = 1, Critical = 2, Error = 3, Warning = 4, Notice = 5, Info = 6, Debug = 7,
   * Protocol = 8, Disabled = 9
   */
  @GeneratedMavField(type = "uint8_t")
  public val logLevels: UByte = 0u,
  /**
   * Arguments (depend on event ID).
   */
  @GeneratedMavField(type = "uint8_t[40]")
  public val arguments: List<UByte> = emptyList(),
) : MavMessage<Event> {
  override val instanceCompanion: MavMessage.MavCompanion<Event> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(id)
    encoder.encodeUInt32(eventTimeBootMs)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt8(destinationComponent)
    encoder.encodeUInt8(destinationSystem)
    encoder.encodeUInt8(logLevels)
    encoder.encodeUInt8Array(arguments, 40)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(id)
    encoder.encodeUInt32(eventTimeBootMs)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt8(destinationComponent)
    encoder.encodeUInt8(destinationSystem)
    encoder.encodeUInt8(logLevels)
    encoder.encodeUInt8Array(arguments, 40)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Event> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    override val id: UInt = 410u

    override val crcExtra: Byte = -96

    override fun deserialize(bytes: ByteArray): Event {
      val decoder = MavDataDecoder(bytes)

      val id = decoder.safeDecodeUInt32()
      val eventTimeBootMs = decoder.safeDecodeUInt32()
      val sequence = decoder.safeDecodeUInt16()
      val destinationComponent = decoder.safeDecodeUInt8()
      val destinationSystem = decoder.safeDecodeUInt8()
      val logLevels = decoder.safeDecodeUInt8()
      val arguments = decoder.safeDecodeUInt8Array(40)

      return Event(
        destinationComponent = destinationComponent,
        destinationSystem = destinationSystem,
        id = id,
        eventTimeBootMs = eventTimeBootMs,
        sequence = sequence,
        logLevels = logLevels,
        arguments = arguments,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Event =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var destinationComponent: UByte = 0u

    public var destinationSystem: UByte = 0u

    public var id: UInt = 0u

    public var eventTimeBootMs: UInt = 0u

    public var sequence: UShort = 0u

    public var logLevels: UByte = 0u

    public var arguments: List<UByte> = emptyList()

    public fun build(): Event = Event(
      destinationComponent = destinationComponent,
      destinationSystem = destinationSystem,
      id = id,
      eventTimeBootMs = eventTimeBootMs,
      sequence = sequence,
      logLevels = logLevels,
      arguments = arguments,
    )
  }
}
