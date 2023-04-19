package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<LogEntry> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeUtc)
    outputBuffer.encodeUInt32(size)
    outputBuffer.encodeUInt16(id)
    outputBuffer.encodeUInt16(numLogs)
    outputBuffer.encodeUInt16(lastLogNum)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeUtc)
    outputBuffer.encodeUInt32(size)
    outputBuffer.encodeUInt16(id)
    outputBuffer.encodeUInt16(numLogs)
    outputBuffer.encodeUInt16(lastLogNum)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 118u

    private const val CRC_EXTRA: Byte = 56

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    private val DESERIALIZER: MavDeserializer<LogEntry> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUtc = inputBuffer.decodeUInt32()
      val size = inputBuffer.decodeUInt32()
      val id = inputBuffer.decodeUInt16()
      val numLogs = inputBuffer.decodeUInt16()
      val lastLogNum = inputBuffer.decodeUInt16()

      LogEntry(
        id = id,
        numLogs = numLogs,
        lastLogNum = lastLogNum,
        timeUtc = timeUtc,
        size = size,
      )
    }


    private val METADATA: MavMessage.Metadata<LogEntry> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LogEntry> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): LogEntry =
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
