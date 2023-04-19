package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

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
  public override val instanceMetadata: MavMessage.Metadata<ProtocolVersion> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(version)
    outputBuffer.encodeUInt16(minVersion)
    outputBuffer.encodeUInt16(maxVersion)
    outputBuffer.encodeUInt8Array(specVersionHash, 8)
    outputBuffer.encodeUInt8Array(libraryVersionHash, 8)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(version)
    outputBuffer.encodeUInt16(minVersion)
    outputBuffer.encodeUInt16(maxVersion)
    outputBuffer.encodeUInt8Array(specVersionHash, 8)
    outputBuffer.encodeUInt8Array(libraryVersionHash, 8)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 300u

    private const val CRC_EXTRA: Byte = -39

    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    private val DESERIALIZER: MavDeserializer<ProtocolVersion> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val version = inputBuffer.decodeUInt16()
      val minVersion = inputBuffer.decodeUInt16()
      val maxVersion = inputBuffer.decodeUInt16()
      val specVersionHash = inputBuffer.decodeUInt8Array(8)
      val libraryVersionHash = inputBuffer.decodeUInt8Array(8)

      ProtocolVersion(
        version = version,
        minVersion = minVersion,
        maxVersion = maxVersion,
        specVersionHash = specVersionHash,
        libraryVersionHash = libraryVersionHash,
      )
    }


    private val METADATA: MavMessage.Metadata<ProtocolVersion> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ProtocolVersion> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ProtocolVersion =
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
