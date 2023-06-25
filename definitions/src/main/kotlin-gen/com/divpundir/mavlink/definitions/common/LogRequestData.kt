package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
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
 * Request a chunk of a log
 */
@GeneratedMavMessage(
  id = 119u,
  crcExtra = 116,
)
public data class LogRequestData(
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
   * Log id (from LOG_ENTRY reply)
   */
  @GeneratedMavField(type = "uint16_t")
  public val id: UShort = 0u,
  /**
   * Offset into the log
   */
  @GeneratedMavField(type = "uint32_t")
  public val ofs: UInt = 0u,
  /**
   * Number of bytes
   */
  @GeneratedMavField(type = "uint32_t")
  public val count: UInt = 0u,
) : MavMessage<LogRequestData> {
  public override val instanceCompanion: MavMessage.MavCompanion<LogRequestData> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(ofs)
    buffer.encodeUInt32(count)
    buffer.encodeUInt16(id)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(ofs)
    buffer.encodeUInt32(count)
    buffer.encodeUInt16(id)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogRequestData> {
    public override val id: UInt = 119u

    public override val crcExtra: Byte = 116

    public override fun deserialize(bytes: ByteArray): LogRequestData {
      val buffer = Buffer().write(bytes)

      val ofs = buffer.decodeUInt32()
      val count = buffer.decodeUInt32()
      val id = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return LogRequestData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        id = id,
        ofs = ofs,
        count = count,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogRequestData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var id: UShort = 0u

    public var ofs: UInt = 0u

    public var count: UInt = 0u

    public fun build(): LogRequestData = LogRequestData(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      id = id,
      ofs = ofs,
      count = count,
    )
  }
}
