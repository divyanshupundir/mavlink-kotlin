package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt16Array
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
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Describe a trajectory using an array of up-to 5 waypoints in the local frame
 * (MAV_FRAME_LOCAL_NED).
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param validPoints Number of valid points (up-to 5 waypoints are possible)
 * @param posX X-coordinate of waypoint, set to NaN if not being used
 * units = m
 * @param posY Y-coordinate of waypoint, set to NaN if not being used
 * units = m
 * @param posZ Z-coordinate of waypoint, set to NaN if not being used
 * units = m
 * @param velX X-velocity of waypoint, set to NaN if not being used
 * units = m/s
 * @param velY Y-velocity of waypoint, set to NaN if not being used
 * units = m/s
 * @param velZ Z-velocity of waypoint, set to NaN if not being used
 * units = m/s
 * @param accX X-acceleration of waypoint, set to NaN if not being used
 * units = m/s/s
 * @param accY Y-acceleration of waypoint, set to NaN if not being used
 * units = m/s/s
 * @param accZ Z-acceleration of waypoint, set to NaN if not being used
 * units = m/s/s
 * @param posYaw Yaw angle, set to NaN if not being used
 * units = rad
 * @param velYaw Yaw rate, set to NaN if not being used
 * units = rad/s
 * @param command MAV_CMD command id of waypoint, set to UINT16_MAX if not being used.
 */
