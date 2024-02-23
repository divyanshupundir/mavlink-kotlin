package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Read registers reply.
 *
 * @param requestId Request ID - copied from request.
 * @param result 0 for success, anything else is failure code.
 * @param regstart Starting register.
 * @param count Count of bytes read.
 * @param data Reply data.
 * @param bank Bank number.
 */
@GeneratedMavMessage(
  id = 11_001u,
  crcExtra = 15,
)
public data class DeviceOpReadReply(
  /**
   * Request ID - copied from request.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: UInt = 0u,
  /**
   * 0 for success, anything else is failure code.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: UByte = 0u,
  /**
   * Starting register.
   */
  @GeneratedMavField(type = "uint8_t")
  public val regstart: UByte = 0u,
  /**
   * Count of bytes read.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Reply data.
   */
  @GeneratedMavField(type = "uint8_t[128]")
  public val `data`: List<UByte> = emptyList(),
  /**
   * Bank number.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val bank: UByte = 0u,
) : MavMessage<DeviceOpReadReply> {
  override val instanceCompanion: MavMessage.MavCompanion<DeviceOpReadReply> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(result)
    encoder.encodeUInt8(regstart)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 128)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(result)
    encoder.encodeUInt8(regstart)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 128)
    encoder.encodeUInt8(bank)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DeviceOpReadReply> {
    private const val SIZE_V1: Int = 135

    private const val SIZE_V2: Int = 136

    override val id: UInt = 11_001u

    override val crcExtra: Byte = 15

    override fun deserialize(bytes: ByteArray): DeviceOpReadReply {
      val decoder = MavDataDecoder(bytes)

      val requestId = decoder.safeDecodeUInt32()
      val result = decoder.safeDecodeUInt8()
      val regstart = decoder.safeDecodeUInt8()
      val count = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(128)
      val bank = decoder.safeDecodeUInt8()

      return DeviceOpReadReply(
        requestId = requestId,
        result = result,
        regstart = regstart,
        count = count,
        data = data,
        bank = bank,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DeviceOpReadReply =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: UInt = 0u

    public var result: UByte = 0u

    public var regstart: UByte = 0u

    public var count: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public var bank: UByte = 0u

    public fun build(): DeviceOpReadReply = DeviceOpReadReply(
      requestId = requestId,
      result = result,
      regstart = regstart,
      count = count,
      data = data,
      bank = bank,
    )
  }
}
