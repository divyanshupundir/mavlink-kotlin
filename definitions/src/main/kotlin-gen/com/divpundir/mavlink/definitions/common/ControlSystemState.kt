package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * The smoothed, monotonic system state used to feed the control loops of the system.
 */
@GeneratedMavMessage(
  id = 146u,
  crcExtra = 103,
)
public data class ControlSystemState(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * X acceleration in body frame
   */
  @GeneratedMavField(type = "float")
  public val xAcc: Float = 0F,
  /**
   * Y acceleration in body frame
   */
  @GeneratedMavField(type = "float")
  public val yAcc: Float = 0F,
  /**
   * Z acceleration in body frame
   */
  @GeneratedMavField(type = "float")
  public val zAcc: Float = 0F,
  /**
   * X velocity in body frame
   */
  @GeneratedMavField(type = "float")
  public val xVel: Float = 0F,
  /**
   * Y velocity in body frame
   */
  @GeneratedMavField(type = "float")
  public val yVel: Float = 0F,
  /**
   * Z velocity in body frame
   */
  @GeneratedMavField(type = "float")
  public val zVel: Float = 0F,
  /**
   * X position in local frame
   */
  @GeneratedMavField(type = "float")
  public val xPos: Float = 0F,
  /**
   * Y position in local frame
   */
  @GeneratedMavField(type = "float")
  public val yPos: Float = 0F,
  /**
   * Z position in local frame
   */
  @GeneratedMavField(type = "float")
  public val zPos: Float = 0F,
  /**
   * Airspeed, set to -1 if unknown
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
   */
  @GeneratedMavField(type = "float")
  public val rollRate: Float = 0F,
  /**
   * Angular rate in pitch axis
   */
  @GeneratedMavField(type = "float")
  public val pitchRate: Float = 0F,
  /**
   * Angular rate in yaw axis
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<ControlSystemState> {
  public override val instanceCompanion: MavMessage.MavCompanion<ControlSystemState> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(xAcc)
    output.encodeFloat(yAcc)
    output.encodeFloat(zAcc)
    output.encodeFloat(xVel)
    output.encodeFloat(yVel)
    output.encodeFloat(zVel)
    output.encodeFloat(xPos)
    output.encodeFloat(yPos)
    output.encodeFloat(zPos)
    output.encodeFloat(airspeed)
    output.encodeFloatArray(velVariance, 12)
    output.encodeFloatArray(posVariance, 12)
    output.encodeFloatArray(q, 16)
    output.encodeFloat(rollRate)
    output.encodeFloat(pitchRate)
    output.encodeFloat(yawRate)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(xAcc)
    output.encodeFloat(yAcc)
    output.encodeFloat(zAcc)
    output.encodeFloat(xVel)
    output.encodeFloat(yVel)
    output.encodeFloat(zVel)
    output.encodeFloat(xPos)
    output.encodeFloat(yPos)
    output.encodeFloat(zPos)
    output.encodeFloat(airspeed)
    output.encodeFloatArray(velVariance, 12)
    output.encodeFloatArray(posVariance, 12)
    output.encodeFloatArray(q, 16)
    output.encodeFloat(rollRate)
    output.encodeFloat(pitchRate)
    output.encodeFloat(yawRate)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ControlSystemState> {
    private const val SIZE_V1: Int = 100

    private const val SIZE_V2: Int = 100

    public override val id: UInt = 146u

    public override val crcExtra: Byte = 103

    public override fun deserialize(source: BufferedSource): ControlSystemState {
      val timeUsec = source.decodeUInt64()
      val xAcc = source.decodeFloat()
      val yAcc = source.decodeFloat()
      val zAcc = source.decodeFloat()
      val xVel = source.decodeFloat()
      val yVel = source.decodeFloat()
      val zVel = source.decodeFloat()
      val xPos = source.decodeFloat()
      val yPos = source.decodeFloat()
      val zPos = source.decodeFloat()
      val airspeed = source.decodeFloat()
      val velVariance = source.decodeFloatArray(12)
      val posVariance = source.decodeFloatArray(12)
      val q = source.decodeFloatArray(16)
      val rollRate = source.decodeFloat()
      val pitchRate = source.decodeFloat()
      val yawRate = source.decodeFloat()

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
