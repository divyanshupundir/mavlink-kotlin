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
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(descriptionType.value, 1)
    output.encodeString(description, 23)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(descriptionType.value, 1)
    output.encodeString(description, 23)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdSelfId> {
    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    public override val id: UInt = 12_903u

    public override val crcExtra: Byte = -7

    public override fun deserialize(source: BufferedSource): OpenDroneIdSelfId {
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val idOrMac = source.decodeUInt8Array(20)
      val descriptionType = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidDescType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val description = source.decodeString(23)

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
