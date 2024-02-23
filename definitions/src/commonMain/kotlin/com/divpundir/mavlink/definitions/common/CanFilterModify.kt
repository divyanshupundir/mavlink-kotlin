package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Modify the filter of what CAN messages to forward over the mavlink. This can be used to make CAN
 * forwarding work well on low bandwidth links. The filtering is applied on bits 8 to 24 of the CAN id
 * (2nd and 3rd bytes) which corresponds to the DroneCAN message ID for DroneCAN. Filters with more
 * than 16 IDs can be constructed by sending multiple CAN_FILTER_MODIFY messages.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param bus bus number
 * @param operation what operation to perform on the filter list. See CAN_FILTER_OP enum.
 * @param numIds number of IDs in filter list
 * @param ids filter IDs, length num_ids
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
  override val instanceCompanion: MavMessage.MavCompanion<CanFilterModify> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16Array(ids, 32)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(bus)
    encoder.encodeEnumValue(operation.value, 1)
    encoder.encodeUInt8(numIds)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16Array(ids, 32)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(bus)
    encoder.encodeEnumValue(operation.value, 1)
    encoder.encodeUInt8(numIds)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CanFilterModify> {
    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    override val id: UInt = 388u

    override val crcExtra: Byte = 8

    override fun deserialize(bytes: ByteArray): CanFilterModify {
      val decoder = MavDataDecoder(bytes)

      val ids = decoder.safeDecodeUInt16Array(32)
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val bus = decoder.safeDecodeUInt8()
      val operation = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = CanFilterOp.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val numIds = decoder.safeDecodeUInt8()

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
