package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 *
 *         Component metadata message, which may be requested using MAV_CMD_REQUEST_MESSAGE.
 *         
 *         This contains the MAVLink FTP URI and CRC for the component's general metadata file.
 *         The file must be hosted on the component, and may be xz compressed.
 *         The file CRC can be used for file caching.
 *         
 *         The general metadata file can be read to get the locations of other metadata files
 * (COMP_METADATA_TYPE) and translations, which may be hosted either on the vehicle or the internet.
 *         For more information see: https://mavlink.io/en/services/component_information.html.
 *         
 *         Note: Camera components should use CAMERA_INFORMATION instead, and autopilots may use
 * both this message and AUTOPILOT_VERSION.
 *       
 */
public data class ComponentMetadata(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * CRC32 of the general metadata file.
   */
  public val fileCrc: Long = 0L,
  /**
   * MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may be
   * compressed with xz. The file contains general component metadata, and may contain URI links for
   * additional metadata (see COMP_METADATA_TYPE). The information is static from boot, and may be
   * generated at compile time. The string needs to be zero terminated.
   */
  public val uri: String = "",
) : MavMessage<ComponentMetadata> {
  public override val instanceMetadata: MavMessage.Metadata<ComponentMetadata> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint32(fileCrc)
    outputBuffer.encodeString(uri, 100)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 397

    private const val CRC: Int = 125

    private const val SIZE: Int = 108

    private val DESERIALIZER: MavDeserializer<ComponentMetadata> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for ComponentMetadata: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val fileCrc = inputBuffer.decodeUint32()
      val uri = inputBuffer.decodeString(100)

      ComponentMetadata(
        timeBootMs = timeBootMs,
        fileCrc = fileCrc,
        uri = uri,
      )
    }


    private val METADATA: MavMessage.Metadata<ComponentMetadata> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ComponentMetadata> = METADATA
  }
}
