package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt16(brkval)
    buffer.encodeUInt16(freemem)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(brkval)
    buffer.encodeUInt16(freemem)
    buffer.encodeUInt32(freemem32)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Meminfo> {
    public override val id: UInt = 152u

    public override val crcExtra: Byte = -48

    public override fun deserialize(bytes: ByteArray): Meminfo {
      val buffer = Buffer().write(bytes)

      val brkval = buffer.decodeUInt16()
      val freemem = buffer.decodeUInt16()
      val freemem32 = buffer.decodeUInt32()

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
