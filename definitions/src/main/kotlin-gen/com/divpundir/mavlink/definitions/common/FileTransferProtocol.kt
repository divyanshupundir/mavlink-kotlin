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
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<FileTransferProtocol> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetNetwork)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(payload, 251)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetNetwork)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(payload, 251)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FileTransferProtocol> {
    public override val id: UInt = 110u

    public override val crcExtra: Byte = 84

    public override fun deserialize(bytes: ByteArray): FileTransferProtocol {
      val buffer = Buffer().write(bytes)

      val targetNetwork = buffer.decodeUInt8()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val payload = buffer.decodeUInt8Array(251)

      return FileTransferProtocol(
        targetNetwork = targetNetwork,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        payload = payload,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FileTransferProtocol =
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
