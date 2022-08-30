package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * File transfer protocol message: https://mavlink.io/en/services/ftp.html.
 */
@GeneratedMavMessage(
  id = 110,
  crc = 84,
)
public data class FileTransferProtocol(
  /**
   * Network ID (0 for broadcast)
   */
  public val targetNetwork: Int = 0,
  /**
   * System ID (0 for broadcast)
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID (0 for broadcast)
   */
  public val targetComponent: Int = 0,
  /**
   * Variable length payload. The length is defined by the remaining message length when subtracting
   * the header and other fields. The content/format of this block is defined in
   * https://mavlink.io/en/services/ftp.html.
   */
  public val payload: List<Int> = emptyList(),
) : MavMessage<FileTransferProtocol> {
  public override val instanceMetadata: MavMessage.Metadata<FileTransferProtocol> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetNetwork)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(payload, 251)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 110

    private const val CRC: Int = 84

    private const val SIZE: Int = 254

    private val DESERIALIZER: MavDeserializer<FileTransferProtocol> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetNetwork = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val payload = inputBuffer.decodeUint8Array(251)

      FileTransferProtocol(
        targetNetwork = targetNetwork,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        payload = payload,
      )
    }


    private val METADATA: MavMessage.Metadata<FileTransferProtocol> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FileTransferProtocol> = METADATA
  }
}