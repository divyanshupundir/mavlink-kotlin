package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

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
@WorkInProgress
@GeneratedMavMessage(
  id = 397u,
  crcExtra = -74,
)
public data class ComponentMetadata(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * CRC32 of the general metadata file.
   */
  @GeneratedMavField(type = "uint32_t")
  public val fileCrc: UInt = 0u,
  /**
   * MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may be
   * compressed with xz. The file contains general component metadata, and may contain URI links for
   * additional metadata (see COMP_METADATA_TYPE). The information is static from boot, and may be
   * generated at compile time. The string needs to be zero terminated.
   */
  @GeneratedMavField(type = "char[100]")
  public val uri: String = "",
) : MavMessage<ComponentMetadata> {
  public override val instanceMetadata: MavMessage.Metadata<ComponentMetadata> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(fileCrc)
    outputBuffer.encodeString(uri, 100)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(fileCrc)
    outputBuffer.encodeString(uri, 100)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 397u

    private const val CRC_EXTRA: Byte = -74

    private const val SIZE_V1: Int = 108

    private const val SIZE_V2: Int = 108

    private val DESERIALIZER: MavDeserializer<ComponentMetadata> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val fileCrc = inputBuffer.decodeUInt32()
      val uri = inputBuffer.decodeString(100)

      ComponentMetadata(
        timeBootMs = timeBootMs,
        fileCrc = fileCrc,
        uri = uri,
      )
    }


    private val METADATA: MavMessage.Metadata<ComponentMetadata> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ComponentMetadata> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ComponentMetadata =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var fileCrc: UInt = 0u

    public var uri: String = ""

    public fun build(): ComponentMetadata = ComponentMetadata(
      timeBootMs = timeBootMs,
      fileCrc = fileCrc,
      uri = uri,
    )
  }
}