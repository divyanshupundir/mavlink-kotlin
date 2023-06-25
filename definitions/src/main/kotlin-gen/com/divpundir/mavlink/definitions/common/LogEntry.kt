package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Reply to LOG_REQUEST_LIST
 */
@GeneratedMavMessage(
  id = 118u,
  crcExtra = 56,
)
public data class LogEntry(
  /**
   * Log id
   */
  @GeneratedMavField(type = "uint16_t")
  public val id: UShort = 0u,
  /**
   * Total number of logs
   */
  @GeneratedMavField(type = "uint16_t")
  public val numLogs: UShort = 0u,
  /**
   * High log number
   */
  @GeneratedMavField(type = "uint16_t")
  public val lastLogNum: UShort = 0u,
  /**
   * UTC timestamp of log since 1970, or 0 if not available
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeUtc: UInt = 0u,
  /**
   * Size of the log (may be approximate)
   */
  @GeneratedMavField(type = "uint32_t")
  public val size: UInt = 0u,
) : MavMessage<LogEntry> {
  public override val instanceCompanion: MavMessage.MavCompanion<LogEntry> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeUtc)
    buffer.encodeUInt32(size)
    buffer.encodeUInt16(id)
    buffer.encodeUInt16(numLogs)
    buffer.encodeUInt16(lastLogNum)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeUtc)
    buffer.encodeUInt32(size)
    buffer.encodeUInt16(id)
    buffer.encodeUInt16(numLogs)
    buffer.encodeUInt16(lastLogNum)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogEntry> {
    public override val id: UInt = 118u

    public override val crcExtra: Byte = 56

    public override fun deserialize(bytes: ByteArray): LogEntry {
      val buffer = Buffer().write(bytes)

      val timeUtc = buffer.decodeUInt32()
      val size = buffer.decodeUInt32()
      val id = buffer.decodeUInt16()
      val numLogs = buffer.decodeUInt16()
      val lastLogNum = buffer.decodeUInt16()

      return LogEntry(
        id = id,
        numLogs = numLogs,
        lastLogNum = lastLogNum,
        timeUtc = timeUtc,
        size = size,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogEntry =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UShort = 0u

    public var numLogs: UShort = 0u

    public var lastLogNum: UShort = 0u

    public var timeUtc: UInt = 0u

    public var size: UInt = 0u

    public fun build(): LogEntry = LogEntry(
      id = id,
      numLogs = numLogs,
      lastLogNum = lastLogNum,
      timeUtc = timeUtc,
      size = size,
    )
  }
}
