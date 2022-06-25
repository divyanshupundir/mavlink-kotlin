package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * Information about a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command.
 */
public data class CameraInformation(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Name of the camera vendor
   */
  public val vendorName: List<Int> = emptyList(),
  /**
   * Name of the camera model
   */
  public val modelName: List<Int> = emptyList(),
  /**
   * Version of the camera firmware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor
   * & 0xff) << 8 | (Major & 0xff)
   */
  public val firmwareVersion: Long = 0L,
  /**
   * Focal length
   */
  public val focalLength: Float = 0F,
  /**
   * Image sensor size horizontal
   */
  public val sensorSizeH: Float = 0F,
  /**
   * Image sensor size vertical
   */
  public val sensorSizeV: Float = 0F,
  /**
   * Horizontal image resolution
   */
  public val resolutionH: Int = 0,
  /**
   * Vertical image resolution
   */
  public val resolutionV: Int = 0,
  /**
   * Reserved for a lens ID
   */
  public val lensId: Int = 0,
  /**
   * Bitmap of camera capability flags.
   */
  public val flags: MavEnumValue<CameraCapFlags> = MavEnumValue.fromValue(0),
  /**
   * Camera definition version (iteration)
   */
  public val camDefinitionVersion: Int = 0,
  /**
   * Camera definition URI (if any, otherwise only basic functions will be available). HTTP-
   * (http://) and MAVLink FTP- (mavlinkftp://) formatted URIs are allowed (and both must be supported
   * by any GCS that implements the Camera Protocol). The definition file may be xz compressed, which
   * will be indicated by the file extension .xml.xz (a GCS that implements the protocol must support
   * decompressing the file). The string needs to be zero terminated.
   */
  public val camDefinitionUri: String = "",
) : MavMessage<CameraInformation> {
  public override val instanceMetadata: MavMessage.Metadata<CameraInformation> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(235).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint8Array(vendorName, 32)
    outputBuffer.encodeUint8Array(modelName, 32)
    outputBuffer.encodeUint32(firmwareVersion)
    outputBuffer.encodeFloat(focalLength)
    outputBuffer.encodeFloat(sensorSizeH)
    outputBuffer.encodeFloat(sensorSizeV)
    outputBuffer.encodeUint16(resolutionH)
    outputBuffer.encodeUint16(resolutionV)
    outputBuffer.encodeUint8(lensId)
    outputBuffer.encodeEnumValue(flags.value, 4)
    outputBuffer.encodeUint16(camDefinitionVersion)
    outputBuffer.encodeString(camDefinitionUri, 140)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 259

    private const val CRC: Int = 120

    private val DESERIALIZER: MavDeserializer<CameraInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val vendorName = inputBuffer.decodeUint8Array(32)
      val modelName = inputBuffer.decodeUint8Array(32)
      val firmwareVersion = inputBuffer.decodeUint32()
      val focalLength = inputBuffer.decodeFloat()
      val sensorSizeH = inputBuffer.decodeFloat()
      val sensorSizeV = inputBuffer.decodeFloat()
      val resolutionH = inputBuffer.decodeUint16()
      val resolutionV = inputBuffer.decodeUint16()
      val lensId = inputBuffer.decodeUint8()
      val flags = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = CameraCapFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val camDefinitionVersion = inputBuffer.decodeUint16()
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


    private val METADATA: MavMessage.Metadata<CameraInformation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraInformation> = METADATA
  }
}
