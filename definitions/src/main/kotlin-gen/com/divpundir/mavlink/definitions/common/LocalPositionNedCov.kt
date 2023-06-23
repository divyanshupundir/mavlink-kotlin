package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeEnumValue
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
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is
 * right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)
 */
@GeneratedMavMessage(
  id = 64u,
  crcExtra = -65,
)
public data class LocalPositionNedCov(
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
   * X Position
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * X Speed
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y Speed
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z Speed
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * X Acceleration
   */
  @GeneratedMavField(type = "float")
  public val ax: Float = 0F,
  /**
   * Y Acceleration
   */
  @GeneratedMavField(type = "float")
  public val ay: Float = 0F,
  /**
   * Z Acceleration
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
  public override val instanceCompanion: MavMessage.MavCompanion<LocalPositionNedCov> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeFloat(vx)
    output.encodeFloat(vy)
    output.encodeFloat(vz)
    output.encodeFloat(ax)
    output.encodeFloat(ay)
    output.encodeFloat(az)
    output.encodeFloatArray(covariance, 180)
    output.encodeEnumValue(estimatorType.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeFloat(vx)
    output.encodeFloat(vy)
    output.encodeFloat(vz)
    output.encodeFloat(ax)
    output.encodeFloat(ay)
    output.encodeFloat(az)
    output.encodeFloatArray(covariance, 180)
    output.encodeEnumValue(estimatorType.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LocalPositionNedCov> {
    private const val SIZE_V1: Int = 225

    private const val SIZE_V2: Int = 225

    public override val id: UInt = 64u

    public override val crcExtra: Byte = -65

    public override fun deserialize(source: BufferedSource): LocalPositionNedCov {
      val timeUsec = source.decodeUInt64()
      val x = source.decodeFloat()
      val y = source.decodeFloat()
      val z = source.decodeFloat()
      val vx = source.decodeFloat()
      val vy = source.decodeFloat()
      val vz = source.decodeFloat()
      val ax = source.decodeFloat()
      val ay = source.decodeFloat()
      val az = source.decodeFloat()
      val covariance = source.decodeFloatArray(180)
      val estimatorType = source.decodeEnumValue(1).let { value ->
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
