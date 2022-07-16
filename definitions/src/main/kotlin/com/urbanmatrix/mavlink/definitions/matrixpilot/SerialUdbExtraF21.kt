package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F21 format
 */
public data class SerialUdbExtraF21(
  /**
   * SUE X accelerometer offset
   */
  public val sueAccelXOffset: Int = 0,
  /**
   * SUE Y accelerometer offset
   */
  public val sueAccelYOffset: Int = 0,
  /**
   * SUE Z accelerometer offset
   */
  public val sueAccelZOffset: Int = 0,
  /**
   * SUE X gyro offset
   */
  public val sueGyroXOffset: Int = 0,
  /**
   * SUE Y gyro offset
   */
  public val sueGyroYOffset: Int = 0,
  /**
   * SUE Z gyro offset
   */
  public val sueGyroZOffset: Int = 0,
) : MavMessage<SerialUdbExtraF21> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF21> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(sueAccelXOffset)
    outputBuffer.encodeInt16(sueAccelYOffset)
    outputBuffer.encodeInt16(sueAccelZOffset)
    outputBuffer.encodeInt16(sueGyroXOffset)
    outputBuffer.encodeInt16(sueGyroYOffset)
    outputBuffer.encodeInt16(sueGyroZOffset)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 187

    private const val CRC: Int = 134

    private const val SIZE: Int = 12

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF21> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SerialUdbExtraF21: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueAccelXOffset = inputBuffer.decodeInt16()
      val sueAccelYOffset = inputBuffer.decodeInt16()
      val sueAccelZOffset = inputBuffer.decodeInt16()
      val sueGyroXOffset = inputBuffer.decodeInt16()
      val sueGyroYOffset = inputBuffer.decodeInt16()
      val sueGyroZOffset = inputBuffer.decodeInt16()

      SerialUdbExtraF21(
        sueAccelXOffset = sueAccelXOffset,
        sueAccelYOffset = sueAccelYOffset,
        sueAccelZOffset = sueAccelZOffset,
        sueGyroXOffset = sueGyroXOffset,
        sueGyroYOffset = sueGyroYOffset,
        sueGyroZOffset = sueGyroZOffset,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF21> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF21> = METADATA
  }
}
