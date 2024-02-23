package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Current motion information from a designated system
 *
 * @param timestamp Timestamp (time since system boot).
 * units = ms
 * @param estCapabilities bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL
 * = 2, ATT + RATES = 3)
 * @param lat Latitude (WGS84)
 * units = degE7
 * @param lon Longitude (WGS84)
 * units = degE7
 * @param alt Altitude (MSL)
 * units = m
 * @param vel target velocity (0,0,0) for unknown
 * units = m/s
 * @param acc linear target acceleration (0,0,0) for unknown
 * units = m/s/s
 * @param attitudeQ (0 0 0 0 for unknown)
 * @param rates (0 0 0 for unknown)
 * @param positionCov eph epv
 * @param customState button states or switches of a tracker device
 */
@GeneratedMavMessage(
  id = 144u,
  crcExtra = 127,
)
public data class FollowTarget(
  /**
   * Timestamp (time since system boot).
   * units = ms
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
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * target velocity (0,0,0) for unknown
   * units = m/s
   */
  @GeneratedMavField(type = "float[3]")
  public val vel: List<Float> = emptyList(),
  /**
   * linear target acceleration (0,0,0) for unknown
   * units = m/s/s
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
  override val instanceCompanion: MavMessage.MavCompanion<FollowTarget> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt64(customState)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloatArray(vel, 12)
    encoder.encodeFloatArray(acc, 12)
    encoder.encodeFloatArray(attitudeQ, 16)
    encoder.encodeFloatArray(rates, 12)
    encoder.encodeFloatArray(positionCov, 12)
    encoder.encodeUInt8(estCapabilities)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt64(customState)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloatArray(vel, 12)
    encoder.encodeFloatArray(acc, 12)
    encoder.encodeFloatArray(attitudeQ, 16)
    encoder.encodeFloatArray(rates, 12)
    encoder.encodeFloatArray(positionCov, 12)
    encoder.encodeUInt8(estCapabilities)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FollowTarget> {
    private const val SIZE_V1: Int = 93

    private const val SIZE_V2: Int = 93

    override val id: UInt = 144u

    override val crcExtra: Byte = 127

    override fun deserialize(bytes: ByteArray): FollowTarget {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val customState = decoder.safeDecodeUInt64()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeFloat()
      val vel = decoder.safeDecodeFloatArray(12)
      val acc = decoder.safeDecodeFloatArray(12)
      val attitudeQ = decoder.safeDecodeFloatArray(16)
      val rates = decoder.safeDecodeFloatArray(12)
      val positionCov = decoder.safeDecodeFloatArray(12)
      val estCapabilities = decoder.safeDecodeUInt8()

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
