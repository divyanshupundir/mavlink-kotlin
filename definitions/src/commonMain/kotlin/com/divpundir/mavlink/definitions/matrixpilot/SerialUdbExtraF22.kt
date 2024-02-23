package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F22 format
 *
 * @param sueAccelXAtCalibration SUE X accelerometer at calibration time
 * @param sueAccelYAtCalibration SUE Y accelerometer at calibration time
 * @param sueAccelZAtCalibration SUE Z accelerometer at calibration time
 * @param sueGyroXAtCalibration SUE X gyro at calibration time
 * @param sueGyroYAtCalibration SUE Y gyro at calibration time
 * @param sueGyroZAtCalibration SUE Z gyro at calibration time
 */
@GeneratedMavMessage(
  id = 188u,
  crcExtra = 91,
)
public data class SerialUdbExtraF22(
  /**
   * SUE X accelerometer at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelXAtCalibration: Short = 0,
  /**
   * SUE Y accelerometer at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelYAtCalibration: Short = 0,
  /**
   * SUE Z accelerometer at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelZAtCalibration: Short = 0,
  /**
   * SUE X gyro at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroXAtCalibration: Short = 0,
  /**
   * SUE Y gyro at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroYAtCalibration: Short = 0,
  /**
   * SUE Z gyro at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroZAtCalibration: Short = 0,
) : MavMessage<SerialUdbExtraF22> {
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF22> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(sueAccelXAtCalibration)
    encoder.encodeInt16(sueAccelYAtCalibration)
    encoder.encodeInt16(sueAccelZAtCalibration)
    encoder.encodeInt16(sueGyroXAtCalibration)
    encoder.encodeInt16(sueGyroYAtCalibration)
    encoder.encodeInt16(sueGyroZAtCalibration)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(sueAccelXAtCalibration)
    encoder.encodeInt16(sueAccelYAtCalibration)
    encoder.encodeInt16(sueAccelZAtCalibration)
    encoder.encodeInt16(sueGyroXAtCalibration)
    encoder.encodeInt16(sueGyroYAtCalibration)
    encoder.encodeInt16(sueGyroZAtCalibration)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF22> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    override val id: UInt = 188u

    override val crcExtra: Byte = 91

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF22 {
      val decoder = MavDataDecoder(bytes)

      val sueAccelXAtCalibration = decoder.safeDecodeInt16()
      val sueAccelYAtCalibration = decoder.safeDecodeInt16()
      val sueAccelZAtCalibration = decoder.safeDecodeInt16()
      val sueGyroXAtCalibration = decoder.safeDecodeInt16()
      val sueGyroYAtCalibration = decoder.safeDecodeInt16()
      val sueGyroZAtCalibration = decoder.safeDecodeInt16()

      return SerialUdbExtraF22(
        sueAccelXAtCalibration = sueAccelXAtCalibration,
        sueAccelYAtCalibration = sueAccelYAtCalibration,
        sueAccelZAtCalibration = sueAccelZAtCalibration,
        sueGyroXAtCalibration = sueGyroXAtCalibration,
        sueGyroYAtCalibration = sueGyroYAtCalibration,
        sueGyroZAtCalibration = sueGyroZAtCalibration,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF22 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueAccelXAtCalibration: Short = 0

    public var sueAccelYAtCalibration: Short = 0

    public var sueAccelZAtCalibration: Short = 0

    public var sueGyroXAtCalibration: Short = 0

    public var sueGyroYAtCalibration: Short = 0

    public var sueGyroZAtCalibration: Short = 0

    public fun build(): SerialUdbExtraF22 = SerialUdbExtraF22(
      sueAccelXAtCalibration = sueAccelXAtCalibration,
      sueAccelYAtCalibration = sueAccelYAtCalibration,
      sueAccelZAtCalibration = sueAccelZAtCalibration,
      sueGyroXAtCalibration = sueGyroXAtCalibration,
      sueGyroYAtCalibration = sueGyroYAtCalibration,
      sueGyroZAtCalibration = sueGyroZAtCalibration,
    )
  }
}
