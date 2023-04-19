package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<DataStream> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(messageRate)
    outputBuffer.encodeUInt8(streamId)
    outputBuffer.encodeUInt8(onOff)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(messageRate)
    outputBuffer.encodeUInt8(streamId)
    outputBuffer.encodeUInt8(onOff)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 67u

    private const val CRC_EXTRA: Byte = 21

    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    private val DESERIALIZER: MavDeserializer<DataStream> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val messageRate = inputBuffer.decodeUInt16()
      val streamId = inputBuffer.decodeUInt8()
      val onOff = inputBuffer.decodeUInt8()

      DataStream(
        streamId = streamId,
        messageRate = messageRate,
        onOff = onOff,
      )
    }


    private val METADATA: MavMessage.Metadata<DataStream> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DataStream> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DataStream =
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
