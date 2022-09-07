package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Request a list of available logs. On some systems calling this may stop on-board logging until
 * LOG_REQUEST_END is called. If there are no log files available this request shall be answered with
 * one LOG_ENTRY message with id = 0 and num_logs = 0.
 */
@GeneratedMavMessage(
  id = 117,
  crc = 128,
)
public data class LogRequestList(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * First log id (0 for first available)
   */
  public val start: Int = 0,
  /**
   * Last log id (0xffff for last available)
   */
  public val end: Int = 0,
) : MavMessage<LogRequestList> {
  public override val instanceMetadata: MavMessage.Metadata<LogRequestList> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(start)
    outputBuffer.encodeUint16(end)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 117

    private const val CRC: Int = 128

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<LogRequestList> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val start = inputBuffer.decodeUint16()
      val end = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      LogRequestList(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        start = start,
        end = end,
      )
    }


    private val METADATA: MavMessage.Metadata<LogRequestList> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LogRequestList> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var start: Int = 0

    public var end: Int = 0

    public fun build(): LogRequestList = LogRequestList(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      start = start,
      end = end,
    )
  }
}
