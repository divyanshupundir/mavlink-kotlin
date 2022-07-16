package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Reqest reading of flexifunction data
 */
public data class FlexifunctionReadReq(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Type of flexifunction data requested
   */
  public val readReqType: Int = 0,
  /**
   * index into data where needed
   */
  public val dataIndex: Int = 0,
) : MavMessage<FlexifunctionReadReq> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionReadReq> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(readReqType)
    outputBuffer.encodeInt16(dataIndex)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 151

    private const val CRC: Int = 26

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<FlexifunctionReadReq> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for FlexifunctionReadReq: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val readReqType = inputBuffer.decodeInt16()
      val dataIndex = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      FlexifunctionReadReq(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        readReqType = readReqType,
        dataIndex = dataIndex,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionReadReq> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionReadReq> = METADATA
  }
}
