package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Offsets and calibrations values for hardware sensors. This makes it easier to debug the
 * calibration process.
 */
@GeneratedMavMessage(
  id = 150,
  crc = 134,
)
public data class SensorOffsets(
  /**
   * Magnetometer X offset.
   */
  public val magOfsX: Int = 0,
  /**
   * Magnetometer Y offset.
   */
  public val magOfsY: Int = 0,
  /**
   * Magnetometer Z offset.
   */
  public val magOfsZ: Int = 0,
  /**
   * Magnetic declination.
   */
  public val magDeclination: Float = 0F,
  /**
   * Raw pressure from barometer.
   */
  public val rawPress: Int = 0,
  /**
   * Raw temperature from barometer.
   */
  public val rawTemp: Int = 0,
  /**
   * Gyro X calibration.
   */
  public val gyroCalX: Float = 0F,
  /**
   * Gyro Y calibration.
   */
  public val gyroCalY: Float = 0F,
  /**
   * Gyro Z calibration.
   */
  public val gyroCalZ: Float = 0F,
  /**
   * Accel X calibration.
   */
  public val accelCalX: Float = 0F,
  /**
   * Accel Y calibration.
   */
  public val accelCalY: Float = 0F,
  /**
   * Accel Z calibration.
   */
  public val accelCalZ: Float = 0F,
) : MavMessage<SensorOffsets> {
  public override val instanceMetadata: MavMessage.Metadata<SensorOffsets> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(magDeclination)
    outputBuffer.encodeInt32(rawPress)
    outputBuffer.encodeInt32(rawTemp)
    outputBuffer.encodeFloat(gyroCalX)
    outputBuffer.encodeFloat(gyroCalY)
    outputBuffer.encodeFloat(gyroCalZ)
    outputBuffer.encodeFloat(accelCalX)
    outputBuffer.encodeFloat(accelCalY)
    outputBuffer.encodeFloat(accelCalZ)
    outputBuffer.encodeInt16(magOfsX)
    outputBuffer.encodeInt16(magOfsY)
    outputBuffer.encodeInt16(magOfsZ)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 150

    private const val CRC: Int = 134

    private const val SIZE: Int = 42

    private val DESERIALIZER: MavDeserializer<SensorOffsets> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val magDeclination = inputBuffer.decodeFloat()
      val rawPress = inputBuffer.decodeInt32()
      val rawTemp = inputBuffer.decodeInt32()
      val gyroCalX = inputBuffer.decodeFloat()
      val gyroCalY = inputBuffer.decodeFloat()
      val gyroCalZ = inputBuffer.decodeFloat()
      val accelCalX = inputBuffer.decodeFloat()
      val accelCalY = inputBuffer.decodeFloat()
      val accelCalZ = inputBuffer.decodeFloat()
      val magOfsX = inputBuffer.decodeInt16()
      val magOfsY = inputBuffer.decodeInt16()
      val magOfsZ = inputBuffer.decodeInt16()

      SensorOffsets(
        magOfsX = magOfsX,
        magOfsY = magOfsY,
        magOfsZ = magOfsZ,
        magDeclination = magDeclination,
        rawPress = rawPress,
        rawTemp = rawTemp,
        gyroCalX = gyroCalX,
        gyroCalY = gyroCalY,
        gyroCalZ = gyroCalZ,
        accelCalX = accelCalX,
        accelCalY = accelCalY,
        accelCalZ = accelCalZ,
      )
    }


    private val METADATA: MavMessage.Metadata<SensorOffsets> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensorOffsets> = METADATA
  }
}
