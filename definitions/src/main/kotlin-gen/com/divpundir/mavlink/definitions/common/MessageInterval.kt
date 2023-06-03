package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
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
 *
 *         The interval between messages for a particular MAVLink message ID.
 *         This message is sent in response to the MAV_CMD_REQUEST_MESSAGE command with param1=244
 * (this message) and param2=message_id (the id of the message for which the interval is required).
 * 	It may also be sent in response to MAV_CMD_GET_MESSAGE_INTERVAL.
 * 	This interface replaces DATA_STREAM.
 */
@GeneratedMavMessage(
  id = 244u,
  crcExtra = 95,
)
public data class MessageInterval(
  /**
   * The ID of the requested MAVLink message. v1.0 is limited to 254 messages.
   */
  @GeneratedMavField(type = "uint16_t")
  public val messageId: UShort = 0u,
  /**
   * The interval between two messages. A value of -1 indicates this stream is disabled, 0 indicates
   * it is not available, > 0 indicates the interval at which it is sent.
   */
  @GeneratedMavField(type = "int32_t")
  public val intervalUs: Int = 0,
) : MavMessage<MessageInterval> {
  public override val instanceCompanion: MavMessage.MavCompanion<MessageInterval> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(intervalUs)
    outputBuffer.encodeUInt16(messageId)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(intervalUs)
    outputBuffer.encodeUInt16(messageId)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MessageInterval> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 244u

    public override val crcExtra: Byte = 95

    public override fun deserialize(bytes: ByteArray): MessageInterval {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val intervalUs = inputBuffer.decodeInt32()
      val messageId = inputBuffer.decodeUInt16()

      return MessageInterval(
        messageId = messageId,
        intervalUs = intervalUs,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MessageInterval =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var messageId: UShort = 0u

    public var intervalUs: Int = 0

    public fun build(): MessageInterval = MessageInterval(
      messageId = messageId,
      intervalUs = intervalUs,
    )
  }
}
