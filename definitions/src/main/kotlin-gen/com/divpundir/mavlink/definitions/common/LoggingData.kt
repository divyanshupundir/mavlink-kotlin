package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * A message containing logged data (see also MAV_CMD_LOGGING_START)
 */
@GeneratedMavMessage(
  id = 266u,
  crcExtra = -63,
)
public data class LoggingData(
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
   * sequence number (can wrap)
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: UShort = 0u,
  /**
   * data length
   */
  @GeneratedMavField(type = "uint8_t")
  public val length: UByte = 0u,
  /**
   * offset into data where first message starts. This can be used for recovery, when a previous
   * message got lost (set to UINT8_MAX if no start exists).
   */
  @GeneratedMavField(type = "uint8_t")
  public val firstMessageOffset: UByte = 0u,
  /**
   * logged data
   */
  @GeneratedMavField(type = "uint8_t[249]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<LoggingData> {
  public override val instanceCompanion: MavMessage.MavCompanion<LoggingData> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(length)
    output.encodeUInt8(firstMessageOffset)
    output.encodeUInt8Array(data, 249)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(sequence)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(length)
    output.encodeUInt8(firstMessageOffset)
    output.encodeUInt8Array(data, 249)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LoggingData> {
    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    public override val id: UInt = 266u

    public override val crcExtra: Byte = -63

    public override fun deserialize(source: BufferedSource): LoggingData {
      val sequence = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val length = source.decodeUInt8()
      val firstMessageOffset = source.decodeUInt8()
      val data = source.decodeUInt8Array(249)

      return LoggingData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
        length = length,
        firstMessageOffset = firstMessageOffset,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LoggingData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var sequence: UShort = 0u

    public var length: UByte = 0u

    public var firstMessageOffset: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): LoggingData = LoggingData(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      sequence = sequence,
      length = length,
      firstMessageOffset = firstMessageOffset,
      data = data,
    )
  }
}
