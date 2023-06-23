package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Adaptive Controller tuning information.
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
   */
  @GeneratedMavField(type = "float")
  public val desired: Float = 0F,
  /**
   * Achieved rate.
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
  public override val instanceCompanion: MavMessage.MavCompanion<AdapTuning> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(desired)
    output.encodeFloat(achieved)
    output.encodeFloat(error)
    output.encodeFloat(theta)
    output.encodeFloat(omega)
    output.encodeFloat(sigma)
    output.encodeFloat(thetaDot)
    output.encodeFloat(omegaDot)
    output.encodeFloat(sigmaDot)
    output.encodeFloat(f)
    output.encodeFloat(fDot)
    output.encodeFloat(u)
    output.encodeEnumValue(axis.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(desired)
    output.encodeFloat(achieved)
    output.encodeFloat(error)
    output.encodeFloat(theta)
    output.encodeFloat(omega)
    output.encodeFloat(sigma)
    output.encodeFloat(thetaDot)
    output.encodeFloat(omegaDot)
    output.encodeFloat(sigmaDot)
    output.encodeFloat(f)
    output.encodeFloat(fDot)
    output.encodeFloat(u)
    output.encodeEnumValue(axis.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AdapTuning> {
    private const val SIZE_V1: Int = 49

    private const val SIZE_V2: Int = 49

    public override val id: UInt = 11_010u

    public override val crcExtra: Byte = 46

    public override fun deserialize(source: BufferedSource): AdapTuning {
      val desired = source.decodeFloat()
      val achieved = source.decodeFloat()
      val error = source.decodeFloat()
      val theta = source.decodeFloat()
      val omega = source.decodeFloat()
      val sigma = source.decodeFloat()
      val thetaDot = source.decodeFloat()
      val omegaDot = source.decodeFloat()
      val sigmaDot = source.decodeFloat()
      val f = source.decodeFloat()
      val fDot = source.decodeFloat()
      val u = source.decodeFloat()
      val axis = source.decodeEnumValue(1).let { value ->
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
