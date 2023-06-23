package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<ResourceRequest> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(requestId)
    output.encodeUInt8(uriType)
    output.encodeUInt8Array(uri, 120)
    output.encodeUInt8(transferType)
    output.encodeUInt8Array(storage, 120)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(requestId)
    output.encodeUInt8(uriType)
    output.encodeUInt8Array(uri, 120)
    output.encodeUInt8(transferType)
    output.encodeUInt8Array(storage, 120)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ResourceRequest> {
    private const val SIZE_V1: Int = 243

    private const val SIZE_V2: Int = 243

    public override val id: UInt = 142u

    public override val crcExtra: Byte = 72

    public override fun deserialize(source: BufferedSource): ResourceRequest {
      val requestId = source.decodeUInt8()
      val uriType = source.decodeUInt8()
      val uri = source.decodeUInt8Array(120)
      val transferType = source.decodeUInt8()
      val storage = source.decodeUInt8Array(120)

      return ResourceRequest(
        requestId = requestId,
        uriType = uriType,
        uri = uri,
        transferType = transferType,
        storage = storage,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ResourceRequest =
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
