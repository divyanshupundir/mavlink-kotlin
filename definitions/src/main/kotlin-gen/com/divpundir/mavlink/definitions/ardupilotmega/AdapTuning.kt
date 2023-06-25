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
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(desired)
    buffer.encodeFloat(achieved)
    buffer.encodeFloat(error)
    buffer.encodeFloat(theta)
    buffer.encodeFloat(omega)
    buffer.encodeFloat(sigma)
    buffer.encodeFloat(thetaDot)
    buffer.encodeFloat(omegaDot)
    buffer.encodeFloat(sigmaDot)
    buffer.encodeFloat(f)
    buffer.encodeFloat(fDot)
    buffer.encodeFloat(u)
    buffer.encodeEnumValue(axis.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(desired)
    buffer.encodeFloat(achieved)
    buffer.encodeFloat(error)
    buffer.encodeFloat(theta)
    buffer.encodeFloat(omega)
    buffer.encodeFloat(sigma)
    buffer.encodeFloat(thetaDot)
    buffer.encodeFloat(omegaDot)
    buffer.encodeFloat(sigmaDot)
    buffer.encodeFloat(f)
    buffer.encodeFloat(fDot)
    buffer.encodeFloat(u)
    buffer.encodeEnumValue(axis.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AdapTuning> {
    public override val id: UInt = 11_010u

    public override val crcExtra: Byte = 46

    public override fun deserialize(bytes: ByteArray): AdapTuning {
      val buffer = Buffer().write(bytes)

      val desired = buffer.decodeFloat()
      val achieved = buffer.decodeFloat()
      val error = buffer.decodeFloat()
      val theta = buffer.decodeFloat()
      val omega = buffer.decodeFloat()
      val sigma = buffer.decodeFloat()
      val thetaDot = buffer.decodeFloat()
      val omegaDot = buffer.decodeFloat()
      val sigmaDot = buffer.decodeFloat()
      val f = buffer.decodeFloat()
      val fDot = buffer.decodeFloat()
      val u = buffer.decodeFloat()
      val axis = buffer.decodeEnumValue(1).let { value ->
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
