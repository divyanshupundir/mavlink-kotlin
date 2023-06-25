package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Data stream status information.
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 67u,
  crcExtra = 21,
)
public data class DataStream(
  /**
   * The ID of the requested data stream
   */
  @GeneratedMavField(type = "uint8_t")
  public val streamId: UByte = 0u,
  /**
   * The message rate
   */
  @GeneratedMavField(type = "uint16_t")
  public val messageRate: UShort = 0u,
  /**
   * 1 stream is enabled, 0 stream is stopped.
   */
  @GeneratedMavField(type = "uint8_t")
  public val onOff: UByte = 0u,
) : MavMessage<DataStream> {
  public override val instanceCompanion: MavMessage.MavCompanion<DataStream> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(messageRate)
    buffer.encodeUInt8(streamId)
    buffer.encodeUInt8(onOff)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(messageRate)
    buffer.encodeUInt8(streamId)
    buffer.encodeUInt8(onOff)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DataStream> {
    public override val id: UInt = 67u

    public override val crcExtra: Byte = 21

    public override fun deserialize(bytes: ByteArray): DataStream {
      val buffer = Buffer().write(bytes)

      val messageRate = buffer.decodeUInt16()
      val streamId = buffer.decodeUInt8()
      val onOff = buffer.decodeUInt8()

      return DataStream(
        streamId = streamId,
        messageRate = messageRate,
        onOff = onOff,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DataStream =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var streamId: UByte = 0u

    public var messageRate: UShort = 0u

    public var onOff: UByte = 0u

    public fun build(): DataStream = DataStream(
      streamId = streamId,
      messageRate = messageRate,
      onOff = onOff,
    )
  }
}
