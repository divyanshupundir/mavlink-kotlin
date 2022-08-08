package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * The autopilot is requesting a resource (file, binary, other type of data)
 */
@GeneratedMavMessage(
  id = 142,
  crc = 72,
)
public data class ResourceRequest(
  /**
   * Request ID. This ID should be re-used when sending back URI contents
   */
  public val requestId: Int = 0,
  /**
   * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary
   */
  public val uriType: Int = 0,
  /**
   * The requested unique resource identifier (URI). It is not necessarily a straight domain name
   * (depends on the URI type enum)
   */
  public val uri: List<Int> = emptyList(),
  /**
   * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream.
   */
  public val transferType: Int = 0,
  /**
   * The storage path the autopilot wants the URI to be stored in. Will only be valid if the
   * transfer_type has a storage associated (e.g. MAVLink FTP).
   */
  public val storage: List<Int> = emptyList(),
) : MavMessage<ResourceRequest> {
  public override val instanceMetadata: MavMessage.Metadata<ResourceRequest> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(requestId)
    outputBuffer.encodeUint8(uriType)
    outputBuffer.encodeUint8Array(uri, 120)
    outputBuffer.encodeUint8(transferType)
    outputBuffer.encodeUint8Array(storage, 120)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 142

    private const val CRC: Int = 72

    private const val SIZE: Int = 243

    private val DESERIALIZER: MavDeserializer<ResourceRequest> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint8()
      val uriType = inputBuffer.decodeUint8()
      val uri = inputBuffer.decodeUint8Array(120)
      val transferType = inputBuffer.decodeUint8()
      val storage = inputBuffer.decodeUint8Array(120)

      ResourceRequest(
        requestId = requestId,
        uriType = uriType,
        uri = uri,
        transferType = transferType,
        storage = storage,
      )
    }


    private val METADATA: MavMessage.Metadata<ResourceRequest> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ResourceRequest> = METADATA
  }
}
