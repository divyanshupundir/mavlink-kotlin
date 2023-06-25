package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Data packet, size 96.
 */
@GeneratedMavMessage(
  id = 172u,
  crcExtra = 22,
)
public data class Data96(
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
  @GeneratedMavField(type = "uint8_t[96]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<Data96> {
  public override val instanceCompanion: MavMessage.MavCompanion<Data96> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(type)
    buffer.encodeUInt8(len)
    buffer.encodeUInt8Array(data, 96)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(type)
    buffer.encodeUInt8(len)
    buffer.encodeUInt8Array(data, 96)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Data96> {
    public override val id: UInt = 172u

    public override val crcExtra: Byte = 22

    public override fun deserialize(bytes: ByteArray): Data96 {
      val buffer = Buffer().write(bytes)

      val type = buffer.decodeUInt8()
      val len = buffer.decodeUInt8()
      val data = buffer.decodeUInt8Array(96)

      return Data96(
        type = type,
        len = len,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Data96 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: UByte = 0u

    public var len: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): Data96 = Data96(
      type = type,
      len = len,
      data = data,
    )
  }
}
