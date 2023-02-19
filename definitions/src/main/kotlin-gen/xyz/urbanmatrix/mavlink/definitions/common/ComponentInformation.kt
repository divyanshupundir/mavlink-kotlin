package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 *
 *         Component information message, which may be requested using MAV_CMD_REQUEST_MESSAGE.
 *       
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 395u,
  crcExtra = 0,
)
public data class ComponentInformation(
  /**
   * Timestamp (time since system boot).
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
  public override val instanceMetadata: MavMessage.Metadata<ComponentInformation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(generalMetadataFileCrc)
    outputBuffer.encodeUInt32(peripheralsMetadataFileCrc)
    outputBuffer.encodeString(generalMetadataUri, 100)
    outputBuffer.encodeString(peripheralsMetadataUri, 100)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(generalMetadataFileCrc)
    outputBuffer.encodeUInt32(peripheralsMetadataFileCrc)
    outputBuffer.encodeString(generalMetadataUri, 100)
    outputBuffer.encodeString(peripheralsMetadataUri, 100)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 395u

    private const val CRC_EXTRA: Byte = 0

    private const val SIZE_V1: Int = 212

    private const val SIZE_V2: Int = 212

    private val DESERIALIZER: MavDeserializer<ComponentInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val generalMetadataFileCrc = inputBuffer.decodeUInt32()
      val peripheralsMetadataFileCrc = inputBuffer.decodeUInt32()
      val generalMetadataUri = inputBuffer.decodeString(100)
      val peripheralsMetadataUri = inputBuffer.decodeString(100)

      ComponentInformation(
        timeBootMs = timeBootMs,
        generalMetadataFileCrc = generalMetadataFileCrc,
        generalMetadataUri = generalMetadataUri,
        peripheralsMetadataFileCrc = peripheralsMetadataFileCrc,
        peripheralsMetadataUri = peripheralsMetadataUri,
      )
    }


    private val METADATA: MavMessage.Metadata<ComponentInformation> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ComponentInformation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ComponentInformation =
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
