package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<CameraCaptureStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(imageInterval)
    outputBuffer.encodeUInt32(recordingTimeMs)
    outputBuffer.encodeFloat(availableCapacity)
    outputBuffer.encodeUInt8(imageStatus)
    outputBuffer.encodeUInt8(videoStatus)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(imageInterval)
    outputBuffer.encodeUInt32(recordingTimeMs)
    outputBuffer.encodeFloat(availableCapacity)
    outputBuffer.encodeUInt8(imageStatus)
    outputBuffer.encodeUInt8(videoStatus)
    outputBuffer.encodeInt32(imageCount)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 262u

    private const val CRC_EXTRA: Byte = 12

    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 22

    private val DESERIALIZER: MavDeserializer<CameraCaptureStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val imageInterval = inputBuffer.decodeFloat()
      val recordingTimeMs = inputBuffer.decodeUInt32()
      val availableCapacity = inputBuffer.decodeFloat()
      val imageStatus = inputBuffer.decodeUInt8()
      val videoStatus = inputBuffer.decodeUInt8()
      val imageCount = inputBuffer.decodeInt32()

      CameraCaptureStatus(
        timeBootMs = timeBootMs,
        imageStatus = imageStatus,
        videoStatus = videoStatus,
        imageInterval = imageInterval,
        recordingTimeMs = recordingTimeMs,
        availableCapacity = availableCapacity,
        imageCount = imageCount,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraCaptureStatus> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraCaptureStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CameraCaptureStatus =
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
