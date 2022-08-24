package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 158,
  crc = 208,
)
public data class FlexifunctionCommandAck(
  /**
   * Command acknowledged
   */
  public val commandType: Int = 0,
  /**
   * result of acknowledge
   */
  public val result: Int = 0,
) : MavMessage<FlexifunctionCommandAck> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionCommandAck> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(commandType)
    outputBuffer.encodeUint16(result)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 158

    private const val CRC: Int = 208

    private const val SIZE: Int = 4

    private val DESERIALIZER: MavDeserializer<FlexifunctionCommandAck> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val commandType = inputBuffer.decodeUint16()
      val result = inputBuffer.decodeUint16()

      FlexifunctionCommandAck(
        commandType = commandType,
        result = result,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionCommandAck> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionCommandAck> = METADATA
  }
}
