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
 * Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation
 * Authority) issued operator ID.
 */
@WorkInProgress
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
  public override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdOperatorId> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(idOrMac, 20)
    buffer.encodeEnumValue(operatorIdType.value, 1)
    buffer.encodeString(operatorId, 20)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(idOrMac, 20)
    buffer.encodeEnumValue(operatorIdType.value, 1)
    buffer.encodeString(operatorId, 20)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdOperatorId> {
    public override val id: UInt = 12_905u

    public override val crcExtra: Byte = 49

    public override fun deserialize(bytes: ByteArray): OpenDroneIdOperatorId {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val idOrMac = buffer.decodeUInt8Array(20)
      val operatorIdType = buffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidOperatorIdType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val operatorId = buffer.decodeString(20)

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
