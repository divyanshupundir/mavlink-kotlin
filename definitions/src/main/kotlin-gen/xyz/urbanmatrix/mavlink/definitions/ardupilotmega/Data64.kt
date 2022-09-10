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
 * Data packet, size 64.
 */
@GeneratedMavMessage(
  id = 171,
  crc = 181,
)
public data class Data64(
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
  @GeneratedMavField(type = "uint8_t[64]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<Data64> {
  public override val instanceMetadata: MavMessage.Metadata<Data64> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 64)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 64)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 171

    private const val CRC: Int = 181

    private const val SIZE: Int = 66

    private val DESERIALIZER: MavDeserializer<Data64> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val type = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(64)

      Data64(
        type = type,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<Data64> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Data64> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: Int = 0

    public var len: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): Data64 = Data64(
      type = type,
      len = len,
      data = data,
    )
  }
}
