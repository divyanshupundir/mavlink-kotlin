package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define
 * message interval.
 */
@WorkInProgress
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
  public override val instanceCompanion: MavMessage.MavCompanion<CameraTrackingImageStatus> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(pointX)
    output.encodeFloat(pointY)
    output.encodeFloat(radius)
    output.encodeFloat(recTopX)
    output.encodeFloat(recTopY)
    output.encodeFloat(recBottomX)
    output.encodeFloat(recBottomY)
    output.encodeEnumValue(trackingStatus.value, 1)
    output.encodeEnumValue(trackingMode.value, 1)
    output.encodeBitmaskValue(targetData.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(pointX)
    output.encodeFloat(pointY)
    output.encodeFloat(radius)
    output.encodeFloat(recTopX)
    output.encodeFloat(recTopY)
    output.encodeFloat(recBottomX)
    output.encodeFloat(recBottomY)
    output.encodeEnumValue(trackingStatus.value, 1)
    output.encodeEnumValue(trackingMode.value, 1)
    output.encodeBitmaskValue(targetData.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CameraTrackingImageStatus> {
    private const val SIZE_V1: Int = 31

    private const val SIZE_V2: Int = 31

    public override val id: UInt = 275u

    public override val crcExtra: Byte = 126

    public override fun deserialize(source: BufferedSource): CameraTrackingImageStatus {
      val pointX = source.decodeFloat()
      val pointY = source.decodeFloat()
      val radius = source.decodeFloat()
      val recTopX = source.decodeFloat()
      val recTopY = source.decodeFloat()
      val recBottomX = source.decodeFloat()
      val recBottomY = source.decodeFloat()
      val trackingStatus = source.decodeEnumValue(1).let { value ->
        val entry = CameraTrackingStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val trackingMode = source.decodeEnumValue(1).let { value ->
        val entry = CameraTrackingMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetData = source.decodeBitmaskValue(1).let { value ->
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
