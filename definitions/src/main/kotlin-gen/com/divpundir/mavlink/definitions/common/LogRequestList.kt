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
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Request a list of available logs. On some systems calling this may stop on-board logging until
 * LOG_REQUEST_END is called. If there are no log files available this request shall be answered with
 * one LOG_ENTRY message with id = 0 and num_logs = 0.
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
  public override val instanceCompanion: MavMessage.MavCompanion<LogRequestList> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(start)
    buffer.encodeUInt16(end)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(start)
    buffer.encodeUInt16(end)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogRequestList> {
    public override val id: UInt = 117u

    public override val crcExtra: Byte = -128

    public override fun deserialize(bytes: ByteArray): LogRequestList {
      val buffer = Buffer().write(bytes)

      val start = buffer.decodeUInt16()
      val end = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

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
