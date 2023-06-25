package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the
 * operator to (optionally) declare their identity and purpose of the flight. This message can provide
 * additional information that could reduce the threat profile of a UA (Unmanned Aircraft) flying in a
 * particular area or manner. This message can also be used to provide optional additional
 * clarification in an emergency/remote ID system failure situation.
 */
@WorkInProgress
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
  public override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdSelfId> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(idOrMac, 20)
    buffer.encodeEnumValue(descriptionType.value, 1)
    buffer.encodeString(description, 23)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(idOrMac, 20)
    buffer.encodeEnumValue(descriptionType.value, 1)
    buffer.encodeString(description, 23)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdSelfId> {
    public override val id: UInt = 12_903u

    public override val crcExtra: Byte = -7

    public override fun deserialize(bytes: ByteArray): OpenDroneIdSelfId {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val idOrMac = buffer.decodeUInt8Array(20)
      val descriptionType = buffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidDescType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val description = buffer.decodeString(23)

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
