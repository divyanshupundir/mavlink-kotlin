package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * The smoothed, monotonic system state used to feed the control loops of the system.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param xAcc X acceleration in body frame
 * units = m/s/s
 * @param yAcc Y acceleration in body frame
 * units = m/s/s
 * @param zAcc Z acceleration in body frame
 * units = m/s/s
 * @param xVel X velocity in body frame
 * units = m/s
 * @param yVel Y velocity in body frame
 * units = m/s
 * @param zVel Z velocity in body frame
 * units = m/s
 * @param xPos X position in local frame
 * units = m
 * @param yPos Y position in local frame
 * units = m
 * @param zPos Z position in local frame
 * units = m
 * @param airspeed Airspeed, set to -1 if unknown
 * units = m/s
 * @param velVariance Variance of body velocity estimate
 * @param posVariance Variance in local position
 * @param q The attitude, represented as Quaternion
 * @param rollRate Angular rate in roll axis
 * units = rad/s
 * @param pitchRate Angular rate in pitch axis
 * units = rad/s
 * @param yawRate Angular rate in yaw axis
 * units = rad/s
 */
@GeneratedMavMessage(
  id = 146u,
  crcExtra = 103,
)
public data class ControlSystemState(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * X acceleration in body frame
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val xAcc: Float = 0F,
  /**
   * Y acceleration in body frame
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val yAcc: Float = 0F,
  /**
   * Z acceleration in body frame
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val zAcc: Float = 0F,
  /**
   * X velocity in body frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val xVel: Float = 0F,
  /**
   * Y velocity in body frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val yVel: Float = 0F,
  /**
   * Z velocity in body frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val zVel: Float = 0F,
  /**
   * X position in local frame
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val xPos: Float = 0F,
  /**
   * Y position in local frame
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val yPos: Float = 0F,
  /**
   * Z position in local frame
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val zPos: Float = 0F,
  /**
   * Airspeed, set to -1 if unknown
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val airspeed: Float = 0F,
  /**
   * Variance of body velocity estimate
   */
  @GeneratedMavField(type = "float[3]")
  public val velVariance: List<Float> = emptyList(),
  /**
   * Variance in local position
   */
  @GeneratedMavField(type = "float[3]")
  public val posVariance: List<Float> = emptyList(),
  /**
   * The attitude, represented as Quaternion
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Angular rate in roll axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val rollRate: Float = 0F,
  /**
   * Angular rate in pitch axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val pitchRate: Float = 0F,
  /**
   * Angular rate in yaw axis
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<ControlSystemState> {
  override val instanceCompanion: MavMessage.MavCompanion<ControlSystemState> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(xAcc)
    encoder.encodeFloat(yAcc)
    encoder.encodeFloat(zAcc)
    encoder.encodeFloat(xVel)
    encoder.encodeFloat(yVel)
    encoder.encodeFloat(zVel)
    encoder.encodeFloat(xPos)
    encoder.encodeFloat(yPos)
    encoder.encodeFloat(zPos)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloatArray(velVariance, 12)
    encoder.encodeFloatArray(posVariance, 12)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(rollRate)
    encoder.encodeFloat(pitchRate)
    encoder.encodeFloat(yawRate)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(xAcc)
    encoder.encodeFloat(yAcc)
    encoder.encodeFloat(zAcc)
    encoder.encodeFloat(xVel)
    encoder.encodeFloat(yVel)
    encoder.encodeFloat(zVel)
    encoder.encodeFloat(xPos)
    encoder.encodeFloat(yPos)
    encoder.encodeFloat(zPos)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloatArray(velVariance, 12)
    encoder.encodeFloatArray(posVariance, 12)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(rollRate)
    encoder.encodeFloat(pitchRate)
    encoder.encodeFloat(yawRate)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ControlSystemState> {
    private const val SIZE_V1: Int = 100

    private const val SIZE_V2: Int = 100

    override val id: UInt = 146u

    override val crcExtra: Byte = 103

    override fun deserialize(bytes: ByteArray): ControlSystemState {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val xAcc = decoder.safeDecodeFloat()
      val yAcc = decoder.safeDecodeFloat()
      val zAcc = decoder.safeDecodeFloat()
      val xVel = decoder.safeDecodeFloat()
      val yVel = decoder.safeDecodeFloat()
      val zVel = decoder.safeDecodeFloat()
      val xPos = decoder.safeDecodeFloat()
      val yPos = decoder.safeDecodeFloat()
      val zPos = decoder.safeDecodeFloat()
      val airspeed = decoder.safeDecodeFloat()
      val velVariance = decoder.safeDecodeFloatArray(12)
      val posVariance = decoder.safeDecodeFloatArray(12)
      val q = decoder.safeDecodeFloatArray(16)
      val rollRate = decoder.safeDecodeFloat()
      val pitchRate = decoder.safeDecodeFloat()
      val yawRate = decoder.safeDecodeFloat()

      return ControlSystemState(
        timeUsec = timeUsec,
        xAcc = xAcc,
        yAcc = yAcc,
        zAcc = zAcc,
        xVel = xVel,
        yVel = yVel,
        zVel = zVel,
        xPos = xPos,
        yPos = yPos,
        zPos = zPos,
        airspeed = airspeed,
        velVariance = velVariance,
        posVariance = posVariance,
        q = q,
        rollRate = rollRate,
        pitchRate = pitchRate,
        yawRate = yawRate,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ControlSystemState =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var xAcc: Float = 0F

    public var yAcc: Float = 0F

    public var zAcc: Float = 0F

    public var xVel: Float = 0F

    public var yVel: Float = 0F

    public var zVel: Float = 0F

    public var xPos: Float = 0F

    public var yPos: Float = 0F

    public var zPos: Float = 0F

    public var airspeed: Float = 0F

    public var velVariance: List<Float> = emptyList()

    public var posVariance: List<Float> = emptyList()

    public var q: List<Float> = emptyList()

    public var rollRate: Float = 0F

    public var pitchRate: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): ControlSystemState = ControlSystemState(
      timeUsec = timeUsec,
      xAcc = xAcc,
      yAcc = yAcc,
      zAcc = zAcc,
      xVel = xVel,
      yVel = yVel,
      zVel = zVel,
      xPos = xPos,
      yPos = yPos,
      zPos = zPos,
      airspeed = airspeed,
      velVariance = velVariance,
      posVariance = posVariance,
      q = q,
      rollRate = rollRate,
      pitchRate = pitchRate,
      yawRate = yawRate,
    )
  }
}
