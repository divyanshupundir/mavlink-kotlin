package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Current motion information from a designated system
 */
@GeneratedMavMessage(
  id = 144u,
  crcExtra = 127,
)
public data class FollowTarget(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3)
   */
  @GeneratedMavField(type = "uint8_t")
  public val estCapabilities: UByte = 0u,
  /**
   * Latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL)
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * target velocity (0,0,0) for unknown
   */
  @GeneratedMavField(type = "float[3]")
  public val vel: List<Float> = emptyList(),
  /**
   * linear target acceleration (0,0,0) for unknown
   */
  @GeneratedMavField(type = "float[3]")
  public val acc: List<Float> = emptyList(),
  /**
   * (0 0 0 0 for unknown)
   */
  @GeneratedMavField(type = "float[4]")
  public val attitudeQ: List<Float> = emptyList(),
  /**
   * (0 0 0 for unknown)
   */
  @GeneratedMavField(type = "float[3]")
  public val rates: List<Float> = emptyList(),
  /**
   * eph epv
   */
  @GeneratedMavField(type = "float[3]")
  public val positionCov: List<Float> = emptyList(),
  /**
   * button states or switches of a tracker device
   */
  @GeneratedMavField(type = "uint64_t")
  public val customState: ULong = 0uL,
) : MavMessage<FollowTarget> {
  public override val instanceCompanion: MavMessage.MavCompanion<FollowTarget> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeUInt64(customState)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeFloat(alt)
    output.encodeFloatArray(vel, 12)
    output.encodeFloatArray(acc, 12)
    output.encodeFloatArray(attitudeQ, 16)
    output.encodeFloatArray(rates, 12)
    output.encodeFloatArray(positionCov, 12)
    output.encodeUInt8(estCapabilities)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeUInt64(customState)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeFloat(alt)
    output.encodeFloatArray(vel, 12)
    output.encodeFloatArray(acc, 12)
    output.encodeFloatArray(attitudeQ, 16)
    output.encodeFloatArray(rates, 12)
    output.encodeFloatArray(positionCov, 12)
    output.encodeUInt8(estCapabilities)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<FollowTarget> {
    private const val SIZE_V1: Int = 93

    private const val SIZE_V2: Int = 93

    public override val id: UInt = 144u

    public override val crcExtra: Byte = 127

    public override fun deserialize(source: BufferedSource): FollowTarget {
      val timestamp = source.decodeUInt64()
      val customState = source.decodeUInt64()
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()
      val alt = source.decodeFloat()
      val vel = source.decodeFloatArray(12)
      val acc = source.decodeFloatArray(12)
      val attitudeQ = source.decodeFloatArray(16)
      val rates = source.decodeFloatArray(12)
      val positionCov = source.decodeFloatArray(12)
      val estCapabilities = source.decodeUInt8()

      return FollowTarget(
        timestamp = timestamp,
        estCapabilities = estCapabilities,
        lat = lat,
        lon = lon,
        alt = alt,
        vel = vel,
        acc = acc,
        attitudeQ = attitudeQ,
        rates = rates,
        positionCov = positionCov,
        customState = customState,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FollowTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var estCapabilities: UByte = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Float = 0F

    public var vel: List<Float> = emptyList()

    public var acc: List<Float> = emptyList()

    public var attitudeQ: List<Float> = emptyList()

    public var rates: List<Float> = emptyList()

    public var positionCov: List<Float> = emptyList()

    public var customState: ULong = 0uL

    public fun build(): FollowTarget = FollowTarget(
      timestamp = timestamp,
      estCapabilities = estCapabilities,
      lat = lat,
      lon = lon,
      alt = alt,
      vel = vel,
      acc = acc,
      attitudeQ = attitudeQ,
      rates = rates,
      positionCov = positionCov,
      customState = customState,
    )
  }
}
