package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param timeUtc Timestamp (time since UNIX epoch) in UTC. 0 for unknown.
 * units = us
 * @param cameraId Deprecated/unused. Component IDs are used to differentiate multiple cameras.
 * @param lat Latitude where image was taken
 * units = degE7
 * @param lon Longitude where capture was taken
 * units = degE7
 * @param alt Altitude (MSL) where image was taken
 * units = mm
 * @param relativeAlt Altitude above ground
 * units = mm
 * @param q Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
 * @param imageIndex Zero based index of this image (i.e. a new image will have index
 * CAMERA_CAPTURE_STATUS.image count -1)
 * @param captureResult Boolean indicating success (1) or failure (0) while capturing this image.
 * @param fileUrl URL of image taken. Either local storage or http://foo.jpg if camera provides an
 * HTTP interface.
 */
@GeneratedMavMessage(
  id = 263u,
  crcExtra = -123,
)
public data class CameraImageCaptured(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Timestamp (time since UNIX epoch) in UTC. 0 for unknown.
   * units = us
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
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude where capture was taken
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL) where image was taken
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   * units = mm
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
  override val instanceCompanion: MavMessage.MavCompanion<CameraImageCaptured> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUtc)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt32(relativeAlt)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeInt32(imageIndex)
    encoder.encodeUInt8(cameraId)
    encoder.encodeInt8(captureResult)
    encoder.encodeString(fileUrl, 205)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUtc)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt32(relativeAlt)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeInt32(imageIndex)
    encoder.encodeUInt8(cameraId)
    encoder.encodeInt8(captureResult)
    encoder.encodeString(fileUrl, 205)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraImageCaptured> {
    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    override val id: UInt = 263u

    override val crcExtra: Byte = -123

    override fun deserialize(bytes: ByteArray): CameraImageCaptured {
      val decoder = MavDataDecoder(bytes)

      val timeUtc = decoder.safeDecodeUInt64()
      val timeBootMs = decoder.safeDecodeUInt32()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt32()
      val relativeAlt = decoder.safeDecodeInt32()
      val q = decoder.safeDecodeFloatArray(16)
      val imageIndex = decoder.safeDecodeInt32()
      val cameraId = decoder.safeDecodeUInt8()
      val captureResult = decoder.safeDecodeInt8()
      val fileUrl = decoder.safeDecodeString(205)

      return CameraImageCaptured(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraImageCaptured =
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
