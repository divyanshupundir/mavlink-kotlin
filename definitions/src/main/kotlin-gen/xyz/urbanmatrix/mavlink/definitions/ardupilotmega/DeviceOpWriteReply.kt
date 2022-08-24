package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Write registers reply.
 */
@GeneratedMavMessage(
  id = 11003,
  crc = 64,
)
public data class DeviceOpWriteReply(
  /**
   * Request ID - copied from request.
   */
  public val requestId: Long = 0L,
  /**
   * 0 for success, anything else is failure code.
   */
  public val result: Int = 0,
) : MavMessage<DeviceOpWriteReply> {
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpWriteReply> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(result)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11003

    private const val CRC: Int = 64

    private const val SIZE: Int = 5

    private val DESERIALIZER: MavDeserializer<DeviceOpWriteReply> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint32()
      val result = inputBuffer.decodeUint8()

      DeviceOpWriteReply(
        requestId = requestId,
        result = result,
      )
    }


    private val METADATA: MavMessage.Metadata<DeviceOpWriteReply> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DeviceOpWriteReply> = METADATA
  }
}
