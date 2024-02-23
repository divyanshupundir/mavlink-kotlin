package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Reports results of completed compass calibration. Sent until MAG_CAL_ACK received.
 *
 * @param compassId Compass being calibrated.
 * @param calMask Bitmask of compasses being calibrated.
 * @param calStatus Calibration Status.
 * @param autosaved 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters.
 * @param fitness RMS milligauss residuals.
 * units = mgauss
 * @param ofsX X offset.
 * @param ofsY Y offset.
 * @param ofsZ Z offset.
 * @param diagX X diagonal (matrix 11).
 * @param diagY Y diagonal (matrix 22).
 * @param diagZ Z diagonal (matrix 33).
 * @param offdiagX X off-diagonal (matrix 12 and 21).
 * @param offdiagY Y off-diagonal (matrix 13 and 31).
 * @param offdiagZ Z off-diagonal (matrix 32 and 23).
 * @param orientationConfidence Confidence in orientation (higher is better).
 * @param oldOrientation orientation before calibration.
 * @param newOrientation orientation after calibration.
 * @param scaleFactor field radius correction factor
 */
@GeneratedMavMessage(
  id = 192u,
  crcExtra = 36,
)
public data class MagCalReport(
  /**
   * Compass being calibrated.
   */
  @GeneratedMavField(type = "uint8_t")
  public val compassId: UByte = 0u,
  /**
   * Bitmask of compasses being calibrated.
   */
  @GeneratedMavField(type = "uint8_t")
  public val calMask: UByte = 0u,
  /**
   * Calibration Status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val calStatus: MavEnumValue<MagCalStatus> = MavEnumValue.fromValue(0u),
  /**
   * 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters.
   */
  @GeneratedMavField(type = "uint8_t")
  public val autosaved: UByte = 0u,
  /**
   * RMS milligauss residuals.
   * units = mgauss
   */
  @GeneratedMavField(type = "float")
  public val fitness: Float = 0F,
  /**
   * X offset.
   */
  @GeneratedMavField(type = "float")
  public val ofsX: Float = 0F,
  /**
   * Y offset.
   */
  @GeneratedMavField(type = "float")
  public val ofsY: Float = 0F,
  /**
   * Z offset.
   */
  @GeneratedMavField(type = "float")
  public val ofsZ: Float = 0F,
  /**
   * X diagonal (matrix 11).
   */
  @GeneratedMavField(type = "float")
  public val diagX: Float = 0F,
  /**
   * Y diagonal (matrix 22).
   */
  @GeneratedMavField(type = "float")
  public val diagY: Float = 0F,
  /**
   * Z diagonal (matrix 33).
   */
  @GeneratedMavField(type = "float")
  public val diagZ: Float = 0F,
  /**
   * X off-diagonal (matrix 12 and 21).
   */
  @GeneratedMavField(type = "float")
  public val offdiagX: Float = 0F,
  /**
   * Y off-diagonal (matrix 13 and 31).
   */
  @GeneratedMavField(type = "float")
  public val offdiagY: Float = 0F,
  /**
   * Z off-diagonal (matrix 32 and 23).
   */
  @GeneratedMavField(type = "float")
  public val offdiagZ: Float = 0F,
  /**
   * Confidence in orientation (higher is better).
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val orientationConfidence: Float = 0F,
  /**
   * orientation before calibration.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val oldOrientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0u),
  /**
   * orientation after calibration.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val newOrientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0u),
  /**
   * field radius correction factor
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val scaleFactor: Float = 0F,
) : MavMessage<MagCalReport> {
  override val instanceCompanion: MavMessage.MavCompanion<MagCalReport> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(fitness)
    encoder.encodeFloat(ofsX)
    encoder.encodeFloat(ofsY)
    encoder.encodeFloat(ofsZ)
    encoder.encodeFloat(diagX)
    encoder.encodeFloat(diagY)
    encoder.encodeFloat(diagZ)
    encoder.encodeFloat(offdiagX)
    encoder.encodeFloat(offdiagY)
    encoder.encodeFloat(offdiagZ)
    encoder.encodeUInt8(compassId)
    encoder.encodeUInt8(calMask)
    encoder.encodeEnumValue(calStatus.value, 1)
    encoder.encodeUInt8(autosaved)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(fitness)
    encoder.encodeFloat(ofsX)
    encoder.encodeFloat(ofsY)
    encoder.encodeFloat(ofsZ)
    encoder.encodeFloat(diagX)
    encoder.encodeFloat(diagY)
    encoder.encodeFloat(diagZ)
    encoder.encodeFloat(offdiagX)
    encoder.encodeFloat(offdiagY)
    encoder.encodeFloat(offdiagZ)
    encoder.encodeUInt8(compassId)
    encoder.encodeUInt8(calMask)
    encoder.encodeEnumValue(calStatus.value, 1)
    encoder.encodeUInt8(autosaved)
    encoder.encodeFloat(orientationConfidence)
    encoder.encodeEnumValue(oldOrientation.value, 1)
    encoder.encodeEnumValue(newOrientation.value, 1)
    encoder.encodeFloat(scaleFactor)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MagCalReport> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 54

    override val id: UInt = 192u

    override val crcExtra: Byte = 36

    override fun deserialize(bytes: ByteArray): MagCalReport {
      val decoder = MavDataDecoder(bytes)

      val fitness = decoder.safeDecodeFloat()
      val ofsX = decoder.safeDecodeFloat()
      val ofsY = decoder.safeDecodeFloat()
      val ofsZ = decoder.safeDecodeFloat()
      val diagX = decoder.safeDecodeFloat()
      val diagY = decoder.safeDecodeFloat()
      val diagZ = decoder.safeDecodeFloat()
      val offdiagX = decoder.safeDecodeFloat()
      val offdiagY = decoder.safeDecodeFloat()
      val offdiagZ = decoder.safeDecodeFloat()
      val compassId = decoder.safeDecodeUInt8()
      val calMask = decoder.safeDecodeUInt8()
      val calStatus = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MagCalStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autosaved = decoder.safeDecodeUInt8()
      val orientationConfidence = decoder.safeDecodeFloat()
      val oldOrientation = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val newOrientation = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val scaleFactor = decoder.safeDecodeFloat()

      return MagCalReport(
        compassId = compassId,
        calMask = calMask,
        calStatus = calStatus,
        autosaved = autosaved,
        fitness = fitness,
        ofsX = ofsX,
        ofsY = ofsY,
        ofsZ = ofsZ,
        diagX = diagX,
        diagY = diagY,
        diagZ = diagZ,
        offdiagX = offdiagX,
        offdiagY = offdiagY,
        offdiagZ = offdiagZ,
        orientationConfidence = orientationConfidence,
        oldOrientation = oldOrientation,
        newOrientation = newOrientation,
        scaleFactor = scaleFactor,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MagCalReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var compassId: UByte = 0u

    public var calMask: UByte = 0u

    public var calStatus: MavEnumValue<MagCalStatus> = MavEnumValue.fromValue(0u)

    public var autosaved: UByte = 0u

    public var fitness: Float = 0F

    public var ofsX: Float = 0F

    public var ofsY: Float = 0F

    public var ofsZ: Float = 0F

    public var diagX: Float = 0F

    public var diagY: Float = 0F

    public var diagZ: Float = 0F

    public var offdiagX: Float = 0F

    public var offdiagY: Float = 0F

    public var offdiagZ: Float = 0F

    public var orientationConfidence: Float = 0F

    public var oldOrientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0u)

    public var newOrientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0u)

    public var scaleFactor: Float = 0F

    public fun build(): MagCalReport = MagCalReport(
      compassId = compassId,
      calMask = calMask,
      calStatus = calStatus,
      autosaved = autosaved,
      fitness = fitness,
      ofsX = ofsX,
      ofsY = ofsY,
      ofsZ = ofsZ,
      diagX = diagX,
      diagY = diagY,
      diagZ = diagZ,
      offdiagX = offdiagX,
      offdiagY = offdiagY,
      offdiagZ = offdiagZ,
      orientationConfidence = orientationConfidence,
      oldOrientation = oldOrientation,
      newOrientation = newOrientation,
      scaleFactor = scaleFactor,
    )
  }
}
