package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
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
 * Status of DCM attitude estimator.
 */
@GeneratedMavMessage(
  id = 163u,
  crcExtra = 127,
)
public data class Ahrs(
  /**
   * X gyro drift estimate.
   */
  @GeneratedMavField(type = "float")
  public val omegaix: Float = 0F,
  /**
   * Y gyro drift estimate.
   */
  @GeneratedMavField(type = "float")
  public val omegaiy: Float = 0F,
  /**
   * Z gyro drift estimate.
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
  public override val instanceCompanion: MavMessage.MavCompanion<Ahrs> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(omegaix)
    outputBuffer.encodeFloat(omegaiy)
    outputBuffer.encodeFloat(omegaiz)
    outputBuffer.encodeFloat(accelWeight)
    outputBuffer.encodeFloat(renormVal)
    outputBuffer.encodeFloat(errorRp)
    outputBuffer.encodeFloat(errorYaw)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(omegaix)
    outputBuffer.encodeFloat(omegaiy)
    outputBuffer.encodeFloat(omegaiz)
    outputBuffer.encodeFloat(accelWeight)
    outputBuffer.encodeFloat(renormVal)
    outputBuffer.encodeFloat(errorRp)
    outputBuffer.encodeFloat(errorYaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Ahrs> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 163u

    public override val crcExtra: Byte = 127

    public override fun deserialize(bytes: ByteArray): Ahrs {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val omegaix = inputBuffer.decodeFloat()
      val omegaiy = inputBuffer.decodeFloat()
      val omegaiz = inputBuffer.decodeFloat()
      val accelWeight = inputBuffer.decodeFloat()
      val renormVal = inputBuffer.decodeFloat()
      val errorRp = inputBuffer.decodeFloat()
      val errorYaw = inputBuffer.decodeFloat()

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
