package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Status of DCM attitude estimator.
 */
public data class Ahrs(
  /**
   * X gyro drift estimate.
   */
  public val omegaix: Float = 0F,
  /**
   * Y gyro drift estimate.
   */
  public val omegaiy: Float = 0F,
  /**
   * Z gyro drift estimate.
   */
  public val omegaiz: Float = 0F,
  /**
   * Average accel_weight.
   */
  public val accelWeight: Float = 0F,
  /**
   * Average renormalisation value.
   */
  public val renormVal: Float = 0F,
  /**
   * Average error_roll_pitch value.
   */
  public val errorRp: Float = 0F,
  /**
   * Average error_yaw value.
   */
  public val errorYaw: Float = 0F,
) : MavMessage<Ahrs> {
  public override val instanceMetadata: MavMessage.Metadata<Ahrs> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(omegaix)
    outputBuffer.encodeFloat(omegaiy)
    outputBuffer.encodeFloat(omegaiz)
    outputBuffer.encodeFloat(accelWeight)
    outputBuffer.encodeFloat(renormVal)
    outputBuffer.encodeFloat(errorRp)
    outputBuffer.encodeFloat(errorYaw)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 163

    private const val CRC: Int = 127

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<Ahrs> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for Ahrs: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val omegaix = inputBuffer.decodeFloat()
      val omegaiy = inputBuffer.decodeFloat()
      val omegaiz = inputBuffer.decodeFloat()
      val accelWeight = inputBuffer.decodeFloat()
      val renormVal = inputBuffer.decodeFloat()
      val errorRp = inputBuffer.decodeFloat()
      val errorYaw = inputBuffer.decodeFloat()

      Ahrs(
        omegaix = omegaix,
        omegaiy = omegaiy,
        omegaiz = omegaiz,
        accelWeight = accelWeight,
        renormVal = renormVal,
        errorRp = errorRp,
        errorYaw = errorYaw,
      )
    }


    private val METADATA: MavMessage.Metadata<Ahrs> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Ahrs> = METADATA
  }
}
