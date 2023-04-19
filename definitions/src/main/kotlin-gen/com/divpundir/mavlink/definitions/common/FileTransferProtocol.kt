package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * File transfer protocol message: https://mavlink.io/en/services/ftp.html.
 */
@GeneratedMavMessage(
  id = 110u,
  crcExtra = 84,
)
public data class FileTransferProtocol(
  /**
   * Network ID (0 for broadcast)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetNetwork: UByte = 0u,
  /**
   * System ID (0 for broadcast)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (0 for broadcast)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Variable length payload. The length is defined by the remaining message length when subtracting
   * the header and other fields. The content/format of this block is defined in
   * https://mavlink.io/en/services/ftp.html.
   */
  @GeneratedMavField(type = "uint8_t[251]")
  public val payload: List<UByte> = emptyList(),
) : MavMessage<FileTransferProtocol> {
  public override val instanceMetadata: MavMessage.Metadata<FileTransferProtocol> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetNetwork)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(payload, 251)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetNetwork)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(payload, 251)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 110u

    private const val CRC_EXTRA: Byte = 84

    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    private val DESERIALIZER: MavDeserializer<FileTransferProtocol> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetNetwork = inputBuffer.decodeUInt8()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val payload = inputBuffer.decodeUInt8Array(251)

      FileTransferProtocol(
        targetNetwork = targetNetwork,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        payload = payload,
      )
    }


    private val METADATA: MavMessage.Metadata<FileTransferProtocol> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FileTransferProtocol> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FileTransferProtocol =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetNetwork: UByte = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var payload: List<UByte> = emptyList()

    public fun build(): FileTransferProtocol = FileTransferProtocol(
      targetNetwork = targetNetwork,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      payload = payload,
    )
  }
}
