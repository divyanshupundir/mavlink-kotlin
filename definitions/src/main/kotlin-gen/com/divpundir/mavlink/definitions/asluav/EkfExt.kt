package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Extended EKF state estimates for ASLUAVs
 */
@GeneratedMavMessage(
  id = 8_007u,
  crcExtra = 64,
)
public data class EkfExt(
  /**
   *  Time since system start
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  Magnitude of wind velocity (in lateral inertial plane)
   */
  @GeneratedMavField(type = "float")
  public val windspeed: Float = 0F,
  /**
   *  Wind heading angle from North
   */
  @GeneratedMavField(type = "float")
  public val winddir: Float = 0F,
  /**
   *  Z (Down) component of inertial wind velocity
   */
  @GeneratedMavField(type = "float")
  public val windz: Float = 0F,
  /**
   *  Magnitude of air velocity
   */
  @GeneratedMavField(type = "float")
  public val airspeed: Float = 0F,
  /**
   *  Sideslip angle
   */
  @GeneratedMavField(type = "float")
  public val beta: Float = 0F,
  /**
   *  Angle of attack
   */
  @GeneratedMavField(type = "float")
  public val alpha: Float = 0F,
) : MavMessage<EkfExt> {
  public override val instanceCompanion: MavMessage.MavCompanion<EkfExt> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(windspeed)
    output.encodeFloat(winddir)
    output.encodeFloat(windz)
    output.encodeFloat(airspeed)
    output.encodeFloat(beta)
    output.encodeFloat(alpha)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(windspeed)
    output.encodeFloat(winddir)
    output.encodeFloat(windz)
    output.encodeFloat(airspeed)
    output.encodeFloat(beta)
    output.encodeFloat(alpha)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<EkfExt> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    public override val id: UInt = 8_007u

    public override val crcExtra: Byte = 64

    public override fun deserialize(source: BufferedSource): EkfExt {
      val timestamp = source.decodeUInt64()
      val windspeed = source.decodeFloat()
      val winddir = source.decodeFloat()
      val windz = source.decodeFloat()
      val airspeed = source.decodeFloat()
      val beta = source.decodeFloat()
      val alpha = source.decodeFloat()

      return EkfExt(
        timestamp = timestamp,
        windspeed = windspeed,
        winddir = winddir,
        windz = windz,
        airspeed = airspeed,
        beta = beta,
        alpha = alpha,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EkfExt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var windspeed: Float = 0F

    public var winddir: Float = 0F

    public var windz: Float = 0F

    public var airspeed: Float = 0F

    public var beta: Float = 0F

    public var alpha: Float = 0F

    public fun build(): EkfExt = EkfExt(
      timestamp = timestamp,
      windspeed = windspeed,
      winddir = winddir,
      windz = windz,
      airspeed = airspeed,
      beta = beta,
      alpha = alpha,
    )
  }
}
