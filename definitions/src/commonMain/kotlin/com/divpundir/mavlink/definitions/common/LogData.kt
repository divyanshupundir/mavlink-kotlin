package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Reply to LOG_REQUEST_DATA
 *
 * @param id Log id (from LOG_ENTRY reply)
 * @param ofs Offset into the log
 * @param count Number of bytes (zero for end of log)
 * units = bytes
 * @param data log data
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
   * units = bytes
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * log data
   */
  @GeneratedMavField(type = "uint8_t[90]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<LogData> {
  override val instanceCompanion: MavMessage.MavCompanion<LogData> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(ofs)
    encoder.encodeUInt16(id)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 90)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(ofs)
    encoder.encodeUInt16(id)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 90)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogData> {
    private const val SIZE_V1: Int = 97

    private const val SIZE_V2: Int = 97

    override val id: UInt = 120u

    override val crcExtra: Byte = -122

    override fun deserialize(bytes: ByteArray): LogData {
      val decoder = MavDataDecoder(bytes)

      val ofs = decoder.safeDecodeUInt32()
      val id = decoder.safeDecodeUInt16()
      val count = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(90)

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
