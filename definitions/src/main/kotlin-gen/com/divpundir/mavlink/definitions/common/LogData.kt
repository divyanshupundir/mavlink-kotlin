package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Reply to LOG_REQUEST_DATA
 */
@GeneratedMavMessage(
  id = 120u,
  crcExtra = -122,
)
public data class LogData(
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
   * Number of bytes (zero for end of log)
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * log data
   */
  @GeneratedMavField(type = "uint8_t[90]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<LogData> {
  public override val instanceCompanion: MavMessage.MavCompanion<LogData> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(ofs)
    buffer.encodeUInt16(id)
    buffer.encodeUInt8(count)
    buffer.encodeUInt8Array(data, 90)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(ofs)
    buffer.encodeUInt16(id)
    buffer.encodeUInt8(count)
    buffer.encodeUInt8Array(data, 90)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogData> {
    public override val id: UInt = 120u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): LogData {
      val buffer = Buffer().write(bytes)

      val ofs = buffer.decodeUInt32()
      val id = buffer.decodeUInt16()
      val count = buffer.decodeUInt8()
      val data = buffer.decodeUInt8Array(90)

      return LogData(
        id = id,
        ofs = ofs,
        count = count,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UShort = 0u

    public var ofs: UInt = 0u

    public var count: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): LogData = LogData(
      id = id,
      ofs = ofs,
      count = count,
      data = data,
    )
  }
}
