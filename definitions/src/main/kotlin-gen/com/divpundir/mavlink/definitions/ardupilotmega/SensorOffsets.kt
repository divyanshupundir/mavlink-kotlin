package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
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
  public override val instanceCompanion: MavMessage.MavCompanion<SensorOffsets> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeFloat(magDeclination)
    encoder.encodeInt32(rawPress)
    encoder.encodeInt32(rawTemp)
    encoder.encodeFloat(gyroCalX)
    encoder.encodeFloat(gyroCalY)
    encoder.encodeFloat(gyroCalZ)
    encoder.encodeFloat(accelCalX)
    encoder.encodeFloat(accelCalY)
    encoder.encodeFloat(accelCalZ)
    encoder.encodeInt16(magOfsX)
    encoder.encodeInt16(magOfsY)
    encoder.encodeInt16(magOfsZ)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeFloat(magDeclination)
    encoder.encodeInt32(rawPress)
    encoder.encodeInt32(rawTemp)
    encoder.encodeFloat(gyroCalX)
    encoder.encodeFloat(gyroCalY)
    encoder.encodeFloat(gyroCalZ)
    encoder.encodeFloat(accelCalX)
    encoder.encodeFloat(accelCalY)
    encoder.encodeFloat(accelCalZ)
    encoder.encodeInt16(magOfsX)
    encoder.encodeInt16(magOfsY)
    encoder.encodeInt16(magOfsZ)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensorOffsets> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 150u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): SensorOffsets {
      val decoder = MavDataDecoder.wrap(bytes)

      val magDeclination = decoder.safeDecodeFloat()
      val rawPress = decoder.safeDecodeInt32()
      val rawTemp = decoder.safeDecodeInt32()
      val gyroCalX = decoder.safeDecodeFloat()
      val gyroCalY = decoder.safeDecodeFloat()
      val gyroCalZ = decoder.safeDecodeFloat()
      val accelCalX = decoder.safeDecodeFloat()
      val accelCalY = decoder.safeDecodeFloat()
      val accelCalZ = decoder.safeDecodeFloat()
      val magOfsX = decoder.safeDecodeInt16()
      val magOfsY = decoder.safeDecodeInt16()
      val magOfsZ = decoder.safeDecodeInt16()

      return SensorOffsets(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SensorOffsets =
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
