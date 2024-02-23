package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define
 * message interval.
 *
 * @param trackingStatus Current tracking status
 * @param trackingMode Current tracking mode
 * @param targetData Defines location of target data
 * @param pointX Current tracked point x value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is
 * left, 1 is right), NAN if unknown
 * @param pointY Current tracked point y value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is
 * top, 1 is bottom), NAN if unknown
 * @param radius Current tracked radius if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is image
 * left, 1 is image right), NAN if unknown
 * @param recTopX Current tracked rectangle top x value if CAMERA_TRACKING_MODE_RECTANGLE
 * (normalized 0..1, 0 is left, 1 is right), NAN if unknown
 * @param recTopY Current tracked rectangle top y value if CAMERA_TRACKING_MODE_RECTANGLE
 * (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown
 * @param recBottomX Current tracked rectangle bottom x value if CAMERA_TRACKING_MODE_RECTANGLE
 * (normalized 0..1, 0 is left, 1 is right), NAN if unknown
 * @param recBottomY Current tracked rectangle bottom y value if CAMERA_TRACKING_MODE_RECTANGLE
 * (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown
 */
@GeneratedMavMessage(
  id = 275u,
  crcExtra = 126,
)
public data class CameraTrackingImageStatus(
  /**
   * Current tracking status
   */
  @GeneratedMavField(type = "uint8_t")
  public val trackingStatus: MavEnumValue<CameraTrackingStatusFlags> = MavEnumValue.fromValue(0u),
  /**
   * Current tracking mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val trackingMode: MavEnumValue<CameraTrackingMode> = MavEnumValue.fromValue(0u),
  /**
   * Defines location of target data
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetData: MavBitmaskValue<CameraTrackingTargetData> = MavBitmaskValue.fromValue(0u),
  /**
   * Current tracked point x value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is left, 1 is
   * right), NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val pointX: Float = 0F,
  /**
   * Current tracked point y value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is top, 1 is
   * bottom), NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val pointY: Float = 0F,
  /**
   * Current tracked radius if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is image left, 1 is
   * image right), NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val radius: Float = 0F,
  /**
   * Current tracked rectangle top x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is
   * left, 1 is right), NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val recTopX: Float = 0F,
  /**
   * Current tracked rectangle top y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is
   * top, 1 is bottom), NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val recTopY: Float = 0F,
  /**
   * Current tracked rectangle bottom x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0
   * is left, 1 is right), NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val recBottomX: Float = 0F,
  /**
   * Current tracked rectangle bottom y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0
   * is top, 1 is bottom), NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val recBottomY: Float = 0F,
) : MavMessage<CameraTrackingImageStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<CameraTrackingImageStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(pointX)
    encoder.encodeFloat(pointY)
    encoder.encodeFloat(radius)
    encoder.encodeFloat(recTopX)
    encoder.encodeFloat(recTopY)
    encoder.encodeFloat(recBottomX)
    encoder.encodeFloat(recBottomY)
    encoder.encodeEnumValue(trackingStatus.value, 1)
    encoder.encodeEnumValue(trackingMode.value, 1)
    encoder.encodeBitmaskValue(targetData.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(pointX)
    encoder.encodeFloat(pointY)
    encoder.encodeFloat(radius)
    encoder.encodeFloat(recTopX)
    encoder.encodeFloat(recTopY)
    encoder.encodeFloat(recBottomX)
    encoder.encodeFloat(recBottomY)
    encoder.encodeEnumValue(trackingStatus.value, 1)
    encoder.encodeEnumValue(trackingMode.value, 1)
    encoder.encodeBitmaskValue(targetData.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraTrackingImageStatus> {
    private const val SIZE_V1: Int = 31

    private const val SIZE_V2: Int = 31

    override val id: UInt = 275u

    override val crcExtra: Byte = 126

    override fun deserialize(bytes: ByteArray): CameraTrackingImageStatus {
      val decoder = MavDataDecoder(bytes)

      val pointX = decoder.safeDecodeFloat()
      val pointY = decoder.safeDecodeFloat()
      val radius = decoder.safeDecodeFloat()
      val recTopX = decoder.safeDecodeFloat()
      val recTopY = decoder.safeDecodeFloat()
      val recBottomX = decoder.safeDecodeFloat()
      val recBottomY = decoder.safeDecodeFloat()
      val trackingStatus = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = CameraTrackingStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val trackingMode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = CameraTrackingMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetData = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = CameraTrackingTargetData.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return CameraTrackingImageStatus(
        trackingStatus = trackingStatus,
        trackingMode = trackingMode,
        targetData = targetData,
        pointX = pointX,
        pointY = pointY,
        radius = radius,
        recTopX = recTopX,
        recTopY = recTopY,
        recBottomX = recBottomX,
        recBottomY = recBottomY,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraTrackingImageStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var trackingStatus: MavEnumValue<CameraTrackingStatusFlags> = MavEnumValue.fromValue(0u)

    public var trackingMode: MavEnumValue<CameraTrackingMode> = MavEnumValue.fromValue(0u)

    public var targetData: MavBitmaskValue<CameraTrackingTargetData> = MavBitmaskValue.fromValue(0u)

    public var pointX: Float = 0F

    public var pointY: Float = 0F

    public var radius: Float = 0F

    public var recTopX: Float = 0F

    public var recTopY: Float = 0F

    public var recBottomX: Float = 0F

    public var recBottomY: Float = 0F

    public fun build(): CameraTrackingImageStatus = CameraTrackingImageStatus(
      trackingStatus = trackingStatus,
      trackingMode = trackingMode,
      targetData = targetData,
      pointX = pointX,
      pointY = pointY,
      radius = radius,
      recTopX = recTopX,
      recTopY = recTopY,
      recBottomX = recBottomX,
      recBottomY = recBottomY,
    )
  }
}
