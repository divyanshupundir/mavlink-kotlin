package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Message that announces the sequence number of the current active mission item. The MAV will fly
 * towards this mission item.
 */
public data class MissionCurrent(
  /**
   * Sequence
   */
  public val seq: Int = 0,
) : MavMessage<MissionCurrent> {
  public override val instanceMetadata: MavMessage.Metadata<MissionCurrent> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 42

    private const val CRC: Int = 28

    private const val SIZE: Int = 2

    private val DESERIALIZER: MavDeserializer<MissionCurrent> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seq = inputBuffer.decodeUint16()

      MissionCurrent(
        seq = seq,
      )
    }


    private val METADATA: MavMessage.Metadata<MissionCurrent> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MissionCurrent> = METADATA
  }
}
