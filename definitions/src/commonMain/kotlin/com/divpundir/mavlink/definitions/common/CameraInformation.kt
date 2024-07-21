package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
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
import kotlin.collections.List

/**
 * Information about a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param vendorName Name of the camera vendor
 * @param modelName Name of the camera model
 * @param firmwareVersion Version of the camera firmware, encoded as: (Dev & 0xff) << 24 | (Patch &
 * 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff). Use 0 if not known.
 * @param focalLength Focal length. Use NaN if not known.
 * units = mm
 * @param sensorSizeH Image sensor size horizontal. Use NaN if not known.
 * units = mm
 * @param sensorSizeV Image sensor size vertical. Use NaN if not known.
 * units = mm
 * @param resolutionH Horizontal image resolution. Use 0 if not known.
 * units = pix
 * @param resolutionV Vertical image resolution. Use 0 if not known.
 * units = pix
 * @param lensId Reserved for a lens ID.  Use 0 if not known.
 * @param flags Bitmap of camera capability flags.
 * @param camDefinitionVersion Camera definition version (iteration).  Use 0 if not known.
 * @param camDefinitionUri Camera definition URI (if any, otherwise only basic functions will be
 * available). HTTP- (http://) and MAVLink FTP- (mavlinkftp://) formatted URIs are allowed (and both
 * must be supported by any GCS that implements the Camera Protocol). The definition file may be xz
 * compressed, which will be indicated by the file extension .xml.xz (a GCS that implements the
 * protocol must support decompressing the file). The string needs to be zero terminated.  Use a
 * zero-length string if not known.
 * @param gimbalDeviceId Gimbal id of a gimbal associated with this camera. This is the component id
 * of the gimbal device, or 1-6 for non mavlink gimbals. Use 0 if no gimbal is associated with the
 * camera.
 * @param cameraDeviceId Camera id of a camera associated with this component. This is the component
 * id of a proxied MAVLink camera, or 1-6 for a non-MAVLink camera attached to the component. Use 0 if
 * the component is a camera (not something else providing access to a camera).
 */
