package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F22 format
 */
public data class SerialUdbExtraF22(
  /**
   * SUE X accelerometer at calibration time
   */
  public val sueAccelXAtCalibration: Int = 0,
  /**
   * SUE Y accelerometer at calibration time
   */
  public val sueAccelYAtCalibration: Int = 0,
  /**
   * SUE Z accelerometer at calibration time
   */
  public val sueAccelZAtCalibration: Int = 0,
  /**
   * SUE X gyro at calibration time
   */
  public val sueGyroXAtCalibration: Int = 0,
  /**
   * SUE Y gyro at calibration time
   */
  public val sueGyroYAtCalibration: Int = 0,
  /**
   * SUE Z gyro at calibration time
   */
  public val sueGyroZAtCalibration: Int = 0,
) : MavMessage<SerialUdbExtraF22> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF22> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(sueAccelXAtCalibration)
    outputBuffer.encodeInt16(sueAccelYAtCalibration)
    outputBuffer.encodeInt16(sueAccelZAtCalibration)
    outputBuffer.encodeInt16(sueGyroXAtCalibration)
    outputBuffer.encodeInt16(sueGyroYAtCalibration)
    outputBuffer.encodeInt16(sueGyroZAtCalibration)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 188

    private const val CRC: Int = 91

    private const val SIZE: Int = 12

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF22> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueAccelXAtCalibration = inputBuffer.decodeInt16()
      val sueAccelYAtCalibration = inputBuffer.decodeInt16()
      val sueAccelZAtCalibration = inputBuffer.decodeInt16()
      val sueGyroXAtCalibration = inputBuffer.decodeInt16()
      val sueGyroYAtCalibration = inputBuffer.decodeInt16()
      val sueGyroZAtCalibration = inputBuffer.decodeInt16()

      SerialUdbExtraF22(
        sueAccelXAtCalibration = sueAccelXAtCalibration,
        sueAccelYAtCalibration = sueAccelYAtCalibration,
        sueAccelZAtCalibration = sueAccelZAtCalibration,
        sueGyroXAtCalibration = sueGyroXAtCalibration,
        sueGyroYAtCalibration = sueGyroYAtCalibration,
        sueGyroZAtCalibration = sueGyroZAtCalibration,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF22> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF22> = METADATA
  }
}
