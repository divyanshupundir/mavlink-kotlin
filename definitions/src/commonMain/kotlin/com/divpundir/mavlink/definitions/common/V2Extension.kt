package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param targetNetwork Network ID (0 for broadcast)
 * @param targetSystem System ID (0 for broadcast)
 * @param targetComponent Component ID (0 for broadcast)
 * @param messageType A code that identifies the software component that understands this message
 * (analogous to USB device classes or mime type strings). If this code is less than 32768, it is
 * considered a 'registered' protocol extension and the corresponding entry should be added to
 * https://github.com/mavlink/mavlink/definition_files/extension_message_ids.xml. Software creators can
 * register blocks of message IDs as needed (useful for GCS specific metadata, etc...). Message_types
 * greater than 32767 are considered local experiments and should not be checked in to any widely
 * distributed codebase.
 * @param payload Variable length payload. The length must be encoded in the payload as part of the
 * message_type protocol, e.g. by including the length as payload data, or by terminating the payload
 * data with a non-zero marker. This is required in order to reconstruct zero-terminated payloads that
 * are (or otherwise would be) trimmed by MAVLink 2 empty-byte truncation. The entire content of the
 * payload block is opaque unless you understand the encoding message_type. The particular encoding
 * used can be extension specific and might not always be documented as part of the MAVLink
 * specification.
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
  override val instanceCompanion: MavMessage.MavCompanion<V2Extension> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(messageType)
    encoder.encodeUInt8(targetNetwork)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(payload, 249)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(messageType)
    encoder.encodeUInt8(targetNetwork)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(payload, 249)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<V2Extension> {
    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    override val id: UInt = 248u

    override val crcExtra: Byte = 8

    override fun deserialize(bytes: ByteArray): V2Extension {
      val decoder = MavDataDecoder(bytes)

      val messageType = decoder.safeDecodeUInt16()
      val targetNetwork = decoder.safeDecodeUInt8()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val payload = decoder.safeDecodeUInt8Array(249)

      return V2Extension(
        targetNetwork = targetNetwork,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        messageType = messageType,
        payload = payload,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): V2Extension =
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
