package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<FollowTarget> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt64(customState)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloatArray(vel, 12)
    outputBuffer.encodeFloatArray(acc, 12)
    outputBuffer.encodeFloatArray(attitudeQ, 16)
    outputBuffer.encodeFloatArray(rates, 12)
    outputBuffer.encodeFloatArray(positionCov, 12)
    outputBuffer.encodeUInt8(estCapabilities)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt64(customState)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloatArray(vel, 12)
    outputBuffer.encodeFloatArray(acc, 12)
    outputBuffer.encodeFloatArray(attitudeQ, 16)
    outputBuffer.encodeFloatArray(rates, 12)
    outputBuffer.encodeFloatArray(positionCov, 12)
    outputBuffer.encodeUInt8(estCapabilities)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 144u

    private const val CRC_EXTRA: Byte = 127

    private const val SIZE_V1: Int = 93

    private const val SIZE_V2: Int = 93

    private val DESERIALIZER: MavDeserializer<FollowTarget> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val customState = inputBuffer.decodeUInt64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
      val vel = inputBuffer.decodeFloatArray(12)
      val acc = inputBuffer.decodeFloatArray(12)
      val attitudeQ = inputBuffer.decodeFloatArray(16)
      val rates = inputBuffer.decodeFloatArray(12)
      val positionCov = inputBuffer.decodeFloatArray(12)
      val estCapabilities = inputBuffer.decodeUInt8()

      FollowTarget(
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


    private val METADATA: MavMessage.Metadata<FollowTarget> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FollowTarget> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FollowTarget =
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
