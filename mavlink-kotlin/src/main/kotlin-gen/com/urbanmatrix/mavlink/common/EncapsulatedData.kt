package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Data packet for images sent using the Image Transmission Protocol:
 * https://mavlink.io/en/services/image_transmission.html.
 */
public data class EncapsulatedData(
  /**
   * sequence number (starting with 0 on every transmission)
   */
  public val seqnr: Int = 0,
  /**
   * image data bytes
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<EncapsulatedData> {
  public override val instanceMetadata: MavMessage.Metadata<EncapsulatedData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seqnr)
    outputBuffer.encodeUint8Array(data, 253)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 131

    private const val CRC: Int = 30

    private const val SIZE: Int = 255

    private val DESERIALIZER: MavDeserializer<EncapsulatedData> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for EncapsulatedData: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
  }
}
