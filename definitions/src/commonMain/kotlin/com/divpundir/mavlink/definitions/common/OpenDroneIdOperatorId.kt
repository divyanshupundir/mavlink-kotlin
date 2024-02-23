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
 * Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation
 * Authority) issued operator ID.
 *
 * @param targetSystem System ID (0 for broadcast).
 * @param targetComponent Component ID (0 for broadcast).
 * @param idOrMac Only used for drone ID data received from other UAs. See detailed description at
 * https://mavlink.io/en/services/opendroneid.html. 
 * @param operatorIdType Indicates the type of the operator_id field.
 * @param operatorId Text description or numeric value expressed as ASCII characters. Shall be
 * filled with nulls in the unused portion of the field.
 */
@GeneratedMavMessage(
  id = 12_905u,
  crcExtra = 49,
)
public data class OpenDroneIdOperatorId(
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
   * Indicates the type of the operator_id field.
   */
  @GeneratedMavField(type = "uint8_t")
  public val operatorIdType: MavEnumValue<MavOdidOperatorIdType> = MavEnumValue.fromValue(0u),
  /**
   * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in
   * the unused portion of the field.
   */
  @GeneratedMavField(type = "char[20]")
  public val operatorId: String = "",
) : MavMessage<OpenDroneIdOperatorId> {
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdOperatorId> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(operatorIdType.value, 1)
    encoder.encodeString(operatorId, 20)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(operatorIdType.value, 1)
    encoder.encodeString(operatorId, 20)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdOperatorId> {
    private const val SIZE_V1: Int = 43

    private const val SIZE_V2: Int = 43

    override val id: UInt = 12_905u

    override val crcExtra: Byte = 49

    override fun deserialize(bytes: ByteArray): OpenDroneIdOperatorId {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idOrMac = decoder.safeDecodeUInt8Array(20)
      val operatorIdType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidOperatorIdType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val operatorId = decoder.safeDecodeString(20)

      return OpenDroneIdOperatorId(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        operatorIdType = operatorIdType,
        operatorId = operatorId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdOperatorId =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var operatorIdType: MavEnumValue<MavOdidOperatorIdType> = MavEnumValue.fromValue(0u)

    public var operatorId: String = ""

    public fun build(): OpenDroneIdOperatorId = OpenDroneIdOperatorId(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      operatorIdType = operatorIdType,
      operatorId = operatorId,
    )
  }
}
