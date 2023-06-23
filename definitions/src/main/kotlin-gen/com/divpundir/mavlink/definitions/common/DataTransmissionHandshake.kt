package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<DataTransmissionHandshake> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(size)
    output.encodeUInt16(width)
    output.encodeUInt16(height)
    output.encodeUInt16(packets)
    output.encodeEnumValue(type.value, 1)
    output.encodeUInt8(payload)
    output.encodeUInt8(jpgQuality)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(size)
    output.encodeUInt16(width)
    output.encodeUInt16(height)
    output.encodeUInt16(packets)
    output.encodeEnumValue(type.value, 1)
    output.encodeUInt8(payload)
    output.encodeUInt8(jpgQuality)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<DataTransmissionHandshake> {
    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    public override val id: UInt = 130u

    public override val crcExtra: Byte = 29

    public override fun deserialize(source: BufferedSource): DataTransmissionHandshake {
      val size = source.decodeUInt32()
      val width = source.decodeUInt16()
      val height = source.decodeUInt16()
      val packets = source.decodeUInt16()
      val type = source.decodeEnumValue(1).let { value ->
        val entry = MavlinkDataStreamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val payload = source.decodeUInt8()
      val jpgQuality = source.decodeUInt8()

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
