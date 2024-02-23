package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 *
 *         Component information message, which may be requested using MAV_CMD_REQUEST_MESSAGE.
 *       
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param generalMetadataFileCrc CRC32 of the general metadata file (general_metadata_uri).
 * @param generalMetadataUri MAVLink FTP URI for the general metadata file
 * (COMP_METADATA_TYPE_GENERAL), which may be compressed with xz. The file contains general component
 * metadata, and may contain URI links for additional metadata (see COMP_METADATA_TYPE). The
 * information is static from boot, and may be generated at compile time. The string needs to be zero
 * terminated.
 * @param peripheralsMetadataFileCrc CRC32 of peripherals metadata file (peripherals_metadata_uri).
 * @param peripheralsMetadataUri (Optional) MAVLink FTP URI for the peripherals metadata file
 * (COMP_METADATA_TYPE_PERIPHERALS), which may be compressed with xz. This contains data about
 * "attached components" such as UAVCAN nodes. The peripherals are in a separate file because the
 * information must be generated dynamically at runtime. The string needs to be zero terminated.
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 395u,
  crcExtra = 0,
)
public data class ComponentInformation(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * CRC32 of the general metadata file (general_metadata_uri).
   */
  @GeneratedMavField(type = "uint32_t")
  public val generalMetadataFileCrc: UInt = 0u,
  /**
   * MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may be
   * compressed with xz. The file contains general component metadata, and may contain URI links for
   * additional metadata (see COMP_METADATA_TYPE). The information is static from boot, and may be
   * generated at compile time. The string needs to be zero terminated.
   */
  @GeneratedMavField(type = "char[100]")
  public val generalMetadataUri: String = "",
  /**
   * CRC32 of peripherals metadata file (peripherals_metadata_uri).
   */
  @GeneratedMavField(type = "uint32_t")
  public val peripheralsMetadataFileCrc: UInt = 0u,
  /**
   * (Optional) MAVLink FTP URI for the peripherals metadata file (COMP_METADATA_TYPE_PERIPHERALS),
   * which may be compressed with xz. This contains data about "attached components" such as UAVCAN
   * nodes. The peripherals are in a separate file because the information must be generated
   * dynamically at runtime. The string needs to be zero terminated.
   */
  @GeneratedMavField(type = "char[100]")
  public val peripheralsMetadataUri: String = "",
) : MavMessage<ComponentInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<ComponentInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(generalMetadataFileCrc)
    encoder.encodeUInt32(peripheralsMetadataFileCrc)
    encoder.encodeString(generalMetadataUri, 100)
    encoder.encodeString(peripheralsMetadataUri, 100)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(generalMetadataFileCrc)
    encoder.encodeUInt32(peripheralsMetadataFileCrc)
    encoder.encodeString(generalMetadataUri, 100)
    encoder.encodeString(peripheralsMetadataUri, 100)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ComponentInformation> {
    private const val SIZE_V1: Int = 212

    private const val SIZE_V2: Int = 212

    override val id: UInt = 395u

    override val crcExtra: Byte = 0

    override fun deserialize(bytes: ByteArray): ComponentInformation {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val generalMetadataFileCrc = decoder.safeDecodeUInt32()
      val peripheralsMetadataFileCrc = decoder.safeDecodeUInt32()
      val generalMetadataUri = decoder.safeDecodeString(100)
      val peripheralsMetadataUri = decoder.safeDecodeString(100)

      return ComponentInformation(
        timeBootMs = timeBootMs,
        generalMetadataFileCrc = generalMetadataFileCrc,
        generalMetadataUri = generalMetadataUri,
        peripheralsMetadataFileCrc = peripheralsMetadataFileCrc,
        peripheralsMetadataUri = peripheralsMetadataUri,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ComponentInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var generalMetadataFileCrc: UInt = 0u

    public var generalMetadataUri: String = ""

    public var peripheralsMetadataFileCrc: UInt = 0u

    public var peripheralsMetadataUri: String = ""

    public fun build(): ComponentInformation = ComponentInformation(
      timeBootMs = timeBootMs,
      generalMetadataFileCrc = generalMetadataFileCrc,
      generalMetadataUri = generalMetadataUri,
      peripheralsMetadataFileCrc = peripheralsMetadataFileCrc,
      peripheralsMetadataUri = peripheralsMetadataUri,
    )
  }
}
