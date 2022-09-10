package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "uint32_t")
  public val requestId: Long = 0L,
  /**
   * 0 for success, anything else is failure code.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: Int = 0,
  /**
   * Starting register.
   */
  @GeneratedMavField(type = "uint8_t")
  public val regstart: Int = 0,
  /**
   * Count of bytes read.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: Int = 0,
  /**
   * Reply data.
   */
  @GeneratedMavField(type = "uint8_t[128]")
  public val `data`: List<Int> = emptyList(),
  /**
   * Bank number.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val bank: Int = 0,
) : MavMessage<DeviceOpReadReply> {
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpReadReply> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(result)
    outputBuffer.encodeUint8(regstart)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 128)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(result)
    outputBuffer.encodeUint8(regstart)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 128)
    outputBuffer.encodeUint8(bank)
    return outputBuffer.array().truncateZeros()
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: Long = 0L

    public var result: Int = 0

    public var regstart: Int = 0

    public var count: Int = 0

    public var `data`: List<Int> = emptyList()

    public var bank: Int = 0

    public fun build(): DeviceOpReadReply = DeviceOpReadReply(
      requestId = requestId,
      result = result,
      regstart = regstart,
      count = count,
      data = data,
      bank = bank,
    )
  }
}
