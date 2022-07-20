package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint16Array
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint16Array
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Modify the filter of what CAN messages to forward over the mavlink. This can be used to make CAN
 * forwarding work well on low bandwith links. The filtering is applied on bits 8 to 24 of the CAN id
 * (2nd and 3rd bytes) which corresponds to the DroneCAN message ID for DroneCAN. Filters with more
 * than 16 IDs can be constructed by sending multiple CAN_FILTER_MODIFY messages.
 */
public data class CanFilterModify(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * bus number
   */
  public val bus: Int = 0,
  /**
   * what operation to perform on the filter list. See CAN_FILTER_OP enum.
   */
  public val operation: MavEnumValue<CanFilterOp> = MavEnumValue.fromValue(0),
  /**
   * number of IDs in filter list
   */
  public val numIds: Int = 0,
  /**
   * filter IDs, length num_ids
   */
  public val ids: List<Int> = emptyList(),
) : MavMessage<CanFilterModify> {
  public override val instanceMetadata: MavMessage.Metadata<CanFilterModify> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(ids, 32)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(bus)
    outputBuffer.encodeEnumValue(operation.value, 1)
    outputBuffer.encodeUint8(numIds)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 388

    private const val CRC: Int = 8

    private const val SIZE: Int = 37

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
  }
}
