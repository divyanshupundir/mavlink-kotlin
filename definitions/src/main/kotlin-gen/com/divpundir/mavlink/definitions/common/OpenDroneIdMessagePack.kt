package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. not in
 * the format given for the above message descriptions but after encoding into the compressed
 * OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long Range/Extended
 * Advertising or on WiFi Neighbor Aware Networking or on WiFi Beacon.
 */
@WorkInProgress
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
  public override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdMessagePack> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeUInt8(singleMessageSize)
    output.encodeUInt8(msgPackSize)
    output.encodeUInt8Array(messages, 225)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeUInt8(singleMessageSize)
    output.encodeUInt8(msgPackSize)
    output.encodeUInt8Array(messages, 225)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdMessagePack> {
    private const val SIZE_V1: Int = 249

    private const val SIZE_V2: Int = 249

    public override val id: UInt = 12_915u

    public override val crcExtra: Byte = 94

    public override fun deserialize(source: BufferedSource): OpenDroneIdMessagePack {
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val idOrMac = source.decodeUInt8Array(20)
      val singleMessageSize = source.decodeUInt8()
      val msgPackSize = source.decodeUInt8()
      val messages = source.decodeUInt8Array(225)

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
