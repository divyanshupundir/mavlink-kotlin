package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "int16_t")
  public val magOfsX: Int = 0,
  /**
   * Magnetometer Y offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsY: Int = 0,
  /**
   * Magnetometer Z offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsZ: Int = 0,
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
    private const val ID: Int = 150

    private const val CRC: Int = 134

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


    private val METADATA: MavMessage.Metadata<SensorOffsets> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensorOffsets> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SensorOffsets =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var magOfsX: Int = 0

    public var magOfsY: Int = 0

    public var magOfsZ: Int = 0

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
