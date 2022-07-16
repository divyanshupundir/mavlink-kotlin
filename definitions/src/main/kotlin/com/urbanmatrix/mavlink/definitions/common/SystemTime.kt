package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * The system time is the time of the master clock, typically the computer clock of the main onboard
 * computer.
 */
public data class SystemTime(
  /**
   * Timestamp (UNIX epoch time).
   */
  public val timeUnixUsec: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
) : MavMessage<SystemTime> {
  public override val instanceMetadata: MavMessage.Metadata<SystemTime> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUnixUsec)
    outputBuffer.encodeUint32(timeBootMs)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 2

    private const val CRC: Int = 137

    private const val SIZE: Int = 12

    private val DESERIALIZER: MavDeserializer<SystemTime> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SystemTime: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUnixUsec = inputBuffer.decodeUint64()
      val timeBootMs = inputBuffer.decodeUint32()

      SystemTime(
        timeUnixUsec = timeUnixUsec,
        timeBootMs = timeBootMs,
      )
    }


    private val METADATA: MavMessage.Metadata<SystemTime> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SystemTime> = METADATA
  }
}
