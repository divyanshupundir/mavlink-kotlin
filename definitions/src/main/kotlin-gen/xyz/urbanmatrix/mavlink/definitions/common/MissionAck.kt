package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Acknowledgment message during waypoint handling. The type field states if this message is a
 * positive ack (type=0) or if an error happened (type=non-zero).
 */
@GeneratedMavMessage(
  id = 47,
  crc = 153,
)
public data class MissionAck(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Mission result.
   */
  public val type: MavEnumValue<MavMissionResult> = MavEnumValue.fromValue(0),
  /**
   * Mission type.
   */
  public val missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0),
) : MavMessage<MissionAck> {
  public override val instanceMetadata: MavMessage.Metadata<MissionAck> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(missionType.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 47

    private const val CRC: Int = 153

    private const val SIZE: Int = 4

    private val DESERIALIZER: MavDeserializer<MissionAck> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMissionResult.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val missionType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      MissionAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        type = type,
        missionType = missionType,
      )
    }


    private val METADATA: MavMessage.Metadata<MissionAck> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MissionAck> = METADATA
  }
}
