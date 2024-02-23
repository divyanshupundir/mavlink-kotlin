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
 * Request a list of available logs. On some systems calling this may stop on-board logging until
 * LOG_REQUEST_END is called. If there are no log files available this request shall be answered with
 * one LOG_ENTRY message with id = 0 and num_logs = 0.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param start First log id (0 for first available)
 * @param end Last log id (0xffff for last available)
 */
@GeneratedMavMessage(
  id = 117u,
  crcExtra = -128,
)
public data class LogRequestList(
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
   * First log id (0 for first available)
   */
  @GeneratedMavField(type = "uint16_t")
  public val start: UShort = 0u,
  /**
   * Last log id (0xffff for last available)
   */
  @GeneratedMavField(type = "uint16_t")
  public val end: UShort = 0u,
) : MavMessage<LogRequestList> {
  override val instanceCompanion: MavMessage.MavCompanion<LogRequestList> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(start)
    encoder.encodeUInt16(end)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(start)
    encoder.encodeUInt16(end)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogRequestList> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 117u

    override val crcExtra: Byte = -128

    override fun deserialize(bytes: ByteArray): LogRequestList {
      val decoder = MavDataDecoder(bytes)

      val start = decoder.safeDecodeUInt16()
      val end = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return LogRequestList(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        start = start,
        end = end,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogRequestList =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var start: UShort = 0u

    public var end: UShort = 0u

    public fun build(): LogRequestList = LogRequestList(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      start = start,
      end = end,
    )
  }
}
