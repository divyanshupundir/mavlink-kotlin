package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<AutopilotVersion> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(capabilities.value, 8)
    output.encodeUInt64(uid)
    output.encodeUInt32(flightSwVersion)
    output.encodeUInt32(middlewareSwVersion)
    output.encodeUInt32(osSwVersion)
    output.encodeUInt32(boardVersion)
    output.encodeUInt16(vendorId)
    output.encodeUInt16(productId)
    output.encodeUInt8Array(flightCustomVersion, 8)
    output.encodeUInt8Array(middlewareCustomVersion, 8)
    output.encodeUInt8Array(osCustomVersion, 8)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(capabilities.value, 8)
    output.encodeUInt64(uid)
    output.encodeUInt32(flightSwVersion)
    output.encodeUInt32(middlewareSwVersion)
    output.encodeUInt32(osSwVersion)
    output.encodeUInt32(boardVersion)
    output.encodeUInt16(vendorId)
    output.encodeUInt16(productId)
    output.encodeUInt8Array(flightCustomVersion, 8)
    output.encodeUInt8Array(middlewareCustomVersion, 8)
    output.encodeUInt8Array(osCustomVersion, 8)
    output.encodeUInt8Array(uid2, 18)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AutopilotVersion> {
    private const val SIZE_V1: Int = 60

    private const val SIZE_V2: Int = 78

    public override val id: UInt = 148u

    public override val crcExtra: Byte = -78

    public override fun deserialize(source: BufferedSource): AutopilotVersion {
      val capabilities = source.decodeBitmaskValue(8).let { value ->
        val flags = MavProtocolCapability.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val uid = source.decodeUInt64()
      val flightSwVersion = source.decodeUInt32()
      val middlewareSwVersion = source.decodeUInt32()
      val osSwVersion = source.decodeUInt32()
      val boardVersion = source.decodeUInt32()
      val vendorId = source.decodeUInt16()
      val productId = source.decodeUInt16()
      val flightCustomVersion = source.decodeUInt8Array(8)
      val middlewareCustomVersion = source.decodeUInt8Array(8)
      val osCustomVersion = source.decodeUInt8Array(8)
      val uid2 = source.decodeUInt8Array(18)

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
