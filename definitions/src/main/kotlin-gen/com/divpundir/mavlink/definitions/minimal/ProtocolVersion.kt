package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Version and capability of protocol version. This message can be requested with
 * MAV_CMD_REQUEST_MESSAGE and is used as part of the handshaking to establish which MAVLink version
 * should be used on the network. Every node should respond to a request for PROTOCOL_VERSION to enable
 * the handshaking. Library implementers should consider adding this into the default decoding state
 * machine to allow the protocol core to respond directly.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 300u,
  crcExtra = -39,
)
public data class ProtocolVersion(
  /**
   * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc.
   */
  @GeneratedMavField(type = "uint16_t")
  public val version: UShort = 0u,
  /**
   * Minimum MAVLink version supported
   */
  @GeneratedMavField(type = "uint16_t")
  public val minVersion: UShort = 0u,
  /**
   * Maximum MAVLink version supported (set to the same value as version by default)
   */
  @GeneratedMavField(type = "uint16_t")
  public val maxVersion: UShort = 0u,
  /**
   * The first 8 bytes (not characters printed in hex!) of the git hash.
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val specVersionHash: List<UByte> = emptyList(),
  /**
   * The first 8 bytes (not characters printed in hex!) of the git hash.
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val libraryVersionHash: List<UByte> = emptyList(),
) : MavMessage<ProtocolVersion> {
  public override val instanceCompanion: MavMessage.MavCompanion<ProtocolVersion> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(version)
    buffer.encodeUInt16(minVersion)
    buffer.encodeUInt16(maxVersion)
    buffer.encodeUInt8Array(specVersionHash, 8)
    buffer.encodeUInt8Array(libraryVersionHash, 8)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(version)
    buffer.encodeUInt16(minVersion)
    buffer.encodeUInt16(maxVersion)
    buffer.encodeUInt8Array(specVersionHash, 8)
    buffer.encodeUInt8Array(libraryVersionHash, 8)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ProtocolVersion> {
    public override val id: UInt = 300u

    public override val crcExtra: Byte = -39

    public override fun deserialize(bytes: ByteArray): ProtocolVersion {
      val buffer = Buffer().write(bytes)

      val version = buffer.decodeUInt16()
      val minVersion = buffer.decodeUInt16()
      val maxVersion = buffer.decodeUInt16()
      val specVersionHash = buffer.decodeUInt8Array(8)
      val libraryVersionHash = buffer.decodeUInt8Array(8)

      return ProtocolVersion(
        version = version,
        minVersion = minVersion,
        maxVersion = maxVersion,
        specVersionHash = specVersionHash,
        libraryVersionHash = libraryVersionHash,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ProtocolVersion =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var version: UShort = 0u

    public var minVersion: UShort = 0u

    public var maxVersion: UShort = 0u

    public var specVersionHash: List<UByte> = emptyList()

    public var libraryVersionHash: List<UByte> = emptyList()

    public fun build(): ProtocolVersion = ProtocolVersion(
      version = version,
      minVersion = minVersion,
      maxVersion = maxVersion,
      specVersionHash = specVersionHash,
      libraryVersionHash = libraryVersionHash,
    )
  }
}
