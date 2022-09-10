package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Reply to LOG_REQUEST_LIST
 */
@GeneratedMavMessage(
  id = 118,
  crc = 56,
)
public data class LogEntry(
  /**
   * Log id
   */
  @GeneratedMavField(type = "uint16_t")
  public val id: Int = 0,
  /**
   * Total number of logs
   */
  @GeneratedMavField(type = "uint16_t")
  public val numLogs: Int = 0,
  /**
   * High log number
   */
  @GeneratedMavField(type = "uint16_t")
  public val lastLogNum: Int = 0,
  /**
   * UTC timestamp of log since 1970, or 0 if not available
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeUtc: Long = 0L,
  /**
   * Size of the log (may be approximate)
   */
  @GeneratedMavField(type = "uint32_t")
  public val size: Long = 0L,
) : MavMessage<LogEntry> {
  public override val instanceMetadata: MavMessage.Metadata<LogEntry> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeUtc)
    outputBuffer.encodeUint32(size)
    outputBuffer.encodeUint16(id)
    outputBuffer.encodeUint16(numLogs)
    outputBuffer.encodeUint16(lastLogNum)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeUtc)
    outputBuffer.encodeUint32(size)
    outputBuffer.encodeUint16(id)
    outputBuffer.encodeUint16(numLogs)
    outputBuffer.encodeUint16(lastLogNum)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 118

    private const val CRC: Int = 56

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    private val DESERIALIZER: MavDeserializer<LogEntry> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUtc = inputBuffer.decodeUint32()
      val size = inputBuffer.decodeUint32()
      val id = inputBuffer.decodeUint16()
      val numLogs = inputBuffer.decodeUint16()
      val lastLogNum = inputBuffer.decodeUint16()

      LogEntry(
        id = id,
        numLogs = numLogs,
        lastLogNum = lastLogNum,
        timeUtc = timeUtc,
        size = size,
      )
    }


    private val METADATA: MavMessage.Metadata<LogEntry> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LogEntry> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: Int = 0

    public var numLogs: Int = 0

    public var lastLogNum: Int = 0

    public var timeUtc: Long = 0L

    public var size: Long = 0L

    public fun build(): LogEntry = LogEntry(
      id = id,
      numLogs = numLogs,
      lastLogNum = lastLogNum,
      timeUtc = timeUtc,
      size = size,
    )
  }
}
