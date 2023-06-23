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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeUInt16(sequenceOldestAvailable)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(reason.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeUInt16(sequenceOldestAvailable)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(reason.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ResponseEventError> {
    private const val SIZE_V1: Int = 7

    private const val SIZE_V2: Int = 7

    public override val id: UInt = 413u

    public override val crcExtra: Byte = 77

    public override fun deserialize(source: BufferedSource): ResponseEventError {
      val sequence = source.decodeUInt16()
      val sequenceOldestAvailable = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val reason = source.decodeEnumValue(1).let { value ->
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
