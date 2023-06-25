package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<RequestEvent> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(firstSequence)
    buffer.encodeUInt16(lastSequence)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(firstSequence)
    buffer.encodeUInt16(lastSequence)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RequestEvent> {
    public override val id: UInt = 412u

    public override val crcExtra: Byte = 33

    public override fun deserialize(bytes: ByteArray): RequestEvent {
      val buffer = Buffer().write(bytes)

      val firstSequence = buffer.decodeUInt16()
      val lastSequence = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return RequestEvent(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        firstSequence = firstSequence,
        lastSequence = lastSequence,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RequestEvent =
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
