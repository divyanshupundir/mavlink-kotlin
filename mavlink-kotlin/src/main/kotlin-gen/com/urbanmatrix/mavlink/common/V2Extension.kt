package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Message implementing parts of the V2 payload specs in V1 frames for transitional support.
 */
public data class V2Extension(
  /**
   * Network ID (0 for broadcast)
   */
  public val targetNetwork: Int = 0,
  /**
   * System ID (0 for broadcast)
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID (0 for broadcast)
   */
  public val targetComponent: Int = 0,
  /**
   * A code that identifies the software component that understands this message (analogous to USB
   * device classes or mime type strings). If this code is less than 32768, it is considered a
   * 'registered' protocol extension and the corresponding entry should be added to
   * https://github.com/mavlink/mavlink/definition_files/extension_message_ids.xml. Software creators
   * can register blocks of message IDs as needed (useful for GCS specific metadata, etc...).
   * Message_types greater than 32767 are considered local experiments and should not be checked in to
   * any widely distributed codebase.
   */
  public val messageType: Int = 0,
  /**
   * Variable length payload. The length must be encoded in the payload as part of the message_type
   * protocol, e.g. by including the length as payload data, or by terminating the payload data with a
   * non-zero marker. This is required in order to reconstruct zero-terminated payloads that are (or
   * otherwise would be) trimmed by MAVLink 2 empty-byte truncation. The entire content of the payload
   * block is opaque unless you understand the encoding message_type. The particular encoding used can
   * be extension specific and might not always be documented as part of the MAVLink specification.
   */
  public val payload: List<Int> = emptyList(),
) : MavMessage<V2Extension> {
  public override val instanceMetadata: MavMessage.Metadata<V2Extension> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(messageType)
    outputBuffer.encodeUint8(targetNetwork)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(payload, 249)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 248

    private const val CRC: Int = 248

    private const val SIZE: Int = 254

    private val DESERIALIZER: MavDeserializer<V2Extension> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for V2Extension: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val messageType = inputBuffer.decodeUint16()
      val targetNetwork = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val payload = inputBuffer.decodeUint8Array(249)

      V2Extension(
        targetNetwork = targetNetwork,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        messageType = messageType,
        payload = payload,
      )
    }


    private val METADATA: MavMessage.Metadata<V2Extension> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<V2Extension> = METADATA
  }
}
