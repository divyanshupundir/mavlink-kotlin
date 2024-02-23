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
 * Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily
 * meant for feeding data to/from an OpenDroneID implementation. E.g.
 * https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with the ASTM F3411
 * Remote ID standard and the ASD-STAN prEN 4709-002 Direct Remote ID standard. Additional information
 * and usage of these messages is documented at https://mavlink.io/en/services/opendroneid.html.
 *
 * @param targetSystem System ID (0 for broadcast).
 * @param targetComponent Component ID (0 for broadcast).
 * @param idOrMac Only used for drone ID data received from other UAs. See detailed description at
 * https://mavlink.io/en/services/opendroneid.html. 
 * @param idType Indicates the format for the uas_id field of this message.
 * @param uaType Indicates the type of UA (Unmanned Aircraft).
 * @param uasId UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall
 * be filled with nulls in the unused portion of the field.
 */
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
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdBasicId> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(idType.value, 1)
    encoder.encodeEnumValue(uaType.value, 1)
    encoder.encodeUInt8Array(uasId, 20)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(idType.value, 1)
    encoder.encodeEnumValue(uaType.value, 1)
    encoder.encodeUInt8Array(uasId, 20)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdBasicId> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    override val id: UInt = 12_900u

    override val crcExtra: Byte = 114

    override fun deserialize(bytes: ByteArray): OpenDroneIdBasicId {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idOrMac = decoder.safeDecodeUInt8Array(20)
      val idType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidIdType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uaType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidUaType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uasId = decoder.safeDecodeUInt8Array(20)

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
