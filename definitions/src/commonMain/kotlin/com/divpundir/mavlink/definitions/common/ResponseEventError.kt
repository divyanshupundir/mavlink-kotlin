package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
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
 * Response to a REQUEST_EVENT in case of an error (e.g. the event is not available anymore).
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param sequence Sequence number.
 * @param sequenceOldestAvailable Oldest Sequence number that is still available after the sequence
 * set in REQUEST_EVENT.
 * @param reason Error reason.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 413u,
  crcExtra = 77,
)
public data class ResponseEventError(
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
   * Sequence number.
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: UShort = 0u,
  /**
   * Oldest Sequence number that is still available after the sequence set in REQUEST_EVENT.
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequenceOldestAvailable: UShort = 0u,
  /**
   * Error reason.
   */
  @GeneratedMavField(type = "uint8_t")
  public val reason: MavEnumValue<MavEventErrorReason> = MavEnumValue.fromValue(0u),
) : MavMessage<ResponseEventError> {
  override val instanceCompanion: MavMessage.MavCompanion<ResponseEventError> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt16(sequenceOldestAvailable)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(reason.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt16(sequenceOldestAvailable)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(reason.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ResponseEventError> {
    private const val SIZE_V1: Int = 7

    private const val SIZE_V2: Int = 7

    override val id: UInt = 413u

    override val crcExtra: Byte = 77

    override fun deserialize(bytes: ByteArray): ResponseEventError {
      val decoder = MavDataDecoder(bytes)

      val sequence = decoder.safeDecodeUInt16()
      val sequenceOldestAvailable = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val reason = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavEventErrorReason.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ResponseEventError(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
        sequenceOldestAvailable = sequenceOldestAvailable,
        reason = reason,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ResponseEventError =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var sequence: UShort = 0u

    public var sequenceOldestAvailable: UShort = 0u

    public var reason: MavEnumValue<MavEventErrorReason> = MavEnumValue.fromValue(0u)

    public fun build(): ResponseEventError = ResponseEventError(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      sequence = sequence,
      sequenceOldestAvailable = sequenceOldestAvailable,
      reason = reason,
    )
  }
}
