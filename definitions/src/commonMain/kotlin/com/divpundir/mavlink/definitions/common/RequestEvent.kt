package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Request one or more events to be (re-)sent. If first_sequence==last_sequence, only a single event
 * is requested. Note that first_sequence can be larger than last_sequence (because the sequence number
 * can wrap). Each sequence will trigger an EVENT or EVENT_ERROR response.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param firstSequence First sequence number of the requested event.
 * @param lastSequence Last sequence number of the requested event.
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
  override val instanceCompanion: MavMessage.MavCompanion<RequestEvent> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(firstSequence)
    encoder.encodeUInt16(lastSequence)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(firstSequence)
    encoder.encodeUInt16(lastSequence)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RequestEvent> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 412u

    override val crcExtra: Byte = 33

    override fun deserialize(bytes: ByteArray): RequestEvent {
      val decoder = MavDataDecoder(bytes)

      val firstSequence = decoder.safeDecodeUInt16()
      val lastSequence = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

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
