package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * Data packet, size 96.
 */
@GeneratedMavMessage(
  id = 172,
  crc = 22,
)
public data class Data96(
  /**
   * Data type.
   */
  public val type: Int = 0,
  /**
   * Data length.
   */
  public val len: Int = 0,
  /**
   * Raw data.
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<Data96> {
  public override val instanceMetadata: MavMessage.Metadata<Data96> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 96)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 172

    private const val CRC: Int = 22

    private const val SIZE: Int = 98

    private val DESERIALIZER: MavDeserializer<Data96> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val type = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(96)

      Data96(
        type = type,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<Data96> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Data96> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: Int = 0

    public var len: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): Data96 = Data96(
      type = type,
      len = len,
      data = data,
    )
  }
}
