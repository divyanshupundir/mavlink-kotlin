package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Information about a captured image. This is emitted every time a message is captured.
 *         MAV_CMD_REQUEST_MESSAGE can be used to (re)request this message for a specific sequence
 * number or range of sequence numbers:
 *         MAV_CMD_REQUEST_MESSAGE.param2 indicates the sequence number the first image to send, or
 * set to -1 to send the message for all sequence numbers.
 *         MAV_CMD_REQUEST_MESSAGE.param3 is used to specify a range of messages to send:
 *         set to 0 (default) to send just the the message for the sequence number in param 2,
 *         set to -1 to send the message for the sequence number in param 2 and all the following
 * sequence numbers, 
 *         set to the sequence number of the final message in the range.
 */
@GeneratedMavMessage(
  id = 263u,
  crcExtra = -123,
)
public data class CameraImageCaptured(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Timestamp (time since UNIX epoch) in UTC. 0 for unknown.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUtc: ULong = 0uL,
  /**
   * Deprecated/unused. Component IDs are used to differentiate multiple cameras.
   */
  @GeneratedMavField(type = "uint8_t")
  public val cameraId: UByte = 0u,
  /**
   * Latitude where image was taken
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude where capture was taken
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL) where image was taken
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Zero based index of this image (i.e. a new image will have index CAMERA_CAPTURE_STATUS.image
   * count -1)
   */
  @GeneratedMavField(type = "int32_t")
  public val imageIndex: Int = 0,
  /**
   * Boolean indicating success (1) or failure (0) while capturing this image.
   */
  @GeneratedMavField(type = "int8_t")
  public val captureResult: Byte = 0,
  /**
   * URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP
   * interface.
   */
  @GeneratedMavField(type = "char[205]")
  public val fileUrl: String = "",
) : MavMessage<CameraImageCaptured> {
  public override val instanceMetadata: MavMessage.Metadata<CameraImageCaptured> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUtc)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(relativeAlt)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeInt32(imageIndex)
    outputBuffer.encodeUInt8(cameraId)
    outputBuffer.encodeInt8(captureResult)
    outputBuffer.encodeString(fileUrl, 205)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUtc)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(relativeAlt)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeInt32(imageIndex)
    outputBuffer.encodeUInt8(cameraId)
    outputBuffer.encodeInt8(captureResult)
    outputBuffer.encodeString(fileUrl, 205)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 263u

    private const val CRC_EXTRA: Byte = -123

    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    private val DESERIALIZER: MavDeserializer<CameraImageCaptured> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUtc = inputBuffer.decodeUInt64()
      val timeBootMs = inputBuffer.decodeUInt32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val relativeAlt = inputBuffer.decodeInt32()
      val q = inputBuffer.decodeFloatArray(16)
      val imageIndex = inputBuffer.decodeInt32()
      val cameraId = inputBuffer.decodeUInt8()
      val captureResult = inputBuffer.decodeInt8()
      val fileUrl = inputBuffer.decodeString(205)

      CameraImageCaptured(
        timeBootMs = timeBootMs,
        timeUtc = timeUtc,
        cameraId = cameraId,
        lat = lat,
        lon = lon,
        alt = alt,
        relativeAlt = relativeAlt,
        q = q,
        imageIndex = imageIndex,
        captureResult = captureResult,
        fileUrl = fileUrl,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraImageCaptured> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraImageCaptured> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CameraImageCaptured =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var timeUtc: ULong = 0uL

    public var cameraId: UByte = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var relativeAlt: Int = 0

    public var q: List<Float> = emptyList()

    public var imageIndex: Int = 0

    public var captureResult: Byte = 0

    public var fileUrl: String = ""

    public fun build(): CameraImageCaptured = CameraImageCaptured(
      timeBootMs = timeBootMs,
      timeUtc = timeUtc,
      cameraId = cameraId,
      lat = lat,
      lon = lon,
      alt = alt,
      relativeAlt = relativeAlt,
      q = q,
      imageIndex = imageIndex,
      captureResult = captureResult,
      fileUrl = fileUrl,
    )
  }
}
