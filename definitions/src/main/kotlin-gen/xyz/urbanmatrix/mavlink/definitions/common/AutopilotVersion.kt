package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Version and capability of autopilot software. This should be emitted in response to a request
 * with MAV_CMD_REQUEST_MESSAGE.
 */
@GeneratedMavMessage(
  id = 148u,
  crcExtra = -78,
)
public data class AutopilotVersion(
  /**
   * Bitmap of capabilities
   */
  @GeneratedMavField(type = "uint64_t")
  public val capabilities: MavBitmaskValue<MavProtocolCapability> = MavBitmaskValue.fromValue(0u),
  /**
   * Firmware version number
   */
  @GeneratedMavField(type = "uint32_t")
  public val flightSwVersion: UInt = 0u,
  /**
   * Middleware version number
   */
  @GeneratedMavField(type = "uint32_t")
  public val middlewareSwVersion: UInt = 0u,
  /**
   * Operating system version number
   */
  @GeneratedMavField(type = "uint32_t")
  public val osSwVersion: UInt = 0u,
  /**
   * HW / board version (last 8 bits should be silicon ID, if any). The first 16 bits of this field
   * specify https://github.com/PX4/PX4-Bootloader/blob/master/board_types.txt
   */
  @GeneratedMavField(type = "uint32_t")
  public val boardVersion: UInt = 0u,
  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique
   * identifier, but should allow to identify the commit using the main version number even for very
   * large code bases.
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val flightCustomVersion: List<UByte> = emptyList(),
  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique
   * identifier, but should allow to identify the commit using the main version number even for very
   * large code bases.
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val middlewareCustomVersion: List<UByte> = emptyList(),
  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique
   * identifier, but should allow to identify the commit using the main version number even for very
   * large code bases.
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val osCustomVersion: List<UByte> = emptyList(),
  /**
   * ID of the board vendor
   */
  @GeneratedMavField(type = "uint16_t")
  public val vendorId: UShort = 0u,
  /**
   * ID of the product
   */
  @GeneratedMavField(type = "uint16_t")
  public val productId: UShort = 0u,
  /**
   * UID if provided by hardware (see uid2)
   */
  @GeneratedMavField(type = "uint64_t")
  public val uid: ULong = 0uL,
  /**
   * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field,
   * otherwise use uid)
   */
  @GeneratedMavField(
    type = "uint8_t[18]",
    extension = true,
  )
  public val uid2: List<UByte> = emptyList(),
) : MavMessage<AutopilotVersion> {
  public override val instanceMetadata: MavMessage.Metadata<AutopilotVersion> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(capabilities.value, 8)
    outputBuffer.encodeUInt64(uid)
    outputBuffer.encodeUInt32(flightSwVersion)
    outputBuffer.encodeUInt32(middlewareSwVersion)
    outputBuffer.encodeUInt32(osSwVersion)
    outputBuffer.encodeUInt32(boardVersion)
    outputBuffer.encodeUInt16(vendorId)
    outputBuffer.encodeUInt16(productId)
    outputBuffer.encodeUInt8Array(flightCustomVersion, 8)
    outputBuffer.encodeUInt8Array(middlewareCustomVersion, 8)
    outputBuffer.encodeUInt8Array(osCustomVersion, 8)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(capabilities.value, 8)
    outputBuffer.encodeUInt64(uid)
    outputBuffer.encodeUInt32(flightSwVersion)
    outputBuffer.encodeUInt32(middlewareSwVersion)
    outputBuffer.encodeUInt32(osSwVersion)
    outputBuffer.encodeUInt32(boardVersion)
    outputBuffer.encodeUInt16(vendorId)
    outputBuffer.encodeUInt16(productId)
    outputBuffer.encodeUInt8Array(flightCustomVersion, 8)
    outputBuffer.encodeUInt8Array(middlewareCustomVersion, 8)
    outputBuffer.encodeUInt8Array(osCustomVersion, 8)
    outputBuffer.encodeUInt8Array(uid2, 18)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 148u

    private const val CRC_EXTRA: Byte = -78

    private const val SIZE_V1: Int = 60

    private const val SIZE_V2: Int = 78

    private val DESERIALIZER: MavDeserializer<AutopilotVersion> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val capabilities = inputBuffer.decodeBitmaskValue(8).let { value ->
        val flags = MavProtocolCapability.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val uid = inputBuffer.decodeUInt64()
      val flightSwVersion = inputBuffer.decodeUInt32()
      val middlewareSwVersion = inputBuffer.decodeUInt32()
      val osSwVersion = inputBuffer.decodeUInt32()
      val boardVersion = inputBuffer.decodeUInt32()
      val vendorId = inputBuffer.decodeUInt16()
      val productId = inputBuffer.decodeUInt16()
      val flightCustomVersion = inputBuffer.decodeUInt8Array(8)
      val middlewareCustomVersion = inputBuffer.decodeUInt8Array(8)
      val osCustomVersion = inputBuffer.decodeUInt8Array(8)
      val uid2 = inputBuffer.decodeUInt8Array(18)

      AutopilotVersion(
        capabilities = capabilities,
        flightSwVersion = flightSwVersion,
        middlewareSwVersion = middlewareSwVersion,
        osSwVersion = osSwVersion,
        boardVersion = boardVersion,
        flightCustomVersion = flightCustomVersion,
        middlewareCustomVersion = middlewareCustomVersion,
        osCustomVersion = osCustomVersion,
        vendorId = vendorId,
        productId = productId,
        uid = uid,
        uid2 = uid2,
      )
    }


    private val METADATA: MavMessage.Metadata<AutopilotVersion> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AutopilotVersion> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AutopilotVersion =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var capabilities: MavBitmaskValue<MavProtocolCapability> = MavBitmaskValue.fromValue(0u)

    public var flightSwVersion: UInt = 0u

    public var middlewareSwVersion: UInt = 0u

    public var osSwVersion: UInt = 0u

    public var boardVersion: UInt = 0u

    public var flightCustomVersion: List<UByte> = emptyList()

    public var middlewareCustomVersion: List<UByte> = emptyList()

    public var osCustomVersion: List<UByte> = emptyList()

    public var vendorId: UShort = 0u

    public var productId: UShort = 0u

    public var uid: ULong = 0uL

    public var uid2: List<UByte> = emptyList()

    public fun build(): AutopilotVersion = AutopilotVersion(
      capabilities = capabilities,
      flightSwVersion = flightSwVersion,
      middlewareSwVersion = middlewareSwVersion,
      osSwVersion = osSwVersion,
      boardVersion = boardVersion,
      flightCustomVersion = flightCustomVersion,
      middlewareCustomVersion = middlewareCustomVersion,
      osCustomVersion = osCustomVersion,
      vendorId = vendorId,
      productId = productId,
      uid = uid,
      uid2 = uid2,
    )
  }
}