@GeneratedMavMessage(
  id = 332u,
  crcExtra = -20,
)
public data class TrajectoryRepresentationWaypoints(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Number of valid points (up-to 5 waypoints are possible)
   */
  @GeneratedMavField(type = "uint8_t")
  public val validPoints: UByte = 0u,
  /**
   * X-coordinate of waypoint, set to NaN if not being used
   * units = m
   */
  @GeneratedMavField(type = "float[5]")
  public val posX: List<Float> = emptyList(),
  /**
   * Y-coordinate of waypoint, set to NaN if not being used
   * units = m
   */
  @GeneratedMavField(type = "float[5]")
  public val posY: List<Float> = emptyList(),
  /**
   * Z-coordinate of waypoint, set to NaN if not being used
   * units = m
   */
  @GeneratedMavField(type = "float[5]")
  public val posZ: List<Float> = emptyList(),
  /**
   * X-velocity of waypoint, set to NaN if not being used
   * units = m/s
   */
  @GeneratedMavField(type = "float[5]")
  public val velX: List<Float> = emptyList(),
  /**
   * Y-velocity of waypoint, set to NaN if not being used
   * units = m/s
   */
  @GeneratedMavField(type = "float[5]")
  public val velY: List<Float> = emptyList(),
  /**
   * Z-velocity of waypoint, set to NaN if not being used
   * units = m/s
   */
  @GeneratedMavField(type = "float[5]")
  public val velZ: List<Float> = emptyList(),
  /**
   * X-acceleration of waypoint, set to NaN if not being used
   * units = m/s/s
   */
  @GeneratedMavField(type = "float[5]")
  public val accX: List<Float> = emptyList(),
  /**
   * Y-acceleration of waypoint, set to NaN if not being used
   * units = m/s/s
   */
  @GeneratedMavField(type = "float[5]")
  public val accY: List<Float> = emptyList(),
  /**
   * Z-acceleration of waypoint, set to NaN if not being used
   * units = m/s/s
   */
  @GeneratedMavField(type = "float[5]")
  public val accZ: List<Float> = emptyList(),
  /**
   * Yaw angle, set to NaN if not being used
   * units = rad
   */
  @GeneratedMavField(type = "float[5]")
  public val posYaw: List<Float> = emptyList(),
  /**
   * Yaw rate, set to NaN if not being used
   * units = rad/s
   */
  @GeneratedMavField(type = "float[5]")
  public val velYaw: List<Float> = emptyList(),
  /**
   * MAV_CMD command id of waypoint, set to UINT16_MAX if not being used.
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val command: List<UShort> = emptyList(),
) : MavMessage<TrajectoryRepresentationWaypoints> {
  override val instanceCompanion: MavMessage.MavCompanion<TrajectoryRepresentationWaypoints> =
      Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(posX, 20)
    encoder.encodeFloatArray(posY, 20)
    encoder.encodeFloatArray(posZ, 20)
    encoder.encodeFloatArray(velX, 20)
    encoder.encodeFloatArray(velY, 20)
    encoder.encodeFloatArray(velZ, 20)
    encoder.encodeFloatArray(accX, 20)
    encoder.encodeFloatArray(accY, 20)
    encoder.encodeFloatArray(accZ, 20)
    encoder.encodeFloatArray(posYaw, 20)
    encoder.encodeFloatArray(velYaw, 20)
    encoder.encodeUInt16Array(command, 10)
    encoder.encodeUInt8(validPoints)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(posX, 20)
    encoder.encodeFloatArray(posY, 20)
    encoder.encodeFloatArray(posZ, 20)
    encoder.encodeFloatArray(velX, 20)
    encoder.encodeFloatArray(velY, 20)
    encoder.encodeFloatArray(velZ, 20)
    encoder.encodeFloatArray(accX, 20)
    encoder.encodeFloatArray(accY, 20)
    encoder.encodeFloatArray(accZ, 20)
    encoder.encodeFloatArray(posYaw, 20)
    encoder.encodeFloatArray(velYaw, 20)
    encoder.encodeUInt16Array(command, 10)
    encoder.encodeUInt8(validPoints)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TrajectoryRepresentationWaypoints> {
    private const val SIZE_V1: Int = 239

    private const val SIZE_V2: Int = 239

    override val id: UInt = 332u

    override val crcExtra: Byte = -20

    override fun deserialize(bytes: ByteArray): TrajectoryRepresentationWaypoints {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val posX = decoder.safeDecodeFloatArray(20)
      val posY = decoder.safeDecodeFloatArray(20)
      val posZ = decoder.safeDecodeFloatArray(20)
      val velX = decoder.safeDecodeFloatArray(20)
      val velY = decoder.safeDecodeFloatArray(20)
      val velZ = decoder.safeDecodeFloatArray(20)
      val accX = decoder.safeDecodeFloatArray(20)
      val accY = decoder.safeDecodeFloatArray(20)
      val accZ = decoder.safeDecodeFloatArray(20)
      val posYaw = decoder.safeDecodeFloatArray(20)
      val velYaw = decoder.safeDecodeFloatArray(20)
      val command = decoder.safeDecodeUInt16Array(10)
      val validPoints = decoder.safeDecodeUInt8()

      return TrajectoryRepresentationWaypoints(
        timeUsec = timeUsec,
        validPoints = validPoints,
        posX = posX,
        posY = posY,
        posZ = posZ,
        velX = velX,
        velY = velY,
        velZ = velZ,
        accX = accX,
        accY = accY,
        accZ = accZ,
        posYaw = posYaw,
        velYaw = velYaw,
        command = command,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TrajectoryRepresentationWaypoints
        = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var validPoints: UByte = 0u

    public var posX: List<Float> = emptyList()

    public var posY: List<Float> = emptyList()

    public var posZ: List<Float> = emptyList()

    public var velX: List<Float> = emptyList()

    public var velY: List<Float> = emptyList()

    public var velZ: List<Float> = emptyList()

    public var accX: List<Float> = emptyList()

    public var accY: List<Float> = emptyList()

    public var accZ: List<Float> = emptyList()

    public var posYaw: List<Float> = emptyList()

    public var velYaw: List<Float> = emptyList()

    public var command: List<UShort> = emptyList()

    public fun build(): TrajectoryRepresentationWaypoints = TrajectoryRepresentationWaypoints(
      timeUsec = timeUsec,
      validPoints = validPoints,
      posX = posX,
      posY = posY,
      posZ = posZ,
      velX = velX,
      velY = velY,
      velZ = velZ,
      accX = accX,
      accY = accY,
      accZ = accZ,
      posYaw = posYaw,
      velYaw = velYaw,
      command = command,
    )
  }
}
