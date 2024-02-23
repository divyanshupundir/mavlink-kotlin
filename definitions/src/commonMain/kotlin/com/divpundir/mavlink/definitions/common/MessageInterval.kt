package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param messageId The ID of the requested MAVLink message. v1.0 is limited to 254 messages.
 * @param intervalUs The interval between two messages. A value of -1 indicates this stream is
 * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent.
 * units = us
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
   * units = us
   */
  @GeneratedMavField(type = "int32_t")
  public val intervalUs: Int = 0,
) : MavMessage<MessageInterval> {
  override val instanceCompanion: MavMessage.MavCompanion<MessageInterval> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(intervalUs)
    encoder.encodeUInt16(messageId)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(intervalUs)
    encoder.encodeUInt16(messageId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MessageInterval> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 244u

    override val crcExtra: Byte = 95

    override fun deserialize(bytes: ByteArray): MessageInterval {
      val decoder = MavDataDecoder(bytes)

      val intervalUs = decoder.safeDecodeInt32()
      val messageId = decoder.safeDecodeUInt16()

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
