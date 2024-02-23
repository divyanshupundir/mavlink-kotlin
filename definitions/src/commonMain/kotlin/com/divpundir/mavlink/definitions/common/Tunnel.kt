package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Message for transporting "arbitrary" variable-length data from one component to another
 * (broadcast is not forbidden, but discouraged). The encoding of the data is usually extension
 * specific, i.e. determined by the source, and is usually not documented as part of the MAVLink
 * specification.
 *
 * @param targetSystem System ID (can be 0 for broadcast, but this is discouraged)
 * @param targetComponent Component ID (can be 0 for broadcast, but this is discouraged)
 * @param payloadType A code that identifies the content of the payload (0 for unknown, which is the
 * default). If this code is less than 32768, it is a 'registered' payload type and the corresponding
 * code should be added to the MAV_TUNNEL_PAYLOAD_TYPE enum. Software creators can register blocks of
 * types as needed. Codes greater than 32767 are considered local experiments and should not be checked
 * in to any widely distributed codebase.
 * @param payloadLength Length of the data transported in payload
 * @param payload Variable length payload. The payload length is defined by payload_length. The
 * entire content of this block is opaque unless you understand the encoding specified by payload_type.
 */
@GeneratedMavMessage(
  id = 385u,
  crcExtra = -109,
)
public data class Tunnel(
  /**
   * System ID (can be 0 for broadcast, but this is discouraged)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (can be 0 for broadcast, but this is discouraged)
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * A code that identifies the content of the payload (0 for unknown, which is the default). If
   * this code is less than 32768, it is a 'registered' payload type and the corresponding code should
   * be added to the MAV_TUNNEL_PAYLOAD_TYPE enum. Software creators can register blocks of types as
   * needed. Codes greater than 32767 are considered local experiments and should not be checked in to
   * any widely distributed codebase.
   */
  @GeneratedMavField(type = "uint16_t")
  public val payloadType: MavEnumValue<MavTunnelPayloadType> = MavEnumValue.fromValue(0u),
  /**
   * Length of the data transported in payload
   */
  @GeneratedMavField(type = "uint8_t")
  public val payloadLength: UByte = 0u,
  /**
   * Variable length payload. The payload length is defined by payload_length. The entire content of
   * this block is opaque unless you understand the encoding specified by payload_type.
   */
  @GeneratedMavField(type = "uint8_t[128]")
  public val payload: List<UByte> = emptyList(),
) : MavMessage<Tunnel> {
  override val instanceCompanion: MavMessage.MavCompanion<Tunnel> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(payloadType.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(payloadLength)
    encoder.encodeUInt8Array(payload, 128)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(payloadType.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(payloadLength)
    encoder.encodeUInt8Array(payload, 128)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Tunnel> {
    private const val SIZE_V1: Int = 133

    private const val SIZE_V2: Int = 133

    override val id: UInt = 385u

    override val crcExtra: Byte = -109

    override fun deserialize(bytes: ByteArray): Tunnel {
      val decoder = MavDataDecoder(bytes)

      val payloadType = decoder.safeDecodeEnumValue(2).let { value ->
        val entry = MavTunnelPayloadType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val payloadLength = decoder.safeDecodeUInt8()
      val payload = decoder.safeDecodeUInt8Array(128)

      return Tunnel(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        payloadType = payloadType,
        payloadLength = payloadLength,
        payload = payload,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Tunnel =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var payloadType: MavEnumValue<MavTunnelPayloadType> = MavEnumValue.fromValue(0u)

    public var payloadLength: UByte = 0u

    public var payload: List<UByte> = emptyList()

    public fun build(): Tunnel = Tunnel(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      payloadType = payloadType,
      payloadLength = payloadLength,
      payload = payload,
    )
  }
}
