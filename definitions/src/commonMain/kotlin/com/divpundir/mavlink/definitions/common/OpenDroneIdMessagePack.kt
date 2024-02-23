package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
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
 * An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. not in
 * the format given for the above message descriptions but after encoding into the compressed
 * OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long Range/Extended
 * Advertising or on WiFi Neighbor Aware Networking or on WiFi Beacon.
 *
 * @param targetSystem System ID (0 for broadcast).
 * @param targetComponent Component ID (0 for broadcast).
 * @param idOrMac Only used for drone ID data received from other UAs. See detailed description at
 * https://mavlink.io/en/services/opendroneid.html. 
 * @param singleMessageSize This field must currently always be equal to 25 (bytes), since all
 * encoded OpenDroneID messages are specified to have this length.
 * units = bytes
 * @param msgPackSize Number of encoded messages in the pack (not the number of bytes). Allowed
 * range is 1 - 9.
 * @param messages Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the
 * unused portion of the field.
 */
@GeneratedMavMessage(
  id = 12_915u,
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
   * are specified to have this length.
   * units = bytes
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
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdMessagePack> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeUInt8(singleMessageSize)
    encoder.encodeUInt8(msgPackSize)
    encoder.encodeUInt8Array(messages, 225)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeUInt8(singleMessageSize)
    encoder.encodeUInt8(msgPackSize)
    encoder.encodeUInt8Array(messages, 225)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdMessagePack> {
    private const val SIZE_V1: Int = 249

    private const val SIZE_V2: Int = 249

    override val id: UInt = 12_915u

    override val crcExtra: Byte = 94

    override fun deserialize(bytes: ByteArray): OpenDroneIdMessagePack {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idOrMac = decoder.safeDecodeUInt8Array(20)
      val singleMessageSize = decoder.safeDecodeUInt8()
      val msgPackSize = decoder.safeDecodeUInt8()
      val messages = decoder.safeDecodeUInt8Array(225)

      return OpenDroneIdMessagePack(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        singleMessageSize = singleMessageSize,
        msgPackSize = msgPackSize,
        messages = messages,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdMessagePack =
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
