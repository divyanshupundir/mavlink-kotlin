package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
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
 * An ack for a LOGGING_DATA_ACKED message
 */
@GeneratedMavMessage(
  id = 268u,
  crcExtra = 14,
)
public data class LoggingAck(
  /**
   * system ID of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * component ID of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * sequence number (must match the one in LOGGING_DATA_ACKED)
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: UShort = 0u,
) : MavMessage<LoggingAck> {
  public override val instanceCompanion: MavMessage.MavCompanion<LoggingAck> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LoggingAck> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    public override val id: UInt = 268u

    public override val crcExtra: Byte = 14

    public override fun deserialize(source: BufferedSource): LoggingAck {
      val sequence = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

      return LoggingAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LoggingAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var sequence: UShort = 0u

    public fun build(): LoggingAck = LoggingAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      sequence = sequence,
    )
  }
}
