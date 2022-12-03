package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Current motion information from a designated system
 */
@GeneratedMavMessage(
  id = 144,
  crc = 127,
)
public data class FollowTarget(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3)
   */
  @GeneratedMavField(type = "uint8_t")
  public val estCapabilities: Int = 0,
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
  public val customState: BigInteger = BigInteger.ZERO,
) : MavMessage<FollowTarget> {
  public override val instanceMetadata: MavMessage.Metadata<FollowTarget> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint64(customState)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloatArray(vel, 12)
    outputBuffer.encodeFloatArray(acc, 12)
    outputBuffer.encodeFloatArray(attitudeQ, 16)
    outputBuffer.encodeFloatArray(rates, 12)
    outputBuffer.encodeFloatArray(positionCov, 12)
    outputBuffer.encodeUint8(estCapabilities)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint64(customState)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloatArray(vel, 12)
    outputBuffer.encodeFloatArray(acc, 12)
    outputBuffer.encodeFloatArray(attitudeQ, 16)
    outputBuffer.encodeFloatArray(rates, 12)
    outputBuffer.encodeFloatArray(positionCov, 12)
    outputBuffer.encodeUint8(estCapabilities)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 144

    private const val CRC: Int = 127

    private const val SIZE_V1: Int = 93

    private const val SIZE_V2: Int = 93

    private val DESERIALIZER: MavDeserializer<FollowTarget> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val customState = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
      val vel = inputBuffer.decodeFloatArray(12)
      val acc = inputBuffer.decodeFloatArray(12)
      val attitudeQ = inputBuffer.decodeFloatArray(16)
      val rates = inputBuffer.decodeFloatArray(12)
      val positionCov = inputBuffer.decodeFloatArray(12)
      val estCapabilities = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<FollowTarget> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FollowTarget> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FollowTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var estCapabilities: Int = 0

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Float = 0F

    public var vel: List<Float> = emptyList()

    public var acc: List<Float> = emptyList()

    public var attitudeQ: List<Float> = emptyList()

    public var rates: List<Float> = emptyList()

    public var positionCov: List<Float> = emptyList()

    public var customState: BigInteger = BigInteger.ZERO

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
