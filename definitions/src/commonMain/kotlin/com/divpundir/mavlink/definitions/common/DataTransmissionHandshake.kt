package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Handshake message to initiate, control and stop image streaming when using the Image Transmission
 * Protocol: https://mavlink.io/en/services/image_transmission.html.
 *
 * @param type Type of requested/acknowledged data.
 * @param size total data size (set on ACK only).
 * units = bytes
 * @param width Width of a matrix or image.
 * @param height Height of a matrix or image.
 * @param packets Number of packets being sent (set on ACK only).
 * @param payload Payload size per packet (normally 253 byte, see DATA field size in message
 * ENCAPSULATED_DATA) (set on ACK only).
 * units = bytes
 * @param jpgQuality JPEG quality. Values: [1-100].
 * units = %
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
   * units = bytes
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
   * units = bytes
   */
  @GeneratedMavField(type = "uint8_t")
  public val payload: UByte = 0u,
  /**
   * JPEG quality. Values: [1-100].
   * units = %
   */
  @GeneratedMavField(type = "uint8_t")
  public val jpgQuality: UByte = 0u,
) : MavMessage<DataTransmissionHandshake> {
  override val instanceCompanion: MavMessage.MavCompanion<DataTransmissionHandshake> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(size)
    encoder.encodeUInt16(width)
    encoder.encodeUInt16(height)
    encoder.encodeUInt16(packets)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(payload)
    encoder.encodeUInt8(jpgQuality)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(size)
    encoder.encodeUInt16(width)
    encoder.encodeUInt16(height)
    encoder.encodeUInt16(packets)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(payload)
    encoder.encodeUInt8(jpgQuality)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DataTransmissionHandshake> {
    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    override val id: UInt = 130u

    override val crcExtra: Byte = 29

    override fun deserialize(bytes: ByteArray): DataTransmissionHandshake {
      val decoder = MavDataDecoder(bytes)

      val size = decoder.safeDecodeUInt32()
      val width = decoder.safeDecodeUInt16()
      val height = decoder.safeDecodeUInt16()
      val packets = decoder.safeDecodeUInt16()
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavlinkDataStreamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val payload = decoder.safeDecodeUInt8()
      val jpgQuality = decoder.safeDecodeUInt8()

      return DataTransmissionHandshake(
        type = type,
        size = size,
        width = width,
        height = height,
        packets = packets,
        payload = payload,
        jpgQuality = jpgQuality,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DataTransmissionHandshake =
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
