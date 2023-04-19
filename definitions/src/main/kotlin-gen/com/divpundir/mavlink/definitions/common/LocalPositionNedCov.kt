package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<LocalPositionNedCov> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(ax)
    outputBuffer.encodeFloat(ay)
    outputBuffer.encodeFloat(az)
    outputBuffer.encodeFloatArray(covariance, 180)
    outputBuffer.encodeEnumValue(estimatorType.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(ax)
    outputBuffer.encodeFloat(ay)
    outputBuffer.encodeFloat(az)
    outputBuffer.encodeFloatArray(covariance, 180)
    outputBuffer.encodeEnumValue(estimatorType.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 64u

    private const val CRC_EXTRA: Byte = -65

    private const val SIZE_V1: Int = 225

    private const val SIZE_V2: Int = 225

    private val DESERIALIZER: MavDeserializer<LocalPositionNedCov> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val vx = inputBuffer.decodeFloat()
      val vy = inputBuffer.decodeFloat()
      val vz = inputBuffer.decodeFloat()
      val ax = inputBuffer.decodeFloat()
      val ay = inputBuffer.decodeFloat()
      val az = inputBuffer.decodeFloat()
      val covariance = inputBuffer.decodeFloatArray(180)
      val estimatorType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavEstimatorType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      LocalPositionNedCov(
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


    private val METADATA: MavMessage.Metadata<LocalPositionNedCov> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LocalPositionNedCov> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): LocalPositionNedCov =
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