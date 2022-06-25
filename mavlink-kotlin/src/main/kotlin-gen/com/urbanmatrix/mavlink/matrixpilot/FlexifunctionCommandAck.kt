package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
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
    val outputBuffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(commandType)
    outputBuffer.encodeUint16(result)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 158

    private const val CRC: Int = 208

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
