package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt8Array
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<MemoryVect> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(address)
    outputBuffer.encodeUInt8(ver)
    outputBuffer.encodeUInt8(type)
    outputBuffer.encodeInt8Array(value, 32)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(address)
    outputBuffer.encodeUInt8(ver)
    outputBuffer.encodeUInt8(type)
    outputBuffer.encodeInt8Array(value, 32)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 249u

    private const val CRC_EXTRA: Byte = -52

    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 36

    private val DESERIALIZER: MavDeserializer<MemoryVect> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val address = inputBuffer.decodeUInt16()
      val ver = inputBuffer.decodeUInt8()
      val type = inputBuffer.decodeUInt8()
      val value = inputBuffer.decodeInt8Array(32)

      MemoryVect(
        address = address,
        ver = ver,
        type = type,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<MemoryVect> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MemoryVect> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): MemoryVect =
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
