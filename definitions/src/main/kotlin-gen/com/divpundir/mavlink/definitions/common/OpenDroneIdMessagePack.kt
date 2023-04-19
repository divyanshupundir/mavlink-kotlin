package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
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
import kotlin.Unit
import kotlin.collections.List

/**
 * An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. not in
 * the format given for the above message descriptions but after encoding into the compressed
 * OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long Range/Extended
 * Advertising or on WiFi Neighbor Aware Networking or on WiFi Beacon.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12915u,
  crcExtra = 94,
)
public data class OpenDroneIdMessagePack(
  /**
   * System ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Only used for drone ID data received from other UAs. See detailed description at
   * https://mavlink.io/en/services/opendroneid.html. 
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val idOrMac: List<UByte> = emptyList(),
  /**
   * This field must currently always be equal to 25 (bytes), since all encoded OpenDroneID messages
   * are specificed to have this length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val singleMessageSize: UByte = 0u,
  /**
   * Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 9.
   */
  @GeneratedMavField(type = "uint8_t")
  public val msgPackSize: UByte = 0u,
  /**
   * Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused portion
   * of the field.
   */
  @GeneratedMavField(type = "uint8_t[225]")
  public val messages: List<UByte> = emptyList(),
) : MavMessage<OpenDroneIdMessagePack> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdMessagePack> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(idOrMac, 20)
    outputBuffer.encodeUInt8(singleMessageSize)
    outputBuffer.encodeUInt8(msgPackSize)
    outputBuffer.encodeUInt8Array(messages, 225)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(idOrMac, 20)
    outputBuffer.encodeUInt8(singleMessageSize)
    outputBuffer.encodeUInt8(msgPackSize)
    outputBuffer.encodeUInt8Array(messages, 225)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 12915u

    private const val CRC_EXTRA: Byte = 94

    private const val SIZE_V1: Int = 249

    private const val SIZE_V2: Int = 249

    private val DESERIALIZER: MavDeserializer<OpenDroneIdMessagePack> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val idOrMac = inputBuffer.decodeUInt8Array(20)
      val singleMessageSize = inputBuffer.decodeUInt8()
      val msgPackSize = inputBuffer.decodeUInt8()
      val messages = inputBuffer.decodeUInt8Array(225)

      OpenDroneIdMessagePack(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        singleMessageSize = singleMessageSize,
        msgPackSize = msgPackSize,
        messages = messages,
      )
    }


    private val METADATA: MavMessage.Metadata<OpenDroneIdMessagePack> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdMessagePack> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OpenDroneIdMessagePack =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var singleMessageSize: UByte = 0u

    public var msgPackSize: UByte = 0u

    public var messages: List<UByte> = emptyList()

    public fun build(): OpenDroneIdMessagePack = OpenDroneIdMessagePack(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      singleMessageSize = singleMessageSize,
      msgPackSize = msgPackSize,
      messages = messages,
    )
  }
}
