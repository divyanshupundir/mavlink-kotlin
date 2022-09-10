package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "uint8_t")
  public val streamId: Int = 0,
  /**
   * The message rate
   */
  @GeneratedMavField(type = "uint16_t")
  public val messageRate: Int = 0,
  /**
   * 1 stream is enabled, 0 stream is stopped.
   */
  @GeneratedMavField(type = "uint8_t")
  public val onOff: Int = 0,
) : MavMessage<DataStream> {
  public override val instanceMetadata: MavMessage.Metadata<DataStream> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(messageRate)
    outputBuffer.encodeUint8(streamId)
    outputBuffer.encodeUint8(onOff)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(messageRate)
    outputBuffer.encodeUint8(streamId)
    outputBuffer.encodeUint8(onOff)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 67

    private const val CRC: Int = 21

    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var streamId: Int = 0

    public var messageRate: Int = 0

    public var onOff: Int = 0

    public fun build(): DataStream = DataStream(
      streamId = streamId,
      messageRate = messageRate,
      onOff = onOff,
    )
  }
}
