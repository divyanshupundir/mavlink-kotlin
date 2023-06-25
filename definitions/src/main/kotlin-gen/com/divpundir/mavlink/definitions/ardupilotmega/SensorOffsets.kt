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
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeFloat(magDeclination)
    buffer.encodeInt32(rawPress)
    buffer.encodeInt32(rawTemp)
    buffer.encodeFloat(gyroCalX)
    buffer.encodeFloat(gyroCalY)
    buffer.encodeFloat(gyroCalZ)
    buffer.encodeFloat(accelCalX)
    buffer.encodeFloat(accelCalY)
    buffer.encodeFloat(accelCalZ)
    buffer.encodeInt16(magOfsX)
    buffer.encodeInt16(magOfsY)
    buffer.encodeInt16(magOfsZ)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(magDeclination)
    buffer.encodeInt32(rawPress)
    buffer.encodeInt32(rawTemp)
    buffer.encodeFloat(gyroCalX)
    buffer.encodeFloat(gyroCalY)
    buffer.encodeFloat(gyroCalZ)
    buffer.encodeFloat(accelCalX)
    buffer.encodeFloat(accelCalY)
    buffer.encodeFloat(accelCalZ)
    buffer.encodeInt16(magOfsX)
    buffer.encodeInt16(magOfsY)
    buffer.encodeInt16(magOfsZ)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensorOffsets> {
    public override val id: UInt = 150u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): SensorOffsets {
      val buffer = Buffer().write(bytes)

      val magDeclination = buffer.decodeFloat()
      val rawPress = buffer.decodeInt32()
      val rawTemp = buffer.decodeInt32()
      val gyroCalX = buffer.decodeFloat()
      val gyroCalY = buffer.decodeFloat()
      val gyroCalZ = buffer.decodeFloat()
      val accelCalX = buffer.decodeFloat()
      val accelCalY = buffer.decodeFloat()
      val accelCalZ = buffer.decodeFloat()
      val magOfsX = buffer.decodeInt16()
      val magOfsY = buffer.decodeInt16()
      val magOfsZ = buffer.decodeInt16()

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
