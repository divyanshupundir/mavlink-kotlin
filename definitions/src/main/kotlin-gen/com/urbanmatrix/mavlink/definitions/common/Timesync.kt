package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt64
import com.urbanmatrix.mavlink.serialization.encodeInt64
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Time synchronization message.
 */
@GeneratedMavMessage(
  id = 111,
  crc = 34,
)
public data class Timesync(
  /**
   * Time sync timestamp 1
   */
  public val tc1: Long = 0L,
  /**
   * Time sync timestamp 2
   */
  public val ts1: Long = 0L,
) : MavMessage<Timesync> {
  public override val instanceMetadata: MavMessage.Metadata<Timesync> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt64(tc1)
    outputBuffer.encodeInt64(ts1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 111

    private const val CRC: Int = 34

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<Timesync> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val tc1 = inputBuffer.decodeInt64()
      val ts1 = inputBuffer.decodeInt64()

      Timesync(
        tc1 = tc1,
        ts1 = ts1,
      )
    }


    private val METADATA: MavMessage.Metadata<Timesync> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Timesync> = METADATA
  }
}
