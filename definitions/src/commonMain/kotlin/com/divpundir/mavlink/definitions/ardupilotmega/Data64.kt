package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
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
 * Data packet, size 64.
 *
 * @param type Data type.
 * @param len Data length.
 * units = bytes
 * @param data Raw data.
 */
@GeneratedMavMessage(
  id = 171u,
  crcExtra = -75,
)
public data class Data64(
  /**
   * Data type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: UByte = 0u,
  /**
   * Data length.
   * units = bytes
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: UByte = 0u,
  /**
   * Raw data.
   */
  @GeneratedMavField(type = "uint8_t[64]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<Data64> {
  override val instanceCompanion: MavMessage.MavCompanion<Data64> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(type)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 64)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(type)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 64)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Data64> {
    private const val SIZE_V1: Int = 66

    private const val SIZE_V2: Int = 66

    override val id: UInt = 171u

    override val crcExtra: Byte = -75

    override fun deserialize(bytes: ByteArray): Data64 {
      val decoder = MavDataDecoder(bytes)

      val type = decoder.safeDecodeUInt8()
      val len = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(64)

      return Data64(
        type = type,
        len = len,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Data64 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: UByte = 0u

    public var len: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): Data64 = Data64(
      type = type,
      len = len,
      data = data,
    )
  }
}
