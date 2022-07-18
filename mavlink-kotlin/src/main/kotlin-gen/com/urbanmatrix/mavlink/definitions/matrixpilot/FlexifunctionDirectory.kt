package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt8Array
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt8Array
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
public data class FlexifunctionDirectory(
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
   * Settings data
   */
  public val directoryData: List<Int> = emptyList(),
) : MavMessage<FlexifunctionDirectory> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionDirectory> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(directoryType)
    outputBuffer.encodeUint8(startIndex)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeInt8Array(directoryData, 48)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 155

    private const val CRC: Int = 12

    private const val SIZE: Int = 53

    private val DESERIALIZER: MavDeserializer<FlexifunctionDirectory> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val directoryType = inputBuffer.decodeUint8()
      val startIndex = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()
      val directoryData = inputBuffer.decodeInt8Array(48)

      FlexifunctionDirectory(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        directoryType = directoryType,
        startIndex = startIndex,
        count = count,
        directoryData = directoryData,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionDirectory> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionDirectory> = METADATA
  }
}
