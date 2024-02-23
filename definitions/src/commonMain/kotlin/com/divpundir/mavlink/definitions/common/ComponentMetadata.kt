package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param fileCrc CRC32 of the general metadata file.
 * @param uri MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may
 * be compressed with xz. The file contains general component metadata, and may contain URI links for
 * additional metadata (see COMP_METADATA_TYPE). The information is static from boot, and may be
 * generated at compile time. The string needs to be zero terminated.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 397u,
  crcExtra = -74,
)
public data class ComponentMetadata(
  /**
   * Timestamp (time since system boot).
   * units = ms
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
  override val instanceCompanion: MavMessage.MavCompanion<ComponentMetadata> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(fileCrc)
    encoder.encodeString(uri, 100)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(fileCrc)
    encoder.encodeString(uri, 100)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ComponentMetadata> {
    private const val SIZE_V1: Int = 108

    private const val SIZE_V2: Int = 108

    override val id: UInt = 397u

    override val crcExtra: Byte = -74

    override fun deserialize(bytes: ByteArray): ComponentMetadata {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val fileCrc = decoder.safeDecodeUInt32()
      val uri = decoder.safeDecodeString(100)

      return ComponentMetadata(
        timeBootMs = timeBootMs,
        fileCrc = fileCrc,
        uri = uri,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ComponentMetadata =
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
