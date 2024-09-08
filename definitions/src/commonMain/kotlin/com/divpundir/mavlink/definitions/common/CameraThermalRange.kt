package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Camera absolute thermal range. This can be streamed when the associated
 * `VIDEO_STREAM_STATUS.flag` bit `VIDEO_STREAM_STATUS_FLAGS_THERMAL_RANGE_ENABLED` is set, but a GCS
 * may choose to only request it for the current active stream. Use MAV_CMD_SET_MESSAGE_INTERVAL to
 * define message interval (param3 indicates the stream id of the current camera, or 0 for all streams,
 * param4 indicates the target camera_device_id for autopilot-attached cameras or 0 for MAVLink
 * cameras).
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param streamId Video Stream ID (1 for first, 2 for second, etc.)
 * @param cameraDeviceId Camera id of a non-MAVLink camera attached to an autopilot (1-6).  0 if the
 * component is a MAVLink camera (with its own component id).
 * @param max Temperature max.
 * units = degC
 * @param maxPointX Temperature max point x value (normalized 0..1, 0 is left, 1 is right), NAN if
 * unknown.
 * @param maxPointY Temperature max point y value (normalized 0..1, 0 is top, 1 is bottom), NAN if
 * unknown.
 * @param min Temperature min.
 * units = degC
 * @param minPointX Temperature min point x value (normalized 0..1, 0 is left, 1 is right), NAN if
 * unknown.
 * @param minPointY Temperature min point y value (normalized 0..1, 0 is top, 1 is bottom), NAN if
 * unknown.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 277u,
  crcExtra = 62,
)
public data class CameraThermalRange(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Video Stream ID (1 for first, 2 for second, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val streamId: UByte = 0u,
  /**
   * Camera id of a non-MAVLink camera attached to an autopilot (1-6).  0 if the component is a
   * MAVLink camera (with its own component id).
   */
  @GeneratedMavField(type = "uint8_t")
  public val cameraDeviceId: UByte = 0u,
  /**
   * Temperature max.
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val max: Float = 0F,
  /**
   * Temperature max point x value (normalized 0..1, 0 is left, 1 is right), NAN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val maxPointX: Float = 0F,
  /**
   * Temperature max point y value (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val maxPointY: Float = 0F,
  /**
   * Temperature min.
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val min: Float = 0F,
  /**
   * Temperature min point x value (normalized 0..1, 0 is left, 1 is right), NAN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val minPointX: Float = 0F,
  /**
   * Temperature min point y value (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown.
   */
  @GeneratedMavField(type = "float")
  public val minPointY: Float = 0F,
) : MavMessage<CameraThermalRange> {
  override val instanceCompanion: MavMessage.MavCompanion<CameraThermalRange> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(max)
    encoder.encodeFloat(maxPointX)
    encoder.encodeFloat(maxPointY)
    encoder.encodeFloat(min)
    encoder.encodeFloat(minPointX)
    encoder.encodeFloat(minPointY)
    encoder.encodeUInt8(streamId)
    encoder.encodeUInt8(cameraDeviceId)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(max)
    encoder.encodeFloat(maxPointX)
    encoder.encodeFloat(maxPointY)
    encoder.encodeFloat(min)
    encoder.encodeFloat(minPointX)
    encoder.encodeFloat(minPointY)
    encoder.encodeUInt8(streamId)
    encoder.encodeUInt8(cameraDeviceId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraThermalRange> {
    private const val SIZE_V1: Int = 30

    private const val SIZE_V2: Int = 30

    override val id: UInt = 277u

    override val crcExtra: Byte = 62

    override fun deserialize(bytes: ByteArray): CameraThermalRange {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val max = decoder.safeDecodeFloat()
      val maxPointX = decoder.safeDecodeFloat()
      val maxPointY = decoder.safeDecodeFloat()
      val min = decoder.safeDecodeFloat()
      val minPointX = decoder.safeDecodeFloat()
      val minPointY = decoder.safeDecodeFloat()
      val streamId = decoder.safeDecodeUInt8()
      val cameraDeviceId = decoder.safeDecodeUInt8()

      return CameraThermalRange(
        timeBootMs = timeBootMs,
        streamId = streamId,
        cameraDeviceId = cameraDeviceId,
        max = max,
        maxPointX = maxPointX,
        maxPointY = maxPointY,
        min = min,
        minPointX = minPointX,
        minPointY = minPointY,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraThermalRange =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var streamId: UByte = 0u

    public var cameraDeviceId: UByte = 0u

    public var max: Float = 0F

    public var maxPointX: Float = 0F

    public var maxPointY: Float = 0F

    public var min: Float = 0F

    public var minPointX: Float = 0F

    public var minPointY: Float = 0F

    public fun build(): CameraThermalRange = CameraThermalRange(
      timeBootMs = timeBootMs,
      streamId = streamId,
      cameraDeviceId = cameraDeviceId,
      max = max,
      maxPointX = maxPointX,
      maxPointY = maxPointY,
      min = min,
      minPointX = minPointX,
      minPointY = minPointY,
    )
  }
}
