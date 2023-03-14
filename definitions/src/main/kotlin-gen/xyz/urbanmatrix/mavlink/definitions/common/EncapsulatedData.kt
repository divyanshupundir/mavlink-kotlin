package xyz.urbanmatrix.mavlink.definitions.common

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
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data packet for images sent using the Image Transmission Protocol:
 * https://mavlink.io/en/services/image_transmission.html.
 */
@GeneratedMavMessage(
  id = 131u,
  crcExtra = -33,
)
public data class EncapsulatedData(
  /**
   * sequence number (starting with 0 on every transmission)
   */
  @GeneratedMavField(type = "uint16_t")
  public val seqnr: UShort = 0u,
  /**
   * image data bytes
   */
  @GeneratedMavField(type = "uint8_t[253]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<EncapsulatedData> {
  public override val instanceMetadata: MavMessage.Metadata<EncapsulatedData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(seqnr)
    outputBuffer.encodeUInt8Array(data, 253)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(seqnr)
    outputBuffer.encodeUInt8Array(data, 253)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 131u

    private const val CRC_EXTRA: Byte = -33

    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    private val DESERIALIZER: MavDeserializer<EncapsulatedData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seqnr = inputBuffer.decodeUInt16()
      val data = inputBuffer.decodeUInt8Array(253)

      EncapsulatedData(
        seqnr = seqnr,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<EncapsulatedData> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EncapsulatedData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): EncapsulatedData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seqnr: UShort = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): EncapsulatedData = EncapsulatedData(
      seqnr = seqnr,
      data = data,
    )
  }
}
