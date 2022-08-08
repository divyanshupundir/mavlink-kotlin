package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 156,
  crc = 218,
)
public data class FlexifunctionDirectoryAck(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * 0=inputs, 1=outputs
   */
  public val directoryType: Int = 0,
  /**
   * index of first directory entry to write
   */
  public val startIndex: Int = 0,
  /**
   * count of directory entries to write
   */
  public val count: Int = 0,
  /**
   * result of acknowledge, 0=fail, 1=good
   */
  public val result: Int = 0,
) : MavMessage<FlexifunctionDirectoryAck> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionDirectoryAck> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(result)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(directoryType)
    outputBuffer.encodeUint8(startIndex)
    outputBuffer.encodeUint8(count)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 156

    private const val CRC: Int = 218

    private const val SIZE: Int = 7

    private val DESERIALIZER: MavDeserializer<FlexifunctionDirectoryAck> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val result = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val directoryType = inputBuffer.decodeUint8()
      val startIndex = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()

      FlexifunctionDirectoryAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        directoryType = directoryType,
        startIndex = startIndex,
        count = count,
        result = result,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionDirectoryAck> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionDirectoryAck> = METADATA
  }
}
