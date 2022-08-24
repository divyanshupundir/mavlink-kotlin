package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * Read registers reply.
 */
@GeneratedMavMessage(
  id = 11001,
  crc = 15,
)
public data class DeviceOpReadReply(
  /**
   * Request ID - copied from request.
   */
  public val requestId: Long = 0L,
  /**
   * 0 for success, anything else is failure code.
   */
  public val result: Int = 0,
  /**
   * Starting register.
   */
  public val regstart: Int = 0,
  /**
   * Count of bytes read.
   */
  public val count: Int = 0,
  /**
   * Reply data.
   */
  public val `data`: List<Int> = emptyList(),
  /**
   * Bank number.
   */
  public val bank: Int = 0,
) : MavMessage<DeviceOpReadReply> {
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpReadReply> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(result)
    outputBuffer.encodeUint8(regstart)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 128)
    outputBuffer.encodeUint8(bank)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11001

    private const val CRC: Int = 15

    private const val SIZE: Int = 136

    private val DESERIALIZER: MavDeserializer<DeviceOpReadReply> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint32()
      val result = inputBuffer.decodeUint8()
      val regstart = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(128)
      val bank = inputBuffer.decodeUint8()

      DeviceOpReadReply(
        requestId = requestId,
        result = result,
        regstart = regstart,
        count = count,
        data = data,
        bank = bank,
      )
    }


    private val METADATA: MavMessage.Metadata<DeviceOpReadReply> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DeviceOpReadReply> = METADATA
  }
}
