package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.definitions.common.MavDistanceSensor
import com.divpundir.mavlink.definitions.common.MavFrame
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Obstacle located as a 3D vector.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 11_037u,
  crcExtra = -126,
)
public data class ObstacleDistance3d(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Class id of the distance sensor type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val sensorType: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0u),
  /**
   * Coordinate frame of reference.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   *  Unique ID given to each obstacle so that its movement can be tracked. Use UINT16_MAX if object
   * ID is unknown or cannot be determined.
   */
  @GeneratedMavField(type = "uint16_t")
  public val obstacleId: UShort = 0u,
  /**
   *  X position of the obstacle.
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   *  Y position of the obstacle.
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   *  Z position of the obstacle.
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Minimum distance the sensor can measure.
   */
  @GeneratedMavField(type = "float")
  public val minDistance: Float = 0F,
  /**
   * Maximum distance the sensor can measure.
   */
  @GeneratedMavField(type = "float")
  public val maxDistance: Float = 0F,
) : MavMessage<ObstacleDistance3d> {
  public override val instanceCompanion: MavMessage.MavCompanion<ObstacleDistance3d> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(minDistance)
    outputBuffer.encodeFloat(maxDistance)
    outputBuffer.encodeUInt16(obstacleId)
    outputBuffer.encodeEnumValue(sensorType.value, 1)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(minDistance)
    outputBuffer.encodeFloat(maxDistance)
    outputBuffer.encodeUInt16(obstacleId)
    outputBuffer.encodeEnumValue(sensorType.value, 1)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ObstacleDistance3d> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 11_037u

    public override val crcExtra: Byte = -126

    public override fun deserialize(bytes: ByteArray): ObstacleDistance3d {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val minDistance = inputBuffer.decodeFloat()
      val maxDistance = inputBuffer.decodeFloat()
      val obstacleId = inputBuffer.decodeUInt16()
      val sensorType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ObstacleDistance3d(
        timeBootMs = timeBootMs,
        sensorType = sensorType,
        frame = frame,
        obstacleId = obstacleId,
        x = x,
        y = y,
        z = z,
        minDistance = minDistance,
        maxDistance = maxDistance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ObstacleDistance3d =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var sensorType: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0u)

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var obstacleId: UShort = 0u

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var minDistance: Float = 0F

    public var maxDistance: Float = 0F

    public fun build(): ObstacleDistance3d = ObstacleDistance3d(
      timeBootMs = timeBootMs,
      sensorType = sensorType,
      frame = frame,
      obstacleId = obstacleId,
      x = x,
      y = y,
      z = z,
      minDistance = minDistance,
      maxDistance = maxDistance,
    )
  }
}
