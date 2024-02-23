package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Status of DCM attitude estimator.
 *
 * @param omegaix X gyro drift estimate.
 * units = rad/s
 * @param omegaiy Y gyro drift estimate.
 * units = rad/s
 * @param omegaiz Z gyro drift estimate.
 * units = rad/s
 * @param accelWeight Average accel_weight.
 * @param renormVal Average renormalisation value.
 * @param errorRp Average error_roll_pitch value.
 * @param errorYaw Average error_yaw value.
 */
@GeneratedMavMessage(
  id = 163u,
  crcExtra = 127,
)
public data class Ahrs(
  /**
   * X gyro drift estimate.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val omegaix: Float = 0F,
  /**
   * Y gyro drift estimate.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val omegaiy: Float = 0F,
  /**
   * Z gyro drift estimate.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val omegaiz: Float = 0F,
  /**
   * Average accel_weight.
   */
  @GeneratedMavField(type = "float")
  public val accelWeight: Float = 0F,
  /**
   * Average renormalisation value.
   */
  @GeneratedMavField(type = "float")
  public val renormVal: Float = 0F,
  /**
   * Average error_roll_pitch value.
   */
  @GeneratedMavField(type = "float")
  public val errorRp: Float = 0F,
  /**
   * Average error_yaw value.
   */
  @GeneratedMavField(type = "float")
  public val errorYaw: Float = 0F,
) : MavMessage<Ahrs> {
  override val instanceCompanion: MavMessage.MavCompanion<Ahrs> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(omegaix)
    encoder.encodeFloat(omegaiy)
    encoder.encodeFloat(omegaiz)
    encoder.encodeFloat(accelWeight)
    encoder.encodeFloat(renormVal)
    encoder.encodeFloat(errorRp)
    encoder.encodeFloat(errorYaw)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(omegaix)
    encoder.encodeFloat(omegaiy)
    encoder.encodeFloat(omegaiz)
    encoder.encodeFloat(accelWeight)
    encoder.encodeFloat(renormVal)
    encoder.encodeFloat(errorRp)
    encoder.encodeFloat(errorYaw)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Ahrs> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    override val id: UInt = 163u

    override val crcExtra: Byte = 127

    override fun deserialize(bytes: ByteArray): Ahrs {
      val decoder = MavDataDecoder(bytes)

      val omegaix = decoder.safeDecodeFloat()
      val omegaiy = decoder.safeDecodeFloat()
      val omegaiz = decoder.safeDecodeFloat()
      val accelWeight = decoder.safeDecodeFloat()
      val renormVal = decoder.safeDecodeFloat()
      val errorRp = decoder.safeDecodeFloat()
      val errorYaw = decoder.safeDecodeFloat()

      return Ahrs(
        omegaix = omegaix,
        omegaiy = omegaiy,
        omegaiz = omegaiz,
        accelWeight = accelWeight,
        renormVal = renormVal,
        errorRp = errorRp,
        errorYaw = errorYaw,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Ahrs =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var omegaix: Float = 0F

    public var omegaiy: Float = 0F

    public var omegaiz: Float = 0F

    public var accelWeight: Float = 0F

    public var renormVal: Float = 0F

    public var errorRp: Float = 0F

    public var errorYaw: Float = 0F

    public fun build(): Ahrs = Ahrs(
      omegaix = omegaix,
      omegaiy = omegaiy,
      omegaiz = omegaiz,
      accelWeight = accelWeight,
      renormVal = renormVal,
      errorRp = errorRp,
      errorYaw = errorYaw,
    )
  }
}
