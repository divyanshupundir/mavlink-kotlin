package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Flexifunction type and parameters for component at function index from buffer
 */
@GeneratedMavMessage(
  id = 153,
  crc = 109,
)
public data class FlexifunctionBufferFunctionAck(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Function index
   */
  public val funcIndex: Int = 0,
  /**
   * result of acknowledge, 0=fail, 1=good
   */
  public val result: Int = 0,
) : MavMessage<FlexifunctionBufferFunctionAck> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionBufferFunctionAck> =
      METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(funcIndex)
    outputBuffer.encodeUint16(result)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 153

    private const val CRC: Int = 109

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<FlexifunctionBufferFunctionAck> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val funcIndex = inputBuffer.decodeUint16()
      val result = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      FlexifunctionBufferFunctionAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        funcIndex = funcIndex,
        result = result,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionBufferFunctionAck> =
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionBufferFunctionAck> = METADATA
  }
}
