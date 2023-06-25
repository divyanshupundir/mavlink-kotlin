package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Information about the status of a video stream. It may be requested using
 * MAV_CMD_REQUEST_MESSAGE.
 */
@GeneratedMavMessage(
  id = 270u,
  crcExtra = 59,
)
public data class VideoStreamStatus(
  /**
   * Video Stream ID (1 for first, 2 for second, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val streamId: UByte = 0u,
  /**
   * Bitmap of stream status flags
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<VideoStreamStatusFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Frame rate
   */
  @GeneratedMavField(type = "float")
  public val framerate: Float = 0F,
  /**
   * Horizontal resolution
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionH: UShort = 0u,
  /**
   * Vertical resolution
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionV: UShort = 0u,
  /**
   * Bit rate
   */
  @GeneratedMavField(type = "uint32_t")
  public val bitrate: UInt = 0u,
  /**
   * Video image rotation clockwise
   */
  @GeneratedMavField(type = "uint16_t")
  public val rotation: UShort = 0u,
  /**
   * Horizontal Field of view
   */
  @GeneratedMavField(type = "uint16_t")
  public val hfov: UShort = 0u,
) : MavMessage<VideoStreamStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<VideoStreamStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(framerate)
    buffer.encodeUInt32(bitrate)
    buffer.encodeBitmaskValue(flags.value, 2)
    buffer.encodeUInt16(resolutionH)
    buffer.encodeUInt16(resolutionV)
    buffer.encodeUInt16(rotation)
    buffer.encodeUInt16(hfov)
    buffer.encodeUInt8(streamId)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(framerate)
    buffer.encodeUInt32(bitrate)
    buffer.encodeBitmaskValue(flags.value, 2)
    buffer.encodeUInt16(resolutionH)
    buffer.encodeUInt16(resolutionV)
    buffer.encodeUInt16(rotation)
    buffer.encodeUInt16(hfov)
    buffer.encodeUInt8(streamId)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VideoStreamStatus> {
    public override val id: UInt = 270u

    public override val crcExtra: Byte = 59

    public override fun deserialize(bytes: ByteArray): VideoStreamStatus {
      val buffer = Buffer().write(bytes)

      val framerate = buffer.decodeFloat()
      val bitrate = buffer.decodeUInt32()
      val flags = buffer.decodeBitmaskValue(2).let { value ->
        val flags = VideoStreamStatusFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val resolutionH = buffer.decodeUInt16()
      val resolutionV = buffer.decodeUInt16()
      val rotation = buffer.decodeUInt16()
      val hfov = buffer.decodeUInt16()
      val streamId = buffer.decodeUInt8()

      return VideoStreamStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): VideoStreamStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var streamId: UByte = 0u

    public var flags: MavBitmaskValue<VideoStreamStatusFlags> = MavBitmaskValue.fromValue(0u)

    public var framerate: Float = 0F

    public var resolutionH: UShort = 0u

    public var resolutionV: UShort = 0u

    public var bitrate: UInt = 0u

    public var rotation: UShort = 0u

    public var hfov: UShort = 0u

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
