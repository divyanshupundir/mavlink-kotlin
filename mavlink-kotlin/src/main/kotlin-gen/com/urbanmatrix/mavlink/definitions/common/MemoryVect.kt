package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt8Array
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt8Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Send raw controller memory. The use of this message is discouraged for normal packets, but a
 * quite efficient way for testing new messages and getting experimental debug output.
 */
public data class MemoryVect(
  /**
   * Starting address of the debug variables
   */
  public val address: Int = 0,
  /**
   * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below
   */
  public val ver: Int = 0,
  /**
   * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15,
   * 3=16 x 1Q14
   */
  public val type: Int = 0,
  /**
   * Memory contents at specified address
   */
  public val `value`: List<Int> = emptyList(),
) : MavMessage<MemoryVect> {
  public override val instanceMetadata: MavMessage.Metadata<MemoryVect> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(address)
    outputBuffer.encodeUint8(ver)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeInt8Array(value, 32)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 249

    private const val CRC: Int = 204

    private const val SIZE: Int = 36

    private val DESERIALIZER: MavDeserializer<MemoryVect> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val address = inputBuffer.decodeUint16()
      val ver = inputBuffer.decodeUint8()
      val type = inputBuffer.decodeUint8()
      val value = inputBuffer.decodeInt8Array(32)

      MemoryVect(
        address = address,
        ver = ver,
        type = type,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<MemoryVect> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MemoryVect> = METADATA
  }
}
