package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
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
 * An ack for a LOGGING_DATA_ACKED message
 *
 * @param targetSystem system ID of the target
 * @param targetComponent component ID of the target
 * @param sequence sequence number (must match the one in LOGGING_DATA_ACKED)
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
  override val instanceCompanion: MavMessage.MavCompanion<LoggingAck> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LoggingAck> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    override val id: UInt = 268u

    override val crcExtra: Byte = 14

    override fun deserialize(bytes: ByteArray): LoggingAck {
      val decoder = MavDataDecoder(bytes)

      val sequence = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

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
