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
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Information about a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command.
 */
@GeneratedMavMessage(
  id = 259u,
  crcExtra = 92,
)
public data class CameraInformation(
  /**
   * Timestamp (time since system boot).
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
   * & 0xff) << 8 | (Major & 0xff)
   */
  @GeneratedMavField(type = "uint32_t")
  public val firmwareVersion: UInt = 0u,
  /**
   * Focal length
   */
  @GeneratedMavField(type = "float")
  public val focalLength: Float = 0F,
  /**
   * Image sensor size horizontal
   */
  @GeneratedMavField(type = "float")
  public val sensorSizeH: Float = 0F,
  /**
   * Image sensor size vertical
   */
  @GeneratedMavField(type = "float")
  public val sensorSizeV: Float = 0F,
  /**
   * Horizontal image resolution
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionH: UShort = 0u,
  /**
   * Vertical image resolution
   */
  @GeneratedMavField(type = "uint16_t")
  public val resolutionV: UShort = 0u,
  /**
   * Reserved for a lens ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val lensId: UByte = 0u,
  /**
   * Bitmap of camera capability flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavBitmaskValue<CameraCapFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Camera definition version (iteration)
   */
  @GeneratedMavField(type = "uint16_t")
  public val camDefinitionVersion: UShort = 0u,
  /**
   * Camera definition URI (if any, otherwise only basic functions will be available). HTTP-
   * (http://) and MAVLink FTP- (mavlinkftp://) formatted URIs are allowed (and both must be supported
   * by any GCS that implements the Camera Protocol). The definition file may be xz compressed, which
   * will be indicated by the file extension .xml.xz (a GCS that implements the protocol must support
   * decompressing the file). The string needs to be zero terminated.
   */
  @GeneratedMavField(type = "char[140]")
  public val camDefinitionUri: String = "",
) : MavMessage<CameraInformation> {
  public override val instanceMetadata: MavMessage.Metadata<CameraInformation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(firmwareVersion)
    outputBuffer.encodeFloat(focalLength)
    outputBuffer.encodeFloat(sensorSizeH)
    outputBuffer.encodeFloat(sensorSizeV)
    outputBuffer.encodeBitmaskValue(flags.value, 4)
    outputBuffer.encodeUInt16(resolutionH)
    outputBuffer.encodeUInt16(resolutionV)
    outputBuffer.encodeUInt16(camDefinitionVersion)
    outputBuffer.encodeUInt8Array(vendorName, 32)
    outputBuffer.encodeUInt8Array(modelName, 32)
    outputBuffer.encodeUInt8(lensId)
    outputBuffer.encodeString(camDefinitionUri, 140)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(firmwareVersion)
    outputBuffer.encodeFloat(focalLength)
    outputBuffer.encodeFloat(sensorSizeH)
    outputBuffer.encodeFloat(sensorSizeV)
    outputBuffer.encodeBitmaskValue(flags.value, 4)
    outputBuffer.encodeUInt16(resolutionH)
    outputBuffer.encodeUInt16(resolutionV)
    outputBuffer.encodeUInt16(camDefinitionVersion)
    outputBuffer.encodeUInt8Array(vendorName, 32)
    outputBuffer.encodeUInt8Array(modelName, 32)
    outputBuffer.encodeUInt8(lensId)
    outputBuffer.encodeString(camDefinitionUri, 140)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 259u

    private const val CRC_EXTRA: Byte = 92

    private const val SIZE_V1: Int = 235

    private const val SIZE_V2: Int = 235

    private val DESERIALIZER: MavDeserializer<CameraInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val firmwareVersion = inputBuffer.decodeUInt32()
      val focalLength = inputBuffer.decodeFloat()
      val sensorSizeH = inputBuffer.decodeFloat()
      val sensorSizeV = inputBuffer.decodeFloat()
      val flags = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = CameraCapFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val resolutionH = inputBuffer.decodeUInt16()
      val resolutionV = inputBuffer.decodeUInt16()
      val camDefinitionVersion = inputBuffer.decodeUInt16()
      val vendorName = inputBuffer.decodeUInt8Array(32)
      val modelName = inputBuffer.decodeUInt8Array(32)
      val lensId = inputBuffer.decodeUInt8()
      val camDefinitionUri = inputBuffer.decodeString(140)

      CameraInformation(
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
      )
    }


    private val METADATA: MavMessage.Metadata<CameraInformation> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraInformation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CameraInformation =
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
    )
  }
}
