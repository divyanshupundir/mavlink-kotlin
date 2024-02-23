package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
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
 * Information about the status of a capture. Can be requested with a MAV_CMD_REQUEST_MESSAGE
 * command.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param imageStatus Current status of image capturing (0: idle, 1: capture in progress, 2:
 * interval set but idle, 3: interval set and capture in progress)
 * @param videoStatus Current status of video capturing (0: idle, 1: capture in progress)
 * @param imageInterval Image capture interval
 * units = s
 * @param recordingTimeMs Elapsed time since recording started (0: Not supported/available). A GCS
 * should compute recording time and use non-zero values of this field to correct any discrepancy.
 * units = ms
 * @param availableCapacity Available storage capacity.
 * units = MiB
 * @param imageCount Total number of images captured ('forever', or until reset using
 * MAV_CMD_STORAGE_FORMAT).
 */
@GeneratedMavMessage(
  id = 262u,
  crcExtra = 12,
)
public data class CameraCaptureStatus(
  /**
   * Timestamp (time since system boot).
   * units = ms
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
   * units = s
   */
  @GeneratedMavField(type = "float")
  public val imageInterval: Float = 0F,
  /**
   * Elapsed time since recording started (0: Not supported/available). A GCS should compute
   * recording time and use non-zero values of this field to correct any discrepancy.
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val recordingTimeMs: UInt = 0u,
  /**
   * Available storage capacity.
   * units = MiB
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
  override val instanceCompanion: MavMessage.MavCompanion<CameraCaptureStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(imageInterval)
    encoder.encodeUInt32(recordingTimeMs)
    encoder.encodeFloat(availableCapacity)
    encoder.encodeUInt8(imageStatus)
    encoder.encodeUInt8(videoStatus)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(imageInterval)
    encoder.encodeUInt32(recordingTimeMs)
    encoder.encodeFloat(availableCapacity)
    encoder.encodeUInt8(imageStatus)
    encoder.encodeUInt8(videoStatus)
    encoder.encodeInt32(imageCount)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraCaptureStatus> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 22

    override val id: UInt = 262u

    override val crcExtra: Byte = 12

    override fun deserialize(bytes: ByteArray): CameraCaptureStatus {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val imageInterval = decoder.safeDecodeFloat()
      val recordingTimeMs = decoder.safeDecodeUInt32()
      val availableCapacity = decoder.safeDecodeFloat()
      val imageStatus = decoder.safeDecodeUInt8()
      val videoStatus = decoder.safeDecodeUInt8()
      val imageCount = decoder.safeDecodeInt32()

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
