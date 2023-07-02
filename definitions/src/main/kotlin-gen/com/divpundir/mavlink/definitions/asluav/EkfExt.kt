package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

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

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(windspeed)
    encoder.encodeFloat(winddir)
    encoder.encodeFloat(windz)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloat(beta)
    encoder.encodeFloat(alpha)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(windspeed)
    encoder.encodeFloat(winddir)
    encoder.encodeFloat(windz)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloat(beta)
    encoder.encodeFloat(alpha)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<EkfExt> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    public override val id: UInt = 8_007u

    public override val crcExtra: Byte = 64

    public override fun deserialize(bytes: ByteArray): EkfExt {
      val decoder = MavDataDecoder.wrap(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val windspeed = decoder.safeDecodeFloat()
      val winddir = decoder.safeDecodeFloat()
      val windz = decoder.safeDecodeFloat()
      val airspeed = decoder.safeDecodeFloat()
      val beta = decoder.safeDecodeFloat()
      val alpha = decoder.safeDecodeFloat()

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
