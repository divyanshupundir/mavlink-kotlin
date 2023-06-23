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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16Array(ids, 32)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(bus)
    output.encodeEnumValue(operation.value, 1)
    output.encodeUInt8(numIds)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16Array(ids, 32)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(bus)
    output.encodeEnumValue(operation.value, 1)
    output.encodeUInt8(numIds)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CanFilterModify> {
    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    public override val id: UInt = 388u

    public override val crcExtra: Byte = 8

    public override fun deserialize(source: BufferedSource): CanFilterModify {
      val ids = source.decodeUInt16Array(32)
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val bus = source.decodeUInt8()
      val operation = source.decodeEnumValue(1).let { value ->
        val entry = CanFilterOp.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val numIds = source.decodeUInt8()

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
