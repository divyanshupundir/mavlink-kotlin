package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt8Array
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Send raw controller memory. The use of this message is discouraged for normal packets, but a
 * quite efficient way for testing new messages and getting experimental debug output.
 */
@GeneratedMavMessage(
  id = 249u,
  crcExtra = -52,
)
public data class MemoryVect(
  /**
   * Starting address of the debug variables
   */
  @GeneratedMavField(type = "uint16_t")
  public val address: UShort = 0u,
  /**
   * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below
   */
  @GeneratedMavField(type = "uint8_t")
  public val ver: UByte = 0u,
  /**
   * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15,
   * 3=16 x 1Q14
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: UByte = 0u,
  /**
   * Memory contents at specified address
   */
  @GeneratedMavField(type = "int8_t[32]")
  public val `value`: List<Byte> = emptyList(),
) : MavMessage<MemoryVect> {
  public override val instanceCompanion: MavMessage.MavCompanion<MemoryVect> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(address)
    output.encodeUInt8(ver)
    output.encodeUInt8(type)
    output.encodeInt8Array(value, 32)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(address)
    output.encodeUInt8(ver)
    output.encodeUInt8(type)
    output.encodeInt8Array(value, 32)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MemoryVect> {
    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 36

    public override val id: UInt = 249u

    public override val crcExtra: Byte = -52

    public override fun deserialize(source: BufferedSource): MemoryVect {
      val address = source.decodeUInt16()
      val ver = source.decodeUInt8()
      val type = source.decodeUInt8()
      val value = source.decodeInt8Array(32)

      return MemoryVect(
        address = address,
        ver = ver,
        type = type,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MemoryVect =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var address: UShort = 0u

    public var ver: UByte = 0u

    public var type: UByte = 0u

    public var `value`: List<Byte> = emptyList()

    public fun build(): MemoryVect = MemoryVect(
      address = address,
      ver = ver,
      type = type,
      value = value,
    )
  }
}
