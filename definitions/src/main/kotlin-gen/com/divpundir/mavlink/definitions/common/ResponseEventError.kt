package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
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
 * Response to a REQUEST_EVENT in case of an error (e.g. the event is not available anymore).
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
  public override val instanceCompanion: MavMessage.MavCompanion<ResponseEventError> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(sequence)
    buffer.encodeUInt16(sequenceOldestAvailable)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(reason.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(sequence)
    buffer.encodeUInt16(sequenceOldestAvailable)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(reason.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ResponseEventError> {
    public override val id: UInt = 413u

    public override val crcExtra: Byte = 77

    public override fun deserialize(bytes: ByteArray): ResponseEventError {
      val buffer = Buffer().write(bytes)

      val sequence = buffer.decodeUInt16()
      val sequenceOldestAvailable = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val reason = buffer.decodeEnumValue(1).let { value ->
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
