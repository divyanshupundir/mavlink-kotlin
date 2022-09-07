package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Information about the status of a video stream. It may be requested using
 * MAV_CMD_REQUEST_MESSAGE.
 */
@GeneratedMavMessage(
  id = 270,
  crc = 59,
)
public data class VideoStreamStatus(
  /**
   * Video Stream ID (1 for first, 2 for second, etc.)
   */
  public val streamId: Int = 0,
  /**
   * Bitmap of stream status flags
   */
  public val flags: MavEnumValue<VideoStreamStatusFlags> = MavEnumValue.fromValue(0),
  /**
   * Frame rate
   */
  public val framerate: Float = 0F,
  /**
   * Horizontal resolution
   */
  public val resolutionH: Int = 0,
  /**
   * Vertical resolution
   */
  public val resolutionV: Int = 0,
  /**
   * Bit rate
   */
  public val bitrate: Long = 0L,
  /**
   * Video image rotation clockwise
   */
  public val rotation: Int = 0,
  /**
   * Horizontal Field of view
   */
  public val hfov: Int = 0,
) : MavMessage<VideoStreamStatus> {
  public override val instanceMetadata: MavMessage.Metadata<VideoStreamStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(framerate)
    outputBuffer.encodeUint32(bitrate)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeUint16(resolutionH)
    outputBuffer.encodeUint16(resolutionV)
    outputBuffer.encodeUint16(rotation)
    outputBuffer.encodeUint16(hfov)
    outputBuffer.encodeUint8(streamId)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 270

    private const val CRC: Int = 59

    private const val SIZE: Int = 19

    private val DESERIALIZER: MavDeserializer<VideoStreamStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val framerate = inputBuffer.decodeFloat()
      val bitrate = inputBuffer.decodeUint32()
      val flags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = VideoStreamStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val resolutionH = inputBuffer.decodeUint16()
      val resolutionV = inputBuffer.decodeUint16()
      val rotation = inputBuffer.decodeUint16()
      val hfov = inputBuffer.decodeUint16()
      val streamId = inputBuffer.decodeUint8()

      VideoStreamStatus(
        streamId = streamId,
        flags = flags,
        framerate = framerate,
        resolutionH = resolutionH,
        resolutionV = resolutionV,
        bitrate = bitrate,
        rotation = rotation,
        hfov = hfov,
      )
    }


    private val METADATA: MavMessage.Metadata<VideoStreamStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VideoStreamStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var streamId: Int = 0

    public var flags: MavEnumValue<VideoStreamStatusFlags> = MavEnumValue.fromValue(0)

    public var framerate: Float = 0F

    public var resolutionH: Int = 0

    public var resolutionV: Int = 0

    public var bitrate: Long = 0L

    public var rotation: Int = 0

    public var hfov: Int = 0

    public fun build(): VideoStreamStatus = VideoStreamStatus(
      streamId = streamId,
      flags = flags,
      framerate = framerate,
      resolutionH = resolutionH,
      resolutionV = resolutionV,
      bitrate = bitrate,
      rotation = rotation,
      hfov = hfov,
    )
  }
}
