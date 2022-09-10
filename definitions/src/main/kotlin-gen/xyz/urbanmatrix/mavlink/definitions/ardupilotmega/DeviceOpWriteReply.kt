package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "uint32_t")
  public val requestId: Long = 0L,
  /**
   * 0 for success, anything else is failure code.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: Int = 0,
) : MavMessage<DeviceOpWriteReply> {
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpWriteReply> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(result)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(result)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 11003

    private const val CRC: Int = 64

    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: Long = 0L

    public var result: Int = 0

    public fun build(): DeviceOpWriteReply = DeviceOpWriteReply(
      requestId = requestId,
      result = result,
    )
  }
}
