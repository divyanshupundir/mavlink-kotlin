package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long

/**
 * Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is
 * by definition for the overall aircraft, not only for one component.
 */
@Deprecated(message = "Use COMMAND_LONG with MAV_CMD_DO_SET_MODE instead")
@GeneratedMavMessage(
  id = 11,
  crc = 89,
)
public data class SetMode(
  /**
   * The system setting the mode
   */
  public val targetSystem: Int = 0,
  /**
   * The new base mode.
   */
  public val baseMode: MavEnumValue<MavMode> = MavEnumValue.fromValue(0),
  /**
   * The new autopilot-specific mode. This field can be ignored by an autopilot.
   */
  public val customMode: Long = 0L,
) : MavMessage<SetMode> {
  public override val instanceMetadata: MavMessage.Metadata<SetMode> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeEnumValue(baseMode.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11

    private const val CRC: Int = 89

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<SetMode> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val customMode = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val baseMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      SetMode(
        targetSystem = targetSystem,
        baseMode = baseMode,
        customMode = customMode,
      )
    }


    private val METADATA: MavMessage.Metadata<SetMode> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetMode> = METADATA
  }
}
