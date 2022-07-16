package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeInt32Array
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeInt32Array
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List

/**
 * ESC information for higher rate streaming. Recommended streaming rate is ~10 Hz. Information that
 * changes more slowly is sent in ESC_INFO. It should typically only be streamed on high-bandwidth
 * links (i.e. to a companion computer).
 */
public data class EscStatus(
  /**
   * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4.
   */
  public val index: Int = 0,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Reported motor RPM from each ESC (negative for reverse rotation).
   */
  public val rpm: List<Int> = emptyList(),
  /**
   * Voltage measured from each ESC.
   */
  public val voltage: List<Float> = emptyList(),
  /**
   * Current measured from each ESC.
   */
  public val current: List<Float> = emptyList(),
) : MavMessage<EscStatus> {
  public override val instanceMetadata: MavMessage.Metadata<EscStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt32Array(rpm, 16)
    outputBuffer.encodeFloatArray(voltage, 16)
    outputBuffer.encodeFloatArray(current, 16)
    outputBuffer.encodeUint8(index)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 291

    private const val CRC: Int = 158

    private const val SIZE: Int = 57

    private val DESERIALIZER: MavDeserializer<EscStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for EscStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val rpm = inputBuffer.decodeInt32Array(16)
      val voltage = inputBuffer.decodeFloatArray(16)
      val current = inputBuffer.decodeFloatArray(16)
      val index = inputBuffer.decodeUint8()

      EscStatus(
        index = index,
        timeUsec = timeUsec,
        rpm = rpm,
        voltage = voltage,
        current = current,
      )
    }


    private val METADATA: MavMessage.Metadata<EscStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EscStatus> = METADATA
  }
}
