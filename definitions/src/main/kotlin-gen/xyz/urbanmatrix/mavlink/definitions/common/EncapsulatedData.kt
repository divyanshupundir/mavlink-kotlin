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
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data packet for images sent using the Image Transmission Protocol:
 * https://mavlink.io/en/services/image_transmission.html.
 */
@GeneratedMavMessage(
  id = 131,
  crc = 223,
)
public data class EncapsulatedData(
  /**
   * sequence number (starting with 0 on every transmission)
   */
  @GeneratedMavField(type = "uint16_t")
  public val seqnr: Int = 0,
  /**
   * image data bytes
   */
  @GeneratedMavField(type = "uint8_t[253]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<EncapsulatedData> {
  public override val instanceMetadata: MavMessage.Metadata<EncapsulatedData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seqnr)
    outputBuffer.encodeUint8Array(data, 253)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seqnr)
    outputBuffer.encodeUint8Array(data, 253)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 131

    private const val CRC: Int = 223

    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    private val DESERIALIZER: MavDeserializer<EncapsulatedData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seqnr = inputBuffer.decodeUint16()
      val data = inputBuffer.decodeUint8Array(253)

      EncapsulatedData(
        seqnr = seqnr,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<EncapsulatedData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EncapsulatedData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seqnr: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): EncapsulatedData = EncapsulatedData(
      seqnr = seqnr,
      data = data,
    )
  }
}
