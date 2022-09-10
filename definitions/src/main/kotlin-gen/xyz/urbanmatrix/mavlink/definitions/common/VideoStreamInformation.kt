package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Information about video stream. It may be requested using MAV_CMD_REQUEST_MESSAGE, where param2
 * indicates the video stream id: 0 for all streams, 1 for first, 2 for second, etc.
 */
@GeneratedMavMessage(
  id = 269,
  crc = 109,
)
public data class VideoStreamInformation(
  /**
   * Video Stream ID (1 for first, 2 for second, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val streamId: Int = 0,
  /**
   * Number of streams available.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: Int = 0,
  /**
   * Type of stream.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<VideoStreamType> = MavEnumValue.fromValue(0),
  /**
   * Bitmap of stream status flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavEnumValue<VideoStreamStatusFlags> = MavEnumValue.fromValue(0),
  /**
   * Frame rate.
   */
  @GeneratedMavField(type = "float")
  public val framerate: Float = 0F,
  /**
   * Horizontal resolution.
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionH: Int = 0,
  /**
   * Vertical resolution.
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionV: Int = 0,
  /**
   * Bit rate.
   */
  @GeneratedMavField(type = "uint32_t")
  public val bitrate: Long = 0L,
  /**
   * Video image rotation clockwise.
   */
  @GeneratedMavField(type = "uint16_t")
  public val rotation: Int = 0,
  /**
   * Horizontal Field of view.
   */
  @GeneratedMavField(type = "uint16_t")
  public val hfov: Int = 0,
  /**
   * Stream name.
   */
  @GeneratedMavField(type = "char[32]")
  public val name: String = "",
  /**
   * Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port
   * ground station should listen to).
   */
  @GeneratedMavField(type = "char[160]")
  public val uri: String = "",
) : MavMessage<VideoStreamInformation> {
  public override val instanceMetadata: MavMessage.Metadata<VideoStreamInformation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(framerate)
    outputBuffer.encodeUint32(bitrate)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeUint16(resolutionH)
    outputBuffer.encodeUint16(resolutionV)
    outputBuffer.encodeUint16(rotation)
    outputBuffer.encodeUint16(hfov)
    outputBuffer.encodeUint8(streamId)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeString(name, 32)
    outputBuffer.encodeString(uri, 160)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(framerate)
    outputBuffer.encodeUint32(bitrate)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeUint16(resolutionH)
    outputBuffer.encodeUint16(resolutionV)
    outputBuffer.encodeUint16(rotation)
    outputBuffer.encodeUint16(hfov)
    outputBuffer.encodeUint8(streamId)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeString(name, 32)
    outputBuffer.encodeString(uri, 160)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 269

    private const val CRC: Int = 109

    private const val SIZE: Int = 213

    private val DESERIALIZER: MavDeserializer<VideoStreamInformation> = MavDeserializer { bytes ->
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
      val count = inputBuffer.decodeUint8()
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = VideoStreamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val name = inputBuffer.decodeString(32)
      val uri = inputBuffer.decodeString(160)

      VideoStreamInformation(
        streamId = streamId,
        count = count,
        type = type,
        flags = flags,
        framerate = framerate,
        resolutionH = resolutionH,
        resolutionV = resolutionV,
        bitrate = bitrate,
        rotation = rotation,
        hfov = hfov,
        name = name,
        uri = uri,
      )
    }


    private val METADATA: MavMessage.Metadata<VideoStreamInformation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VideoStreamInformation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var streamId: Int = 0

    public var count: Int = 0

    public var type: MavEnumValue<VideoStreamType> = MavEnumValue.fromValue(0)

    public var flags: MavEnumValue<VideoStreamStatusFlags> = MavEnumValue.fromValue(0)

    public var framerate: Float = 0F

    public var resolutionH: Int = 0

    public var resolutionV: Int = 0

    public var bitrate: Long = 0L

    public var rotation: Int = 0

    public var hfov: Int = 0

    public var name: String = ""

    public var uri: String = ""

    public fun build(): VideoStreamInformation = VideoStreamInformation(
      streamId = streamId,
      count = count,
      type = type,
      flags = flags,
      framerate = framerate,
      resolutionH = resolutionH,
      resolutionV = resolutionV,
      bitrate = bitrate,
      rotation = rotation,
      hfov = hfov,
      name = name,
      uri = uri,
    )
  }
}
