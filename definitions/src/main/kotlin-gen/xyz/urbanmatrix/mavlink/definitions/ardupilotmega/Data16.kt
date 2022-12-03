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
 * Data packet, size 16.
 */
@GeneratedMavMessage(
  id = 169,
  crc = 234,
)
public data class Data16(
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
  @GeneratedMavField(type = "uint8_t[16]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<Data16> {
  public override val instanceMetadata: MavMessage.Metadata<Data16> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 16)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 16)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 169

    private const val CRC: Int = 234

    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    private val DESERIALIZER: MavDeserializer<Data16> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val type = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(16)

      Data16(
        type = type,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<Data16> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Data16> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Data16 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: Int = 0

    public var len: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): Data16 = Data16(
      type = type,
      len = len,
      data = data,
    )
  }
}
