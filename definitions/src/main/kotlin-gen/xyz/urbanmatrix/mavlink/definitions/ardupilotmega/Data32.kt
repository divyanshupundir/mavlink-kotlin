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
  public val type: Int = 0,
  /**
   * Data length.
   */
  public val len: Int = 0,
  /**
   * Raw data.
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<Data32> {
  public override val instanceMetadata: MavMessage.Metadata<Data32> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 32)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 170

    private const val CRC: Int = 73

    private const val SIZE: Int = 34

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
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
