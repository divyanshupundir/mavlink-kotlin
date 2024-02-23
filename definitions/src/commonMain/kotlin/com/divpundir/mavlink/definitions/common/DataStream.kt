package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Data stream status information.
 *
 * @param streamId The ID of the requested data stream
 * @param messageRate The message rate
 * units = Hz
 * @param onOff 1 stream is enabled, 0 stream is stopped.
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
   * units = Hz
   */
  @GeneratedMavField(type = "uint16_t")
  public val messageRate: UShort = 0u,
  /**
   * 1 stream is enabled, 0 stream is stopped.
   */
  @GeneratedMavField(type = "uint8_t")
  public val onOff: UByte = 0u,
) : MavMessage<DataStream> {
  override val instanceCompanion: MavMessage.MavCompanion<DataStream> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(messageRate)
    encoder.encodeUInt8(streamId)
    encoder.encodeUInt8(onOff)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(messageRate)
    encoder.encodeUInt8(streamId)
    encoder.encodeUInt8(onOff)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DataStream> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    override val id: UInt = 67u

    override val crcExtra: Byte = 21

    override fun deserialize(bytes: ByteArray): DataStream {
      val decoder = MavDataDecoder(bytes)

      val messageRate = decoder.safeDecodeUInt16()
      val streamId = decoder.safeDecodeUInt8()
      val onOff = decoder.safeDecodeUInt8()

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
