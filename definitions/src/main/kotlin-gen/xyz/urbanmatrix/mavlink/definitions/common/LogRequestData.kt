package xyz.urbanmatrix.mavlink.definitions.common

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
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Request a chunk of a log
 */
@GeneratedMavMessage(
  id = 119,
  crc = 116,
)
public data class LogRequestData(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Log id (from LOG_ENTRY reply)
   */
  @GeneratedMavField(type = "uint16_t")
  public val id: Int = 0,
  /**
   * Offset into the log
   */
  @GeneratedMavField(type = "uint32_t")
  public val ofs: Long = 0L,
  /**
   * Number of bytes
   */
  @GeneratedMavField(type = "uint32_t")
  public val count: Long = 0L,
) : MavMessage<LogRequestData> {
  public override val instanceMetadata: MavMessage.Metadata<LogRequestData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(ofs)
    outputBuffer.encodeUint32(count)
    outputBuffer.encodeUint16(id)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(ofs)
    outputBuffer.encodeUint32(count)
    outputBuffer.encodeUint16(id)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 119

    private const val CRC: Int = 116

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<LogRequestData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val ofs = inputBuffer.decodeUint32()
      val count = inputBuffer.decodeUint32()
      val id = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      LogRequestData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        id = id,
        ofs = ofs,
        count = count,
      )
    }


    private val METADATA: MavMessage.Metadata<LogRequestData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LogRequestData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): LogRequestData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var id: Int = 0

    public var ofs: Long = 0L

    public var count: Long = 0L

    public fun build(): LogRequestData = LogRequestData(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      id = id,
      ofs = ofs,
      count = count,
    )
  }
}
