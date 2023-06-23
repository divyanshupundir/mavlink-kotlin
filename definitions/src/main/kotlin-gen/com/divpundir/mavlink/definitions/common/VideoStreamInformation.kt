package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Information about video stream. It may be requested using MAV_CMD_REQUEST_MESSAGE, where param2
 * indicates the video stream id: 0 for all streams, 1 for first, 2 for second, etc.
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
   */
  @GeneratedMavField(type = "float")
  public val framerate: Float = 0F,
  /**
   * Horizontal resolution.
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionH: UShort = 0u,
  /**
   * Vertical resolution.
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionV: UShort = 0u,
  /**
   * Bit rate.
   */
  @GeneratedMavField(type = "uint32_t")
  public val bitrate: UInt = 0u,
  /**
   * Video image rotation clockwise.
   */
  @GeneratedMavField(type = "uint16_t")
  public val rotation: UShort = 0u,
  /**
   * Horizontal Field of view.
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
) : MavMessage<VideoStreamInformation> {
  public override val instanceCompanion: MavMessage.MavCompanion<VideoStreamInformation> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(framerate)
    output.encodeUInt32(bitrate)
    output.encodeBitmaskValue(flags.value, 2)
    output.encodeUInt16(resolutionH)
    output.encodeUInt16(resolutionV)
    output.encodeUInt16(rotation)
    output.encodeUInt16(hfov)
    output.encodeUInt8(streamId)
    output.encodeUInt8(count)
    output.encodeEnumValue(type.value, 1)
    output.encodeString(name, 32)
    output.encodeString(uri, 160)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(framerate)
    output.encodeUInt32(bitrate)
    output.encodeBitmaskValue(flags.value, 2)
    output.encodeUInt16(resolutionH)
    output.encodeUInt16(resolutionV)
    output.encodeUInt16(rotation)
    output.encodeUInt16(hfov)
    output.encodeUInt8(streamId)
    output.encodeUInt8(count)
    output.encodeEnumValue(type.value, 1)
    output.encodeString(name, 32)
    output.encodeString(uri, 160)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<VideoStreamInformation> {
    private const val SIZE_V1: Int = 213

    private const val SIZE_V2: Int = 213

    public override val id: UInt = 269u

    public override val crcExtra: Byte = 109

    public override fun deserialize(source: BufferedSource): VideoStreamInformation {
      val framerate = source.decodeFloat()
      val bitrate = source.decodeUInt32()
      val flags = source.decodeBitmaskValue(2).let { value ->
        val flags = VideoStreamStatusFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val resolutionH = source.decodeUInt16()
      val resolutionV = source.decodeUInt16()
      val rotation = source.decodeUInt16()
      val hfov = source.decodeUInt16()
      val streamId = source.decodeUInt8()
      val count = source.decodeUInt8()
      val type = source.decodeEnumValue(1).let { value ->
        val entry = VideoStreamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val name = source.decodeString(32)
      val uri = source.decodeString(160)

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