@GeneratedMavMessage(
  id = 259u,
  crcExtra = 92,
)
public data class CameraInformation(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Name of the camera vendor
   */
  @GeneratedMavField(type = "uint8_t[32]")
  public val vendorName: List<UByte> = emptyList(),
  /**
   * Name of the camera model
   */
  @GeneratedMavField(type = "uint8_t[32]")
  public val modelName: List<UByte> = emptyList(),
  /**
   * Version of the camera firmware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor
   * & 0xff) << 8 | (Major & 0xff). Use 0 if not known.
   */
  @GeneratedMavField(type = "uint32_t")
  public val firmwareVersion: UInt = 0u,
  /**
   * Focal length. Use NaN if not known.
   * units = mm
   */
  @GeneratedMavField(type = "float")
  public val focalLength: Float = 0F,
  /**
   * Image sensor size horizontal. Use NaN if not known.
   * units = mm
   */
  @GeneratedMavField(type = "float")
  public val sensorSizeH: Float = 0F,
  /**
   * Image sensor size vertical. Use NaN if not known.
   * units = mm
   */
  @GeneratedMavField(type = "float")
  public val sensorSizeV: Float = 0F,
  /**
   * Horizontal image resolution. Use 0 if not known.
   * units = pix
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionH: UShort = 0u,
  /**
   * Vertical image resolution. Use 0 if not known.
   * units = pix
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionV: UShort = 0u,
  /**
   * Reserved for a lens ID.  Use 0 if not known.
   */
  @GeneratedMavField(type = "uint8_t")
  public val lensId: UByte = 0u,
  /**
   * Bitmap of camera capability flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavBitmaskValue<CameraCapFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Camera definition version (iteration).  Use 0 if not known.
   */
  @GeneratedMavField(type = "uint16_t")
  public val camDefinitionVersion: UShort = 0u,
  /**
   * Camera definition URI (if any, otherwise only basic functions will be available). HTTP-
   * (http://) and MAVLink FTP- (mavlinkftp://) formatted URIs are allowed (and both must be supported
   * by any GCS that implements the Camera Protocol). The definition file may be xz compressed, which
   * will be indicated by the file extension .xml.xz (a GCS that implements the protocol must support
   * decompressing the file). The string needs to be zero terminated.  Use a zero-length string if not
   * known.
   */
  @GeneratedMavField(type = "char[140]")
  public val camDefinitionUri: String = "",
  /**
   * Gimbal id of a gimbal associated with this camera. This is the component id of the gimbal
   * device, or 1-6 for non mavlink gimbals. Use 0 if no gimbal is associated with the camera.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val gimbalDeviceId: UByte = 0u,
  /**
   * Camera id of a camera associated with this component. This is the component id of a proxied
   * MAVLink camera, or 1-6 for a non-MAVLink camera attached to the component. Use 0 if the component
   * is a camera (not something else providing access to a camera).
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val cameraDeviceId: UByte = 0u,
) : MavMessage<CameraInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<CameraInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(firmwareVersion)
    encoder.encodeFloat(focalLength)
    encoder.encodeFloat(sensorSizeH)
    encoder.encodeFloat(sensorSizeV)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeUInt16(resolutionH)
    encoder.encodeUInt16(resolutionV)
    encoder.encodeUInt16(camDefinitionVersion)
    encoder.encodeUInt8Array(vendorName, 32)
    encoder.encodeUInt8Array(modelName, 32)
    encoder.encodeUInt8(lensId)
    encoder.encodeString(camDefinitionUri, 140)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(firmwareVersion)
    encoder.encodeFloat(focalLength)
    encoder.encodeFloat(sensorSizeH)
    encoder.encodeFloat(sensorSizeV)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeUInt16(resolutionH)
    encoder.encodeUInt16(resolutionV)
    encoder.encodeUInt16(camDefinitionVersion)
    encoder.encodeUInt8Array(vendorName, 32)
    encoder.encodeUInt8Array(modelName, 32)
    encoder.encodeUInt8(lensId)
    encoder.encodeString(camDefinitionUri, 140)
    encoder.encodeUInt8(gimbalDeviceId)
    encoder.encodeUInt8(cameraDeviceId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraInformation> {
    private const val SIZE_V1: Int = 235

    private const val SIZE_V2: Int = 237

    override val id: UInt = 259u

    override val crcExtra: Byte = 92

    override fun deserialize(bytes: ByteArray): CameraInformation {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val firmwareVersion = decoder.safeDecodeUInt32()
      val focalLength = decoder.safeDecodeFloat()
      val sensorSizeH = decoder.safeDecodeFloat()
      val sensorSizeV = decoder.safeDecodeFloat()
      val flags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = CameraCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val resolutionH = decoder.safeDecodeUInt16()
      val resolutionV = decoder.safeDecodeUInt16()
      val camDefinitionVersion = decoder.safeDecodeUInt16()
      val vendorName = decoder.safeDecodeUInt8Array(32)
      val modelName = decoder.safeDecodeUInt8Array(32)
      val lensId = decoder.safeDecodeUInt8()
      val camDefinitionUri = decoder.safeDecodeString(140)
      val gimbalDeviceId = decoder.safeDecodeUInt8()
      val cameraDeviceId = decoder.safeDecodeUInt8()

      return CameraInformation(
        timeBootMs = timeBootMs,
        vendorName = vendorName,
        modelName = modelName,
        firmwareVersion = firmwareVersion,
        focalLength = focalLength,
        sensorSizeH = sensorSizeH,
        sensorSizeV = sensorSizeV,
        resolutionH = resolutionH,
        resolutionV = resolutionV,
        lensId = lensId,
        flags = flags,
        camDefinitionVersion = camDefinitionVersion,
        camDefinitionUri = camDefinitionUri,
        gimbalDeviceId = gimbalDeviceId,
        cameraDeviceId = cameraDeviceId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var vendorName: List<UByte> = emptyList()

    public var modelName: List<UByte> = emptyList()

    public var firmwareVersion: UInt = 0u

    public var focalLength: Float = 0F

    public var sensorSizeH: Float = 0F

    public var sensorSizeV: Float = 0F

    public var resolutionH: UShort = 0u

    public var resolutionV: UShort = 0u

    public var lensId: UByte = 0u

    public var flags: MavBitmaskValue<CameraCapFlags> = MavBitmaskValue.fromValue(0u)

    public var camDefinitionVersion: UShort = 0u

    public var camDefinitionUri: String = ""

    public var gimbalDeviceId: UByte = 0u

    public var cameraDeviceId: UByte = 0u

    public fun build(): CameraInformation = CameraInformation(
      timeBootMs = timeBootMs,
      vendorName = vendorName,
      modelName = modelName,
      firmwareVersion = firmwareVersion,
      focalLength = focalLength,
      sensorSizeH = sensorSizeH,
      sensorSizeV = sensorSizeV,
      resolutionH = resolutionH,
      resolutionV = resolutionV,
      lensId = lensId,
      flags = flags,
      camDefinitionVersion = camDefinitionVersion,
      camDefinitionUri = camDefinitionUri,
      gimbalDeviceId = gimbalDeviceId,
      cameraDeviceId = cameraDeviceId,
    )
  }
}
