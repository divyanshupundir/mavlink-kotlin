package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Adaptive Controller tuning information.
 *
 * @param axis Axis.
 * @param desired Desired rate.
 * units = deg/s
 * @param achieved Achieved rate.
 * units = deg/s
 * @param error Error between model and vehicle.
 * @param theta Theta estimated state predictor.
 * @param omega Omega estimated state predictor.
 * @param sigma Sigma estimated state predictor.
 * @param thetaDot Theta derivative.
 * @param omegaDot Omega derivative.
 * @param sigmaDot Sigma derivative.
 * @param f Projection operator value.
 * @param fDot Projection operator derivative.
 * @param u u adaptive controlled output command.
 */
@GeneratedMavMessage(
  id = 11_010u,
  crcExtra = 46,
)
public data class AdapTuning(
  /**
   * Axis.
   */
  @GeneratedMavField(type = "uint8_t")
  public val axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0u),
  /**
   * Desired rate.
   * units = deg/s
   */
  @GeneratedMavField(type = "float")
  public val desired: Float = 0F,
  /**
   * Achieved rate.
   * units = deg/s
   */
  @GeneratedMavField(type = "float")
  public val achieved: Float = 0F,
  /**
   * Error between model and vehicle.
   */
  @GeneratedMavField(type = "float")
  public val error: Float = 0F,
  /**
   * Theta estimated state predictor.
   */
  @GeneratedMavField(type = "float")
  public val theta: Float = 0F,
  /**
   * Omega estimated state predictor.
   */
  @GeneratedMavField(type = "float")
  public val omega: Float = 0F,
  /**
   * Sigma estimated state predictor.
   */
  @GeneratedMavField(type = "float")
  public val sigma: Float = 0F,
  /**
   * Theta derivative.
   */
  @GeneratedMavField(type = "float")
  public val thetaDot: Float = 0F,
  /**
   * Omega derivative.
   */
  @GeneratedMavField(type = "float")
  public val omegaDot: Float = 0F,
  /**
   * Sigma derivative.
   */
  @GeneratedMavField(type = "float")
  public val sigmaDot: Float = 0F,
  /**
   * Projection operator value.
   */
  @GeneratedMavField(type = "float")
  public val f: Float = 0F,
  /**
   * Projection operator derivative.
   */
  @GeneratedMavField(type = "float")
  public val fDot: Float = 0F,
  /**
   * u adaptive controlled output command.
   */
  @GeneratedMavField(type = "float")
  public val u: Float = 0F,
) : MavMessage<AdapTuning> {
  override val instanceCompanion: MavMessage.MavCompanion<AdapTuning> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(desired)
    encoder.encodeFloat(achieved)
    encoder.encodeFloat(error)
    encoder.encodeFloat(theta)
    encoder.encodeFloat(omega)
    encoder.encodeFloat(sigma)
    encoder.encodeFloat(thetaDot)
    encoder.encodeFloat(omegaDot)
    encoder.encodeFloat(sigmaDot)
    encoder.encodeFloat(f)
    encoder.encodeFloat(fDot)
    encoder.encodeFloat(u)
    encoder.encodeEnumValue(axis.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(desired)
    encoder.encodeFloat(achieved)
    encoder.encodeFloat(error)
    encoder.encodeFloat(theta)
    encoder.encodeFloat(omega)
    encoder.encodeFloat(sigma)
    encoder.encodeFloat(thetaDot)
    encoder.encodeFloat(omegaDot)
    encoder.encodeFloat(sigmaDot)
    encoder.encodeFloat(f)
    encoder.encodeFloat(fDot)
    encoder.encodeFloat(u)
    encoder.encodeEnumValue(axis.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AdapTuning> {
    private const val SIZE_V1: Int = 49

    private const val SIZE_V2: Int = 49

    override val id: UInt = 11_010u

    override val crcExtra: Byte = 46

    override fun deserialize(bytes: ByteArray): AdapTuning {
      val decoder = MavDataDecoder(bytes)

      val desired = decoder.safeDecodeFloat()
      val achieved = decoder.safeDecodeFloat()
      val error = decoder.safeDecodeFloat()
      val theta = decoder.safeDecodeFloat()
      val omega = decoder.safeDecodeFloat()
      val sigma = decoder.safeDecodeFloat()
      val thetaDot = decoder.safeDecodeFloat()
      val omegaDot = decoder.safeDecodeFloat()
      val sigmaDot = decoder.safeDecodeFloat()
      val f = decoder.safeDecodeFloat()
      val fDot = decoder.safeDecodeFloat()
      val u = decoder.safeDecodeFloat()
      val axis = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = PidTuningAxis.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return AdapTuning(
        axis = axis,
        desired = desired,
        achieved = achieved,
        error = error,
        theta = theta,
        omega = omega,
        sigma = sigma,
        thetaDot = thetaDot,
        omegaDot = omegaDot,
        sigmaDot = sigmaDot,
        f = f,
        fDot = fDot,
        u = u,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AdapTuning =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0u)

    public var desired: Float = 0F

    public var achieved: Float = 0F

    public var error: Float = 0F

    public var theta: Float = 0F

    public var omega: Float = 0F

    public var sigma: Float = 0F

    public var thetaDot: Float = 0F

    public var omegaDot: Float = 0F

    public var sigmaDot: Float = 0F

    public var f: Float = 0F

    public var fDot: Float = 0F

    public var u: Float = 0F

    public fun build(): AdapTuning = AdapTuning(
      axis = axis,
      desired = desired,
      achieved = achieved,
      error = error,
      theta = theta,
      omega = omega,
      sigma = sigma,
      thetaDot = thetaDot,
      omegaDot = omegaDot,
      sigmaDot = sigmaDot,
      f = f,
      fDot = fDot,
      u = u,
    )
  }
}
