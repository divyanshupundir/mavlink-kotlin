package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Adaptive Controller tuning information.
 */
@GeneratedMavMessage(
  id = 11010,
  crc = 46,
)
public data class AdapTuning(
  /**
   * Axis.
   */
  public val axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0),
  /**
   * Desired rate.
   */
  public val desired: Float = 0F,
  /**
   * Achieved rate.
   */
  public val achieved: Float = 0F,
  /**
   * Error between model and vehicle.
   */
  public val error: Float = 0F,
  /**
   * Theta estimated state predictor.
   */
  public val theta: Float = 0F,
  /**
   * Omega estimated state predictor.
   */
  public val omega: Float = 0F,
  /**
   * Sigma estimated state predictor.
   */
  public val sigma: Float = 0F,
  /**
   * Theta derivative.
   */
  public val thetaDot: Float = 0F,
  /**
   * Omega derivative.
   */
  public val omegaDot: Float = 0F,
  /**
   * Sigma derivative.
   */
  public val sigmaDot: Float = 0F,
  /**
   * Projection operator value.
   */
  public val f: Float = 0F,
  /**
   * Projection operator derivative.
   */
  public val fDot: Float = 0F,
  /**
   * u adaptive controlled output command.
   */
  public val u: Float = 0F,
) : MavMessage<AdapTuning> {
  public override val instanceMetadata: MavMessage.Metadata<AdapTuning> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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

  public companion object {
    private const val ID: Int = 11010

    private const val CRC: Int = 46

    private const val SIZE: Int = 49

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


    private val METADATA: MavMessage.Metadata<AdapTuning> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AdapTuning> = METADATA
  }
}
