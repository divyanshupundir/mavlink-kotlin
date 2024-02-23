package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * File transfer protocol message: https://mavlink.io/en/services/ftp.html.
 *
 * @param targetNetwork Network ID (0 for broadcast)
 * @param targetSystem System ID (0 for broadcast)
 * @param targetComponent Component ID (0 for broadcast)
 * @param payload Variable length payload. The length is defined by the remaining message length
 * when subtracting the header and other fields. The content/format of this block is defined in
 * https://mavlink.io/en/services/ftp.html.
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
  override val instanceCompanion: MavMessage.MavCompanion<FileTransferProtocol> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetNetwork)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(payload, 251)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetNetwork)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(payload, 251)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FileTransferProtocol> {
    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    override val id: UInt = 110u

    override val crcExtra: Byte = 84

    override fun deserialize(bytes: ByteArray): FileTransferProtocol {
      val decoder = MavDataDecoder(bytes)

      val targetNetwork = decoder.safeDecodeUInt8()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val payload = decoder.safeDecodeUInt8Array(251)

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
