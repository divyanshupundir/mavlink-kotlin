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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "uint8_t")
  public val requestId: Int = 0,
  /**
   * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary
   */
  @GeneratedMavField(type = "uint8_t")
  public val uriType: Int = 0,
  /**
   * The requested unique resource identifier (URI). It is not necessarily a straight domain name
   * (depends on the URI type enum)
   */
  @GeneratedMavField(type = "uint8_t[120]")
  public val uri: List<Int> = emptyList(),
  /**
   * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream.
   */
  @GeneratedMavField(type = "uint8_t")
  public val transferType: Int = 0,
  /**
   * The storage path the autopilot wants the URI to be stored in. Will only be valid if the
   * transfer_type has a storage associated (e.g. MAVLink FTP).
   */
  @GeneratedMavField(type = "uint8_t[120]")
  public val storage: List<Int> = emptyList(),
) : MavMessage<ResourceRequest> {
  public override val instanceMetadata: MavMessage.Metadata<ResourceRequest> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(requestId)
    outputBuffer.encodeUint8(uriType)
    outputBuffer.encodeUint8Array(uri, 120)
    outputBuffer.encodeUint8(transferType)
    outputBuffer.encodeUint8Array(storage, 120)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(requestId)
    outputBuffer.encodeUint8(uriType)
    outputBuffer.encodeUint8Array(uri, 120)
    outputBuffer.encodeUint8(transferType)
    outputBuffer.encodeUint8Array(storage, 120)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 142

    private const val CRC: Int = 72

    private const val SIZE_V1: Int = 243

    private const val SIZE_V2: Int = 243

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: Int = 0

    public var uriType: Int = 0

    public var uri: List<Int> = emptyList()

    public var transferType: Int = 0

    public var storage: List<Int> = emptyList()

    public fun build(): ResourceRequest = ResourceRequest(
      requestId = requestId,
      uriType = uriType,
      uri = uri,
      transferType = transferType,
      storage = storage,
    )
  }
}
