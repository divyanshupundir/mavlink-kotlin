package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The autopilot is requesting a resource (file, binary, other type of data)
 */
@GeneratedMavMessage(
  id = 142u,
  crcExtra = 72,
)
public data class ResourceRequest(
  /**
   * Request ID. This ID should be re-used when sending back URI contents
   */
  @GeneratedMavField(type = "uint8_t")
  public val requestId: UByte = 0u,
  /**
   * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary
   */
  @GeneratedMavField(type = "uint8_t")
  public val uriType: UByte = 0u,
  /**
   * The requested unique resource identifier (URI). It is not necessarily a straight domain name
   * (depends on the URI type enum)
   */
  @GeneratedMavField(type = "uint8_t[120]")
  public val uri: List<UByte> = emptyList(),
  /**
   * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream.
   */
  @GeneratedMavField(type = "uint8_t")
  public val transferType: UByte = 0u,
  /**
   * The storage path the autopilot wants the URI to be stored in. Will only be valid if the
   * transfer_type has a storage associated (e.g. MAVLink FTP).
   */
  @GeneratedMavField(type = "uint8_t[120]")
  public val storage: List<UByte> = emptyList(),
) : MavMessage<ResourceRequest> {
  public override val instanceMetadata: MavMessage.Metadata<ResourceRequest> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(requestId)
    outputBuffer.encodeUInt8(uriType)
    outputBuffer.encodeUInt8Array(uri, 120)
    outputBuffer.encodeUInt8(transferType)
    outputBuffer.encodeUInt8Array(storage, 120)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(requestId)
    outputBuffer.encodeUInt8(uriType)
    outputBuffer.encodeUInt8Array(uri, 120)
    outputBuffer.encodeUInt8(transferType)
    outputBuffer.encodeUInt8Array(storage, 120)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 142u

    private const val CRC_EXTRA: Byte = 72

    private const val SIZE_V1: Int = 243

    private const val SIZE_V2: Int = 243

    private val DESERIALIZER: MavDeserializer<ResourceRequest> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUInt8()
      val uriType = inputBuffer.decodeUInt8()
      val uri = inputBuffer.decodeUInt8Array(120)
      val transferType = inputBuffer.decodeUInt8()
      val storage = inputBuffer.decodeUInt8Array(120)

      ResourceRequest(
        requestId = requestId,
        uriType = uriType,
        uri = uri,
        transferType = transferType,
        storage = storage,
      )
    }


    private val METADATA: MavMessage.Metadata<ResourceRequest> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ResourceRequest> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ResourceRequest =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: UByte = 0u

    public var uriType: UByte = 0u

    public var uri: List<UByte> = emptyList()

    public var transferType: UByte = 0u

    public var storage: List<UByte> = emptyList()

    public fun build(): ResourceRequest = ResourceRequest(
      requestId = requestId,
      uriType = uriType,
      uri = uri,
      transferType = transferType,
      storage = storage,
    )
  }
}
