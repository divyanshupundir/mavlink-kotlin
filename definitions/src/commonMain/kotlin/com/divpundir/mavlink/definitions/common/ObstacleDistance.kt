package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt16
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
 * Obstacle distances in front of the sensor, starting from the left in increment degrees to the
 * right
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param sensorType Class id of the distance sensor type.
 * @param distances Distance of obstacles around the vehicle with index 0 corresponding to north +
 * angle_offset, unless otherwise specified in the frame. A value of 0 is valid and means that the
 * obstacle is practically touching the sensor. A value of max_distance +1 means no obstacle is
 * present. A value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to
 * 1cm.
 * units = cm
 * @param increment Angular width in degrees of each array element. Increment direction is
 * clockwise. This field is ignored if increment_f is non-zero.
 * units = deg
 * @param minDistance Minimum distance the sensor can measure.
 * units = cm
 * @param maxDistance Maximum distance the sensor can measure.
 * units = cm
 * @param incrementF Angular width in degrees of each array element as a float. If non-zero then
 * this value is used instead of the uint8_t increment field. Positive is clockwise direction, negative
 * is counter-clockwise.
 * units = deg
 * @param angleOffset Relative angle offset of the 0-index element in the distances array. Value of
 * 0 corresponds to forward. Positive is clockwise direction, negative is counter-clockwise.
 * units = deg
 * @param frame Coordinate frame of reference for the yaw rotation and offset of the sensor data.
 * Defaults to MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use
 * MAV_FRAME_BODY_FRD, which is vehicle front aligned.
 */
@GeneratedMavMessage(
  id = 330u,
  crcExtra = 23,
)
public data class ObstacleDistance(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Class id of the distance sensor type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val sensorType: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0u),
  /**
   * Distance of obstacles around the vehicle with index 0 corresponding to north + angle_offset,
   * unless otherwise specified in the frame. A value of 0 is valid and means that the obstacle is
   * practically touching the sensor. A value of max_distance +1 means no obstacle is present. A value
   * of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm.
   * units = cm
   */
  @GeneratedMavField(type = "uint16_t[72]")
  public val distances: List<UShort> = emptyList(),
  /**
   * Angular width in degrees of each array element. Increment direction is clockwise. This field is
   * ignored if increment_f is non-zero.
   * units = deg
   */
  @GeneratedMavField(type = "uint8_t")
  public val increment: UByte = 0u,
  /**
   * Minimum distance the sensor can measure.
   * units = cm
   */
  @GeneratedMavField(type = "uint16_t")
  public val minDistance: UShort = 0u,
  /**
   * Maximum distance the sensor can measure.
   * units = cm
   */
  @GeneratedMavField(type = "uint16_t")
  public val maxDistance: UShort = 0u,
  /**
   * Angular width in degrees of each array element as a float. If non-zero then this value is used
   * instead of the uint8_t increment field. Positive is clockwise direction, negative is
   * counter-clockwise.
   * units = deg
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val incrementF: Float = 0F,
  /**
   * Relative angle offset of the 0-index element in the distances array. Value of 0 corresponds to
   * forward. Positive is clockwise direction, negative is counter-clockwise.
   * units = deg
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val angleOffset: Float = 0F,
  /**
   * Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to
   * MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use MAV_FRAME_BODY_FRD, which
   * is vehicle front aligned.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
) : MavMessage<ObstacleDistance> {
  override val instanceCompanion: MavMessage.MavCompanion<ObstacleDistance> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt16Array(distances, 144)
    encoder.encodeUInt16(minDistance)
    encoder.encodeUInt16(maxDistance)
    encoder.encodeEnumValue(sensorType.value, 1)
    encoder.encodeUInt8(increment)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt16Array(distances, 144)
    encoder.encodeUInt16(minDistance)
    encoder.encodeUInt16(maxDistance)
    encoder.encodeEnumValue(sensorType.value, 1)
    encoder.encodeUInt8(increment)
    encoder.encodeFloat(incrementF)
    encoder.encodeFloat(angleOffset)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ObstacleDistance> {
    private const val SIZE_V1: Int = 158

    private const val SIZE_V2: Int = 167

    override val id: UInt = 330u

    override val crcExtra: Byte = 23

    override fun deserialize(bytes: ByteArray): ObstacleDistance {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val distances = decoder.safeDecodeUInt16Array(144)
      val minDistance = decoder.safeDecodeUInt16()
      val maxDistance = decoder.safeDecodeUInt16()
      val sensorType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val increment = decoder.safeDecodeUInt8()
      val incrementF = decoder.safeDecodeFloat()
      val angleOffset = decoder.safeDecodeFloat()
      val frame = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ObstacleDistance(
        timeUsec = timeUsec,
        sensorType = sensorType,
        distances = distances,
        increment = increment,
        minDistance = minDistance,
        maxDistance = maxDistance,
        incrementF = incrementF,
        angleOffset = angleOffset,
        frame = frame,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ObstacleDistance =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var sensorType: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0u)

    public var distances: List<UShort> = emptyList()

    public var increment: UByte = 0u

    public var minDistance: UShort = 0u

    public var maxDistance: UShort = 0u

    public var incrementF: Float = 0F

    public var angleOffset: Float = 0F

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public fun build(): ObstacleDistance = ObstacleDistance(
      timeUsec = timeUsec,
      sensorType = sensorType,
      distances = distances,
      increment = increment,
      minDistance = minDistance,
      maxDistance = maxDistance,
      incrementF = incrementF,
      angleOffset = angleOffset,
      frame = frame,
    )
  }
}
