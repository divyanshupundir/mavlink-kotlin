package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Send raw controller memory. The use of this message is discouraged for normal packets, but a
 * quite efficient way for testing new messages and getting experimental debug output.
 *
 * @param address Starting address of the debug variables
 * @param ver Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as
 * below
 * @param type Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16
 * x Q15, 3=16 x 1Q14
 * @param value Memory contents at specified address
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
  override val instanceCompanion: MavMessage.MavCompanion<MemoryVect> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(address)
    encoder.encodeUInt8(ver)
    encoder.encodeUInt8(type)
    encoder.encodeInt8Array(value, 32)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(address)
    encoder.encodeUInt8(ver)
    encoder.encodeUInt8(type)
    encoder.encodeInt8Array(value, 32)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MemoryVect> {
    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 36

    override val id: UInt = 249u

    override val crcExtra: Byte = -52

    override fun deserialize(bytes: ByteArray): MemoryVect {
      val decoder = MavDataDecoder(bytes)

      val address = decoder.safeDecodeUInt16()
      val ver = decoder.safeDecodeUInt8()
      val type = decoder.safeDecodeUInt8()
      val value = decoder.safeDecodeInt8Array(32)

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
