package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Reports results of completed compass calibration. Sent until MAG_CAL_ACK received.
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
  public override val instanceCompanion: MavMessage.MavCompanion<MagCalReport> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(fitness)
    output.encodeFloat(ofsX)
    output.encodeFloat(ofsY)
    output.encodeFloat(ofsZ)
    output.encodeFloat(diagX)
    output.encodeFloat(diagY)
    output.encodeFloat(diagZ)
    output.encodeFloat(offdiagX)
    output.encodeFloat(offdiagY)
    output.encodeFloat(offdiagZ)
    output.encodeUInt8(compassId)
    output.encodeUInt8(calMask)
    output.encodeEnumValue(calStatus.value, 1)
    output.encodeUInt8(autosaved)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(fitness)
    output.encodeFloat(ofsX)
    output.encodeFloat(ofsY)
    output.encodeFloat(ofsZ)
    output.encodeFloat(diagX)
    output.encodeFloat(diagY)
    output.encodeFloat(diagZ)
    output.encodeFloat(offdiagX)
    output.encodeFloat(offdiagY)
    output.encodeFloat(offdiagZ)
    output.encodeUInt8(compassId)
    output.encodeUInt8(calMask)
    output.encodeEnumValue(calStatus.value, 1)
    output.encodeUInt8(autosaved)
    output.encodeFloat(orientationConfidence)
    output.encodeEnumValue(oldOrientation.value, 1)
    output.encodeEnumValue(newOrientation.value, 1)
    output.encodeFloat(scaleFactor)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MagCalReport> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 54

    public override val id: UInt = 192u

    public override val crcExtra: Byte = 36

    public override fun deserialize(source: BufferedSource): MagCalReport {
      val fitness = source.decodeFloat()
      val ofsX = source.decodeFloat()
      val ofsY = source.decodeFloat()
      val ofsZ = source.decodeFloat()
      val diagX = source.decodeFloat()
      val diagY = source.decodeFloat()
      val diagZ = source.decodeFloat()
      val offdiagX = source.decodeFloat()
      val offdiagY = source.decodeFloat()
      val offdiagZ = source.decodeFloat()
      val compassId = source.decodeUInt8()
      val calMask = source.decodeUInt8()
      val calStatus = source.decodeEnumValue(1).let { value ->
        val entry = MagCalStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autosaved = source.decodeUInt8()
      val orientationConfidence = source.decodeFloat()
      val oldOrientation = source.decodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val newOrientation = source.decodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val scaleFactor = source.decodeFloat()

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
