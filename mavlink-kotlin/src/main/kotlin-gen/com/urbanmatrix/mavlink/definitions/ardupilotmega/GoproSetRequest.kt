package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Request to set a GOPRO_COMMAND with a desired.
 */
public data class GoproSetRequest(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Command ID.
   */
  public val cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0),
  /**
   * Value.
   */
  public val `value`: List<Int> = emptyList(),
) : MavMessage<GoproSetRequest> {
  public override val instanceMetadata: MavMessage.Metadata<GoproSetRequest> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    outputBuffer.encodeUint8Array(value, 4)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 218

    private const val CRC: Int = 17

    private const val SIZE: Int = 7

    private val DESERIALIZER: MavDeserializer<GoproSetRequest> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val cmdId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val value = inputBuffer.decodeUint8Array(4)

      GoproSetRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        cmdId = cmdId,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproSetRequest> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproSetRequest> = METADATA
  }
}
