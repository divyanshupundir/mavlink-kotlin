package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Modify the filter of what CAN messages to forward over the mavlink. This can be used to make CAN
 * forwarding work well on low bandwith links. The filtering is applied on bits 8 to 24 of the CAN id
 * (2nd and 3rd bytes) which corresponds to the DroneCAN message ID for DroneCAN. Filters with more
 * than 16 IDs can be constructed by sending multiple CAN_FILTER_MODIFY messages.
 */
@GeneratedMavMessage(
  id = 388u,
  crcExtra = 8,
)
public data class CanFilterModify(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * bus number
   */
  @GeneratedMavField(type = "uint8_t")
  public val bus: UByte = 0u,
  /**
   * what operation to perform on the filter list. See CAN_FILTER_OP enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val operation: MavEnumValue<CanFilterOp> = MavEnumValue.fromValue(0u),
  /**
   * number of IDs in filter list
   */
  @GeneratedMavField(type = "uint8_t")
  public val numIds: UByte = 0u,
  /**
   * filter IDs, length num_ids
   */
  @GeneratedMavField(type = "uint16_t[16]")
  public val ids: List<UShort> = emptyList(),
) : MavMessage<CanFilterModify> {
  public override val instanceCompanion: MavMessage.MavCompanion<CanFilterModify> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16Array(ids, 32)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(bus)
    buffer.encodeEnumValue(operation.value, 1)
    buffer.encodeUInt8(numIds)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16Array(ids, 32)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(bus)
    buffer.encodeEnumValue(operation.value, 1)
    buffer.encodeUInt8(numIds)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CanFilterModify> {
    public override val id: UInt = 388u

    public override val crcExtra: Byte = 8

    public override fun deserialize(bytes: ByteArray): CanFilterModify {
      val buffer = Buffer().write(bytes)

      val ids = buffer.decodeUInt16Array(32)
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val bus = buffer.decodeUInt8()
      val operation = buffer.decodeEnumValue(1).let { value ->
        val entry = CanFilterOp.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val numIds = buffer.decodeUInt8()

      return CanFilterModify(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        bus = bus,
        operation = operation,
        numIds = numIds,
        ids = ids,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CanFilterModify =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var bus: UByte = 0u

    public var operation: MavEnumValue<CanFilterOp> = MavEnumValue.fromValue(0u)

    public var numIds: UByte = 0u

    public var ids: List<UShort> = emptyList()

    public fun build(): CanFilterModify = CanFilterModify(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      bus = bus,
      operation = operation,
      numIds = numIds,
      ids = ids,
    )
  }
}
