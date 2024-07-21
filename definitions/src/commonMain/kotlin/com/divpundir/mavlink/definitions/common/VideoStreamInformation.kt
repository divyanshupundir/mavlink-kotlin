package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Information about video stream. It may be requested using MAV_CMD_REQUEST_MESSAGE, where param2
 * indicates the video stream id: 0 for all streams, 1 for first, 2 for second, etc.
 *
 * @param streamId Video Stream ID (1 for first, 2 for second, etc.)
 * @param count Number of streams available.
 * @param type Type of stream.
 * @param flags Bitmap of stream status flags.
 * @param framerate Frame rate.
 * units = Hz
 * @param resolutionH Horizontal resolution.
 * units = pix
 * @param resolutionV Vertical resolution.
 * units = pix
 * @param bitrate Bit rate.
 * units = bits/s
 * @param rotation Video image rotation clockwise.
 * units = deg
 * @param hfov Horizontal Field of view.
 * units = deg
 * @param name Stream name.
 * @param uri Video stream URI (TCP or RTSP URI ground station should connect to) or port number
 * (UDP port ground station should listen to).
 * @param encoding Encoding of stream.
 */
@GeneratedMavMessage(
  id = 269u,
  crcExtra = 109,
)
public data class VideoStreamInformation(
  /**
   * Video Stream ID (1 for first, 2 for second, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val streamId: UByte = 0u,
  /**
   * Number of streams available.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Type of stream.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<VideoStreamType> = MavEnumValue.fromValue(0u),
  /**
   * Bitmap of stream status flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<VideoStreamStatusFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Frame rate.
   * units = Hz
   */
  @GeneratedMavField(type = "float")
  public val framerate: Float = 0F,
  /**
   * Horizontal resolution.
   * units = pix
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionH: UShort = 0u,
  /**
   * Vertical resolution.
   * units = pix
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionV: UShort = 0u,
  /**
   * Bit rate.
   * units = bits/s
   */
  @GeneratedMavField(type = "uint32_t")
  public val bitrate: UInt = 0u,
  /**
   * Video image rotation clockwise.
   * units = deg
   */
  @GeneratedMavField(type = "uint16_t")
  public val rotation: UShort = 0u,
  /**
   * Horizontal Field of view.
   * units = deg
   */
  @GeneratedMavField(type = "uint16_t")
  public val hfov: UShort = 0u,
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
  /**
   * Encoding of stream.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val encoding: MavEnumValue<VideoStreamEncoding> = MavEnumValue.fromValue(0u),
) : MavMessage<VideoStreamInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<VideoStreamInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(framerate)
    encoder.encodeUInt32(bitrate)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt16(resolutionH)
    encoder.encodeUInt16(resolutionV)
    encoder.encodeUInt16(rotation)
    encoder.encodeUInt16(hfov)
    encoder.encodeUInt8(streamId)
    encoder.encodeUInt8(count)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeString(name, 32)
    encoder.encodeString(uri, 160)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(framerate)
    encoder.encodeUInt32(bitrate)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt16(resolutionH)
    encoder.encodeUInt16(resolutionV)
    encoder.encodeUInt16(rotation)
    encoder.encodeUInt16(hfov)
    encoder.encodeUInt8(streamId)
    encoder.encodeUInt8(count)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeString(name, 32)
    encoder.encodeString(uri, 160)
    encoder.encodeEnumValue(encoding.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VideoStreamInformation> {
    private const val SIZE_V1: Int = 213

    private const val SIZE_V2: Int = 214

    override val id: UInt = 269u

    override val crcExtra: Byte = 109

    override fun deserialize(bytes: ByteArray): VideoStreamInformation {
      val decoder = MavDataDecoder(bytes)

      val framerate = decoder.safeDecodeFloat()
      val bitrate = decoder.safeDecodeUInt32()
      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = VideoStreamStatusFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val resolutionH = decoder.safeDecodeUInt16()
      val resolutionV = decoder.safeDecodeUInt16()
      val rotation = decoder.safeDecodeUInt16()
      val hfov = decoder.safeDecodeUInt16()
      val streamId = decoder.safeDecodeUInt8()
      val count = decoder.safeDecodeUInt8()
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = VideoStreamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val name = decoder.safeDecodeString(32)
      val uri = decoder.safeDecodeString(160)
      val encoding = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = VideoStreamEncoding.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return VideoStreamInformation(
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
        encoding = encoding,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): VideoStreamInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var streamId: UByte = 0u

    public var count: UByte = 0u

    public var type: MavEnumValue<VideoStreamType> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<VideoStreamStatusFlags> = MavBitmaskValue.fromValue(0u)

    public var framerate: Float = 0F

    public var resolutionH: UShort = 0u

    public var resolutionV: UShort = 0u

    public var bitrate: UInt = 0u

    public var rotation: UShort = 0u

    public var hfov: UShort = 0u

    public var name: String = ""

    public var uri: String = ""

    public var encoding: MavEnumValue<VideoStreamEncoding> = MavEnumValue.fromValue(0u)

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
      encoding = encoding,
    )
  }
}
