package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Adaptive Controller tuning information.
 */
@GeneratedMavMessage(
  id = 11010u,
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
  public override val instanceMetadata: MavMessage.Metadata<AdapTuning> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(desired)
    outputBuffer.encodeFloat(achieved)
    outputBuffer.encodeFloat(error)
    outputBuffer.encodeFloat(theta)
    outputBuffer.encodeFloat(omega)
    outputBuffer.encodeFloat(sigma)
    outputBuffer.encodeFloat(thetaDot)
    outputBuffer.encodeFloat(omegaDot)
    outputBuffer.encodeFloat(sigmaDot)
    outputBuffer.encodeFloat(f)
    outputBuffer.encodeFloat(fDot)
    outputBuffer.encodeFloat(u)
    outputBuffer.encodeEnumValue(axis.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(desired)
    outputBuffer.encodeFloat(achieved)
    outputBuffer.encodeFloat(error)
    outputBuffer.encodeFloat(theta)
    outputBuffer.encodeFloat(omega)
    outputBuffer.encodeFloat(sigma)
    outputBuffer.encodeFloat(thetaDot)
    outputBuffer.encodeFloat(omegaDot)
    outputBuffer.encodeFloat(sigmaDot)
    outputBuffer.encodeFloat(f)
    outputBuffer.encodeFloat(fDot)
    outputBuffer.encodeFloat(u)
    outputBuffer.encodeEnumValue(axis.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11010u

    private const val CRC_EXTRA: Byte = 46

    private const val SIZE_V1: Int = 49

    private const val SIZE_V2: Int = 49

    private val DESERIALIZER: MavDeserializer<AdapTuning> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val desired = inputBuffer.decodeFloat()
      val achieved = inputBuffer.decodeFloat()
      val error = inputBuffer.decodeFloat()
      val theta = inputBuffer.decodeFloat()
      val omega = inputBuffer.decodeFloat()
      val sigma = inputBuffer.decodeFloat()
      val thetaDot = inputBuffer.decodeFloat()
      val omegaDot = inputBuffer.decodeFloat()
      val sigmaDot = inputBuffer.decodeFloat()
      val f = inputBuffer.decodeFloat()
      val fDot = inputBuffer.decodeFloat()
      val u = inputBuffer.decodeFloat()
      val axis = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = PidTuningAxis.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      AdapTuning(
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


    private val METADATA: MavMessage.Metadata<AdapTuning> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AdapTuning> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AdapTuning =
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
