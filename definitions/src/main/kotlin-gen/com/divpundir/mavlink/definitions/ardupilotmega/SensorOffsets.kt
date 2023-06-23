package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(magDeclination)
    output.encodeInt32(rawPress)
    output.encodeInt32(rawTemp)
    output.encodeFloat(gyroCalX)
    output.encodeFloat(gyroCalY)
    output.encodeFloat(gyroCalZ)
    output.encodeFloat(accelCalX)
    output.encodeFloat(accelCalY)
    output.encodeFloat(accelCalZ)
    output.encodeInt16(magOfsX)
    output.encodeInt16(magOfsY)
    output.encodeInt16(magOfsZ)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(magDeclination)
    output.encodeInt32(rawPress)
    output.encodeInt32(rawTemp)
    output.encodeFloat(gyroCalX)
    output.encodeFloat(gyroCalY)
    output.encodeFloat(gyroCalZ)
    output.encodeFloat(accelCalX)
    output.encodeFloat(accelCalY)
    output.encodeFloat(accelCalZ)
    output.encodeInt16(magOfsX)
    output.encodeInt16(magOfsY)
    output.encodeInt16(magOfsZ)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SensorOffsets> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 150u

    public override val crcExtra: Byte = -122

    public override fun deserialize(source: BufferedSource): SensorOffsets {
      val magDeclination = source.decodeFloat()
      val rawPress = source.decodeInt32()
      val rawTemp = source.decodeInt32()
      val gyroCalX = source.decodeFloat()
      val gyroCalY = source.decodeFloat()
      val gyroCalZ = source.decodeFloat()
      val accelCalX = source.decodeFloat()
      val accelCalY = source.decodeFloat()
      val accelCalZ = source.decodeFloat()
      val magOfsX = source.decodeInt16()
      val magOfsY = source.decodeInt16()
      val magOfsZ = source.decodeInt16()

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
