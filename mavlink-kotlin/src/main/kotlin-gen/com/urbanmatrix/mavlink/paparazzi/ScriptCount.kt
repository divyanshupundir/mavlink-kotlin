package com.urbanmatrix.mavlink.paparazzi

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
 * This message is emitted as response to SCRIPT_REQUEST_LIST by the MAV to get the number of
 * mission scripts.
 */
public data class ScriptCount(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Number of script items in the sequence
   */
  public val count: Int = 0,
) : MavMessage<ScriptCount> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptCount> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint16(count)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 183

    private const val CRC: Int = 182

    private val DESERIALIZER: MavDeserializer<ScriptCount> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint16()
      ScriptCount(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        count = count,
      )
    }


    private val METADATA: MavMessage.Metadata<ScriptCount> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScriptCount> = METADATA
  }
}
