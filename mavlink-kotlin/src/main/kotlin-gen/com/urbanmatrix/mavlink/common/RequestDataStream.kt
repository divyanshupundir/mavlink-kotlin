package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int

/**
 * Request a data stream.
 */
@Deprecated(message = "")
public data class RequestDataStream(
  /**
   * 1 to start sending, 0 to stop sending.
   */
  public val startStop: Int = 0,
  /**
   * The requested message rate
   */
  public val reqMessageRate: Int = 0,
  /**
   * The ID of the requested data stream
   */
  public val reqStreamId: Int = 0,
  /**
   * The target requested to send the message stream.
   */
  public val targetComponent: Int = 0,
  /**
   * The target requested to send the message stream.
   */
  public val targetSystem: Int = 0,
) : MavMessage<RequestDataStream> {
  public override val instanceMetadata: MavMessage.Metadata<RequestDataStream> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(6).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(reqMessageRate)
    outputBuffer.encodeUint8(startStop)
    outputBuffer.encodeUint8(reqStreamId)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(targetSystem)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 66

    private const val CRC: Int = 247

    private val DESERIALIZER: MavDeserializer<RequestDataStream> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val reqMessageRate = inputBuffer.decodeUint16()
      val startStop = inputBuffer.decodeUint8()
      val reqStreamId = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()
      RequestDataStream(
        startStop = startStop,
        reqMessageRate = reqMessageRate,
        reqStreamId = reqStreamId,
        targetComponent = targetComponent,
        targetSystem = targetSystem,
      )
    }


    private val METADATA: MavMessage.Metadata<RequestDataStream> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RequestDataStream> = METADATA
  }
}
