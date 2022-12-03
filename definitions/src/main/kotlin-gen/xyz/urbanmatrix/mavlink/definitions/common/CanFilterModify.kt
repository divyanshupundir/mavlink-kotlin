package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Modify the filter of what CAN messages to forward over the mavlink. This can be used to make CAN
 * forwarding work well on low bandwith links. The filtering is applied on bits 8 to 24 of the CAN id
 * (2nd and 3rd bytes) which corresponds to the DroneCAN message ID for DroneCAN. Filters with more
 * than 16 IDs can be constructed by sending multiple CAN_FILTER_MODIFY messages.
 */
@GeneratedMavMessage(
  id = 388,
  crc = 8,
)
public data class CanFilterModify(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * bus number
   */
  @GeneratedMavField(type = "uint8_t")
  public val bus: Int = 0,
  /**
   * what operation to perform on the filter list. See CAN_FILTER_OP enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val operation: MavEnumValue<CanFilterOp> = MavEnumValue.fromValue(0),
  /**
   * number of IDs in filter list
   */
  @GeneratedMavField(type = "uint8_t")
  public val numIds: Int = 0,
  /**
   * filter IDs, length num_ids
   */
  @GeneratedMavField(type = "uint16_t[16]")
  public val ids: List<Int> = emptyList(),
) : MavMessage<CanFilterModify> {
  public override val instanceMetadata: MavMessage.Metadata<CanFilterModify> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(ids, 32)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(bus)
    outputBuffer.encodeEnumValue(operation.value, 1)
    outputBuffer.encodeUint8(numIds)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(ids, 32)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(bus)
    outputBuffer.encodeEnumValue(operation.value, 1)
    outputBuffer.encodeUint8(numIds)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 388

    private const val CRC: Int = 8

    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    private val DESERIALIZER: MavDeserializer<CanFilterModify> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val ids = inputBuffer.decodeUint16Array(32)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val bus = inputBuffer.decodeUint8()
      val operation = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CanFilterOp.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val numIds = inputBuffer.decodeUint8()

      CanFilterModify(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        bus = bus,
        operation = operation,
        numIds = numIds,
        ids = ids,
      )
    }


    private val METADATA: MavMessage.Metadata<CanFilterModify> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CanFilterModify> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CanFilterModify =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var bus: Int = 0

    public var operation: MavEnumValue<CanFilterOp> = MavEnumValue.fromValue(0)

    public var numIds: Int = 0

    public var ids: List<Int> = emptyList()

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
