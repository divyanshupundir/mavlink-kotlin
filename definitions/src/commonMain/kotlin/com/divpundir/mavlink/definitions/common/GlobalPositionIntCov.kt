package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeInt32
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
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame
 * (right-handed, Z-up). It  is designed as scaled integer message since the resolution of float is not
 * sufficient. NOTE: This message is intended for onboard networks / companion computers and
 * higher-bandwidth links and optimized for accuracy and completeness. Please use the
 * GLOBAL_POSITION_INT message for a minimal subset.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param estimatorType Class id of the estimator this estimate originated from.
 * @param lat Latitude
 * units = degE7
 * @param lon Longitude
 * units = degE7
 * @param alt Altitude in meters above MSL
 * units = mm
 * @param relativeAlt Altitude above ground
 * units = mm
 * @param vx Ground X Speed (Latitude)
 * units = m/s
 * @param vy Ground Y Speed (Longitude)
 * units = m/s
 * @param vz Ground Z Speed (Altitude)
 * units = m/s
 * @param covariance Row-major representation of a 6x6 position and velocity 6x6 cross-covariance
 * matrix (states: lat, lon, alt, vx, vy, vz; first six entries are the first ROW, next six entries are
 * the second row, etc.). If unknown, assign NaN value to first element in the array.
 */
@GeneratedMavMessage(
  id = 63u,
  crcExtra = 119,
)
public data class GlobalPositionIntCov(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Class id of the estimator this estimate originated from.
   */
  @GeneratedMavField(type = "uint8_t")
  public val estimatorType: MavEnumValue<MavEstimatorType> = MavEnumValue.fromValue(0u),
  /**
   * Latitude
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude in meters above MSL
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Ground X Speed (Latitude)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Ground Y Speed (Longitude)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Ground Z Speed (Altitude)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * Row-major representation of a 6x6 position and velocity 6x6 cross-covariance matrix (states:
   * lat, lon, alt, vx, vy, vz; first six entries are the first ROW, next six entries are the second
   * row, etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(type = "float[36]")
  public val covariance: List<Float> = emptyList(),
) : MavMessage<GlobalPositionIntCov> {
  override val instanceCompanion: MavMessage.MavCompanion<GlobalPositionIntCov> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt32(relativeAlt)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloatArray(covariance, 144)
    encoder.encodeEnumValue(estimatorType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt32(relativeAlt)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloatArray(covariance, 144)
    encoder.encodeEnumValue(estimatorType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GlobalPositionIntCov> {
    private const val SIZE_V1: Int = 181

    private const val SIZE_V2: Int = 181

    override val id: UInt = 63u

    override val crcExtra: Byte = 119

    override fun deserialize(bytes: ByteArray): GlobalPositionIntCov {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt32()
      val relativeAlt = decoder.safeDecodeInt32()
      val vx = decoder.safeDecodeFloat()
      val vy = decoder.safeDecodeFloat()
      val vz = decoder.safeDecodeFloat()
      val covariance = decoder.safeDecodeFloatArray(144)
      val estimatorType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavEstimatorType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return GlobalPositionIntCov(
        timeUsec = timeUsec,
        estimatorType = estimatorType,
        lat = lat,
        lon = lon,
        alt = alt,
        relativeAlt = relativeAlt,
        vx = vx,
        vy = vy,
        vz = vz,
        covariance = covariance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GlobalPositionIntCov =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var estimatorType: MavEnumValue<MavEstimatorType> = MavEnumValue.fromValue(0u)

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var relativeAlt: Int = 0

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var covariance: List<Float> = emptyList()

    public fun build(): GlobalPositionIntCov = GlobalPositionIntCov(
      timeUsec = timeUsec,
      estimatorType = estimatorType,
      lat = lat,
      lon = lon,
      alt = alt,
      relativeAlt = relativeAlt,
      vx = vx,
      vy = vy,
      vz = vz,
      covariance = covariance,
    )
  }
}
