package com.divpundir.mavlink.definitions.cubepilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8Array
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
 * Raw RC Data
 */
@GeneratedMavMessage(
  id = 50_001u,
  crcExtra = -10,
)
public data class CubepilotRawRc(
  @GeneratedMavField(type = "uint8_t[32]")
  public val rcRaw: List<UByte> = emptyList(),
) : MavMessage<CubepilotRawRc> {
  public override val instanceCompanion: MavMessage.MavCompanion<CubepilotRawRc> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8Array(rcRaw, 32)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8Array(rcRaw, 32)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CubepilotRawRc> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    public override val id: UInt = 50_001u

    public override val crcExtra: Byte = -10

    public override fun deserialize(bytes: ByteArray): CubepilotRawRc {
      val decoder = MavDataDecoder(bytes)

      val rcRaw = decoder.safeDecodeUInt8Array(32)

      return CubepilotRawRc(
        rcRaw = rcRaw,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CubepilotRawRc =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rcRaw: List<UByte> = emptyList()

    public fun build(): CubepilotRawRc = CubepilotRawRc(
      rcRaw = rcRaw,
    )
  }
}
