package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
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
 * Message implementing parts of the V2 payload specs in V1 frames for transitional support.
 */
@GeneratedMavMessage(
  id = 248u,
  crcExtra = 8,
)
public data class V2Extension(
  /**
   * Network ID (0 for broadcast)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetNetwork: UByte = 0u,
  /**
   * System ID (0 for broadcast)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (0 for broadcast)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * A code that identifies the software component that understands this message (analogous to USB
   * device classes or mime type strings). If this code is less than 32768, it is considered a
   * 'registered' protocol extension and the corresponding entry should be added to
   * https://github.com/mavlink/mavlink/definition_files/extension_message_ids.xml. Software creators
   * can register blocks of message IDs as needed (useful for GCS specific metadata, etc...).
   * Message_types greater than 32767 are considered local experiments and should not be checked in to
   * any widely distributed codebase.
   */
  @GeneratedMavField(type = "uint16_t")
  public val messageType: UShort = 0u,
  /**
   * Variable length payload. The length must be encoded in the payload as part of the message_type
   * protocol, e.g. by including the length as payload data, or by terminating the payload data with a
   * non-zero marker. This is required in order to reconstruct zero-terminated payloads that are (or
   * otherwise would be) trimmed by MAVLink 2 empty-byte truncation. The entire content of the payload
   * block is opaque unless you understand the encoding message_type. The particular encoding used can
   * be extension specific and might not always be documented as part of the MAVLink specification.
   */
  @GeneratedMavField(type = "uint8_t[249]")
  public val payload: List<UByte> = emptyList(),
) : MavMessage<V2Extension> {
  public override val instanceMetadata: MavMessage.Metadata<V2Extension> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(messageType)
    outputBuffer.encodeUInt8(targetNetwork)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(payload, 249)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(messageType)
    outputBuffer.encodeUInt8(targetNetwork)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(payload, 249)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 248u

    private const val CRC_EXTRA: Byte = 8

    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    private val DESERIALIZER: MavDeserializer<V2Extension> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val messageType = inputBuffer.decodeUInt16()
      val targetNetwork = inputBuffer.decodeUInt8()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val payload = inputBuffer.decodeUInt8Array(249)

      V2Extension(
        targetNetwork = targetNetwork,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        messageType = messageType,
        payload = payload,
      )
    }


    private val METADATA: MavMessage.Metadata<V2Extension> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<V2Extension> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): V2Extension =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetNetwork: UByte = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var messageType: UShort = 0u

    public var payload: List<UByte> = emptyList()

    public fun build(): V2Extension = V2Extension(
      targetNetwork = targetNetwork,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      messageType = messageType,
      payload = payload,
    )
  }
}
