package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeInt8
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeInt8
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
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
 */
public data class CameraImageCaptured(
  /**
   * Timestamp (time since UNIX epoch) in UTC. 0 for unknown.
   */
  public val timeUtc: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Latitude where image was taken
   */
  public val lat: Int = 0,
  /**
   * Longitude where capture was taken
   */
  public val lon: Int = 0,
  /**
   * Altitude (MSL) where image was taken
   */
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  public val relativeAlt: Int = 0,
  /**
   * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  public val q: List<Float> = emptyList(),
  /**
   * Zero based index of this image (i.e. a new image will have index CAMERA_CAPTURE_STATUS.image
   * count -1)
   */
  public val imageIndex: Int = 0,
  /**
   * Deprecated/unused. Component IDs are used to differentiate multiple cameras.
   */
  public val cameraId: Int = 0,
  /**
   * Boolean indicating success (1) or failure (0) while capturing this image.
   */
  public val captureResult: Int = 0,
  /**
   * URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP
   * interface.
   */
  public val fileUrl: String = "",
) : MavMessage<CameraImageCaptured> {
  public override val instanceMetadata: MavMessage.Metadata<CameraImageCaptured> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(255).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUtc)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(relativeAlt)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeInt32(imageIndex)
    outputBuffer.encodeUint8(cameraId)
    outputBuffer.encodeInt8(captureResult)
    outputBuffer.encodeString(fileUrl, 205)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 263

    private const val CRC: Int = 32

    private val DESERIALIZER: MavDeserializer<CameraImageCaptured> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUtc = inputBuffer.decodeUint64()
      val timeBootMs = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val relativeAlt = inputBuffer.decodeInt32()
      val q = inputBuffer.decodeFloatArray(16)
      val imageIndex = inputBuffer.decodeInt32()
      val cameraId = inputBuffer.decodeUint8()
      val captureResult = inputBuffer.decodeInt8()
      val fileUrl = inputBuffer.decodeString(205)
      CameraImageCaptured(
        timeUtc = timeUtc,
        timeBootMs = timeBootMs,
        lat = lat,
        lon = lon,
        alt = alt,
        relativeAlt = relativeAlt,
        q = q,
        imageIndex = imageIndex,
        cameraId = cameraId,
        captureResult = captureResult,
        fileUrl = fileUrl,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraImageCaptured> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraImageCaptured> = METADATA
  }
}
