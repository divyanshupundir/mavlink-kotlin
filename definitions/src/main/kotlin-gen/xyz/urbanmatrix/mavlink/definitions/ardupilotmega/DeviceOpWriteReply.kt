package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Write registers reply.
 */
@GeneratedMavMessage(
  id = 11003u,
  crcExtra = 64,
)
public data class DeviceOpWriteReply(
  /**
   * Request ID - copied from request.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: UInt = 0u,
  /**
   * 0 for success, anything else is failure code.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: UByte = 0u,
) : MavMessage<DeviceOpWriteReply> {
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpWriteReply> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeUInt8(result)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeUInt8(result)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11003u

    private const val CRC_EXTRA: Byte = 64

    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    private val DESERIALIZER: MavDeserializer<DeviceOpWriteReply> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUInt32()
      val result = inputBuffer.decodeUInt8()

      DeviceOpWriteReply(
        requestId = requestId,
        result = result,
      )
    }


    private val METADATA: MavMessage.Metadata<DeviceOpWriteReply> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DeviceOpWriteReply> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DeviceOpWriteReply =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: UInt = 0u

    public var result: UByte = 0u

    public fun build(): DeviceOpWriteReply = DeviceOpWriteReply(
      requestId = requestId,
      result = result,
    )
  }
}
