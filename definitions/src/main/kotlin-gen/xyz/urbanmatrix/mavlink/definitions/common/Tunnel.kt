package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Message for transporting "arbitrary" variable-length data from one component to another
 * (broadcast is not forbidden, but discouraged). The encoding of the data is usually extension
 * specific, i.e. determined by the source, and is usually not documented as part of the MAVLink
 * specification.
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
  public override val instanceMetadata: MavMessage.Metadata<Tunnel> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(payloadType.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(payloadLength)
    outputBuffer.encodeUInt8Array(payload, 128)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(payloadType.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(payloadLength)
    outputBuffer.encodeUInt8Array(payload, 128)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 385u

    private const val CRC_EXTRA: Byte = -109

    private const val SIZE_V1: Int = 133

    private const val SIZE_V2: Int = 133

    private val DESERIALIZER: MavDeserializer<Tunnel> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val payloadType = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavTunnelPayloadType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val payloadLength = inputBuffer.decodeUInt8()
      val payload = inputBuffer.decodeUInt8Array(128)

      Tunnel(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        payloadType = payloadType,
        payloadLength = payloadLength,
        payload = payload,
      )
    }


    private val METADATA: MavMessage.Metadata<Tunnel> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Tunnel> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Tunnel =
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
