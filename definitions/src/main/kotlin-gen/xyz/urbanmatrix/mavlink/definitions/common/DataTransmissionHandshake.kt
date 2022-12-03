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
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Handshake message to initiate, control and stop image streaming when using the Image Transmission
 * Protocol: https://mavlink.io/en/services/image_transmission.html.
 */
@GeneratedMavMessage(
  id = 130,
  crc = 29,
)
public data class DataTransmissionHandshake(
  /**
   * Type of requested/acknowledged data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavlinkDataStreamType> = MavEnumValue.fromValue(0),
  /**
   * total data size (set on ACK only).
   */
  @GeneratedMavField(type = "uint32_t")
  public val size: Long = 0L,
  /**
   * Width of a matrix or image.
   */
  @GeneratedMavField(type = "uint16_t")
  public val width: Int = 0,
  /**
   * Height of a matrix or image.
   */
  @GeneratedMavField(type = "uint16_t")
  public val height: Int = 0,
  /**
   * Number of packets being sent (set on ACK only).
   */
  @GeneratedMavField(type = "uint16_t")
  public val packets: Int = 0,
  /**
   * Payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA)
   * (set on ACK only).
   */
  @GeneratedMavField(type = "uint8_t")
  public val payload: Int = 0,
  /**
   * JPEG quality. Values: [1-100].
   */
  @GeneratedMavField(type = "uint8_t")
  public val jpgQuality: Int = 0,
) : MavMessage<DataTransmissionHandshake> {
  public override val instanceMetadata: MavMessage.Metadata<DataTransmissionHandshake> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(size)
    outputBuffer.encodeUint16(width)
    outputBuffer.encodeUint16(height)
    outputBuffer.encodeUint16(packets)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(payload)
    outputBuffer.encodeUint8(jpgQuality)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(size)
    outputBuffer.encodeUint16(width)
    outputBuffer.encodeUint16(height)
    outputBuffer.encodeUint16(packets)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(payload)
    outputBuffer.encodeUint8(jpgQuality)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 130

    private const val CRC: Int = 29

    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    private val DESERIALIZER: MavDeserializer<DataTransmissionHandshake> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val size = inputBuffer.decodeUint32()
      val width = inputBuffer.decodeUint16()
      val height = inputBuffer.decodeUint16()
      val packets = inputBuffer.decodeUint16()
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavlinkDataStreamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val payload = inputBuffer.decodeUint8()
      val jpgQuality = inputBuffer.decodeUint8()

      DataTransmissionHandshake(
        type = type,
        size = size,
        width = width,
        height = height,
        packets = packets,
        payload = payload,
        jpgQuality = jpgQuality,
      )
    }


    private val METADATA: MavMessage.Metadata<DataTransmissionHandshake> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DataTransmissionHandshake> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DataTransmissionHandshake =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: MavEnumValue<MavlinkDataStreamType> = MavEnumValue.fromValue(0)

    public var size: Long = 0L

    public var width: Int = 0

    public var height: Int = 0

    public var packets: Int = 0

    public var payload: Int = 0

    public var jpgQuality: Int = 0

    public fun build(): DataTransmissionHandshake = DataTransmissionHandshake(
      type = type,
      size = size,
      width = width,
      height = height,
      packets = packets,
      payload = payload,
      jpgQuality = jpgQuality,
    )
  }
}
