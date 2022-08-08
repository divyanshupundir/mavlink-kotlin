package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Send a debug value. The index is used to discriminate between values. These values show up in the
 * plot of QGroundControl as DEBUG N.
 */
@GeneratedMavMessage(
  id = 254,
  crc = 46,
)
public data class Debug(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * index of debug variable
   */
  public val ind: Int = 0,
  /**
   * DEBUG value
   */
  public val `value`: Float = 0F,
) : MavMessage<Debug> {
  public override val instanceMetadata: MavMessage.Metadata<Debug> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(value)
    outputBuffer.encodeUint8(ind)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 254

    private const val CRC: Int = 46

    private const val SIZE: Int = 9

    private val DESERIALIZER: MavDeserializer<Debug> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val value = inputBuffer.decodeFloat()
      val ind = inputBuffer.decodeUint8()

      Debug(
        timeBootMs = timeBootMs,
        ind = ind,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<Debug> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Debug> = METADATA
  }
}
