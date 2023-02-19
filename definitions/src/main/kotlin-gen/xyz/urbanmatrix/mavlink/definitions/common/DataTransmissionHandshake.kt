package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Handshake message to initiate, control and stop image streaming when using the Image Transmission
 * Protocol: https://mavlink.io/en/services/image_transmission.html.
 */
@GeneratedMavMessage(
  id = 130u,
  crcExtra = 29,
)
public data class DataTransmissionHandshake(
  /**
   * Type of requested/acknowledged data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavlinkDataStreamType> = MavEnumValue.fromValue(0u),
  /**
   * total data size (set on ACK only).
   */
  @GeneratedMavField(type = "uint32_t")
  public val size: UInt = 0u,
  /**
   * Width of a matrix or image.
   */
  @GeneratedMavField(type = "uint16_t")
  public val width: UShort = 0u,
  /**
   * Height of a matrix or image.
   */
  @GeneratedMavField(type = "uint16_t")
  public val height: UShort = 0u,
  /**
   * Number of packets being sent (set on ACK only).
   */
  @GeneratedMavField(type = "uint16_t")
  public val packets: UShort = 0u,
  /**
   * Payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA)
   * (set on ACK only).
   */
  @GeneratedMavField(type = "uint8_t")
  public val payload: UByte = 0u,
  /**
   * JPEG quality. Values: [1-100].
   */
  @GeneratedMavField(type = "uint8_t")
  public val jpgQuality: UByte = 0u,
) : MavMessage<DataTransmissionHandshake> {
  public override val instanceMetadata: MavMessage.Metadata<DataTransmissionHandshake> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(size)
    outputBuffer.encodeUInt16(width)
    outputBuffer.encodeUInt16(height)
    outputBuffer.encodeUInt16(packets)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(payload)
    outputBuffer.encodeUInt8(jpgQuality)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(size)
    outputBuffer.encodeUInt16(width)
    outputBuffer.encodeUInt16(height)
    outputBuffer.encodeUInt16(packets)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(payload)
    outputBuffer.encodeUInt8(jpgQuality)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 130u

    private const val CRC_EXTRA: Byte = 29

    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    private val DESERIALIZER: MavDeserializer<DataTransmissionHandshake> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val size = inputBuffer.decodeUInt32()
      val width = inputBuffer.decodeUInt16()
      val height = inputBuffer.decodeUInt16()
      val packets = inputBuffer.decodeUInt16()
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavlinkDataStreamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val payload = inputBuffer.decodeUInt8()
      val jpgQuality = inputBuffer.decodeUInt8()

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
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DataTransmissionHandshake> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DataTransmissionHandshake =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: MavEnumValue<MavlinkDataStreamType> = MavEnumValue.fromValue(0u)

    public var size: UInt = 0u

    public var width: UShort = 0u

    public var height: UShort = 0u

    public var packets: UShort = 0u

    public var payload: UByte = 0u

    public var jpgQuality: UByte = 0u

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
