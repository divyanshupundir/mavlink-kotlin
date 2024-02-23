package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Version and capability of autopilot software. This should be emitted in response to a request
 * with MAV_CMD_REQUEST_MESSAGE.
 *
 * @param capabilities Bitmap of capabilities
 * @param flightSwVersion Firmware version number
 * @param middlewareSwVersion Middleware version number
 * @param osSwVersion Operating system version number
 * @param boardVersion HW / board version (last 8 bits should be silicon ID, if any). The first 16
 * bits of this field specify https://github.com/PX4/PX4-Bootloader/blob/master/board_types.txt
 * @param flightCustomVersion Custom version field, commonly the first 8 bytes of the git hash. This
 * is not an unique identifier, but should allow to identify the commit using the main version number
 * even for very large code bases.
 * @param middlewareCustomVersion Custom version field, commonly the first 8 bytes of the git hash.
 * This is not an unique identifier, but should allow to identify the commit using the main version
 * number even for very large code bases.
 * @param osCustomVersion Custom version field, commonly the first 8 bytes of the git hash. This is
 * not an unique identifier, but should allow to identify the commit using the main version number even
 * for very large code bases.
 * @param vendorId ID of the board vendor
 * @param productId ID of the product
 * @param uid UID if provided by hardware (see uid2)
 * @param uid2 UID if provided by hardware (supersedes the uid field. If this is non-zero, use this
 * field, otherwise use uid)
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
  override val instanceCompanion: MavMessage.MavCompanion<AutopilotVersion> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(capabilities.value, 8)
    encoder.encodeUInt64(uid)
    encoder.encodeUInt32(flightSwVersion)
    encoder.encodeUInt32(middlewareSwVersion)
    encoder.encodeUInt32(osSwVersion)
    encoder.encodeUInt32(boardVersion)
    encoder.encodeUInt16(vendorId)
    encoder.encodeUInt16(productId)
    encoder.encodeUInt8Array(flightCustomVersion, 8)
    encoder.encodeUInt8Array(middlewareCustomVersion, 8)
    encoder.encodeUInt8Array(osCustomVersion, 8)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(capabilities.value, 8)
    encoder.encodeUInt64(uid)
    encoder.encodeUInt32(flightSwVersion)
    encoder.encodeUInt32(middlewareSwVersion)
    encoder.encodeUInt32(osSwVersion)
    encoder.encodeUInt32(boardVersion)
    encoder.encodeUInt16(vendorId)
    encoder.encodeUInt16(productId)
    encoder.encodeUInt8Array(flightCustomVersion, 8)
    encoder.encodeUInt8Array(middlewareCustomVersion, 8)
    encoder.encodeUInt8Array(osCustomVersion, 8)
    encoder.encodeUInt8Array(uid2, 18)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AutopilotVersion> {
    private const val SIZE_V1: Int = 60

    private const val SIZE_V2: Int = 78

    override val id: UInt = 148u

    override val crcExtra: Byte = -78

    override fun deserialize(bytes: ByteArray): AutopilotVersion {
      val decoder = MavDataDecoder(bytes)

      val capabilities = decoder.safeDecodeBitmaskValue(8).let { value ->
        val flags = MavProtocolCapability.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val uid = decoder.safeDecodeUInt64()
      val flightSwVersion = decoder.safeDecodeUInt32()
      val middlewareSwVersion = decoder.safeDecodeUInt32()
      val osSwVersion = decoder.safeDecodeUInt32()
      val boardVersion = decoder.safeDecodeUInt32()
      val vendorId = decoder.safeDecodeUInt16()
      val productId = decoder.safeDecodeUInt16()
      val flightCustomVersion = decoder.safeDecodeUInt8Array(8)
      val middlewareCustomVersion = decoder.safeDecodeUInt8Array(8)
      val osCustomVersion = decoder.safeDecodeUInt8Array(8)
      val uid2 = decoder.safeDecodeUInt8Array(18)

      return AutopilotVersion(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): AutopilotVersion =
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
