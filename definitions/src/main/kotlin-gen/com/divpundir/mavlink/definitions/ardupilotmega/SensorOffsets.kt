package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

/**
 * Offsets and calibrations values for hardware sensors. This makes it easier to debug the
 * calibration process.
 */
@GeneratedMavMessage(
  id = 150u,
  crcExtra = -122,
)
public data class SensorOffsets(
  /**
   * Magnetometer X offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsX: Short = 0,
  /**
   * Magnetometer Y offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsY: Short = 0,
  /**
   * Magnetometer Z offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsZ: Short = 0,
  /**
   * Magnetic declination.
   */
  @GeneratedMavField(type = "float")
  public val magDeclination: Float = 0F,
  /**
   * Raw pressure from barometer.
   */
  @GeneratedMavField(type = "int32_t")
  public val rawPress: Int = 0,
  /**
   * Raw temperature from barometer.
   */
  @GeneratedMavField(type = "int32_t")
  public val rawTemp: Int = 0,
  /**
   * Gyro X calibration.
   */
  @GeneratedMavField(type = "float")
  public val gyroCalX: Float = 0F,
  /**
   * Gyro Y calibration.
   */
  @GeneratedMavField(type = "float")
  public val gyroCalY: Float = 0F,
  /**
   * Gyro Z calibration.
   */
  @GeneratedMavField(type = "float")
  public val gyroCalZ: Float = 0F,
  /**
   * Accel X calibration.
   */
  @GeneratedMavField(type = "float")
  public val accelCalX: Float = 0F,
  /**
   * Accel Y calibration.
   */
  @GeneratedMavField(type = "float")
  public val accelCalY: Float = 0F,
  /**
   * Accel Z calibration.
   */
  @GeneratedMavField(type = "float")
  public val accelCalZ: Float = 0F,
) : MavMessage<SensorOffsets> {
  public override val instanceMetadata: MavMessage.Metadata<SensorOffsets> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 150u

    private const val CRC_EXTRA: Byte = -122

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

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


    private val METADATA: MavMessage.Metadata<SensorOffsets> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensorOffsets> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SensorOffsets =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var magOfsX: Short = 0

    public var magOfsY: Short = 0

    public var magOfsZ: Short = 0

    public var magDeclination: Float = 0F

    public var rawPress: Int = 0

    public var rawTemp: Int = 0

    public var gyroCalX: Float = 0F

    public var gyroCalY: Float = 0F

    public var gyroCalZ: Float = 0F

    public var accelCalX: Float = 0F

    public var accelCalY: Float = 0F

    public var accelCalZ: Float = 0F

    public fun build(): SensorOffsets = SensorOffsets(
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
}
