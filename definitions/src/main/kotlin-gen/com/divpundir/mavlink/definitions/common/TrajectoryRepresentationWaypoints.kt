package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt16Array
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
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Describe a trajectory using an array of up-to 5 waypoints in the local frame
 * (MAV_FRAME_LOCAL_NED).
 */
@GeneratedMavMessage(
  id = 332u,
  crcExtra = -20,
)
public data class TrajectoryRepresentationWaypoints(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
   */
  @GeneratedMavField(type = "float[5]")
  public val posX: List<Float> = emptyList(),
  /**
   * Y-coordinate of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val posY: List<Float> = emptyList(),
  /**
   * Z-coordinate of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val posZ: List<Float> = emptyList(),
  /**
   * X-velocity of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val velX: List<Float> = emptyList(),
  /**
   * Y-velocity of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val velY: List<Float> = emptyList(),
  /**
   * Z-velocity of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val velZ: List<Float> = emptyList(),
  /**
   * X-acceleration of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val accX: List<Float> = emptyList(),
  /**
   * Y-acceleration of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val accY: List<Float> = emptyList(),
  /**
   * Z-acceleration of waypoint, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val accZ: List<Float> = emptyList(),
  /**
   * Yaw angle, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val posYaw: List<Float> = emptyList(),
  /**
   * Yaw rate, set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val velYaw: List<Float> = emptyList(),
  /**
   * MAV_CMD command id of waypoint, set to UINT16_MAX if not being used.
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val command: List<UShort> = emptyList(),
) : MavMessage<TrajectoryRepresentationWaypoints> {
  public override val instanceCompanion: MavMessage.MavCompanion<TrajectoryRepresentationWaypoints>
      = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloatArray(posX, 20)
    outputBuffer.encodeFloatArray(posY, 20)
    outputBuffer.encodeFloatArray(posZ, 20)
    outputBuffer.encodeFloatArray(velX, 20)
    outputBuffer.encodeFloatArray(velY, 20)
    outputBuffer.encodeFloatArray(velZ, 20)
    outputBuffer.encodeFloatArray(accX, 20)
    outputBuffer.encodeFloatArray(accY, 20)
    outputBuffer.encodeFloatArray(accZ, 20)
    outputBuffer.encodeFloatArray(posYaw, 20)
    outputBuffer.encodeFloatArray(velYaw, 20)
    outputBuffer.encodeUInt16Array(command, 10)
    outputBuffer.encodeUInt8(validPoints)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloatArray(posX, 20)
    outputBuffer.encodeFloatArray(posY, 20)
    outputBuffer.encodeFloatArray(posZ, 20)
    outputBuffer.encodeFloatArray(velX, 20)
    outputBuffer.encodeFloatArray(velY, 20)
    outputBuffer.encodeFloatArray(velZ, 20)
    outputBuffer.encodeFloatArray(accX, 20)
    outputBuffer.encodeFloatArray(accY, 20)
    outputBuffer.encodeFloatArray(accZ, 20)
    outputBuffer.encodeFloatArray(posYaw, 20)
    outputBuffer.encodeFloatArray(velYaw, 20)
    outputBuffer.encodeUInt16Array(command, 10)
    outputBuffer.encodeUInt8(validPoints)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TrajectoryRepresentationWaypoints> {
    private const val SIZE_V1: Int = 239

    private const val SIZE_V2: Int = 239

    public override val id: UInt = 332u

    public override val crcExtra: Byte = -20

    public override fun deserialize(bytes: ByteArray): TrajectoryRepresentationWaypoints {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val posX = inputBuffer.decodeFloatArray(20)
      val posY = inputBuffer.decodeFloatArray(20)
      val posZ = inputBuffer.decodeFloatArray(20)
      val velX = inputBuffer.decodeFloatArray(20)
      val velY = inputBuffer.decodeFloatArray(20)
      val velZ = inputBuffer.decodeFloatArray(20)
      val accX = inputBuffer.decodeFloatArray(20)
      val accY = inputBuffer.decodeFloatArray(20)
      val accZ = inputBuffer.decodeFloatArray(20)
      val posYaw = inputBuffer.decodeFloatArray(20)
      val velYaw = inputBuffer.decodeFloatArray(20)
      val command = inputBuffer.decodeUInt16Array(10)
      val validPoints = inputBuffer.decodeUInt8()

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
