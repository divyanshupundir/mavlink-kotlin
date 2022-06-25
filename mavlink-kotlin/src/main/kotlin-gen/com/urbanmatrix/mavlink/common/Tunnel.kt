package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Message for transporting "arbitrary" variable-length data from one component to another
 * (broadcast is not forbidden, but discouraged). The encoding of the data is usually extension
 * specific, i.e. determined by the source, and is usually not documented as part of the MAVLink
 * specification.
 */
public data class Tunnel(
  /**
   * A code that identifies the content of the payload (0 for unknown, which is the default). If
   * this code is less than 32768, it is a 'registered' payload type and the corresponding code should
   * be added to the MAV_TUNNEL_PAYLOAD_TYPE enum. Software creators can register blocks of types as
   * needed. Codes greater than 32767 are considered local experiments and should not be checked in to
   * any widely distributed codebase.
   */
  public val payloadType: MavEnumValue<MavTunnelPayloadType> = MavEnumValue.fromValue(0),
  /**
   * System ID (can be 0 for broadcast, but this is discouraged)
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID (can be 0 for broadcast, but this is discouraged)
   */
  public val targetComponent: Int = 0,
  /**
   * Length of the data transported in payload
   */
  public val payloadLength: Int = 0,
  /**
   * Variable length payload. The payload length is defined by payload_length. The entire content of
   * this block is opaque unless you understand the encoding specified by payload_type.
   */
  public val payload: List<Int> = emptyList(),
) : MavMessage<Tunnel> {
  public override val instanceMetadata: MavMessage.Metadata<Tunnel> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(133).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(payloadType.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(payloadLength)
    outputBuffer.encodeUint8Array(payload, 128)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 385

    private const val CRC: Int = 62

    private val DESERIALIZER: MavDeserializer<Tunnel> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val payloadType = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavTunnelPayloadType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val payloadLength = inputBuffer.decodeUint8()
      val payload = inputBuffer.decodeUint8Array(128)
      Tunnel(
        payloadType = payloadType,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        payloadLength = payloadLength,
        payload = payload,
      )
    }


    private val METADATA: MavMessage.Metadata<Tunnel> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Tunnel> = METADATA
  }
}
