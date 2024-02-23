package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.definitions.common.MavDistanceSensor
import com.divpundir.mavlink.definitions.common.MavFrame
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Obstacle located as a 3D vector.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param sensorType Class id of the distance sensor type.
 * @param frame Coordinate frame of reference.
 * @param obstacleId  Unique ID given to each obstacle so that its movement can be tracked. Use
 * UINT16_MAX if object ID is unknown or cannot be determined.
 * @param x  X position of the obstacle.
 * units = m
 * @param y  Y position of the obstacle.
 * units = m
 * @param z  Z position of the obstacle.
 * units = m
 * @param minDistance Minimum distance the sensor can measure.
 * units = m
 * @param maxDistance Maximum distance the sensor can measure.
 * units = m
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 11_037u,
  crcExtra = -126,
)
public data class ObstacleDistance3d(
  /**
   * Timestamp (time since system boot).
   * units = ms
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
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   *  Y position of the obstacle.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   *  Z position of the obstacle.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Minimum distance the sensor can measure.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val minDistance: Float = 0F,
  /**
   * Maximum distance the sensor can measure.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val maxDistance: Float = 0F,
) : MavMessage<ObstacleDistance3d> {
  override val instanceCompanion: MavMessage.MavCompanion<ObstacleDistance3d> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(minDistance)
    encoder.encodeFloat(maxDistance)
    encoder.encodeUInt16(obstacleId)
    encoder.encodeEnumValue(sensorType.value, 1)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(minDistance)
    encoder.encodeFloat(maxDistance)
    encoder.encodeUInt16(obstacleId)
    encoder.encodeEnumValue(sensorType.value, 1)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ObstacleDistance3d> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    override val id: UInt = 11_037u

    override val crcExtra: Byte = -126

    override fun deserialize(bytes: ByteArray): ObstacleDistance3d {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val minDistance = decoder.safeDecodeFloat()
      val maxDistance = decoder.safeDecodeFloat()
      val obstacleId = decoder.safeDecodeUInt16()
      val sensorType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val frame = decoder.safeDecodeEnumValue(1).let { value ->
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
