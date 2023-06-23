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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(ofs)
    output.encodeUInt16(id)
    output.encodeUInt8(count)
    output.encodeUInt8Array(data, 90)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(ofs)
    output.encodeUInt16(id)
    output.encodeUInt8(count)
    output.encodeUInt8Array(data, 90)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LogData> {
    private const val SIZE_V1: Int = 97

    private const val SIZE_V2: Int = 97

    public override val id: UInt = 120u

    public override val crcExtra: Byte = -122

    public override fun deserialize(source: BufferedSource): LogData {
      val ofs = source.decodeUInt32()
      val id = source.decodeUInt16()
      val count = source.decodeUInt8()
      val data = source.decodeUInt8Array(90)

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
