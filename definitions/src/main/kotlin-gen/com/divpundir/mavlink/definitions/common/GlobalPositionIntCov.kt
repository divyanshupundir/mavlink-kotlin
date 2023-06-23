package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
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
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame
 * (right-handed, Z-up). It  is designed as scaled integer message since the resolution of float is not
 * sufficient. NOTE: This message is intended for onboard networks / companion computers and
 * higher-bandwidth links and optimized for accuracy and completeness. Please use the
 * GLOBAL_POSITION_INT message for a minimal subset.
 */
@GeneratedMavMessage(
  id = 63u,
  crcExtra = 119,
)
public data class GlobalPositionIntCov(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude in meters above MSL
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Ground X Speed (Latitude)
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Ground Y Speed (Longitude)
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Ground Z Speed (Altitude)
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
  public override val instanceCompanion: MavMessage.MavCompanion<GlobalPositionIntCov> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt32(relativeAlt)
    output.encodeFloat(vx)
    output.encodeFloat(vy)
    output.encodeFloat(vz)
    output.encodeFloatArray(covariance, 144)
    output.encodeEnumValue(estimatorType.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt32(relativeAlt)
    output.encodeFloat(vx)
    output.encodeFloat(vy)
    output.encodeFloat(vz)
    output.encodeFloatArray(covariance, 144)
    output.encodeEnumValue(estimatorType.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GlobalPositionIntCov> {
    private const val SIZE_V1: Int = 181

    private const val SIZE_V2: Int = 181

    public override val id: UInt = 63u

    public override val crcExtra: Byte = 119

    public override fun deserialize(source: BufferedSource): GlobalPositionIntCov {
      val timeUsec = source.decodeUInt64()
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()
      val alt = source.decodeInt32()
      val relativeAlt = source.decodeInt32()
      val vx = source.decodeFloat()
      val vy = source.decodeFloat()
      val vz = source.decodeFloat()
      val covariance = source.decodeFloatArray(144)
      val estimatorType = source.decodeEnumValue(1).let { value ->
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
