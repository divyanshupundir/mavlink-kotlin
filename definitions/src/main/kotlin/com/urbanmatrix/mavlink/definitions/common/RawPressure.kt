package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * The RAW pressure readings for the typical setup of one absolute pressure and one differential
 * pressure sensor. The sensor values should be the raw, UNSCALED ADC values.
 */
public data class RawPressure(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Absolute pressure (raw)
   */
  public val pressAbs: Int = 0,
  /**
   * Differential pressure 1 (raw, 0 if nonexistent)
   */
  public val pressDiff1: Int = 0,
  /**
   * Differential pressure 2 (raw, 0 if nonexistent)
   */
  public val pressDiff2: Int = 0,
  /**
   * Raw Temperature measurement (raw)
   */
  public val temperature: Int = 0,
) : MavMessage<RawPressure> {
  public override val instanceMetadata: MavMessage.Metadata<RawPressure> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt16(pressAbs)
    outputBuffer.encodeInt16(pressDiff1)
    outputBuffer.encodeInt16(pressDiff2)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 28

    private const val CRC: Int = 67

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<RawPressure> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val pressAbs = inputBuffer.decodeInt16()
      val pressDiff1 = inputBuffer.decodeInt16()
      val pressDiff2 = inputBuffer.decodeInt16()
      val temperature = inputBuffer.decodeInt16()

      RawPressure(
        timeUsec = timeUsec,
        pressAbs = pressAbs,
        pressDiff1 = pressDiff1,
        pressDiff2 = pressDiff2,
        temperature = temperature,
      )
    }


    private val METADATA: MavMessage.Metadata<RawPressure> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RawPressure> = METADATA
  }
}
