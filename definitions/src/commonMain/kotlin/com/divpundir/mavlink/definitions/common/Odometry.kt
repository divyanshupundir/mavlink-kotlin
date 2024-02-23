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
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeInt8
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
 * Odometry message to communicate odometry information with an external interface. Fits ROS REP 147
 * standard for aerial vehicles (http://www.ros.org/reps/rep-0147.html).
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param frameId Coordinate frame of reference for the pose data.
 * @param childFrameId Coordinate frame of reference for the velocity in free space (twist) data.
 * @param x X Position
 * units = m
 * @param y Y Position
 * units = m
 * @param z Z Position
 * units = m
 * @param q Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)
 * @param vx X linear speed
 * units = m/s
 * @param vy Y linear speed
 * units = m/s
 * @param vz Z linear speed
 * units = m/s
 * @param rollspeed Roll angular speed
 * units = rad/s
 * @param pitchspeed Pitch angular speed
 * units = rad/s
 * @param yawspeed Yaw angular speed
 * units = rad/s
 * @param poseCovariance Row-major representation of a 6x6 pose cross-covariance matrix upper right
 * triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries
 * are the second ROW, etc.). If unknown, assign NaN value to first element in the array.
 * @param velocityCovariance Row-major representation of a 6x6 velocity cross-covariance matrix
 * upper right triangle (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the
 * first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first
 * element in the array.
 * @param resetCounter Estimate reset counter. This should be incremented when the estimate resets
 * in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used
 * when e.g an external SLAM system detects a loop-closure and the estimate jumps.
 * @param estimatorType Type of estimator that is providing the odometry.
 * @param quality Optional odometry quality metric as a percentage. -1 = odometry has failed, 0 =
 * unknown/unset quality, 1 = worst quality, 100 = best quality
 * units = %
 */
@GeneratedMavMessage(
  id = 331u,
  crcExtra = 91,
)
public data class Odometry(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Coordinate frame of reference for the pose data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * Coordinate frame of reference for the velocity in free space (twist) data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val childFrameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
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
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X linear speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y linear speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z linear speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * Roll angular speed
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val rollspeed: Float = 0F,
  /**
   * Pitch angular speed
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val pitchspeed: Float = 0F,
  /**
   * Yaw angular speed
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val yawspeed: Float = 0F,
  /**
   * Row-major representation of a 6x6 pose cross-covariance matrix upper right triangle (states: x,
   * y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW,
   * etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(type = "float[21]")
  public val poseCovariance: List<Float> = emptyList(),
  /**
   * Row-major representation of a 6x6 velocity cross-covariance matrix upper right triangle
   * (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the first ROW, next
   * five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the
   * array.
   */
  @GeneratedMavField(type = "float[21]")
  public val velocityCovariance: List<Float> = emptyList(),
  /**
   * Estimate reset counter. This should be incremented when the estimate resets in any of the
   * dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an
   * external SLAM system detects a loop-closure and the estimate jumps.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val resetCounter: UByte = 0u,
  /**
   * Type of estimator that is providing the odometry.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val estimatorType: MavEnumValue<MavEstimatorType> = MavEnumValue.fromValue(0u),
  /**
   * Optional odometry quality metric as a percentage. -1 = odometry has failed, 0 = unknown/unset
   * quality, 1 = worst quality, 100 = best quality
   * units = %
   */
  @GeneratedMavField(
    type = "int8_t",
    extension = true,
  )
  public val quality: Byte = 0,
) : MavMessage<Odometry> {
  override val instanceCompanion: MavMessage.MavCompanion<Odometry> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    encoder.encodeFloatArray(poseCovariance, 84)
    encoder.encodeFloatArray(velocityCovariance, 84)
    encoder.encodeEnumValue(frameId.value, 1)
    encoder.encodeEnumValue(childFrameId.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    encoder.encodeFloatArray(poseCovariance, 84)
    encoder.encodeFloatArray(velocityCovariance, 84)
    encoder.encodeEnumValue(frameId.value, 1)
    encoder.encodeEnumValue(childFrameId.value, 1)
    encoder.encodeUInt8(resetCounter)
    encoder.encodeEnumValue(estimatorType.value, 1)
    encoder.encodeInt8(quality)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Odometry> {
    private const val SIZE_V1: Int = 230

    private const val SIZE_V2: Int = 233

    override val id: UInt = 331u

    override val crcExtra: Byte = 91

    override fun deserialize(bytes: ByteArray): Odometry {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val q = decoder.safeDecodeFloatArray(16)
      val vx = decoder.safeDecodeFloat()
      val vy = decoder.safeDecodeFloat()
      val vz = decoder.safeDecodeFloat()
      val rollspeed = decoder.safeDecodeFloat()
      val pitchspeed = decoder.safeDecodeFloat()
      val yawspeed = decoder.safeDecodeFloat()
      val poseCovariance = decoder.safeDecodeFloatArray(84)
      val velocityCovariance = decoder.safeDecodeFloatArray(84)
      val frameId = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val childFrameId = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val resetCounter = decoder.safeDecodeUInt8()
      val estimatorType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavEstimatorType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val quality = decoder.safeDecodeInt8()

      return Odometry(
        timeUsec = timeUsec,
        frameId = frameId,
        childFrameId = childFrameId,
        x = x,
        y = y,
        z = z,
        q = q,
        vx = vx,
        vy = vy,
        vz = vz,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        poseCovariance = poseCovariance,
        velocityCovariance = velocityCovariance,
        resetCounter = resetCounter,
        estimatorType = estimatorType,
        quality = quality,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Odometry =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var frameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var childFrameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var q: List<Float> = emptyList()

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var poseCovariance: List<Float> = emptyList()

    public var velocityCovariance: List<Float> = emptyList()

    public var resetCounter: UByte = 0u

    public var estimatorType: MavEnumValue<MavEstimatorType> = MavEnumValue.fromValue(0u)

    public var quality: Byte = 0

    public fun build(): Odometry = Odometry(
      timeUsec = timeUsec,
      frameId = frameId,
      childFrameId = childFrameId,
      x = x,
      y = y,
      z = z,
      q = q,
      vx = vx,
      vy = vy,
      vz = vz,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
      poseCovariance = poseCovariance,
      velocityCovariance = velocityCovariance,
      resetCounter = resetCounter,
      estimatorType = estimatorType,
      quality = quality,
    )
  }
}
