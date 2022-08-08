package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int

/**
 * Data stream status information.
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 67,
  crc = 21,
)
public data class DataStream(
  /**
   * The ID of the requested data stream
   */
  public val streamId: Int = 0,
  /**
   * The message rate
   */
  public val messageRate: Int = 0,
  /**
   * 1 stream is enabled, 0 stream is stopped.
   */
  public val onOff: Int = 0,
) : MavMessage<DataStream> {
  public override val instanceMetadata: MavMessage.Metadata<DataStream> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(messageRate)
    outputBuffer.encodeUint8(streamId)
    outputBuffer.encodeUint8(onOff)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 67

    private const val CRC: Int = 21

    private const val SIZE: Int = 4

    private val DESERIALIZER: MavDeserializer<DataStream> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val messageRate = inputBuffer.decodeUint16()
      val streamId = inputBuffer.decodeUint8()
      val onOff = inputBuffer.decodeUint8()

      DataStream(
        streamId = streamId,
        messageRate = messageRate,
        onOff = onOff,
      )
    }


    private val METADATA: MavMessage.Metadata<DataStream> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DataStream> = METADATA
  }
}
