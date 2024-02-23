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
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
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
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is
 * right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param estimatorType Class id of the estimator this estimate originated from.
 * @param x X Position
 * units = m
 * @param y Y Position
 * units = m
 * @param z Z Position
 * units = m
 * @param vx X Speed
 * units = m/s
 * @param vy Y Speed
 * units = m/s
 * @param vz Z Speed
 * units = m/s
 * @param ax X Acceleration
 * units = m/s/s
 * @param ay Y Acceleration
 * units = m/s/s
 * @param az Z Acceleration
 * units = m/s/s
 * @param covariance Row-major representation of position, velocity and acceleration 9x9
 * cross-covariance matrix upper right triangle (states: x, y, z, vx, vy, vz, ax, ay, az; first nine
 * entries are the first ROW, next eight entries are the second row, etc.). If unknown, assign NaN
 * value to first element in the array.
 */
@GeneratedMavMessage(
  id = 64u,
  crcExtra = -65,
)
public data class LocalPositionNedCov(
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
   * X Position
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * X Speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y Speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z Speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * X Acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val ax: Float = 0F,
  /**
   * Y Acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val ay: Float = 0F,
  /**
   * Z Acceleration
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val az: Float = 0F,
  /**
   * Row-major representation of position, velocity and acceleration 9x9 cross-covariance matrix
   * upper right triangle (states: x, y, z, vx, vy, vz, ax, ay, az; first nine entries are the first
   * ROW, next eight entries are the second row, etc.). If unknown, assign NaN value to first element
   * in the array.
   */
  @GeneratedMavField(type = "float[45]")
  public val covariance: List<Float> = emptyList(),
) : MavMessage<LocalPositionNedCov> {
  override val instanceCompanion: MavMessage.MavCompanion<LocalPositionNedCov> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(ax)
    encoder.encodeFloat(ay)
    encoder.encodeFloat(az)
    encoder.encodeFloatArray(covariance, 180)
    encoder.encodeEnumValue(estimatorType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(ax)
    encoder.encodeFloat(ay)
    encoder.encodeFloat(az)
    encoder.encodeFloatArray(covariance, 180)
    encoder.encodeEnumValue(estimatorType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LocalPositionNedCov> {
    private const val SIZE_V1: Int = 225

    private const val SIZE_V2: Int = 225

    override val id: UInt = 64u

    override val crcExtra: Byte = -65

    override fun deserialize(bytes: ByteArray): LocalPositionNedCov {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val vx = decoder.safeDecodeFloat()
      val vy = decoder.safeDecodeFloat()
      val vz = decoder.safeDecodeFloat()
      val ax = decoder.safeDecodeFloat()
      val ay = decoder.safeDecodeFloat()
      val az = decoder.safeDecodeFloat()
      val covariance = decoder.safeDecodeFloatArray(180)
      val estimatorType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavEstimatorType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return LocalPositionNedCov(
        timeUsec = timeUsec,
        estimatorType = estimatorType,
        x = x,
        y = y,
        z = z,
        vx = vx,
        vy = vy,
        vz = vz,
        ax = ax,
        ay = ay,
        az = az,
        covariance = covariance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LocalPositionNedCov =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var estimatorType: MavEnumValue<MavEstimatorType> = MavEnumValue.fromValue(0u)

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var ax: Float = 0F

    public var ay: Float = 0F

    public var az: Float = 0F

    public var covariance: List<Float> = emptyList()

    public fun build(): LocalPositionNedCov = LocalPositionNedCov(
      timeUsec = timeUsec,
      estimatorType = estimatorType,
      x = x,
      y = y,
      z = z,
      vx = vx,
      vy = vy,
      vz = vz,
      ax = ax,
      ay = ay,
      az = az,
      covariance = covariance,
    )
  }
}
