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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetNetwork)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(payload, 251)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetNetwork)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(payload, 251)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<FileTransferProtocol> {
    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    public override val id: UInt = 110u

    public override val crcExtra: Byte = 84

    public override fun deserialize(source: BufferedSource): FileTransferProtocol {
      val targetNetwork = source.decodeUInt8()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val payload = source.decodeUInt8Array(251)

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
