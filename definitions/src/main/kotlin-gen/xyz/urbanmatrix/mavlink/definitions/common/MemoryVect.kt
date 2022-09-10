package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt8Array
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Send raw controller memory. The use of this message is discouraged for normal packets, but a
 * quite efficient way for testing new messages and getting experimental debug output.
 */
@GeneratedMavMessage(
  id = 249,
  crc = 204,
)
public data class MemoryVect(
  /**
   * Starting address of the debug variables
   */
  @GeneratedMavField(type = "uint16_t")
  public val address: Int = 0,
  /**
   * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below
   */
  @GeneratedMavField(type = "uint8_t")
  public val ver: Int = 0,
  /**
   * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15,
   * 3=16 x 1Q14
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: Int = 0,
  /**
   * Memory contents at specified address
   */
  @GeneratedMavField(type = "int8_t[32]")
  public val `value`: List<Int> = emptyList(),
) : MavMessage<MemoryVect> {
  public override val instanceMetadata: MavMessage.Metadata<MemoryVect> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(address)
    outputBuffer.encodeUint8(ver)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeInt8Array(value, 32)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(address)
    outputBuffer.encodeUint8(ver)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeInt8Array(value, 32)
    return outputBuffer.array().truncateZeros()
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var address: Int = 0

    public var ver: Int = 0

    public var type: Int = 0

    public var `value`: List<Int> = emptyList()

    public fun build(): MemoryVect = MemoryVect(
      address = address,
      ver = ver,
      type = type,
      value = value,
    )
  }
}
