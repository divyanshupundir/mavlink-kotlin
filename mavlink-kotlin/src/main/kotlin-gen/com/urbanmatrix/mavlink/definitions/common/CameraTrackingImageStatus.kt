package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define
 * message interval.
 */
public data class CameraTrackingImageStatus(
  /**
   * Current tracking status
   */
  public val trackingStatus: MavEnumValue<CameraTrackingStatusFlags> = MavEnumValue.fromValue(0),
  /**
   * Current tracking mode
   */
  public val trackingMode: MavEnumValue<CameraTrackingMode> = MavEnumValue.fromValue(0),
  /**
   * Defines location of target data
   */
  public val targetData: MavEnumValue<CameraTrackingTargetData> = MavEnumValue.fromValue(0),
  /**
   * Current tracked point x value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is left, 1 is
   * right), NAN if unknown
   */
  public val pointX: Float = 0F,
  /**
   * Current tracked point y value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is top, 1 is
   * bottom), NAN if unknown
   */
  public val pointY: Float = 0F,
  /**
   * Current tracked radius if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is image left, 1 is
   * image right), NAN if unknown
   */
  public val radius: Float = 0F,
  /**
   * Current tracked rectangle top x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is
   * left, 1 is right), NAN if unknown
   */
  public val recTopX: Float = 0F,
  /**
   * Current tracked rectangle top y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is
   * top, 1 is bottom), NAN if unknown
   */
  public val recTopY: Float = 0F,
  /**
   * Current tracked rectangle bottom x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0
   * is left, 1 is right), NAN if unknown
   */
  public val recBottomX: Float = 0F,
  /**
   * Current tracked rectangle bottom y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0
   * is top, 1 is bottom), NAN if unknown
   */
  public val recBottomY: Float = 0F,
) : MavMessage<CameraTrackingImageStatus> {
  public override val instanceMetadata: MavMessage.Metadata<CameraTrackingImageStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(pointX)
    outputBuffer.encodeFloat(pointY)
    outputBuffer.encodeFloat(radius)
    outputBuffer.encodeFloat(recTopX)
    outputBuffer.encodeFloat(recTopY)
    outputBuffer.encodeFloat(recBottomX)
    outputBuffer.encodeFloat(recBottomY)
    outputBuffer.encodeEnumValue(trackingStatus.value, 1)
    outputBuffer.encodeEnumValue(trackingMode.value, 1)
    outputBuffer.encodeEnumValue(targetData.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 275

    private const val CRC: Int = 126

    private const val SIZE: Int = 31

    private val DESERIALIZER: MavDeserializer<CameraTrackingImageStatus> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val pointX = inputBuffer.decodeFloat()
      val pointY = inputBuffer.decodeFloat()
      val radius = inputBuffer.decodeFloat()
      val recTopX = inputBuffer.decodeFloat()
      val recTopY = inputBuffer.decodeFloat()
      val recBottomX = inputBuffer.decodeFloat()
      val recBottomY = inputBuffer.decodeFloat()
      val trackingStatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraTrackingStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val trackingMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraTrackingMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetData = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraTrackingTargetData.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      CameraTrackingImageStatus(
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


    private val METADATA: MavMessage.Metadata<CameraTrackingImageStatus> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraTrackingImageStatus> = METADATA
  }
}
