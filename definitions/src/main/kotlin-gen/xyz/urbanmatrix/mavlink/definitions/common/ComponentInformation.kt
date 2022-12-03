package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 *
 *         Component information message, which may be requested using MAV_CMD_REQUEST_MESSAGE.
 *       
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 395,
  crc = 0,
)
public data class ComponentInformation(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * CRC32 of the general metadata file (general_metadata_uri).
   */
  @GeneratedMavField(type = "uint32_t")
  public val generalMetadataFileCrc: Long = 0L,
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
  public val peripheralsMetadataFileCrc: Long = 0L,
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
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint32(generalMetadataFileCrc)
    outputBuffer.encodeUint32(peripheralsMetadataFileCrc)
    outputBuffer.encodeString(generalMetadataUri, 100)
    outputBuffer.encodeString(peripheralsMetadataUri, 100)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint32(generalMetadataFileCrc)
    outputBuffer.encodeUint32(peripheralsMetadataFileCrc)
    outputBuffer.encodeString(generalMetadataUri, 100)
    outputBuffer.encodeString(peripheralsMetadataUri, 100)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 395

    private const val CRC: Int = 0

    private const val SIZE_V1: Int = 212

    private const val SIZE_V2: Int = 212

    private val DESERIALIZER: MavDeserializer<ComponentInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val generalMetadataFileCrc = inputBuffer.decodeUint32()
      val peripheralsMetadataFileCrc = inputBuffer.decodeUint32()
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


    private val METADATA: MavMessage.Metadata<ComponentInformation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ComponentInformation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ComponentInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var generalMetadataFileCrc: Long = 0L

    public var generalMetadataUri: String = ""

    public var peripheralsMetadataFileCrc: Long = 0L

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
