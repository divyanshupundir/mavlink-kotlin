package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
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
 * Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily
 * meant for feeding data to/from an OpenDroneID implementation. E.g.
 * https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with the ASTM F3411
 * Remote ID standard and the ASD-STAN prEN 4709-002 Direct Remote ID standard. Additional information
 * and usage of these messages is documented at https://mavlink.io/en/services/opendroneid.html.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12_900u,
  crcExtra = 114,
)
public data class OpenDroneIdBasicId(
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
   * Indicates the format for the uas_id field of this message.
   */
  @GeneratedMavField(type = "uint8_t")
  public val idType: MavEnumValue<MavOdidIdType> = MavEnumValue.fromValue(0u),
  /**
   * Indicates the type of UA (Unmanned Aircraft).
   */
  @GeneratedMavField(type = "uint8_t")
  public val uaType: MavEnumValue<MavOdidUaType> = MavEnumValue.fromValue(0u),
  /**
   * UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled
   * with nulls in the unused portion of the field.
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val uasId: List<UByte> = emptyList(),
) : MavMessage<OpenDroneIdBasicId> {
  public override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdBasicId> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(idType.value, 1)
    output.encodeEnumValue(uaType.value, 1)
    output.encodeUInt8Array(uasId, 20)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(idType.value, 1)
    output.encodeEnumValue(uaType.value, 1)
    output.encodeUInt8Array(uasId, 20)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdBasicId> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    public override val id: UInt = 12_900u

    public override val crcExtra: Byte = 114

    public override fun deserialize(source: BufferedSource): OpenDroneIdBasicId {
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val idOrMac = source.decodeUInt8Array(20)
      val idType = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidIdType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uaType = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidUaType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uasId = source.decodeUInt8Array(20)

      return OpenDroneIdBasicId(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        idType = idType,
        uaType = uaType,
        uasId = uasId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdBasicId =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var idType: MavEnumValue<MavOdidIdType> = MavEnumValue.fromValue(0u)

    public var uaType: MavEnumValue<MavOdidUaType> = MavEnumValue.fromValue(0u)

    public var uasId: List<UByte> = emptyList()

    public fun build(): OpenDroneIdBasicId = OpenDroneIdBasicId(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      idType = idType,
      uaType = uaType,
      uasId = uasId,
    )
  }
}
