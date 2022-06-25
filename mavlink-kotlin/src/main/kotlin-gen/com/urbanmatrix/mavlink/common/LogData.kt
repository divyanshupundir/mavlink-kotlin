package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * Reply to LOG_REQUEST_DATA
 */
public data class LogData(
  /**
   * Offset into the log
   */
  public val ofs: Long = 0L,
  /**
   * Log id (from LOG_ENTRY reply)
   */
  public val id: Int = 0,
  /**
   * Number of bytes (zero for end of log)
   */
  public val count: Int = 0,
  /**
   * log data
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<LogData> {
  public override val instanceMetadata: MavMessage.Metadata<LogData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(97).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(ofs)
    outputBuffer.encodeUint16(id)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 90)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 120

    private const val CRC: Int = 94

    private val DESERIALIZER: MavDeserializer<LogData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val ofs = inputBuffer.decodeUint32()
      val id = inputBuffer.decodeUint16()
      val count = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(90)
      LogData(
        ofs = ofs,
        id = id,
        count = count,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<LogData> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LogData> = METADATA
  }
}
