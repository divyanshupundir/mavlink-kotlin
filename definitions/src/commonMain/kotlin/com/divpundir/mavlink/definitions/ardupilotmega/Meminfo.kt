package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * State of autopilot RAM.
 */
@GeneratedMavMessage(
  id = 152u,
  crcExtra = -48,
)
public data class Meminfo(
  /**
   * Heap top.
   */
  @GeneratedMavField(type = "uint16_t")
  public val brkval: UShort = 0u,
  /**
   * Free memory.
   */
  @GeneratedMavField(type = "uint16_t")
  public val freemem: UShort = 0u,
  /**
   * Free memory (32 bit).
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val freemem32: UInt = 0u,
) : MavMessage<Meminfo> {
  public override val instanceCompanion: MavMessage.MavCompanion<Meminfo> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(brkval)
    encoder.encodeUInt16(freemem)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(brkval)
    encoder.encodeUInt16(freemem)
    encoder.encodeUInt32(freemem32)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Meminfo> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 152u

    public override val crcExtra: Byte = -48

    public override fun deserialize(bytes: ByteArray): Meminfo {
      val decoder = MavDataDecoder(bytes)

      val brkval = decoder.safeDecodeUInt16()
      val freemem = decoder.safeDecodeUInt16()
      val freemem32 = decoder.safeDecodeUInt32()

      return Meminfo(
        brkval = brkval,
        freemem = freemem,
        freemem32 = freemem32,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Meminfo =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var brkval: UShort = 0u

    public var freemem: UShort = 0u

    public var freemem32: UInt = 0u

    public fun build(): Meminfo = Meminfo(
      brkval = brkval,
      freemem = freemem,
      freemem32 = freemem32,
    )
  }
}
