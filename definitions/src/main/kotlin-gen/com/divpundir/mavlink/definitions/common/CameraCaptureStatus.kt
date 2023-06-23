package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Information about the status of a capture. Can be requested with a MAV_CMD_REQUEST_MESSAGE
 * command.
 */
@GeneratedMavMessage(
  id = 262u,
  crcExtra = 12,
)
public data class CameraCaptureStatus(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle,
   * 3: interval set and capture in progress)
   */
  @GeneratedMavField(type = "uint8_t")
  public val imageStatus: UByte = 0u,
  /**
   * Current status of video capturing (0: idle, 1: capture in progress)
   */
  @GeneratedMavField(type = "uint8_t")
  public val videoStatus: UByte = 0u,
  /**
   * Image capture interval
   */
  @GeneratedMavField(type = "float")
  public val imageInterval: Float = 0F,
  /**
   * Elapsed time since recording started (0: Not supported/available). A GCS should compute
   * recording time and use non-zero values of this field to correct any discrepancy.
   */
  @GeneratedMavField(type = "uint32_t")
  public val recordingTimeMs: UInt = 0u,
  /**
   * Available storage capacity.
   */
  @GeneratedMavField(type = "float")
  public val availableCapacity: Float = 0F,
  /**
   * Total number of images captured ('forever', or until reset using MAV_CMD_STORAGE_FORMAT).
   */
  @GeneratedMavField(
    type = "int32_t",
    extension = true,
  )
  public val imageCount: Int = 0,
) : MavMessage<CameraCaptureStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<CameraCaptureStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeFloat(imageInterval)
    output.encodeUInt32(recordingTimeMs)
    output.encodeFloat(availableCapacity)
    output.encodeUInt8(imageStatus)
    output.encodeUInt8(videoStatus)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeFloat(imageInterval)
    output.encodeUInt32(recordingTimeMs)
    output.encodeFloat(availableCapacity)
    output.encodeUInt8(imageStatus)
    output.encodeUInt8(videoStatus)
    output.encodeInt32(imageCount)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CameraCaptureStatus> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 22

    public override val id: UInt = 262u

    public override val crcExtra: Byte = 12

    public override fun deserialize(source: BufferedSource): CameraCaptureStatus {
      val timeBootMs = source.decodeUInt32()
      val imageInterval = source.decodeFloat()
      val recordingTimeMs = source.decodeUInt32()
      val availableCapacity = source.decodeFloat()
      val imageStatus = source.decodeUInt8()
      val videoStatus = source.decodeUInt8()
      val imageCount = source.decodeInt32()

      return CameraCaptureStatus(
        timeBootMs = timeBootMs,
        imageStatus = imageStatus,
        videoStatus = videoStatus,
        imageInterval = imageInterval,
        recordingTimeMs = recordingTimeMs,
        availableCapacity = availableCapacity,
        imageCount = imageCount,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraCaptureStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var imageStatus: UByte = 0u

    public var videoStatus: UByte = 0u

    public var imageInterval: Float = 0F

    public var recordingTimeMs: UInt = 0u

    public var availableCapacity: Float = 0F

    public var imageCount: Int = 0

    public fun build(): CameraCaptureStatus = CameraCaptureStatus(
      timeBootMs = timeBootMs,
      imageStatus = imageStatus,
      videoStatus = videoStatus,
      imageInterval = imageInterval,
      recordingTimeMs = recordingTimeMs,
      availableCapacity = availableCapacity,
      imageCount = imageCount,
    )
  }
}
