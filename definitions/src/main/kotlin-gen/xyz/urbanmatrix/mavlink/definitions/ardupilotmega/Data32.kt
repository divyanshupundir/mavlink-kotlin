package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data packet, size 32.
 */
@GeneratedMavMessage(
  id = 170,
  crc = 73,
)
public data class Data32(
  /**
   * Data type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: Int = 0,
  /**
   * Data length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: Int = 0,
  /**
   * Raw data.
   */
  @GeneratedMavField(type = "uint8_t[32]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<Data32> {
  public override val instanceMetadata: MavMessage.Metadata<Data32> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 32)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 32)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 170

    private const val CRC: Int = 73

    private const val SIZE_V1: Int = 34

    private const val SIZE_V2: Int = 34

    private val DESERIALIZER: MavDeserializer<Data32> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val type = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(32)

      Data32(
        type = type,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<Data32> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Data32> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Data32 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: Int = 0

    public var len: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): Data32 = Data32(
      type = type,
      len = len,
      data = data,
    )
  }
}
