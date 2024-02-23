package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Reply to LOG_REQUEST_LIST
 *
 * @param id Log id
 * @param numLogs Total number of logs
 * @param lastLogNum High log number
 * @param timeUtc UTC timestamp of log since 1970, or 0 if not available
 * units = s
 * @param size Size of the log (may be approximate)
 * units = bytes
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
   * units = s
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeUtc: UInt = 0u,
  /**
   * Size of the log (may be approximate)
   * units = bytes
   */
  @GeneratedMavField(type = "uint32_t")
  public val size: UInt = 0u,
) : MavMessage<LogEntry> {
  override val instanceCompanion: MavMessage.MavCompanion<LogEntry> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeUtc)
    encoder.encodeUInt32(size)
    encoder.encodeUInt16(id)
    encoder.encodeUInt16(numLogs)
    encoder.encodeUInt16(lastLogNum)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeUtc)
    encoder.encodeUInt32(size)
    encoder.encodeUInt16(id)
    encoder.encodeUInt16(numLogs)
    encoder.encodeUInt16(lastLogNum)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogEntry> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    override val id: UInt = 118u

    override val crcExtra: Byte = 56

    override fun deserialize(bytes: ByteArray): LogEntry {
      val decoder = MavDataDecoder(bytes)

      val timeUtc = decoder.safeDecodeUInt32()
      val size = decoder.safeDecodeUInt32()
      val id = decoder.safeDecodeUInt16()
      val numLogs = decoder.safeDecodeUInt16()
      val lastLogNum = decoder.safeDecodeUInt16()

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
