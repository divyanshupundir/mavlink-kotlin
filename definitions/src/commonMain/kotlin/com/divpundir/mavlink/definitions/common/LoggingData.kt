package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
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
 * A message containing logged data (see also MAV_CMD_LOGGING_START)
 *
 * @param targetSystem system ID of the target
 * @param targetComponent component ID of the target
 * @param sequence sequence number (can wrap)
 * @param length data length
 * units = bytes
 * @param firstMessageOffset offset into data where first message starts. This can be used for
 * recovery, when a previous message got lost (set to UINT8_MAX if no start exists).
 * units = bytes
 * @param data logged data
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
   * units = bytes
   */
  @GeneratedMavField(type = "uint8_t")
  public val length: UByte = 0u,
  /**
   * offset into data where first message starts. This can be used for recovery, when a previous
   * message got lost (set to UINT8_MAX if no start exists).
   * units = bytes
   */
  @GeneratedMavField(type = "uint8_t")
  public val firstMessageOffset: UByte = 0u,
  /**
   * logged data
   */
  @GeneratedMavField(type = "uint8_t[249]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<LoggingData> {
  override val instanceCompanion: MavMessage.MavCompanion<LoggingData> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(length)
    encoder.encodeUInt8(firstMessageOffset)
    encoder.encodeUInt8Array(data, 249)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(sequence)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(length)
    encoder.encodeUInt8(firstMessageOffset)
    encoder.encodeUInt8Array(data, 249)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LoggingData> {
    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    override val id: UInt = 266u

    override val crcExtra: Byte = -63

    override fun deserialize(bytes: ByteArray): LoggingData {
      val decoder = MavDataDecoder(bytes)

      val sequence = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val length = decoder.safeDecodeUInt8()
      val firstMessageOffset = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(249)

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
