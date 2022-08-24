package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Request a data stream.
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 66,
  crc = 148,
)
public data class RequestDataStream(
  /**
   * The target requested to send the message stream.
   */
  public val targetSystem: Int = 0,
  /**
   * The target requested to send the message stream.
   */
  public val targetComponent: Int = 0,
  /**
   * The ID of the requested data stream
   */
  public val reqStreamId: Int = 0,
  /**
   * The requested message rate
   */
  public val reqMessageRate: Int = 0,
  /**
   * 1 to start sending, 0 to stop sending.
   */
  public val startStop: Int = 0,
) : MavMessage<RequestDataStream> {
  public override val instanceMetadata: MavMessage.Metadata<RequestDataStream> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(reqMessageRate)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(reqStreamId)
    outputBuffer.encodeUint8(startStop)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 66

    private const val CRC: Int = 148

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<RequestDataStream> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val reqMessageRate = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val reqStreamId = inputBuffer.decodeUint8()
      val startStop = inputBuffer.decodeUint8()

      RequestDataStream(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        reqStreamId = reqStreamId,
        reqMessageRate = reqMessageRate,
        startStop = startStop,
      )
    }


    private val METADATA: MavMessage.Metadata<RequestDataStream> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RequestDataStream> = METADATA
  }
}
