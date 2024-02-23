package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the
 * operator to (optionally) declare their identity and purpose of the flight. This message can provide
 * additional information that could reduce the threat profile of a UA (Unmanned Aircraft) flying in a
 * particular area or manner. This message can also be used to provide optional additional
 * clarification in an emergency/remote ID system failure situation.
 *
 * @param targetSystem System ID (0 for broadcast).
 * @param targetComponent Component ID (0 for broadcast).
 * @param idOrMac Only used for drone ID data received from other UAs. See detailed description at
 * https://mavlink.io/en/services/opendroneid.html. 
 * @param descriptionType Indicates the type of the description field.
 * @param description Text description or numeric value expressed as ASCII characters. Shall be
 * filled with nulls in the unused portion of the field.
 */
@GeneratedMavMessage(
  id = 12_903u,
  crcExtra = -7,
)
public data class OpenDroneIdSelfId(
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
   * Indicates the type of the description field.
   */
  @GeneratedMavField(type = "uint8_t")
  public val descriptionType: MavEnumValue<MavOdidDescType> = MavEnumValue.fromValue(0u),
  /**
   * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in
   * the unused portion of the field.
   */
  @GeneratedMavField(type = "char[23]")
  public val description: String = "",
) : MavMessage<OpenDroneIdSelfId> {
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdSelfId> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(descriptionType.value, 1)
    encoder.encodeString(description, 23)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(descriptionType.value, 1)
    encoder.encodeString(description, 23)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdSelfId> {
    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    override val id: UInt = 12_903u

    override val crcExtra: Byte = -7

    override fun deserialize(bytes: ByteArray): OpenDroneIdSelfId {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idOrMac = decoder.safeDecodeUInt8Array(20)
      val descriptionType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidDescType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val description = decoder.safeDecodeString(23)

      return OpenDroneIdSelfId(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        descriptionType = descriptionType,
        description = description,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdSelfId =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var descriptionType: MavEnumValue<MavOdidDescType> = MavEnumValue.fromValue(0u)

    public var description: String = ""

    public fun build(): OpenDroneIdSelfId = OpenDroneIdSelfId(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      descriptionType = descriptionType,
      description = description,
    )
  }
}
