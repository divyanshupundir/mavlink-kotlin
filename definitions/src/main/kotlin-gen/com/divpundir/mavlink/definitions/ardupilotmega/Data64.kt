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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Data packet, size 64.
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
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: UByte = 0u,
  /**
   * Raw data.
   */
  @GeneratedMavField(type = "uint8_t[64]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<Data64> {
  public override val instanceCompanion: MavMessage.MavCompanion<Data64> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(type)
    output.encodeUInt8(len)
    output.encodeUInt8Array(data, 64)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(type)
    output.encodeUInt8(len)
    output.encodeUInt8Array(data, 64)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Data64> {
    private const val SIZE_V1: Int = 66

    private const val SIZE_V2: Int = 66

    public override val id: UInt = 171u

    public override val crcExtra: Byte = -75

    public override fun deserialize(source: BufferedSource): Data64 {
      val type = source.decodeUInt8()
      val len = source.decodeUInt8()
      val data = source.decodeUInt8Array(64)

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
