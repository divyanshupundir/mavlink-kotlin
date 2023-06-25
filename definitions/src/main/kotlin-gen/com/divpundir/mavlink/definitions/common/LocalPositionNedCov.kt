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
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeFloat(vx)
    buffer.encodeFloat(vy)
    buffer.encodeFloat(vz)
    buffer.encodeFloat(ax)
    buffer.encodeFloat(ay)
    buffer.encodeFloat(az)
    buffer.encodeFloatArray(covariance, 180)
    buffer.encodeEnumValue(estimatorType.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeFloat(vx)
    buffer.encodeFloat(vy)
    buffer.encodeFloat(vz)
    buffer.encodeFloat(ax)
    buffer.encodeFloat(ay)
    buffer.encodeFloat(az)
    buffer.encodeFloatArray(covariance, 180)
    buffer.encodeEnumValue(estimatorType.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LocalPositionNedCov> {
    public override val id: UInt = 64u

    public override val crcExtra: Byte = -65

    public override fun deserialize(bytes: ByteArray): LocalPositionNedCov {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val x = buffer.decodeFloat()
      val y = buffer.decodeFloat()
      val z = buffer.decodeFloat()
      val vx = buffer.decodeFloat()
      val vy = buffer.decodeFloat()
      val vz = buffer.decodeFloat()
      val ax = buffer.decodeFloat()
      val ay = buffer.decodeFloat()
      val az = buffer.decodeFloat()
      val covariance = buffer.decodeFloatArray(180)
      val estimatorType = buffer.decodeEnumValue(1).let { value ->
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
