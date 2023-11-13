package com.divpundir.mavlink.definitions.cubepilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
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
 * Information about video stream
 */
@GeneratedMavMessage(
  id = 50_002u,
  crcExtra = -75,
)
public data class HerelinkVideoStreamInformation(
  /**
   * Video Stream ID (1 for first, 2 for second, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val cameraId: UByte = 0u,
  /**
   * Number of streams available.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: UByte = 0u,
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
   * Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port
   * ground station should listen to).
   */
  @GeneratedMavField(type = "char[230]")
  public val uri: String = "",
) : MavMessage<HerelinkVideoStreamInformation> {
  public override val instanceCompanion: MavMessage.MavCompanion<HerelinkVideoStreamInformation> =
      Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(framerate)
    encoder.encodeUInt32(bitrate)
    encoder.encodeUInt16(resolutionH)
    encoder.encodeUInt16(resolutionV)
    encoder.encodeUInt16(rotation)
    encoder.encodeUInt8(cameraId)
    encoder.encodeUInt8(status)
    encoder.encodeString(uri, 230)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(framerate)
    encoder.encodeUInt32(bitrate)
    encoder.encodeUInt16(resolutionH)
    encoder.encodeUInt16(resolutionV)
    encoder.encodeUInt16(rotation)
    encoder.encodeUInt8(cameraId)
    encoder.encodeUInt8(status)
    encoder.encodeString(uri, 230)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HerelinkVideoStreamInformation> {
    private const val SIZE_V1: Int = 246

    private const val SIZE_V2: Int = 246

    public override val id: UInt = 50_002u

    public override val crcExtra: Byte = -75

    public override fun deserialize(bytes: ByteArray): HerelinkVideoStreamInformation {
      val decoder = MavDataDecoder(bytes)

      val framerate = decoder.safeDecodeFloat()
      val bitrate = decoder.safeDecodeUInt32()
      val resolutionH = decoder.safeDecodeUInt16()
      val resolutionV = decoder.safeDecodeUInt16()
      val rotation = decoder.safeDecodeUInt16()
      val cameraId = decoder.safeDecodeUInt8()
      val status = decoder.safeDecodeUInt8()
      val uri = decoder.safeDecodeString(230)

      return HerelinkVideoStreamInformation(
        cameraId = cameraId,
        status = status,
        framerate = framerate,
        resolutionH = resolutionH,
        resolutionV = resolutionV,
        bitrate = bitrate,
        rotation = rotation,
        uri = uri,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HerelinkVideoStreamInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var cameraId: UByte = 0u

    public var status: UByte = 0u

    public var framerate: Float = 0F

    public var resolutionH: UShort = 0u

    public var resolutionV: UShort = 0u

    public var bitrate: UInt = 0u

    public var rotation: UShort = 0u

    public var uri: String = ""

    public fun build(): HerelinkVideoStreamInformation = HerelinkVideoStreamInformation(
      cameraId = cameraId,
      status = status,
      framerate = framerate,
      resolutionH = resolutionH,
      resolutionV = resolutionV,
      bitrate = bitrate,
      rotation = rotation,
      uri = uri,
    )
  }
}
