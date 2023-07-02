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
 * Data packet, size 32.
 */
@GeneratedMavMessage(
  id = 170u,
  crcExtra = 73,
)
public data class Data32(
  /**
   * Data type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: UByte = 0u,
  /**
   * Data length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: UByte = 0u,
  /**
   * Raw data.
   */
  @GeneratedMavField(type = "uint8_t[32]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<Data32> {
  public override val instanceCompanion: MavMessage.MavCompanion<Data32> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt8(type)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 32)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt8(type)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 32)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Data32> {
    private const val SIZE_V1: Int = 34

    private const val SIZE_V2: Int = 34

    public override val id: UInt = 170u

    public override val crcExtra: Byte = 73

    public override fun deserialize(bytes: ByteArray): Data32 {
      val decoder = MavDataDecoder.wrap(bytes)

      val type = decoder.safeDecodeUInt8()
      val len = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(32)

      return Data32(
        type = type,
        len = len,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Data32 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: UByte = 0u

    public var len: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): Data32 = Data32(
      type = type,
      len = len,
      data = data,
    )
  }
}
