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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(ofs)
    outputBuffer.encodeUInt16(id)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeUInt8Array(data, 90)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(ofs)
    outputBuffer.encodeUInt16(id)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeUInt8Array(data, 90)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogData> {
    private const val SIZE_V1: Int = 97

    private const val SIZE_V2: Int = 97

    public override val id: UInt = 120u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): LogData {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val ofs = inputBuffer.decodeUInt32()
      val id = inputBuffer.decodeUInt16()
      val count = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(90)

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
