package com.urbanmatrix.mavlink.definitions.paparazzi

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * This message informs about the currently active SCRIPT.
 */
public data class ScriptCurrent(
  /**
   * Active Sequence
   */
  public val seq: Int = 0,
) : MavMessage<ScriptCurrent> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptCurrent> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 184

    private const val CRC: Int = 40

    private const val SIZE: Int = 2

    private val DESERIALIZER: MavDeserializer<ScriptCurrent> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seq = inputBuffer.decodeUint16()

      ScriptCurrent(
        seq = seq,
      )
    }


    private val METADATA: MavMessage.Metadata<ScriptCurrent> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScriptCurrent> = METADATA
  }
}
