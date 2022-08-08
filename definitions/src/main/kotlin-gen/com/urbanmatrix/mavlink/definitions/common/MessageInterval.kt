package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 *
 *         The interval between messages for a particular MAVLink message ID.
 *         This message is sent in response to the MAV_CMD_REQUEST_MESSAGE command with param1=244
 * (this message) and param2=message_id (the id of the message for which the interval is required).
 * 	It may also be sent in response to MAV_CMD_GET_MESSAGE_INTERVAL.
 * 	This interface replaces DATA_STREAM.
 */
@GeneratedMavMessage(
  id = 244,
  crc = 95,
)
public data class MessageInterval(
  /**
   * The ID of the requested MAVLink message. v1.0 is limited to 254 messages.
   */
  public val messageId: Int = 0,
  /**
   * The interval between two messages. A value of -1 indicates this stream is disabled, 0 indicates
   * it is not available, > 0 indicates the interval at which it is sent.
   */
  public val intervalUs: Int = 0,
) : MavMessage<MessageInterval> {
  public override val instanceMetadata: MavMessage.Metadata<MessageInterval> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(intervalUs)
    outputBuffer.encodeUint16(messageId)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 244

    private const val CRC: Int = 95

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<MessageInterval> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val intervalUs = inputBuffer.decodeInt32()
      val messageId = inputBuffer.decodeUint16()

      MessageInterval(
        messageId = messageId,
        intervalUs = intervalUs,
      )
    }


    private val METADATA: MavMessage.Metadata<MessageInterval> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MessageInterval> = METADATA
  }
}
