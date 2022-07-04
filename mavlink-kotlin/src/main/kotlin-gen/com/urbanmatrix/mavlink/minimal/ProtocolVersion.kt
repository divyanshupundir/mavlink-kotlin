package com.urbanmatrix.mavlink.minimal

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Version and capability of protocol version. This message can be requested with
 * MAV_CMD_REQUEST_MESSAGE and is used as part of the handshaking to establish which MAVLink version
 * should be used on the network. Every node should respond to a request for PROTOCOL_VERSION to enable
 * the handshaking. Library implementers should consider adding this into the default decoding state
 * machine to allow the protocol core to respond directly.
 */
public data class ProtocolVersion(
  /**
   * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc.
   */
  public val version: Int = 0,
  /**
   * Minimum MAVLink version supported
   */
  public val minVersion: Int = 0,
  /**
   * Maximum MAVLink version supported (set to the same value as version by default)
   */
  public val maxVersion: Int = 0,
  /**
   * The first 8 bytes (not characters printed in hex!) of the git hash.
   */
  public val specVersionHash: List<Int> = emptyList(),
  /**
   * The first 8 bytes (not characters printed in hex!) of the git hash.
   */
  public val libraryVersionHash: List<Int> = emptyList(),
) : MavMessage<ProtocolVersion> {
  public override val instanceMetadata: MavMessage.Metadata<ProtocolVersion> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(version)
    outputBuffer.encodeUint16(minVersion)
    outputBuffer.encodeUint16(maxVersion)
    outputBuffer.encodeUint8Array(specVersionHash, 8)
    outputBuffer.encodeUint8Array(libraryVersionHash, 8)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 300

    private const val CRC: Int = 233

    private const val SIZE: Int = 22

    private val DESERIALIZER: MavDeserializer<ProtocolVersion> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for ProtocolVersion: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val version = inputBuffer.decodeUint16()
      val minVersion = inputBuffer.decodeUint16()
      val maxVersion = inputBuffer.decodeUint16()
      val specVersionHash = inputBuffer.decodeUint8Array(8)
      val libraryVersionHash = inputBuffer.decodeUint8Array(8)

      ProtocolVersion(
        version = version,
        minVersion = minVersion,
        maxVersion = maxVersion,
        specVersionHash = specVersionHash,
        libraryVersionHash = libraryVersionHash,
      )
    }


    private val METADATA: MavMessage.Metadata<ProtocolVersion> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ProtocolVersion> = METADATA
  }
}
